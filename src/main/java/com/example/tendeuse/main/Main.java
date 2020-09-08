package com.example.tendeuse.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.tendeuse.inoutFiles.ReadFile;
import com.example.tendeuse.pojo.Tendeuse;
import com.example.tendeuse.traitement.ParserFile;

public class Main {

	public static void main(String... args) {

		String filename = "D:\\Cours\\Tendeuse\\InputFile.txt";

		String[] st = ReadFile.readLines(filename);

		String[] stringArray = ReadFile.readLines(filename);
		String[] modifiedArray = Arrays.copyOfRange(stringArray, 1, stringArray.length);
		System.out.println(stringArray[0]);
		System.out.println(modifiedArray[0]);
		List<Tendeuse> tendeuseList = new ArrayList<Tendeuse>();
		tendeuseList = ParserFile.alimenterTendeuses(modifiedArray);
		System.out.println("toutes les tendeuses");
		for (Tendeuse tendeuse : tendeuseList) {
			System.out.println(tendeuse.getPosition());
			System.out.println(tendeuse.getInstructions());
		}
//		String ligneInstruction = st[2];
//		System.out.println(ligneInstruction);
//		List<Instruction> p = FormaterLigne.formaterLigneInstruction(ligneInstruction);
//		System.out.println(p);

//		String lignePoint = st[0];
//		System.out.println(lignePoint);
//		Point pelouse = FormaterLigne.formaterLignePoint(lignePoint);
//		System.out.println(pelouse);
//		Pelouse.setCoinSup(pelouse);
////
//		String lignePosition = st[1];
//		System.out.println(lignePosition);
//		Position pos = FormaterLigne.formaterLignePosition(lignePosition);
//		pos = ExecuterInstruction.avancer(pos);
//		System.out.println("avancer");
//		System.out.println(pos.getPoint() + " " + pos.getDirection());
//		System.out.println("tourner à gauche");
//		pos = ExecuterInstruction.tournerGauche(pos);
//		System.out.println(pos.getPoint() + " " + pos.getDirection());
//		System.out.println("tourner à droite");
//		pos = ExecuterInstruction.tournerDroite(pos);
//		System.out.println(pos.getPoint() + " " + pos.getDirection());
//
//		pos = ExecuterInstruction.avancer(pos);
//		System.out.println("avancer");
//		System.out.println(pos.getPoint() + " " + pos.getDirection());
//		pos = ExecuterInstruction.avancer(pos);
//		System.out.println("avancer");
//		System.out.println(pos.getPoint() + " " + pos.getDirection());
//		pos = ExecuterInstruction.avancer(pos);
//		System.out.println("avancer");
//		System.out.println(pos.getPoint() + " " + pos.getDirection());
//		pos = ExecuterInstruction.avancer(pos);
//		System.out.println("avancer");
//		System.out.println(pos.getPoint() + " " + pos.getDirection());

		// System.out.println(pos.getDirection().getCodeORientation());
//		System.out.println(pos.getDirection().getCoordonneX());
//		System.out.println(pos.getDirection().getCoordonneY());
//		System.out.println(pos.getPoint());
//
//		String s = "AAG";
//		if (Pattern.matches("[ADG]+", s)) {
//			// Do something
//			System.out.println("Yes, string contains letters only");
//		} else {
//			throw new TendeuseExceptions(MessageConstants.INSTRUCTION_INCORRECTE);
//		}

		/*
		 * Direction dr = Direction.EAST; System.out.println(dr.getCodeORientation());
		 * System.out.println(dr.getCoordonneX());
		 * System.out.println(dr.getCoordonneY());
		 * 
		 * String testString = "This Is Test"; char[] stringToCharArray =
		 * testString.toCharArray();
		 * 
		 * for (char output : stringToCharArray) { System.out.println(output); }
		 */

//		Position p = new Position();
//		p.setDirection(Direction.EAST);
//		System.out.println(p.getDirection().getCoordonneX());
	}

}
