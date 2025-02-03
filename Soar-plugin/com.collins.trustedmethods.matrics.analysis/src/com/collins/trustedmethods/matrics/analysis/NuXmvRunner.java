package com.collins.trustedmethods.matrics.analysis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.IConsoleView;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

public class NuXmvRunner {

	private final static String CONSOLE_NAME = "nuXmv";

	private Process process;
	private BufferedReader fromProcess;
	private BufferedWriter toProcess;
	private MessageConsole console = null;
	private IConsoleView view = null;
	private MessageConsoleStream outputStream = null;

	public NuXmvRunner(IProgressMonitor monitor, String commandFile, String inputFile) throws Exception {

		Display.getDefault().asyncExec(() -> {
			console = findConsole(CONSOLE_NAME);
			outputStream = console.newMessageStream();
			final IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			try {
				view = (IConsoleView) page.showView(IConsoleConstants.ID_CONSOLE_VIEW);
			} catch (PartInitException e) {
				e.printStackTrace();
			}
			view.display(console);
		});

		final List<String> args = new ArrayList<>();
		args.add("nuXmv.exe");
		args.add("-load");
		args.add(commandFile);
		args.add(inputFile);

		final ProcessBuilder processBuilder = new ProcessBuilder(args);
		processBuilder.redirectErrorStream(true);
		println(String.join(" ", processBuilder.command()));
		try {
			process = processBuilder.start();
		} catch (IOException e) {
			final Exception generalException = new Exception(
					"Unable to start nuXmv by executing: " + String.join(" ", processBuilder.command()), e);
			throw generalException;
		}
		addShutdownHook();
		toProcess = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
		fromProcess = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String out;
		while ((out = fromProcess.readLine()) != null) {
			println(out);
			if (monitor.isCanceled()) {
				stop();
				break;
			}
		}
//		process.waitFor();
		println("Finished running nuXmv.");

	}

	private final Thread shutdownHook = new Thread("shutdown-hook") {
		@Override
		public void run() {
			NuXmvRunner.this.stop();
		}
	};

	private void addShutdownHook() {
		Runtime.getRuntime().addShutdownHook(shutdownHook);
	}

	private void removeShutdownHook() {
		try {
			Runtime.getRuntime().removeShutdownHook(shutdownHook);
		} catch (IllegalStateException e) {
			// Ignore, we are already shutting down
		}
	}

	private void println(String text) {
		Display.getDefault().asyncExec(() -> {
			outputStream.println(text);
		});
	}

	private MessageConsole findConsole(String name) {
		final ConsolePlugin plugin = ConsolePlugin.getDefault();
		final IConsoleManager conMan = plugin.getConsoleManager();
		final IConsole[] existing = conMan.getConsoles();
		for (int i = 0; i < existing.length; i++) {
			if (name.equals(existing[i].getName())) {
				return (MessageConsole) existing[i];
			}
		}
		// no console found, so create a new one
		final MessageConsole myConsole = new MessageConsole(name, null);
		conMan.addConsoles(new IConsole[] { myConsole });
		return myConsole;
	}

	public synchronized void stop() {
		/**
		 * This must be synchronized since two threads (an Engine or a shutdown
		 * hook) may try to stop the process at the same time
		 */

		if (process != null) {
			process.destroy();
			process = null;
		}

		removeShutdownHook();
	}

}
