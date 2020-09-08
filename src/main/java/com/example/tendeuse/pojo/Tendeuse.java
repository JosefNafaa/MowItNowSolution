package com.example.tendeuse.pojo;

import java.util.List;

public class Tendeuse {

	private Position position;
	private List<Instruction> instructions;
	

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public List<Instruction> getInstructions() {
		return instructions;
	}

	public void setInstructions(List<Instruction> instructions) {
		this.instructions = instructions;
	}

}
