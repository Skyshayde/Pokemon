package pokemon;

import javax.swing.JLabel;

public class Places {
	private static Place[] places;
	private static Place[] mapLocations;
	private static Place[] buildings;
	private static int currentPlace;
	
	public Places() {
		places = new Place[2]; //TODO
		setPlaces();
	}
	
	public static Place[] getBuildings() {
		return buildings;
	}
	
	public static Place[] getMapLocations() {
		return mapLocations;
	}
	
	public static Place[] getPlaces() {
		return places;
	}
	
	public void setPlaces() {
		places[0] = new Place(38, 37, "Ambler Johnstown", 0);
	}
	
	public static JLabel createMap(int m) {
		currentPlace = m;
		places[m].startSong();
		return places[m].getMap();
	}
	
	public static JLabel getLayerMap() {
		return places[currentPlace].getMapLayer();
	}
	
	public static JLabel getObjectsMap() {
		return places[currentPlace].getMapObjects();
	}
	
	public static int threadNum() {
		return currentPlace;
	}
	
	
}
