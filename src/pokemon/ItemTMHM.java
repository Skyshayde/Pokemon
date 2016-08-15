package pokemon;

public class ItemTMHM extends Item {
	private ItemType type;
	private Move move;
	private ImageFile image;
	
	public ItemTMHM(String name, Move move, ItemType type, int price, int sell, String description) {
		super(name, type, price, sell, move.getDescription());
		this.move = move;
		this.type = type;
	}
	
	public ImageFile getImage() {
		return image;
	}
	
	public void setImage(ImageFile image) {
		//TODO
	}
	
	public boolean use(Pokemon pokemon) {
		boolean isSet = pokemon.trainMove(move);
		if (isSet) {
			if (type == ItemType.TM) {
				Player.removeItem(this);
			}			
		}
		return isSet;
	}
	
}