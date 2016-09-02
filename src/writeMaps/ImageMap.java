package writeMaps;

import java.util.HashMap;

import pokemon.Blocks;
import pokemon.ImageFile;

public class ImageMap {
	private HashMap<Integer, ImageFile> imageFiles;
	private HashMap<ImageFile, Blocks> blockLib;
	private HashMap<Blocks, Integer> blockIDs;
	private ImageFile[] images;

	public ImageMap() {
		imageFiles = new HashMap<Integer, ImageFile>();
		blockLib = new HashMap<ImageFile, Blocks>();
		blockIDs = new HashMap<Blocks, Integer>();
		images = new ImageFile[9];
		setImages();
		setFileLibrary();
		setBlockLibrary();
		setBlockIDs();
	}
	
	private void setFileLibrary() {
		for (int i = 0; i < images.length; i++)
			imageFiles.put(i, images[i]);
	}
	
	private void setBlockLibrary() {//TODO int instead of ImageFile?
		for (int i = 0; i < images.length; i++) {
			if (images[i].toString().contains("Barrier")) blockLib.put(images[i], Blocks.BARRIER);
			else if (images[i].toString().contains("BerrySoil")) blockLib.put(images[i], Blocks.BERRYSOIL);
			else if (images[i].toString().contains("Cave")) blockLib.put(images[i], Blocks.CAVE);
			else if (images[i].toString().contains("CutTree")) blockLib.put(images[i], Blocks.CUT_TREE);
			else if (images[i].toString().contains("Desert")) blockLib.put(images[i], Blocks.DESERT);
			else if (images[i].toString().contains("Door")) blockLib.put(images[i], Blocks.DOOR);
			else if (images[i].toString().contains("Flower")) blockLib.put(images[i], Blocks.FLOWER);
			else if (images[i].toString().contains("Person")) blockLib.put(images[i], Blocks.PERSON);
			else if (images[i].toString().contains("Player")) blockLib.put(images[i], Blocks.PLAYER);
			else if (images[i].toString().contains("Pokeball")) blockLib.put(images[i], Blocks.POKEBALL);
			else if (images[i].toString().contains("Pond")) blockLib.put(images[i], Blocks.POND);
			else if (images[i].toString().contains("Puddle")) blockLib.put(images[i], Blocks.PUDDLE);
			else if (images[i].toString().contains("Ridge")) blockLib.put(images[i], Blocks.RIDGE);
			else if (images[i].toString().contains("RockSmashRock")) blockLib.put(images[i], Blocks.ROCKSMASH_ROCK);
			else if (images[i].toString().contains("Sign")) blockLib.put(images[i], Blocks.SIGN);
			else if (images[i].toString().contains("SignBarrier")) blockLib.put(images[i], Blocks.SIGNBARRIER);
			else if (images[i].toString().contains("Standard")) blockLib.put(images[i], Blocks.STANDARD);
			else if (images[i].toString().contains("StrengthBoulder")) blockLib.put(images[i], Blocks.STRENGTH_BOULDER);
			else if (images[i].toString().contains("TallGrass")) blockLib.put(images[i], Blocks.TALLGRASS);
			else if (images[i].toString().contains("Water")) blockLib.put(images[i], Blocks.WATER);
			else if (images[i].toString().contains("Waterfall")) blockLib.put(images[i], Blocks.WATERFALL);
		}
	}
	
	private void setBlockIDs() {
		blockIDs.put(Blocks.BARRIER, 0);
		blockIDs.put(Blocks.BERRYSOIL, 1);
		blockIDs.put(Blocks.CAVE, 2);
		blockIDs.put(Blocks.CUT_TREE, 3);
		blockIDs.put(Blocks.DESERT, 4);
		blockIDs.put(Blocks.DOOR, 5);
		blockIDs.put(Blocks.FLOWER, 6);
		blockIDs.put(Blocks.PERSON, 7);
		blockIDs.put(Blocks.PLAYER, 8);
		blockIDs.put(Blocks.POKEBALL, 9);
		blockIDs.put(Blocks.POND, 10);
		blockIDs.put(Blocks.PUDDLE, 11);
		blockIDs.put(Blocks.RIDGE, 12);
		blockIDs.put(Blocks.ROCKSMASH_ROCK, 13);
		blockIDs.put(Blocks.SIGN, 14);
		blockIDs.put(Blocks.SIGNBARRIER, 15);
		blockIDs.put(Blocks.STANDARD, 16);
		blockIDs.put(Blocks.STRENGTH_BOULDER, 17);
		blockIDs.put(Blocks.TALLGRASS, 18);
		blockIDs.put(Blocks.WATER, 19);
		blockIDs.put(Blocks.WATERFALL, 20);
	}
	
	private void setImages() {
		images[0] = new ImageFile(getClass().getResource("/mapImages/Barrier/void.png"));
		images[1] = new ImageFile(getClass().getResource("/mapImages/Standard/grass.png"));
		images[2] = new ImageFile(getClass().getResource("/mapImages/Standard/grass-forest.png"));
		images[3] = new ImageFile(getClass().getResource("/mapImages/Standard/grass-patch.png"));
		images[4] = new ImageFile(getClass().getResource("/mapImages/Standard/grass-sand patch.png"));
		images[5] = new ImageFile(getClass().getResource("/mapImages/Standard/ground-stone panel grass left.png"));
		images[6] = new ImageFile(getClass().getResource("/mapImages/Standard/ground-stone panel left.png"));
		images[7] = new ImageFile(getClass().getResource("/mapImages/Standard/ground-stone walkway.png"));
		images[8] = new ImageFile(getClass().getResource("/mapImages/Standard/ground-stone.png"));
		images[9] = new ImageFile(getClass().getResource("/mapImages/Standard/sand.png"));
	}
	
	public ImageFile getImage(int code) { return imageFiles.get(code); }
	
	public Blocks getImageBlock(int code) {
		ImageFile image = getImage(code);
		return blockLib.get(image);
	}
	
	public ImageFile[] getImages() { return images; }
	
	public int getBlockID(Blocks block) { return blockIDs.get(block); }
}
