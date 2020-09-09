package com.example.tendeuse.main;

public class MainTestFormat {
	
	public static void main(String args[]) {

		final String SEPARATEUR = " ";
		String conte = "55555 12565";

		String mots[] = conte.split(SEPARATEUR);

		for (int i = 0; i < mots.length; i++) {
			System.out.println(mots[i]);
		}
		System.out.println(Integer.parseInt(String.valueOf(mots[0])));
	}
}
