package pokemon;

public class Pokedex {
	private static PokemonGeneric[] pokedex;
	
	public Pokedex() {
		pokedex = new PokemonGeneric[7];//TODO
		setPokemon();
	}
	
	public static PokemonGeneric[] getPokemon() {
		return pokedex;
	}
	
	public void setPokemon() {
		pokedex[0] = new PokemonGeneric("Bulbasaur", Element.GRASS, 5, "There is a plant seed on its back right from the day this Pokémon is born. The seed slowly grows larger.", 1);
		pokedex[0].addElement(Element.POISON);
			
		pokedex[1] = new PokemonGeneric("Ivysaur", Element.GRASS, 5, "There is a plant bulb on its back. When it absorbs nutrients, the bulb is said to blossom into a large flower.", 2);
		pokedex[1].addElement(Element.POISON);
		
		pokedex[2] = new PokemonGeneric("Venasaur", Element.GRASS, 5, "A bewitching aroma wafts from its flower. The fragrance becalms those engaged in a battle.", 3);
		pokedex[2].addElement(Element.POISON);
		
		pokedex[3] = new PokemonGeneric("Brontasaur", Element.GRASS, 5, "", 4);
		pokedex[3].addElement(Element.POISON);
			
		pokedex[4] = new PokemonGeneric("Machop", Element.FIGHTING, 5, "Its whole body is composed of muscles. Even though it's the size of a human child, it can hurl 100 grown-ups.", 5);
		
		pokedex[5] = new PokemonGeneric("Machoke", Element.FIGHTING, 5, "Its formidable body never gets tired. It helps people by doing work such as the moving of heavy goods.", 6);
		
		pokedex[6] = new PokemonGeneric("Machamp", Element.FIGHTING, 5, "Its four ruggedly developed arms can launch a flurry of 1,000 punches in just two seconds.", 7);
		
		pokedex[7] = new PokemonGeneric("Machampion", Element.FIGHTING, 5, "", 8);
		
		pokedex[8] = new PokemonGeneric("Dratini", Element.DRAGON, 5, "Long considered a mythical Pokémon until recently, when a small colony was found living underwater.", 9);
		
		pokedex[9] = new PokemonGeneric("Dragonair", Element.DRAGON, 5, "A mystical Pokémon that exudes a gentle aura. It is said to have the ability to change the weather.", 10);
		
		pokedex[10] = new PokemonGeneric("Dragonite", Element.DRAGON, 5, "Very few people ever see this Pokémon. Its intelligence is said to match that of humans.", 11);
		pokedex[10].addElement(Element.FLYING);
		
		pokedex[11] = new PokemonGeneric("", Element.DRAGON, 5, "", 12);
		pokedex[11].addElement(Element.FLYING);
		
		pokedex[12] = new PokemonGeneric("Cyndaquil", Element.FIRE, 5, "It is timid, and always curls itself up in a ball. If attacked, it flares up its back for protection.", 13);
		
		pokedex[13] = new PokemonGeneric("Quilava", Element.FIRE, 5, "This Pokémon is fully covered by nonflammable fur. It can withstand any kind of fire attack.", 14);
		
		pokedex[14] = new PokemonGeneric("Typhlosion", Element.FIRE, 5, "If its rage peaks, it becomes so hot that anything that touches it will instantly go up in flames.", 15);
		
		pokedex[15] = new PokemonGeneric("", Element.FIRE, 5, "", 16);
		
		pokedex[16] = new PokemonGeneric("Pichu", Element.ELECTRIC, 5, "Despite its small size, it can zap even adult humans. However, if it does so, it also surprises itself.", 17);
		
		pokedex[17] = new PokemonGeneric("Pikachu", Element.ELECTRIC, 5, "When several of these Pokémon gather, their electricity could build and cause lightning storms.", 18);
		
		pokedex[18] = new PokemonGeneric("Raichu", Element.ELECTRIC, 5, "Its long tail serves as a ground to protect itself from its own high voltage power.", 19);
		
		pokedex[19] = new PokemonGeneric("", Element.ELECTRIC, 5, "", 20);
		
		pokedex[20] = new PokemonGeneric("Mudkip", Element.WATER, 5, "Its large tail fin propels it through water with powerful acceleration. It is strong in spite of its size.", 21);
		
		pokedex[21] = new PokemonGeneric("Marshtomp", Element.WATER, 5, "", 22);
		pokedex[21].addElement(Element.GROUND);
		
		pokedex[22] = new PokemonGeneric("Swampert", Element.WATER, 5, "", 23);
		pokedex[22].addElement(Element.GROUND);
		
		pokedex[23] = new PokemonGeneric("Laguna", Element.WATER, 5, "", 24);
		pokedex[23].addElement(Element.GROUND);
		
		pokedex[24] = new PokemonGeneric("Ralts", Element.PSYCHIC, 5, "It is highly attuned to the emotions of people and Pokémon. It hides if it senses hostility.", 25);
		
		pokedex[25] = new PokemonGeneric("Kirlia", Element.PSYCHIC, 5, "", 26);
		
		pokedex[26] = new PokemonGeneric("Gardevior", Element.PSYCHIC, 5, "", 27);
		
		pokedex[27] = new PokemonGeneric("Gallade", Element.PSYCHIC, 5, "", 28);
		pokedex[27].addElement(Element.FIGHTING);
		
		pokedex[28] = new PokemonGeneric("Aron", Element.STEEL, 5, "", 29);
		pokedex[28].addElement(Element.ROCK);
		//pokedex[28].addLevelMove();
		
		pokedex[29] = new PokemonGeneric("Lairon", Element.STEEL, 5, "", 30);
		pokedex[29].addElement(Element.ROCK);
		
		pokedex[30] = new PokemonGeneric("Aggron", Element.STEEL, 5, "", 31);
		pokedex[30].addElement(Element.ROCK);
		
		pokedex[31] = new PokemonGeneric("Megaron", Element.STEEL, 5, "", 32);
		pokedex[31].addElement(Element.ROCK);
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
