package pokemon;

import javax.swing.JLabel;

public class Place {
	private String name;
	private int placeID;
	private Blocks[][] grid;
	private Place[] adj;
	private JLabel map, mapL, mapO;
	private Song song;
	
	public Place(int x, int y, String name, int id) {
		this.name = name;
		placeID = id; //NOTE: starts at 0 for arrays
		grid = new Blocks[x][y];
		adj = new Place[4];
		
		setGrid();
		setMaps();
	}
	
	/**
	 * @param dir of 0 is north, 1 is east, 2 is south, 3 is west
	 */
	public void setAdjPlaces(Place p, int dir) {
		if (dir < 4 && dir >= 0) {
			adj[dir] = p;
		}
		else {
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * @param dir of 0 is north, 1 is east, 2 is south, 3 is west
	 */
	public Place getAdjPlaceAt(int dir) {
		if (dir < 4 && dir >= 0) {
			return adj[dir];
		}
		throw new IllegalArgumentException();
	}
	
	public void setMaps() {
		ImageFile mapImage = new ImageFile(getClass().getResource("/maps/"+name+" - Map.png"), 420);
		ImageFile mapLImage = new ImageFile(getClass().getResource("/maps/"+name+" - MapL.png"), 420);
		ImageFile mapOImage = new ImageFile(getClass().getResource("/maps/"+name+" - MapO.png"), 420);
		
		map = new JLabel(mapImage);
		map.setBounds(-527, -731, mapImage.getIconWidth(), mapImage.getIconHeight());
		mapL = new JLabel(mapLImage);
		mapL.setBounds(-527, -731, mapLImage.getIconWidth(), mapLImage.getIconHeight());
		mapO = new JLabel(mapOImage);
		mapO.setBounds(-527, -731, mapOImage.getIconWidth(), mapOImage.getIconHeight());
	}
	
	public void startSong() {
		song = new Song("/songs/T1.wav");
		song.loop();
	}
	
	public void stopSong() {
		song.stop();
	}
	
	public JLabel getMap() {
		return map;
	}
	
	public JLabel getMapLayer() {
		return mapL;
	}
	
	public JLabel getMapObjects() {
		return mapO;
	}
	
	public void setGrid() {
		grid[7][12] = Blocks.WATER;
		grid[8][12] = Blocks.WATER;
		grid[9][12] = Blocks.WATER;
		grid[10][12] = Blocks.WATER;
		grid[11][12] = Blocks.WATER;
		grid[12][12] = Blocks.WATER;
		grid[13][12] = Blocks.WATER;
		grid[14][12] = Blocks.WATER;
		grid[15][12] = Blocks.WATER;
		grid[16][11] = Blocks.WATER;
		grid[17][11] = Blocks.WATER;
		grid[18][11] = Blocks.WATER;
		grid[19][11] = Blocks.WATER;
		grid[20][11] = Blocks.WATER;
		grid[21][11] = Blocks.WATER;
		grid[22][11] = Blocks.WATER;
		grid[23][11] = Blocks.BARRIER;
		grid[24][11] = Blocks.BARRIER;
		grid[25][11] = Blocks.BARRIER;
		grid[26][11] = Blocks.BARRIER;
		grid[26][10] = Blocks.BARRIER;
		grid[26][9] = Blocks.BARRIER;
		grid[26][8] = Blocks.BARRIER;
		grid[26][7] = Blocks.BARRIER;
		grid[26][6] = Blocks.BARRIER;
		grid[26][5] = Blocks.BARRIER;
		grid[26][4] = Blocks.BARRIER;
		grid[26][3] = Blocks.BARRIER;
		grid[26][2] = Blocks.BARRIER;
		grid[26][1] = Blocks.BARRIER;
		grid[26][0] = Blocks.BARRIER;
		grid[31][0] = Blocks.BARRIER;
		grid[31][1] = Blocks.BARRIER;
		grid[31][2] = Blocks.BARRIER;
		grid[31][3] = Blocks.BARRIER;
		grid[31][4] = Blocks.BARRIER;
		grid[31][5] = Blocks.BARRIER;
		grid[31][6] = Blocks.BARRIER;
		grid[31][7] = Blocks.BARRIER;
		grid[31][8] = Blocks.BARRIER;
		grid[31][9] = Blocks.BARRIER;
		grid[31][10] = Blocks.BARRIER;
		grid[31][11] = Blocks.BARRIER;
		grid[31][12] = Blocks.BARRIER;
		grid[31][13] = Blocks.BARRIER;
		grid[31][14] = Blocks.BARRIER;
		grid[31][15] = Blocks.BARRIER;
		grid[31][16] = Blocks.BARRIER;
		grid[31][17] = Blocks.BARRIER;
		grid[31][18] = Blocks.BARRIER;
		grid[31][19] = Blocks.BARRIER;
		grid[31][20] = Blocks.BARRIER;
		grid[31][21] = Blocks.BARRIER;
		grid[31][22] = Blocks.BARRIER;
		grid[31][23] = Blocks.BARRIER;
		grid[31][24] = Blocks.BARRIER;
		grid[31][25] = Blocks.BARRIER;
		grid[31][26] = Blocks.BARRIER;
		grid[31][27] = Blocks.BARRIER;
		grid[31][28] = Blocks.BARRIER;
		grid[31][29] = Blocks.BARRIER;
		grid[30][30] = Blocks.BARRIER;
		grid[29][30] = Blocks.BARRIER;
		grid[29][31] = Blocks.BARRIER;
		grid[28][32] = Blocks.BARRIER;
		grid[27][32] = Blocks.BARRIER;
		grid[26][32] = Blocks.BARRIER;
		grid[25][32] = Blocks.BARRIER;
		grid[24][32] = Blocks.BARRIER;
		grid[23][32] = Blocks.BARRIER;
		grid[22][32] = Blocks.BARRIER;
		grid[21][32] = Blocks.BARRIER;
		grid[20][32] = Blocks.BARRIER;
		grid[19][32] = Blocks.BARRIER;
		grid[18][32] = Blocks.BARRIER;
		grid[17][32] = Blocks.BARRIER;
		grid[16][32] = Blocks.BARRIER;
		grid[15][32] = Blocks.BARRIER;
		grid[14][32] = Blocks.BARRIER;
		grid[13][32] = Blocks.BARRIER;
		grid[12][32] = Blocks.BARRIER;
		grid[11][32] = Blocks.BARRIER;
		grid[10][32] = Blocks.BARRIER;
		grid[9][32] = Blocks.BARRIER;
		grid[8][31] = Blocks.BARRIER;
		grid[8][30] = Blocks.BARRIER;
		grid[7][30] = Blocks.BARRIER;
		grid[6][29] = Blocks.BARRIER;
		grid[6][28] = Blocks.BARRIER;
		grid[6][27] = Blocks.BARRIER;
		grid[6][26] = Blocks.BARRIER;
		grid[6][25] = Blocks.BARRIER;
		grid[6][24] = Blocks.BARRIER;
		grid[6][23] = Blocks.BARRIER;
		grid[6][22] = Blocks.BARRIER;
		grid[6][21] = Blocks.BARRIER;
		grid[6][20] = Blocks.BARRIER;
		grid[6][19] = Blocks.BARRIER;
		grid[6][18] = Blocks.BARRIER;
		grid[6][17] = Blocks.BARRIER;
		grid[6][16] = Blocks.BARRIER;
		grid[6][15] = Blocks.BARRIER;
		grid[6][14] = Blocks.BARRIER;
		grid[6][13] = Blocks.BARRIER;
		
		grid[9][19] = Blocks.BARRIER;
		grid[9][18] = Blocks.BARRIER;
		grid[9][17] = Blocks.BARRIER;
		grid[10][17] = Blocks.BARRIER;
		grid[11][17] = Blocks.BARRIER;
		grid[12][17] = Blocks.BARRIER;
		grid[13][17] = Blocks.BARRIER;
		grid[13][18] = Blocks.BARRIER;
		grid[14][19] = Blocks.SIGNBARRIER;
		grid[13][19] = Blocks.BARRIER;
		grid[12][19] = Blocks.BARRIER;
		grid[11][19] = Blocks.DOOR;
		grid[10][19] = Blocks.BARRIER;
		grid[10][20] = Blocks.FLOWER;
		grid[9][20] = Blocks.FLOWER;
		
		grid[24][19] = Blocks.BARRIER;
		grid[24][18] = Blocks.BARRIER;
		grid[24][17] = Blocks.BARRIER;
		grid[25][17] = Blocks.BARRIER;
		grid[26][17] = Blocks.BARRIER;
		grid[27][17] = Blocks.BARRIER;
		grid[28][17] = Blocks.BARRIER;
		grid[28][18] = Blocks.BARRIER;
		grid[28][19] = Blocks.BARRIER;
		grid[27][19] = Blocks.BARRIER;
		grid[26][19] = Blocks.DOOR;
		grid[25][19] = Blocks.BARRIER;
		grid[23][19] = Blocks.FLOWER;
		
		grid[24][27] = Blocks.BARRIER;
		grid[24][26] = Blocks.BARRIER;
		grid[24][25] = Blocks.BARRIER;
		grid[25][25] = Blocks.BARRIER;
		grid[26][25] = Blocks.BARRIER;
		grid[27][25] = Blocks.BARRIER;
		grid[28][25] = Blocks.BARRIER;
		grid[28][26] = Blocks.BARRIER;
		grid[28][27] = Blocks.BARRIER;
		grid[27][27] = Blocks.BARRIER;
		grid[26][27] = Blocks.DOOR;
		grid[25][27] = Blocks.BARRIER;
		grid[27][28] = Blocks.FLOWER;
		grid[23][27] = Blocks.SIGNBARRIER;
		
		grid[9][27] = Blocks.BARRIER;
		grid[9][26] = Blocks.BARRIER;
		grid[9][25] = Blocks.BARRIER;
		grid[10][25] = Blocks.BARRIER;
		grid[11][25] = Blocks.BARRIER;
		grid[12][25] = Blocks.BARRIER;
		grid[13][25] = Blocks.BARRIER;
		grid[13][26] = Blocks.BARRIER;
		grid[13][27] = Blocks.BARRIER;
		grid[12][27] = Blocks.BARRIER;
		grid[11][27] = Blocks.DOOR;
		grid[10][27] = Blocks.BARRIER;
		grid[8][27] = Blocks.FLOWER;
		grid[10][28] = Blocks.FLOWER;

		grid[20][21] = Blocks.SIGNBARRIER;
		grid[19][22] = Blocks.FLOWER;
		grid[17][21] = Blocks.FLOWER;
		grid[19][21] = Blocks.PLAYER;
	}
	
	public Blocks getBlock(int x, int y) { return grid[x][y]; }
	
	public boolean isBarrier(int x, int y) {
		if (grid[x][y] == Blocks.BARRIER || grid[x][y] == Blocks.BERRYSOIL ||
				grid[x][y] == Blocks.CUT_TREE || grid[x][y] == Blocks.PERSON ||
				grid[x][y] == Blocks.POKEBALL || grid[x][y] == Blocks.POND ||
				grid[x][y] == Blocks.ROCKSMASH_ROCK || grid[x][y] == Blocks.SIGNBARRIER ||
				grid[x][y] == Blocks.STRENGTH_BOULDER || grid[x][y] == Blocks.WATER) {
			return true;
		}
		return false;
	}
	
	public int getPlaceID() { return placeID; }

}
