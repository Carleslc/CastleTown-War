package domain;

import domain.utils.IO;

public class CastleTownWar {

	public static void main(String[] args) {
		System.out.println("Welcome to CastleTown War!");
		new Game().run();
		IO.close();
	}

}
