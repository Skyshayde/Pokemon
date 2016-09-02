package writeMaps;

import pokemon.Item;

public class ItemData {
	private Item item;
	private int posX;
	private int posY;
	private boolean isHidden;
	private boolean isPatch;
	private int imageVal;

	public ItemData(Item item, int image) {
		this.item = item;
		this.imageVal = image;
	}

	public int getImageVal() { return imageVal; }
	
	public Item getItem() { return item; }
	
	public int getX() { return posX; }
	public int getY () { return posY; }

	public boolean isHidden() { return isHidden; }

	public boolean isPatch() { return isPatch; }
	
	public void setHidden(boolean hidden) { isHidden = hidden; }
	
	public void setPatch(boolean patch) { isPatch = patch; }

}
