package com.collins.trustedmethods.matrics.analysis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;

public class NuXmvRunner {

	private Process process;
	private BufferedReader fromProcess;
	private BufferedWriter toProcess;

	public NuXmvRunner(IProgressMonitor monitor, String commandFile, String inputFile) throws Exception {

		final List<String> args = new ArrayList<>();
		args.add("nuXmv.exe");
		args.add("-load");
		args.add(commandFile);
		args.add(inputFile);

		ProcessBuilder processBuilder = new ProcessBuilder(args);
		processBuilder.redirectErrorStream(true);
		System.out.println(String.join(" ", processBuilder.command()));
		try {
			process = processBuilder.start();
		} catch (IOException e) {
			Exception generalException = new Exception(
					"Unable to start nuXmv by executing: " + String.join(" ", processBuilder.command()), e);
			throw generalException;
		}
		addShutdownHook();
		toProcess = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
		fromProcess = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String out;
		while ((out = fromProcess.readLine()) != null) {
			System.out.println(out);
			if (monitor.isCanceled()) {
				stop();
				return;
			}
		}
		process.waitFor();
		System.out.println("Finished running nuXmv.");

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
