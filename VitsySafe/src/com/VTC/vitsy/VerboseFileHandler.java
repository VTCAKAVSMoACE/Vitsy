package com.VTC.vitsy;

import java.io.*;
import java.util.ArrayList;

public class VerboseFileHandler implements FileHandler {

	@SuppressWarnings("all")
	public ArrayList<String[]> getFileInstruct(ArrayList<String> filename, boolean codeOnly, boolean[] checkUses) {
		ArrayList<String[]> file = new ArrayList(0);
		if (!checkUses[0] && !checkUses[1]) {
			if (!codeOnly) {
				String fullfile = "";
				String line = "";
				try (BufferedReader br = new BufferedReader(new FileReader(filename.get(0)))) {
					while ((line = br.readLine()) != null)
						fullfile += line;
				} catch (Exception e) {
					System.err.println("File " + filename.get(0) + " not found, exiting...");
					e.printStackTrace();
					System.exit(1);
				}
				String[] fullfilesplit = fullfile.replaceAll("\n", "").replaceAll("\r", "").split(":");
				for (int i = 0; i < fullfilesplit.length; i++)
					file.add(fullfilesplit[i].substring(0, fullfilesplit[i].lastIndexOf(';')).split(";"));
			} else if (filename.size() > 0) {
				String[] fullfilesplit = filename.get(0).replaceAll("\n", "").replaceAll("\r", "").split(":");
				for (int i = 0; i < fullfilesplit.length; i++)
					file.add(fullfilesplit[i].substring(0, fullfilesplit[i].lastIndexOf(';')).split(";"));
			}
		}
		return file;
	}

}
