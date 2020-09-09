package com.example.tendeuse.inoutFiles;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.tendeuse.exceptions.TendeuseExceptions;
import com.example.tendeuse.util.MessageConstants;

public class ReadFile {
	public static int numeroLigne = 1;
	

	public static int getNumeroLigne() {
		return numeroLigne;
	}


	public static void setNumeroLigne(int numeroLigne) {
		ReadFile.numeroLigne = numeroLigne;
	}


	public static String[] readLines(String filename) {
		FileReader fileReader = null;

		try {
			fileReader = new FileReader(filename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new TendeuseExceptions(MessageConstants.ERREUR_FICHIER_INEXISTANT);
		}

		BufferedReader bufferedReader = new BufferedReader(fileReader);
		List<String> lines = new ArrayList<String>();
		String line = null;

		try {
			while ((line = bufferedReader.readLine()) != null) {

				lines.add(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (lines.size() == 0)
			throw new TendeuseExceptions(MessageConstants.ERREUR_FICHIER_VIDE);
		else if (lines.size() < 3)
			throw new TendeuseExceptions(MessageConstants.ERREUR_FICHIER_INCOMPLET);
		try {
			bufferedReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lines.toArray(new String[lines.size()]);
	}

}
