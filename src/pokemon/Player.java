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
	private static HashMap<String> questAchievements;
	private static Person[] peopleFriends;
	private static Person[] peopleAcquaintances;
	private static Person[] peopleFamily;
	private static boolean[] placesVisited;
	
	private static Bag bag;
	private static PC pc;

	public Player() {
		id = 0;
		firstName = "Frodo";
		lastName = "Baggins";
		money = 0;
		badges = 0;
		
		pokemonCaught = new Pokemon[Pokedex.getPokemon().length];
		pokemonSeen = new Pokemon[Pokedex.getPokemon().length];
		pokemonParty = new Pokemon[6];
		
		questAchievements = new HashMap<String>(String.class);
		
		peopleFriends = new Person[People.getPeople().length];
		peopleAcquaintances = new Person[People.getPeople().length];
		peopleFamily = new Person[People.getPeople().length];
		placesVisited = new boolean[Places.getPlaces().length];
		
		bag = new Bag();
		pc = new PC();
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
