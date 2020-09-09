package com.example.tendeuse.traitement;

import java.util.ArrayList;
import java.util.List;

import com.example.tendeuse.exceptions.TendeuseExceptions;
import com.example.tendeuse.inoutFiles.ReadFile;
import com.example.tendeuse.pojo.Tendeuse;
import com.example.tendeuse.util.MessageConstants;

public class ParserFile {
	/**
	 * 
	 * @param fileWithoutFirstLigne: l'ensemble des lignes qui contiennnet les
	 *                               positions des tendeuses et leurs instructions
	 * @return une liste d'objet tendeuse pour resemble chaque tendeuse avec ses
	 *         instructions
	 */
	public static List<Tendeuse> alimenterTendeuses(String[] fileWithoutFirstLigne) {
		List<Tendeuse> tendeuseList = new ArrayList<Tendeuse>();
		if(fileWithoutFirstLigne.length%2!=0)
			throw new TendeuseExceptions(MessageConstants.ERREUR_FICHIER_INCOMPLET);
		for (int i = 0; i < fileWithoutFirstLigne.length; i = i + 2) {
			Tendeuse t = new Tendeuse();

			/***
			 * Alimenter la position de la tendeuse
			 */
			t.setPosition(FormaterLigne.formaterLignePosition(fileWithoutFirstLigne[i]));
			ReadFile.numeroLigne = ReadFile.numeroLigne + 1;
			/**
			 * ALimenter la liste des instructions
			 */
			t.setInstructions(FormaterLigne.formaterLigneInstruction(fileWithoutFirstLigne[i + 1]));
			ReadFile.numeroLigne = ReadFile.numeroLigne + 1;
			tendeuseList.add(t);
		}
		return tendeuseList;
	}

}
