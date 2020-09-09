package com.example.tendeuse.pojo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class PositionTest {
	@Test
	public void verifier_surcharge_equals() {

		Position positionT = new Position(new Point(5, 5), Direction.NORTH);
		Position positionTOk = new Position(new Point(5, 5), Direction.NORTH);
		Position positionTKo = new Position(new Point(5, 5), Direction.SOUTH);

		assertThat(positionT.equals(positionTOk)).isTrue();
		assertThat(positionT.equals(positionTKo)).isFalse();
	}

}
