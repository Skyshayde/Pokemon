package pokemon;

public class Pokedex {
	private static PokemonGeneric[] pokedex;
	
	public Pokedex() {
		pokedex = new PokemonGeneric[7];
		setPokemon();
	}
	
	public void setPokemon() {
		pokedex[0] = new PokemonGeneric("Bulbasaur", Element.GRASS, 5, "grassy pokemon", 1);
		pokedex[1] = new PokemonGeneric("Ivysaur", Element.GRASS, 5, "grassy pokemon", 2);
		pokedex[2] = new PokemonGeneric("Venasaur", Element.GRASS, 5, "grassy pokemon", 3);
		pokedex[3] = new PokemonGeneric("Charmander", Element.FIRE, 5, "firey pokemon", 4);
		pokedex[4] = new PokemonGeneric("Charmealeon", Element.FIRE, 5, "firey pokemon", 5);
		pokedex[5] = new PokemonGeneric("Charizard", Element.FIRE, 5, "firey pokemon", 6);
		pokedex[6] = new PokemonGeneric("Squirtle", Element.WATER, 5, "watery pokemon", 7);
		pokedex[7] = new PokemonGeneric("Squirtle", Element.WATER, 5, "watery pokemon", 8);
		pokedex[8] = new PokemonGeneric("Squirtle", Element.WATER, 5, "watery pokemon", 9);
		pokedex[9] = new PokemonGeneric("Cindaquil", Element.FIRE, 5, "firey pokemon", 10);
		pokedex[10] = new PokemonGeneric("Cindaquil", Element.FIRE, 5, "firey pokemon", 11);
		pokedex[11] = new PokemonGeneric("Cindaquil", Element.FIRE, 5, "firey pokemon", 12);
		pokedex[12] = new PokemonGeneric("Mudkip", Element.WATER, 5, "watery pokemon", 13);
		pokedex[13] = new PokemonGeneric("Mudkip", Element.WATER, 5, "watery pokemon", 14);
		pokedex[14] = new PokemonGeneric("Mudkip", Element.WATER, 5, "watery pokemon", 15);
		pokedex[15] = new PokemonGeneric("Machop", Element.FIGHTING, 5, "fighting pokemon", 16);
		pokedex[16] = new PokemonGeneric("Machop", Element.FIGHTING, 5, "fighting pokemon", 17);
		pokedex[17] = new PokemonGeneric("Machop", Element.FIGHTING, 5, "fighting pokemon", 18);
	}
	
	public PokemonGeneric[] getPokemon() {
		return pokedex;
	}
	
	public String toString() {
		System.out.println(pokedex[0].toString());
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 5; i++) {
			builder.append(pokedex[i].toString());
			builder.append(", ");
		}
		return builder.toString();
	}
}
