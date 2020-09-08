package com.example.tendeuse.pojo;

public class Position {

	private Point point;
	private Direction direction;

	public Position() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Position(Point point, Direction direction) {
		super();
		this.point = point;
		this.direction = direction;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	@Override
	public String toString() {
		return "Position [point=" + point + ", direction=" + direction + "]";
	}

	
}
