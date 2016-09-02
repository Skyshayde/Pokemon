package pokemon;

public class PersonTrainer extends Person {
	private Pokemon[] pokemonParty;
	private Item[] items;
	private int itemSize;
	private int money;
	private String battleStartDialogue;
	private String battleEndDialogue;

	public PersonTrainer(String firstName, String lastName, String displayName, 
			PeopleType type, boolean gender, int id) {
		super(firstName, lastName, displayName, type, gender, id);
		super.setClassID('T');
		pokemonParty = new Pokemon[6];
		items = new Item[20]; //Sets max items per trainer to 20
		itemSize = 0;
	}
	
	public void addItem(Item item, int amount) { 
		for (int i = 0; i < amount; i++) {
			if (itemSize < 20) {
				items[itemSize] = item;
				itemSize++;
			}
		}
	}
	
	public String getBattleEndDialogue() { return battleEndDialogue; }
	
	public String getBattleStartDialogue() { return battleStartDialogue; }
	
	public Item[] getItems() { return items; }

	public int getMoney() { return money; }

	public Pokemon[] getPokemon() { return pokemonParty; }
	
	public void setBattleEndDialogue(String dialogue) { battleEndDialogue = dialogue; }
	
	public void setBattleStartDialogue(String dialogue) { battleStartDialogue = dialogue; }
	
	public void setMoney(int money) { this.money = money; }
	
	public void setPokemon(Pokemon p1, Pokemon p2, Pokemon p3, Pokemon p4, Pokemon p5, Pokemon p6) { 
		pokemonParty[0] = p1;
		pokemonParty[1] = p2;
		pokemonParty[2] = p3;
		pokemonParty[3] = p4;
		pokemonParty[4] = p5;
		pokemonParty[5] = p6;
	}
	
}
