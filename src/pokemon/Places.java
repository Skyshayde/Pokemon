package pokemon;

public class Places {
	private static Place[] places;
	private static Place[] mapLocations;
	private static Place[] buildings;
	private static ImageFile[] maps;
	
	public Places() {
		maps = new ImageFile[1];//TODO
		setMapImages();
		places = new Place[1]; //TODO
		setPlaces();
	}
	
	public static Place[] getBuildings() {
		return buildings;
	}
	
	public static ImageFile getMap(int place) { return maps[place]; }
	
	public static Place[] getMapLocations() {
		return mapLocations;
	}
	
	public static Place[] getPlaces() {
		return places;
	}
	
	public void setPlaces() {
		places[0] = new Place(38, 37, "Ambler Johnstown", 0);
	}
	
	public void setMapImages() {
		maps[0] = new ImageFile(getClass().getResource("/maps/Ambler Johnstown - Map.png"), 420);
	}
	

}
