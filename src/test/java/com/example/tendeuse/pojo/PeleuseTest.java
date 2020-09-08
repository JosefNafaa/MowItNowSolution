package com.example.tendeuse.pojo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class PeleuseTest {

	Pelouse pelouse;
	Point coinSup = new Point(5, 5);


	public void init() {
		pelouse = new Pelouse();
		pelouse.setCoinSup(coinSup);

	}

	@Test
	public void verifier_si_point_appartient_a_la_pelouse() {
		this.init();
		Point point = new Point(3, 2);
		boolean var = pelouse.estDansPeleuse(point);
		assertTrue(var);
	}
	@Test
	public void verifier_si_point_ne_se_trouve_pas_dans_la_pelouse() {
		this.init();
		Point point = new Point(-3, 2);
		boolean var = pelouse.estDansPeleuse(point);
		assertFalse(var);
	}
}
