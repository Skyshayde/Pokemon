package pokemon;

public class PC {
	private Pokemon[][] boxes;
	private Bag itemStorage;
	private HashMap<String> mail;

	public PC() {
		boxes = new Pokemon[12][30];
		itemStorage = new Bag();
		mail = new HashMap<String>(String.class);
	}
	
	public void addItem(Item item) {
		itemStorage.add(item);
	}
	
	public Pokemon addPokemon(Pokemon newPokemon, int box, int pos) {
		Pokemon pokemon = boxes[box][pos];
		boxes[box][pos] = newPokemon;
		return pokemon;
	}
	
	public Pokemon[] getBox(int box) {
		return boxes[box];
	}
	
	public String getLetterSender(String letter) {
		return mail.getKeyFromText(letter);
	}
	
	public String[] getLetterSenders() {
		return mail.getKeys();
	}
	
	public Pokemon getPokemon(int box, int pos) {
		return boxes[box][pos];
	}
	
	public Item getPokemonItems(int box, int pos) {
		return boxes[box][pos].getHold();
	}
	
	public void receiveMail(String from, String letter) {
		mail.put(from, letter);
	}
	
	public void removeItem(Item item) {
		itemStorage.remove(item);
	}
	
	public void removeMail(String letter) {
		mail.removeText(letter);
	}
	
	public Pokemon removePokemon(int box, int pos) {
		Pokemon pokemon = boxes[box][pos];
		boxes[box][pos] = null;
		return pokemon;
	}
}
