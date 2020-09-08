package com.example.tendeuse.pojo;

import java.util.List;

public class Pelouse {

	private static Point coinSup;
	private static Point coinInf = new Point(0, 0);
	private List<Tendeuse> tendeuses;

	public static Point getCoinSup() {
		return coinSup;
	}

	public static void setCoinSup(Point coinSup) {
		Pelouse.coinSup = coinSup;
	}

	public List<Tendeuse> getTendeuses() {
		return tendeuses;
	}

	public void setTendeuses(List<Tendeuse> tendeuses) {
		this.tendeuses = tendeuses;
	}

	/**
	 * 
	 * @param p:Elle prend un point en entré
	 * @return valeur boolean pour dire si un point est dans la peleuse ou non
	 */
	public static boolean estDansPeleuse(Point p) {

		if (Pelouse.getCoinSup().getX() >= 0 && Pelouse.getCoinSup().getY() >= 0) {
			if (p.getX() > Pelouse.getCoinSup().getX() || p.getY() > Pelouse.getCoinSup().getY()
					|| p.getX() < coinInf.getX() || p.getY() < coinInf.getY())

				return false;
		} else if (Pelouse.getCoinSup().getX() <= 0 && Pelouse.getCoinSup().getY() >= 0) {
			if (p.getX() > Pelouse.getCoinSup().getX() || p.getY() > Pelouse.getCoinSup().getY()
					|| p.getX() < coinInf.getX() || p.getY() < coinInf.getY())

				return false;
		} else if (Pelouse.getCoinSup().getX() <= 0 && Pelouse.getCoinSup().getY() <= 0) {
			if (p.getX() > Pelouse.getCoinSup().getX() || p.getY() < Pelouse.getCoinSup().getY()
					|| p.getX() < coinInf.getX() || p.getY() > coinInf.getY())

				return false;
		}

		else if (Pelouse.getCoinSup().getX() >= 0 && Pelouse.getCoinSup().getY() >= 0) {
			if (p.getX() < Pelouse.getCoinSup().getX() || p.getY() > Pelouse.getCoinSup().getY()
					|| p.getX() > coinInf.getX() || p.getY() < coinInf.getY())

				return false;
		}
		return true;
	}

}
