package com.example.tendeuse.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.tendeuse.inoutFiles.ReadFile;
import com.example.tendeuse.pojo.Pelouse;
import com.example.tendeuse.pojo.Point;
import com.example.tendeuse.pojo.Position;
import com.example.tendeuse.pojo.Tendeuse;
import com.example.tendeuse.traitement.ExecuterInstruction;
import com.example.tendeuse.traitement.FormaterLigne;
import com.example.tendeuse.traitement.ParserFile;

public class Principale {

	public static void main(String[] args) {

		String filename = "fichiers//inputFile.txt";
		String[] st = allLinesFile(filename);

		System.out.println("Le fichier suivant est fourni en entrée :");
		for (String string : st) {
			System.out.println(string);
		}
		List<String> lines = lancerProgramme(filename);
		System.out.println();
		afficherResultat(lines);

	}

	public static void afficherResultat(List<String> lines) {
		System.out.println("Le résultat apres le processus :");
		for (String string : lines) {
			System.out.println(string);
		}
	}

	public static String[] allLinesFile(String filename) {
		String[] st = ReadFile.readLines(filename);
		return st;
	}

	public static List<String> lancerProgramme(String filename) {
		String[] st = allLinesFile(filename);
		String lignePoint = st[0];
		Point point = FormaterLigne.formaterLignePoint(lignePoint);
		Pelouse pelouse = new Pelouse();
		pelouse.setCoinSup(point);
		ReadFile.numeroLigne++;
		String[] stringArray = ReadFile.readLines(filename);
		String[] modifiedArray = Arrays.copyOfRange(stringArray, 1, stringArray.length);
		List<Tendeuse> tendeuseList = new ArrayList<Tendeuse>();
		tendeuseList = ParserFile.alimenterTendeuses(modifiedArray);
		List<Position> allPositions = ExecuterInstruction.lancerToutesTendeuses(tendeuseList);
		List<String> lines = ExecuterInstruction.outputResultat(allPositions);
		return lines;
	}

}
