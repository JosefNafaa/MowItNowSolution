package com.example.tendeuse.traitement;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.example.tendeuse.exceptions.TendeuseExceptions;
import com.example.tendeuse.inoutFiles.ReadFile;
import com.example.tendeuse.pojo.Direction;
import com.example.tendeuse.pojo.Instruction;
import com.example.tendeuse.pojo.Point;
import com.example.tendeuse.pojo.Position;
import com.example.tendeuse.pojo.Tendeuse;
import com.example.tendeuse.util.MessageConstants;

public class FormaterLigne {

	public static String espace = " ";

	/****
	 * 
	 * @param lignePoint :le paramtère d'entrée c'est la première ligne du fichier
	 * @return un objet de type point
	 */
	public static Point formaterLignePoint(String lignePoint) {
		Point point = new Point();
		ValiderFIle.validerLignePoint(lignePoint);
		final String SEPARATEUR = " ";
		String mots[] = lignePoint.split(SEPARATEUR);
		String coordonneeX = mots[0];
		String coordonneeY = mots[1];

		try {
			point.setX(Integer.parseInt(String.valueOf(coordonneeX)));
		} catch (NumberFormatException e) {
			throw new TendeuseExceptions("Erreur dans la ligne numéro:" + ReadFile.numeroLigne + " "
					+ MessageConstants.COOORDONE_INCORRECTE);
		}
		try {
			point.setY(Integer.parseInt(String.valueOf(coordonneeY)));
		} catch (NumberFormatException e) {
			throw new TendeuseExceptions("Erreur dans la ligne numéro : " + ReadFile.numeroLigne + " "
					+ MessageConstants.COOORDONE_INCORRECTE);
		}

		return point;

	}

	/***
	 * 
	 * @param lignePosition:le paramtère d'entrée c'est la ligne du fichier qui
	 *                         contient la position
	 * @return un objet de type position
	 */
	public static Position formaterLignePosition(String lignePosition) {
		Position position = new Position();
		Point point = new Point();
		ValiderFIle.validerLignePosition(lignePosition);
		final String SEPARATEUR = " ";
		String mots[] = lignePosition.split(SEPARATEUR);
		String lignePoint = mots[0] + " " + mots[1];
		point = formaterLignePoint(lignePoint);
		position.setPoint(point);
		String orientation = mots[2];
		if (Pattern.matches("[NSEW]+", orientation)) {
			// Do something
			switch (orientation) {
			case "N":
				position.setDirection(Direction.NORTH);
				break;
			case "S":
				position.setDirection(Direction.SOUTH);
				break;
			case "E":
				position.setDirection(Direction.EAST);
				break;
			case "W":
				position.setDirection(Direction.WEST);
				break;
			}

		} else {
			throw new TendeuseExceptions("Erreur dans la ligne numéro:" + ReadFile.numeroLigne + " "
					+ MessageConstants.ORIENTATION_INCORRECTE);
		}
		return position;
	}

	/***
	 * 
	 * @param ligneInstructionle paramtère d'entrée c'est la ligne du fichier qui
	 *                           contient les intsructions
	 * @return une list d'instructions
	 */

	public static List<Instruction> formaterLigneInstruction(String ligneInstruction) {
		List<Instruction> instructions = new ArrayList<Instruction>();
		if (Pattern.matches("[ADG]+", ligneInstruction)) {
			Character[] charObjectArray = ligneInstruction.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
			for (Character character : charObjectArray) {
				switch (character) {
				case 'A':
					instructions.add(Instruction.AVANCER);
					break;
				case 'G':
					instructions.add(Instruction.GAUCHE);
					break;
				case 'D':
					instructions.add(Instruction.DROITE);
					break;

				}

			}
		} else {
			throw new TendeuseExceptions("Erreur dans la ligne numéro:" + ReadFile.numeroLigne + " "
					+ MessageConstants.INSTRUCTION_INCORRECTE);
		}
		return instructions;
	}

	/**
	 * 
	 * @param position
	 * @param instructions
	 * @return un objet de type tendeuse
	 */
	public static Tendeuse alimenterTendeuse(Position position, List<Instruction> instructions) {
		Tendeuse tendeuse = new Tendeuse();
		tendeuse.setPosition(position);
		tendeuse.setInstructions(instructions);
		return tendeuse;
	}
}
