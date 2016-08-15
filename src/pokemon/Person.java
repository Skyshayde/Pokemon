package pokemon;

public class Person {
	private String firstName;
	private String lastName;
	private String displayName;
	private PeopleType type;
	private boolean gender;
	private int id;
	private int money;
	private Place location;
	private int posX;
	private int posY;
	private int facing; //NOTE: 0=North, 1=East, 2=South, 3=West
	private boolean turns;
	private boolean[] turnsTo;
	private boolean walks;
	private int[][] walkingCoordinates;
	private String genericDialogue;
	private boolean heals;
	
	public Person(String firstName, String lastName, String displayName, 
			PeopleType type, boolean gender, int id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.displayName = displayName;
		this.type = type;
		this.gender = gender;
		this.id = id;
		money = 0;
	}
	
	public void addMoney(int money) { this.money += money; }
	
	public boolean doesTurn() { return turns; }
	
	public boolean doesWalk() { return walks; }
	
	public String getDisplayName() { return displayName; }
	
	public int getFacingDirection() { return facing; }
	
	public String getFullName() { return firstName + " " + lastName; }
	
	public String getGender() {
		if (gender) return "Male";
		return "Female";
	}
	
	public String getGenDialogue() { return genericDialogue; }
	
	public int getID() { return id; }
	
	public Place getLocation() { return location; }
	
	public int getMoney() { return money; }
	
	public PeopleType getPeopleType() { return type; }
	
	public int getPosX() { return posX; }
	
	public int getPosY() { return posY; }

	public int[][] getWalkingCoordinates() { return walkingCoordinates; }
	
	public void heals(boolean heal) { heals = heal; }
	
	public void onSelection() { //TODO
		//speaks
		if (heals) Player.healPokemon();
	}
	
	public void setDisplayName(String name) { displayName = name; }	
	
	public void setGenDialogue(String dialogue) { genericDialogue = dialogue; }
	
	public void setLocation(Place location, int x, int y, int facing, 
			boolean turns, boolean walks) {
		this.location = location;
		posX = x;
		posY = y;
		this.facing = facing;
		this.turns = turns;
		this.walks = walks;
	}
	
	public void setTurningDirections(boolean north, boolean east, 
			boolean south, boolean west) {
		turnsTo = new boolean[4];
		turnsTo[0] = north;
		turnsTo[1] = east;
		turnsTo[2] = south;
		turnsTo[3] = west;
	}
	
	public void setWalkingCoordinates(int[][] pos) {
		walkingCoordinates = pos; //TODO better way?
	}
	
}
