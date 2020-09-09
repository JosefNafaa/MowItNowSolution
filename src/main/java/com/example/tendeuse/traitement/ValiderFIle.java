package com.example.tendeuse.traitement;

import java.util.regex.Pattern;

import com.example.tendeuse.exceptions.TendeuseExceptions;
import com.example.tendeuse.inoutFiles.ReadFile;
import com.example.tendeuse.util.MessageConstants;

public class ValiderFIle {
	/**
	 * 
	 * @param line: le ligne qui contient le point(cpin sup)
	 * @return variable boolean soit pour valider ou bien rejeter un fichier
	 */

	public static boolean validerLignePoint(String lignePoint) {
		if (lignePoint.trim().equals("") || lignePoint.length() == 0)
			throw new TendeuseExceptions(
					"Erreur dans la ligne numéro:" + ReadFile.numeroLigne + " " + MessageConstants.LIGNE_VIDE);
		else if (!lignePoint.replaceAll("\\s", "").trim().matches("\\d+"))
			throw new TendeuseExceptions("Erreur dans la ligne numéro:" + ReadFile.numeroLigne + " "
					+ MessageConstants.COOORDONE_INCORRECTE);
		return true;

	}

	/**
	 * 
	 * @param line: le ligne qui contient l'instruction
	 * @return variable boolean soit pour valider ou bien rejeter un fichier
	 */
	public static boolean validerLigneInstruction(String ligneInstruction) {
		if (ligneInstruction.trim().equals("") || ligneInstruction.length() == 0)
			throw new TendeuseExceptions(
					"Erreur dans la ligne numéro:" + ReadFile.numeroLigne + " " + MessageConstants.LIGNE_VIDE);
		else if (ligneInstruction.indexOf(" ") != -1)
			throw new TendeuseExceptions("Erreur dans la ligne numéro:" + ReadFile.numeroLigne + " "
					+ MessageConstants.INSTRUCTION_INCORRECTE);
		else if (!Pattern.matches("[ADG]+", ligneInstruction))
			throw new TendeuseExceptions("Erreur dans la ligne numéro:" + ReadFile.numeroLigne + " "
					+ MessageConstants.INSTRUCTION_INCORRECTE);

		return true;
	}

	/**
	 * 
	 * @param line: le ligne qui contient la Position de la tendeuse
	 * @return variable boolean soit pour valider ou bien rejeter un fichier
	 */

	public static boolean validerLignePosition(String lignePosition) {
		if (lignePosition.trim().equals("") || lignePosition.length() == 0)
			throw new TendeuseExceptions(
					"Erreur dans la ligne numéro:" + ReadFile.numeroLigne + " " + MessageConstants.LIGNE_VIDE);

		return true;
	}

}
