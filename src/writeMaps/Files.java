package writeMaps;

import java.util.Arrays;

import pokemon.Blocks;
import pokemon.Person;

public class Files {
	private String dir;
	private String mapName;
	private String creator;
	private int gridSize;
	private String[] images;
	private Blocks[][] blocks;
	private int[][] mapImages;
	private Person[] people;
	private ItemData[] items;
	private PokemonData[] pokemon;
	private ImageMap imageMap;
	
	public Files(int gridSize, ImageMap imageMap) {
		dir = "";
		mapName = "";
		creator = "";
		this.gridSize = gridSize;
		images = new String[0];
		blocks = new Blocks[gridSize][gridSize];
		mapImages = new int[gridSize][gridSize];
		people = new Person[0];
		items = new ItemData[0];
		pokemon = new PokemonData[0];
		this.imageMap = imageMap;
	}
	
	public void addImages(String[] images) {
		if (images.length == 0) this.images = images;
		else {
			String[] temp = this.images;
			this.images = new String[temp.length+images.length];
			int j = 0;
			for (int i = 0; i < this.images.length; i++) {
				if (i < temp.length) {
					this.images[i] = temp[i];
					j = i;
				}
				else this.images[i] = images[i-j-1];
			}
		}
	}
	
	public void addItems(ItemData[] items) {
		if (items.length == 0) this.items = items;
		else {
			ItemData[] temp = this.items;
			this.items = new ItemData[temp.length+items.length];
			int j = 0;
			for (int i = 0; i < this.items.length; i++) {
				if (i < temp.length) {
					this.items[i] = temp[i];
					j = i;
				}
				else this.items[i] = items[i-j-1];
			}
		}
	}
	
	public void addPeople(Person[] people) {
		if (people.length == 0) this.people = people;
		else {
			Person[] temp = this.people;
			this.people = new Person[temp.length+people.length];
			int j = 0;
			for (int i = 0; i < this.people.length; i++) {
				if (i < temp.length) {
					this.people[i] = temp[i];
					j = i;
				}
				else this.people[i] = people[i-j-1];
			}
		}
	}
	
	public void addPokemon(PokemonData[] pokemon) {
		if (pokemon.length == 0) this.pokemon = pokemon;
		else {
			PokemonData[] temp = this.pokemon;
			this.pokemon = new PokemonData[temp.length+pokemon.length];
			int j = 0;
			for (int i = 0; i < this.pokemon.length; i++) {
				if (i < temp.length) {
					this.pokemon[i] = temp[i];
					j = i;
				}
				else this.pokemon[i] = pokemon[i-j-1];
			}
		}
	}
	
	public void setGrid(int x, int y, Blocks block, int image) {
		blocks[x][y] = block;
		mapImages[x][y] = image;
	}
	
	public void changeGridSize(int gridSize) {
		if (this.gridSize != gridSize) {
			Blocks[][] tempBl = blocks;
			blocks = new Blocks[gridSize][gridSize];
			Arrays.fill(blocks, Blocks.BARRIER);
			int[][] tempIm = mapImages;
			mapImages = new int[gridSize][gridSize];
			Arrays.fill(mapImages, 0);
			
			int size = this.gridSize < gridSize ? this.gridSize : gridSize;
			for (int i = 0; i < size; i++) {
				blocks[i] = tempBl[i];
				mapImages[i] = tempIm[i];
			}
		}
	}
	
	public String getDir() { return dir; }
	
	public String getName() { return mapName; }
	
	public String getCreator() { return creator; }
	
	public int getSize() { return gridSize; }
	
	public String[] getImages() { return images; }
	
	public Blocks[][] getBlocks() { return blocks; }
	
	public int[][] getBlockIDs() {
		int[][] ids = new int[gridSize][gridSize];
		for (int i = 0; i < gridSize; i++) {
			for (int j = 0; j < gridSize; j++) {
				ids[i][j] = imageMap.getBlockID(blocks[i][j]);
			}
		}
		return ids;
	}
	
	public int[][] getMapImages() { return mapImages; }
	
	public Person[] getPeople() { return people; }
	
	public ItemData[] getItems() { return items; }
	
	public PokemonData[] getPokemon() { return pokemon; }
	
	public void setDir(String dir) {
		this.dir = dir;
	}
	
	public void setName(String name) {
		mapName = name;
	}
	
	public void setCreator(String name) {
		creator = name;
	}
	
}
