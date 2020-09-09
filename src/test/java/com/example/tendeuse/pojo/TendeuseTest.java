package com.example.tendeuse.pojo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class TendeuseTest {
	@Test
	public void verifier_surcharge_equals() {
		Point p1 = new Point(1, 2);
		Position pos1 = new Position();
		pos1.setDirection(Direction.EAST);
		Position pos2 = new Position();
		pos2.setDirection(Direction.SOUTH);
		Point p2 = new Point(1, 2);
		List<Instruction> instructions = new ArrayList<Instruction>();
		instructions.add(Instruction.AVANCER);
		instructions.add(Instruction.DROITE);
		Tendeuse t1 = new Tendeuse();
		t1.setInstructions(instructions);
		t1.setPosition(pos1);
		Tendeuse t2 = new Tendeuse();
		t2.setInstructions(instructions);
		t2.setPosition(pos1);
		Point p3 = new Point(1, 3);
		assertThat(t1.equals(t2)).isTrue();
		t2.setPosition(pos2);
		assertThat(t1.equals(t2)).isFalse();
	}
}
