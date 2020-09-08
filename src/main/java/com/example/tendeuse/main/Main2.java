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

public class Main2 {

	public static void main(String[] args) {
		String filename = "D:\\Cours\\Tendeuse\\InputFile.txt";

		String[] st = ReadFile.readLines(filename);
		String lignePoint = st[0];
		Point point = FormaterLigne.formaterLignePoint(lignePoint);
		System.out.println("coin sup");
		System.out.println(point);
		Pelouse pelouse = new Pelouse();
		pelouse.setCoinSup(point);
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

		List<Position> allPositions = ExecuterInstruction.lancerToutesTendeuses(tendeuseList);

		System.out.println("apres le traitement");
		for (Position position : allPositions) {
			System.out.println(position);
		}

	}

}
