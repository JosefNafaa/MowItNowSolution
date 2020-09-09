package com.example.tendeuse.pojo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.Test;

public class PointTest {
	@Test
	public void verifier_surcharge_equals() {
		Point p1 = new Point(1, 2);
		Point p2 = new Point(1, 2);
		assertThat(p1.equals(p2)).isTrue();
		p2 = new Point(1, 3);
		assertThat(p1.equals(p2)).isFalse();
	}

	
}
