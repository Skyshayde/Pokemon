package pokemon;

public class Bag {
	private PokeHashMap<ItemMain> mainItems;
	private PokeHashMap<ItemBalls> balls;
	private PokeHashMap<ItemBerries> berries;
	private PokeHashMap<ItemTMHM> tmhm;
	private PokeHashMap<ItemKey> keyItems;

	public Bag() {
		mainItems = new PokeHashMap<ItemMain>(ItemMain.class);
		balls = new PokeHashMap<ItemBalls>(ItemBalls.class);
		berries = new PokeHashMap<ItemBerries>(ItemBerries.class);
		tmhm = new PokeHashMap<ItemTMHM>(ItemTMHM.class);
		keyItems = new PokeHashMap<ItemKey>(ItemKey.class);
	}
	
	public void add(Item item) {
		switch (item.getItemType()) {
		case MAIN:
			mainItems.put((ItemMain) item, 1);
			break;
		case BALL:
			balls.put((ItemBalls) item, 1);
			break;
		case BERRY:
			berries.put((ItemBerries) item, 1);
			break;
		case TM:
			tmhm.put((ItemTMHM) item, 1);
			break;
		case HM:
			tmhm.put((ItemTMHM) item, 1);
			break;
		case KEY:
			keyItems.put((ItemKey) item, 1);
			break;
		}
	}
	
	public ItemBalls[] getBallsPocket(ItemType type) {
		return balls.getKeys();
	}
	
	public ItemBerries[] getBerriesPocket(ItemType type) {
		return berries.getKeys();
	}
	
	public ItemKey[] getKeyPocket(ItemType type) {
		return keyItems.getKeys();
	}
	
	public ItemMain[] getMainPocket(ItemType type) {
		return mainItems.getKeys();
	}
	
	public int getNumOfItem(Item item) {
		switch (item.getItemType()) {
		case MAIN:
			return mainItems.getValue((ItemMain) item);
		case BALL:
			return balls.getValue((ItemBalls) item);
		case BERRY:
			return berries.getValue((ItemBerries) item);
		case TM:
			return tmhm.getValue((ItemTMHM) item);
		case HM:
			return tmhm.getValue((ItemTMHM) item);
		case KEY:
			return keyItems.getValue((ItemKey) item);
		}
		return 0;
	}
	
	public ItemTMHM[] getTMHMPocket(ItemType type) {
		return tmhm.getKeys();
	}
	
	public void remove(Item item) {
		switch (item.getItemType()) {
		case MAIN:
			mainItems.removeValueAt((ItemMain) item);
			break;
		case BALL:
			balls.removeValueAt((ItemBalls) item);
			break;
		case BERRY:
			berries.removeValueAt((ItemBerries) item);
			break;
		case TM:
			tmhm.removeValueAt((ItemTMHM) item);
			break;
		case HM:
			tmhm.removeValueAt((ItemTMHM) item);
			break;
		case KEY:
			keyItems.removeValueAt((ItemKey) item);
			break;
		}
	}
}
