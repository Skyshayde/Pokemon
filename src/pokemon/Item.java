package pokemon;

public class Item {
	private int id;
	private String name;
	private ItemType type;
	private int price;
	private int sell;
	private String description;
	private Place location;
	
	public Item(int id, String name, ItemType type, int price, int sell, String description) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.price = price;
		this.sell = sell;
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getID() {
		return id;
	}
	
	public ItemType getItemType() {
		return type;
	}
	
	public Place getLocation() {
		return location;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public int getSell() {
		return sell;
	}
	
	public void setLocation(Place location) {
		this.location = location;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setSell(int sell) {
		this.sell = sell;
	}
}
