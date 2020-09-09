package com.example.tendeuse.traitement;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.example.tendeuse.pojo.Direction;
import com.example.tendeuse.pojo.Pelouse;
import com.example.tendeuse.pojo.Point;
import com.example.tendeuse.pojo.Position;

public class ExecuterInstructionTest {

	@Test
	public void tourner_a_gauche() {

		Position position = new Position(new Point(1, 2), Direction.WEST);
		position = ExecuterInstruction.tournerGauche(position);
		Position positionTOk = new Position(new Point(1, 2), Direction.SOUTH);
		assertThat(position.equals(positionTOk)).isTrue();

	}

	@Test
	public void tourner_a_droite() {

		Position position = new Position(new Point(1, 2), Direction.NORTH);
		position = ExecuterInstruction.tournerDroite(position);
		Position positionTOk = new Position(new Point(1, 2), Direction.EAST);
		assertThat(position.equals(positionTOk)).isTrue();

	}

	@Test
	public void avancer() {

		Position position = new Position(new Point(1, 2), Direction.NORTH);
		Pelouse.setCoinSup(new Point(5, 5));// on définit le coin supérieur .Avant d'avancer un point il ya une
											// vérification pour s'assurer qu'on reste dans la peleuse
		position = ExecuterInstruction.avancer(position);
		Position positionTOk = new Position(new Point(1, 3), Direction.NORTH);
		assertThat(position.equals(positionTOk)).isTrue();

	}

	@Test
	public void executer_plusieurs_instructions() {
		Pelouse.setCoinSup(new Point(5, 5));// on définit le coin supérieur .Avant d'avancer un point il ya une
											// vérification pour s'assurer qu'on reste dans la peleuse

		Position position = new Position(new Point(1, 2), Direction.NORTH);
		for (int i = 0; i < 4; i++) {
			position = ExecuterInstruction.tournerGauche(position);
			position = ExecuterInstruction.avancer(position);
		}

		position = ExecuterInstruction.avancer(position);
		Position positionTOk = new Position(new Point(1, 3), Direction.NORTH);
		assertThat(position.equals(positionTOk)).isTrue();

	}

}
