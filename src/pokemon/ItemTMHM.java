package pokemon;

public class ItemTMHM extends Item {
	private ItemType type;
	private Move move;
	private Image image;
	
	public ItemTMHM(String name, Move move, ItemType type, int price, int sell, String description) {
		super(name, type, price, sell, move.getDescription());
		this.move = move;
		this.type = type;
	}
	
	public void use(Pokemon pokemon) {
		pokemon.trainMove(move);
		if (type == ItemType.TM) {
			Player.removeItem(this);
		}
	}
	
	public void setImage(Image image) {
		//TODO
	}
	
	public Image getImage() {
		return image;
	}
	
}