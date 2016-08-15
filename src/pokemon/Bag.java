package pokemon;

public class Bag {
	private HashMap<ItemMain> mainItems;
	private HashMap<ItemBalls> balls;
	private HashMap<ItemBerries> berries;
	private HashMap<ItemTMHM> tmhm;
	private HashMap<ItemKey> keyItems;

	public Bag() {
		mainItems = new HashMap<ItemMain>(ItemMain.class);
		balls = new HashMap<ItemBalls>(ItemBalls.class);
		berries = new HashMap<ItemBerries>(ItemBerries.class);
		tmhm = new HashMap<ItemTMHM>(ItemTMHM.class);
		keyItems = new HashMap<ItemKey>(ItemKey.class);
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
