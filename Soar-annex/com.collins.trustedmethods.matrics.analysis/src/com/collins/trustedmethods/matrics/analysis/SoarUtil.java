package com.collins.trustedmethods.matrics.analysis;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.osate.aadl2.Element;

public class SoarUtil {

	public static IProject getProject(Element element) {
		try {
			return getFile(element.eResource().getURI()).getProject();
		} catch (Exception e) {

		}

		return null;
	}

	public static IFile getFile(URI f) {
		final String pathString = f.isPlatform() ? f.toPlatformString(true) : f.toString();
		return getRoot().getFile(new Path(pathString));
	}

	public static IFolder makeFolder(URI f) {

		final IFolder folder = getRoot().getFolder(new Path(f.toPlatformString(true)));
		try {
			if (!folder.exists()) {
				folder.create(true, true, new NullProgressMonitor());
			}
		} catch (CoreException e) {
			System.err.println("Error: trouble creating folder.");
			e.printStackTrace();
		}
		return folder;
	}

	public static IFile createFile(URI fileName, String contents) {
		final IFile file = getFile(fileName);
		if (!writeFile(file, contents)) {
			return null;
		}
		return file;
	}

	public static String readFile(IFile res) throws CoreException, IOException {
		String contents = "";
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(res.getContents()));
		String line = null;

		while ((line = bufferedReader.readLine()) != null) {
			contents += line + System.lineSeparator();
		}
		bufferedReader.close();

		return contents;
	}

	public static boolean writeFile(IFile res, String contents) {
		final NullProgressMonitor monitor = new NullProgressMonitor();
		final InputStream stream = new ByteArrayInputStream(contents.getBytes());

		try {
			if (res.exists()) {
				res.delete(true, monitor);
			}
			res.create(stream, true, monitor);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static String insertString(String original, String newContent, int index) {
		return original.substring(0, index + 1) + System.lineSeparator() + newContent + System.lineSeparator()
				+ original.substring(index + 1);
	}

	private static IWorkspaceRoot getRoot() {
		return ResourcesPlugin.getWorkspace().getRoot();
	}
}
