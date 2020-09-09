package com.example.tendeuse.traitement;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.example.tendeuse.pojo.Direction;
import com.example.tendeuse.pojo.Instruction;
import com.example.tendeuse.pojo.Point;

public class FormaterLigneTest {
	@Test
	public void formater_ligne_pelouse() {
		assertThat(FormaterLigne.formaterLignePoint("250 250")).isEqualTo(new Point(250, 250));
	}

	@Test
	public void formater_ligne_tondeuse() {

		assertThat(FormaterLigne.formaterLignePosition("10 15 N").getPoint()).isEqualTo(new Point(10, 15));
		assertThat(FormaterLigne.formaterLignePosition("10 15 N").getDirection()).isEqualTo(Direction.NORTH);
	}

	@Test
	public void formater_ligne_instruction() {
		assertThat(FormaterLigne.formaterLigneInstruction("DGAD")).hasSize(4).contains(Instruction.DROITE)
				.contains(Instruction.GAUCHE).contains(Instruction.AVANCER);
	}
}
