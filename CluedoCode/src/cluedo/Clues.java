package cluedo;

import java.util.LinkedList;
import java.util.Random;

public class Clues {
	Random rand = new Random();
	int roomSize = 9, personNum = 5, weaponNum = 4;
	String[] roomNames = {"Conservatory", "Billiard Room", "Library", 
							"Study", "Ball Room", "Hall", 
							"Kitchen", "Dining Room", "Lounge"};
	String[] peopleNames = {"Miss Scarlett", "Colonel Mustard", "Mrs White", "Professor Plum", "Reverend Green"};
	String[] weaponNames = {"Dagger", "Revolver", "Wrench", "Candlestick"};
	
	String[][] peopleClues = {{"This person is living their life", "This person is quite young", "This person is fond of a primary color"},
							  {"This person has aged well", "This person has light hair", "This person has a mustache"},
							  {"This person is female", "This person has dark hair", "This person is married"},
							  {"This person is wearing head accessores", "This person lacks hair", "This person smokes"},
							  {"This person is NOT wearing head accessories", "This person has glowing ears", "This person is NOT wearing a tie"}};
	String[][] weaponClues = {{"The weapon is sharp", "This weapon is short"},
							  {"This weapon is long-ranged", "This weapon is easy to conceal"},
							  {"This weapon is a household tool", "This weapon is long"},
							  {"This weapon is often used in darkness", "this weapon may have prongs"}};
	
	private int chosenRoom, chosenWeapon, chosenPerson;
	
	LinkedList<RoomClues>[] rooms;
	LinkedList<PersonClues>[] persons;
	LinkedList<WeaponClues>[] weapons;
	
	@SuppressWarnings("unchecked")
	public Clues(){
		//generateAnswers();
		
		rooms = new LinkedList[roomSize];
		persons = new LinkedList[personNum];
		weapons = new LinkedList[weaponNum];
		
		for(int i = 0; i < roomSize; i++) {
			rooms[i] = new LinkedList<RoomClues>();
			
			rooms[i].add(new RoomClues("The " + roomNames[i] + " was where the victim was killed"));
			rooms[i].add(new RoomClues("There are no signs of any disturbance in the " + roomNames[i]));
		}
		
		for(int i = 0; i < personNum; i++) {
			persons[i] = new LinkedList<PersonClues>();
			
			for(int j = 0; j < 3; j++) {
				persons[i].add(new PersonClues(peopleClues[i][j]));
			}
		}

		for(int i = 0; i < weaponNum; i++) {
			weapons[i] = new LinkedList<WeaponClues>();
			
			for(int j = 0; j < 2; j++) {
				weapons[i].add(new WeaponClues(weaponClues[i][j]));
			}
		}
	}

	public String getRoomClue(int roomNum) {
		if(roomNum == chosenRoom) {
			return rooms[roomNum].get(0).getClue();
		}
		else {
			return rooms[roomNum].get(1).getClue();
		}
	}
	public String getPersonClue(int roomNum) {
		int p = rand.nextInt(0, 4);
		
		if(roomNum == chosenRoom) {
			if(p == chosenPerson) {				
				return persons[chosenPerson].get(rand.nextInt(0, 3)).getClue() + ". This person is the culprit";
			}
			else {				
				return persons[p].get(rand.nextInt(0, 3)).getClue() + ". This person is NOT the culprit";
			}
		}
		else {
			if(p == chosenPerson) {				
				return persons[chosenPerson].get(rand.nextInt(0, 3)).getClue() + ". This person is the culprit";
			}
			else {				
				return persons[p].get(rand.nextInt(0, 3)).getClue() + ". This person is NOT the culprit";
			}
		}
	}
	public String getWeaponClue(int roomNum) {
		int p = rand.nextInt(0, 3);
		
		if(roomNum == chosenRoom) {
			if(p == chosenWeapon) {				
				return weapons[chosenWeapon].get(rand.nextInt(0, 2)).getClue() + ". This was the culpit's weapon";
			}
			else {				
				return weapons[p].get(rand.nextInt(0, 2)).getClue() + ". This was NOT the culpit's weapon";
			}
		}
		else {
			if(p == chosenWeapon) {				
				return weapons[chosenWeapon].get(rand.nextInt(0, 2)).getClue() + ". This was the culpit's weapon";
			}
			else {				
				return weapons[p].get(rand.nextInt(0, 2)).getClue() + ". This was NOT the culpit's weapon";
			}
		}
	}
	
	public void setChosenRoom(int room) {
		chosenRoom = room;
	}
	public void setChosenWeapon(int chosenWeapon) {
		this.chosenWeapon = chosenWeapon;
	}
	public void setChosenPerson(int chosenPerson) {
		this.chosenPerson = chosenPerson;
	}
	public int getChosenRoom() {
		return chosenRoom;
	}
	public int getChosenPerson() {
		return chosenPerson;
	}
	public int getChosenWeapon() {
		return chosenWeapon;
	}
	
	
	public String getRoomName(int i) {
		return roomNames[i];
	}
	public String getWeaponName(int i) {
		return weaponNames[i];
	}
	
	public void generateAnswers(int peopleMax) {
		saveLoadWin.getAnswersFilehandler().createNewFile("answers", true);
		
		chosenRoom = rand.nextInt(0, 9);
		setChosenWeapon(rand.nextInt(0, 4));
		setChosenPerson(rand.nextInt(0, peopleMax));		
	}

}
