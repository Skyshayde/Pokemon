package pokemon;

public class People {
	private static Person[] people;

	public static Person[] getPeople() {
		return people;
	}
	
	public void setPeople() {
		people[0] = new PersonQuest("Rachel", Player.getLastName(), "Mom", PeopleType.GENERIC, false, 1);
			people[0].setLocation(Places.getBuildings()[0], 0, 0, 3, false, false); //TODO
			people[0].setGenDialogue("Hello honey, how are you feeling? You should rest");
			people[0].heals(true);
		people[1] = new PersonQuest("Bruce", Player.getLastName(), "Dad", PeopleType.GENERIC, true, 2);
		people[3] = new PersonQuest("Professor", "Gabriel", "Gabriel", PeopleType.PROFESSOR, true, 3);
		people[4] = new PersonQuest("Drew", "Mac", "Drew", PeopleType.GENERIC, true, 4);
		people[5] = new PersonQuest("Zach", "Wells", "Zach", PeopleType.GENERIC, true, 5);
		people[6] = new PersonQuest("Brittany", "Spears", "Brittany", PeopleType.GENERIC, false, 6);
		people[7] = new PersonQuest("Nina", "Kent", "Nina", PeopleType.GENERIC, false, 7);
	}

}
