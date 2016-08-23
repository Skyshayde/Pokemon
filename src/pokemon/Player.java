package pokemon;

import javax.swing.Icon;

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
	
	public static ImageFile imageUP;
	public static ImageFile imageUP_L;
	public static ImageFile imageUP_R;
	public static ImageFile imageRunUP;
	public static ImageFile imageRunUP_L;
	public static ImageFile imageRunUP_R;
	public static ImageFile imageRIGHT;
	public static ImageFile imageRIGHT_L;
	public static ImageFile imageRIGHT_R;
	public static ImageFile imageRunRIGHT;
	public static ImageFile imageRunRIGHT_L;
	public static ImageFile imageRunRIGHT_R;
	public static ImageFile imageDOWN;
	public static ImageFile imageDOWN_L;
	public static ImageFile imageDOWN_R;
	public static ImageFile imageRunDOWN;
	public static ImageFile imageRunDOWN_L;
	public static ImageFile imageRunDOWN_R;
	public static ImageFile imageLEFT;
	public static ImageFile imageLEFT_L;
	public static ImageFile imageLEFT_R;
	public static ImageFile imageRunLEFT;
	public static ImageFile imageRunLEFT_L;
	public static ImageFile imageRunLEFT_R;

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
		imageUP = new ImageFile(getClass().getResource("/sprites/player back.png"), 10);
		imageUP_L = new ImageFile(getClass().getResource("/sprites/player back step left.png"), 10);
		imageUP_R = new ImageFile(getClass().getResource("/sprites/player back step right.png"), 10);
		imageRunUP = new ImageFile(getClass().getResource("/sprites/player back run.png"), 10);
		imageRunUP_L = new ImageFile(getClass().getResource("/sprites/player back run left.png"), 10);
		imageRunUP_R = new ImageFile(getClass().getResource("/sprites/player back run right.png"), 10);
		
		imageRIGHT = new ImageFile(getClass().getResource("/sprites/player right.png"), 10);
		imageRIGHT_L = new ImageFile(getClass().getResource("/sprites/player right step left.png"), 10);
		imageRIGHT_R = new ImageFile(getClass().getResource("/sprites/player right step right.png"), 10);
		imageRunRIGHT = new ImageFile(getClass().getResource("/sprites/player right run.png"), 10);
		imageRunRIGHT_L = new ImageFile(getClass().getResource("/sprites/player right run left.png"), 10);
		imageRunRIGHT_R = new ImageFile(getClass().getResource("/sprites/player right run right.png"), 10);
		
		imageDOWN = new ImageFile(getClass().getResource("/sprites/player front.png"), 10);
		imageDOWN_L = new ImageFile(getClass().getResource("/sprites/player front step left.png"), 10);
		imageDOWN_R = new ImageFile(getClass().getResource("/sprites/player front step right.png"), 10);
		imageRunDOWN = new ImageFile(getClass().getResource("/sprites/player front run.png"), 10);
		imageRunDOWN_L = new ImageFile(getClass().getResource("/sprites/player front run left.png"), 10);
		imageRunDOWN_R = new ImageFile(getClass().getResource("/sprites/player front run right.png"), 10);
		
		imageLEFT = new ImageFile(getClass().getResource("/sprites/player left.png"), 10);
		imageLEFT_L = new ImageFile(getClass().getResource("/sprites/player left step left.png"), 10);
		imageLEFT_R = new ImageFile(getClass().getResource("/sprites/player left step right.png"), 10);
		imageRunLEFT = new ImageFile(getClass().getResource("/sprites/player left run.png"), 10);
		imageRunLEFT_L = new ImageFile(getClass().getResource("/sprites/player left run left.png"), 10);
		imageRunLEFT_R = new ImageFile(getClass().getResource("/sprites/player left run right.png"), 10);
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
