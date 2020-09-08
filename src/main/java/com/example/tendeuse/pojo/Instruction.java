package com.example.tendeuse.pojo;

public enum Instruction {
	GAUCHE('G', "Tourner à gauche"), DROITE('D', "tourner à droite"), AVANCER('A', "avancer");

	private char libelleInstruction;
	private String messageInstruction;

	private Instruction(char libelleInstruction, String messageInstruction) {
		this.libelleInstruction = libelleInstruction;
		this.messageInstruction = messageInstruction;
	}

	public char getLibelleInstruction() {
		return libelleInstruction;
	}

	public String getMessageInstruction() {
		return messageInstruction;
	}

}
