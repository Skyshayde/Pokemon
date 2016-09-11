package pokemon;

public class Player {
	private static int id;
	private static String firstName;
	private static String lastName;
	private static int money;
	private static int badges;
	private static Pokemon[] pokemonCaught;
	private static Pokemon[] pokemonSeen;
	private static Pokemon[] pokemonParty;
	private static int partySize;
	private static PokeHashMap<String> questAchievements;
	private static Person[] peopleFriends;
	private static Person[] peopleAcquaintances;
	private static Person[] peopleFamily;
	private static boolean[] placesVisited;
	
	private static Bag bag;
	private static PC pc;
	
	private static int posX, posY;
	
	public static ImageFile imageUP, imageUP_L, imageUP_R, imageRunUP, imageRunUP_L, imageRunUP_R, 
							imageRIGHT, imageRIGHT_L, imageRIGHT_R, imageRunRIGHT, imageRunRIGHT_L, imageRunRIGHT_R, 
							imageDOWN, imageDOWN_L, imageDOWN_R, imageRunDOWN, imageRunDOWN_L, imageRunDOWN_R, 
							imageLEFT, imageLEFT_L, imageLEFT_R, imageRunLEFT, imageRunLEFT_L, imageRunLEFT_R;

	public Player() {
		new People();
		new Places();
		
		id = 0;
		firstName = "Frodo";
		lastName = "Baggins";
		money = 0;
		badges = 0;
		
		pokemonCaught = new Pokemon[Pokedex.getPokemon().length];
		pokemonSeen = new Pokemon[Pokedex.getPokemon().length];
		pokemonParty = new Pokemon[6];
		
		questAchievements = new PokeHashMap<String>(String.class);
		
		peopleFriends = new Person[People.getPeople().length];
		peopleAcquaintances = new Person[People.getPeople().length];
		peopleFamily = new Person[People.getPeople().length];
		placesVisited = new boolean[Places.getPlaces().length];
		
		bag = new Bag();
		pc = new PC();
		
		setImages();
	}
	
	public static void addItem(Item item) {
		bag.add(item);
	}

	public static void addMoney(int m) {
		money += m;
	}
	
	public boolean depositFromParty(int pos) {//TODO test
		if (pos > 0) {
			int i;
			for (i = pos; i < partySize-1; i++) {
				pokemonParty[i] = pokemonParty[i+1];
			}
			pokemonParty[i] = null;
			partySize--;
			return true;
		}
		return false;
	}
	
	public static String getFirstName() { return firstName; }
	
	public static String getFullName() { return firstName + " " + lastName; }

	public static int getID() { return id; }
	
	public static String getLastName() { return lastName; }
	
	public static int getMoney() { return money; }
	
	public static int getNumBadges() { return badges; }
	
	public int getTimeInt() {
		return 0;//TODO
	}
	
	public String getTimeString() {
		return "";//TODO
	}
	
	public static int getX() { return posX; }
	
	public static int getY() { return posY; }

	public static boolean hasPokemon(Pokemon pokemon) {
		for (int i = 0; i < pokemonCaught.length; i++) {
			if (pokemonCaught[i].getName().equals(pokemon.getName())) return true;
		}
		return false;
	}
	
	public static void healPokemon() {
		for (int i = 0; i < partySize; i++) {
			pokemonParty[i].heal();
		}
	}

	public static void removeItem(Item item) {
		bag.remove(item);
	}
	
	public static boolean seenPokemon(Pokemon pokemon) {
		for (int i = 0; i < pokemonSeen.length; i++) {
			if (pokemonSeen[i].getName().equals(pokemon.getName())) return true;
		}
		return false;
	}
	
	private void setImages() {
		imageUP = new ImageFile(getClass().getResource("/sprites/player back.png"), 15);
		imageUP_L = new ImageFile(getClass().getResource("/sprites/player back step left.png"), 15);
		imageUP_R = new ImageFile(getClass().getResource("/sprites/player back step right.png"), 15);
		imageRunUP = new ImageFile(getClass().getResource("/sprites/player back run.png"), 15);
		imageRunUP_L = new ImageFile(getClass().getResource("/sprites/player back run left.png"), 15);
		imageRunUP_R = new ImageFile(getClass().getResource("/sprites/player back run right.png"), 15);
		
		imageRIGHT = new ImageFile(getClass().getResource("/sprites/player right.png"), 15);
		imageRIGHT_L = new ImageFile(getClass().getResource("/sprites/player right step left.png"), 15);
		imageRIGHT_R = new ImageFile(getClass().getResource("/sprites/player right step right.png"), 15);
		imageRunRIGHT = new ImageFile(getClass().getResource("/sprites/player right run.png"), 15);
		imageRunRIGHT_L = new ImageFile(getClass().getResource("/sprites/player right run left.png"), 15);
		imageRunRIGHT_R = new ImageFile(getClass().getResource("/sprites/player right run right.png"), 15);
		
		imageDOWN = new ImageFile(getClass().getResource("/sprites/player front.png"), 15);
		imageDOWN_L = new ImageFile(getClass().getResource("/sprites/player front step left.png"), 15);
		imageDOWN_R = new ImageFile(getClass().getResource("/sprites/player front step right.png"), 15);
		imageRunDOWN = new ImageFile(getClass().getResource("/sprites/player front run.png"), 15);
		imageRunDOWN_L = new ImageFile(getClass().getResource("/sprites/player front run left.png"), 15);
		imageRunDOWN_R = new ImageFile(getClass().getResource("/sprites/player front run right.png"), 15);
		
		imageLEFT = new ImageFile(getClass().getResource("/sprites/player left.png"), 15);
		imageLEFT_L = new ImageFile(getClass().getResource("/sprites/player left step left.png"), 15);
		imageLEFT_R = new ImageFile(getClass().getResource("/sprites/player left step right.png"), 15);
		imageRunLEFT = new ImageFile(getClass().getResource("/sprites/player left run.png"), 15);
		imageRunLEFT_L = new ImageFile(getClass().getResource("/sprites/player left run left.png"), 15);
		imageRunLEFT_R = new ImageFile(getClass().getResource("/sprites/player left run right.png"), 15);
	}
	
	public static void setPosition(int x, int y) {
		posX = x;
		posY = y;
	}
	
	public Pokemon swapInParty(Pokemon pokemon, int pos) { 
		if (partySize == 6) {
			Pokemon temp = pokemonParty[pos];
			pokemonParty[pos] = pokemon;
			return temp;
		}
		else if (partySize <= pos) {
			pokemonParty[pos] = pokemon;
			return null;
		}
		pokemonParty[partySize] = pokemon;
		partySize++;
		return null;
	}
	
	public boolean withdrawToParty(Pokemon pokemon) { 
		if (partySize < 6) {
			pokemonParty[partySize] = pokemon;
			partySize++;
			return true;
		}
		return false;
	}
}
