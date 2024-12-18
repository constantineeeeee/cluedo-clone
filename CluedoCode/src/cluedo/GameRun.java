package cluedo;

public class GameRun {
	static Clues generate = new Clues();
	static int round = 1;
	static int killCount = 0;
	static int gameDifficulty;

	public static void main(String[] args) {
		
		MainMenuScreen mms = new MainMenuScreen();
	}
	
	static int getChosenRoom() {
		return generate.getChosenRoom();
	}
	static int getChosenWeapon() {
		return generate.getChosenWeapon();
	}
	static int getChosenPerson() {
		return generate.getChosenPerson();
	}
	static int getRound() {
		return round;
	}
	static void addRound() {
		round += 1;
	}
	static void addKill() {
		killCount += 1;
	}


}
