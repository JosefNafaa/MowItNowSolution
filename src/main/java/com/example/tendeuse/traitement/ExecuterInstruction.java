package com.example.tendeuse.traitement;

import java.util.ArrayList;
import java.util.List;

import com.example.tendeuse.pojo.Direction;
import com.example.tendeuse.pojo.Instruction;
import com.example.tendeuse.pojo.Pelouse;
import com.example.tendeuse.pojo.Point;
import com.example.tendeuse.pojo.Position;
import com.example.tendeuse.pojo.Tendeuse;

public class ExecuterInstruction {

	/**
	 * 
	 * @param position:la position actuelle
	 * @return la nouvelle position apres avoir avancer la tendeuse par un pas
	 */
	public static Position avancer(Position position) {
		int x = 0, y = 0;
		switch (position.getDirection().getCodeORientation()) {

		case 'N':
			x = position.getPoint().getX() + Direction.NORTH.getCoordonneX();
			y = position.getPoint().getY() + Direction.NORTH.getCoordonneY();
			if (Pelouse.estDansPeleuse(new Point(x, y))) {
				position.setPoint(new Point(x, y));
			}

			break;

		case 'S':
			x = position.getPoint().getX() + Direction.SOUTH.getCoordonneX();
			y = position.getPoint().getY() + Direction.SOUTH.getCoordonneY();
			if (Pelouse.estDansPeleuse(new Point(x, y))) {
				position.setPoint(new Point(x, y));
			}
			break;

		case 'E':
			x = position.getPoint().getX() + Direction.EAST.getCoordonneX();
			y = position.getPoint().getY() + Direction.EAST.getCoordonneY();
			if (Pelouse.estDansPeleuse(new Point(x, y))) {
				position.setPoint(new Point(x, y));
			}
			break;

		case 'W':
			x = position.getPoint().getX() + Direction.WEST.getCoordonneX();
			y = position.getPoint().getY() + Direction.WEST.getCoordonneY();
			if (Pelouse.estDansPeleuse(new Point(x, y))) {
				position.setPoint(new Point(x, y));
			}
			break;
		}
		return position;
	}

	/**
	 * 
	 * @param position:la position actuelle
	 * @return la nouvelle position apres avoir tourner la tendeuse à gauche
	 */
	public static Position tournerGauche(Position position) {
		switch (position.getDirection().getCodeORientation()) {

		case 'N':
			position.setDirection(Direction.WEST);
			break;
		case 'S':
			position.setDirection(Direction.EAST);
			break;
		case 'E':
			position.setDirection(Direction.NORTH);
			break;
		case 'W':
			position.setDirection(Direction.SOUTH);
			break;
		}
		return position;
	}

	/**
	 * 
	 * @param position:la position actuelle
	 * @return la nouvelle position apres avoir tourner la tendeuse à droite
	 */
	public static Position tournerDroite(Position position) {
		switch (position.getDirection().getCodeORientation()) {

		case 'N':
			position.setDirection(Direction.EAST);
			break;
		case 'S':
			position.setDirection(Direction.WEST);
			break;
		case 'E':
			position.setDirection(Direction.SOUTH);
			break;
		case 'W':
			position.setDirection(Direction.NORTH);
			break;
		}
		return position;
	}

	/***
	 * 
	 * @param position
	 * @param instruction
	 * @return execute l'operation adéqute
	 */
	public static Position executerInstructionUnitaire(Position position, Instruction instruction) {
		switch (instruction.getLibelleInstruction()) {

		case 'G':
			position = ExecuterInstruction.tournerGauche(position);
			break;

		case 'D':
			position = ExecuterInstruction.tournerDroite(position);
			break;
		case 'A':
			position = ExecuterInstruction.avancer(position);
			break;
		}

		return position;
	}

	/**
	 * 
	 * @param tendeuse:elle prend une tendeuse en entrée
	 * @return la position finale de la tendeuse aprés avoir executer toutes les
	 *         intructions
	 */
	public static Position lancertendeuse(Tendeuse tendeuse) {
		List<Instruction> instructions = tendeuse.getInstructions();
		Position pos = tendeuse.getPosition();
		for (Instruction instruction : instructions) {

			pos = ExecuterInstruction.executerInstructionUnitaire(pos, instruction);
		}
		return pos;

	}

	/**
	 * 
	 * @param tendeuses : la liste de toutes les tendeuses
	 * @return la listes des positions des tendeus à la fin d'executions des
	 *         instructions
	 */
	public static List<Position> lancerToutesTendeuses(List<Tendeuse> tendeuses) {
		List<Position> positions = new ArrayList<Position>();
		for (Tendeuse tendeuse : tendeuses) {
			positions.add(ExecuterInstruction.lancertendeuse(tendeuse));
		}
		return positions;

	}

}
