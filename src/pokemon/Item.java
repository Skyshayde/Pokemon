package pokemon;

public class Item {
	private String name;
	private ItemType type;
	private int price;
	private int sell;
	private String description;
	private Place location;
	
	public Item(String name, ItemType type, int price, int sell, String description) {
		this.name = name;
		this.type = type;
		this.price = price;
		this.sell = sell;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	
	public ItemType getItemType() {
		return type;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setSell(int sell) {
		this.sell = sell;
	}
	
	public int getSell() {
		return sell;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setLocation(Place location) {
		this.location = location;
	}
	
	public Place getLocation() {
		return location;
	}
}
