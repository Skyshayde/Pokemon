package writeMaps;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

import pokemon.PeopleType;
import pokemon.Person;

public class Output {
	private File output;
	private PrintWriter writer;
	private Files files;
	
	public Output(Files files, boolean newSave) {
		this.files = files;
		if (newSave) newSave();
		else files.getDir();

		try {
			writer = new PrintWriter(output.getPath(), "ANSI");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		writeHeader();
		writeFiles();
		writeBlocks();
		writeBlockImages();
		writePeople();
		writeItems();
		writePokemon();
		writer.close();
	}
	
	private void newSave() {
		try {
			output = new File(Run.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()+"/"+files.getName()+".map");
		} catch (URISyntaxException e) {
			e.printStackTrace();
			//TODO ask for new File location
			output = new File(System.getProperty("user.home") + "/Desktop/"+files.getName()+".map");
		}
		files.setDir(output.getPath());
	}
	
	private void writeHeader() {
		writer.println("'" + files.getName() + "'");
		writer.println("'" + files.getCreator() + "'");
		writer.println(files.getSize());
	}
	
	private void writeFiles() {
		writer.println("-F-");
		for (int i = 0; i < files.getImages().length; i++) {
			writer.println("f"+i+files.getImages()[i]);
		}
	}
	
	private void writeBlocks() {
		writer.println("-B-");
		for (int i = 0; i < files.getBlocks().length; i++) {
			for (int j = 0; j < files.getBlocks()[i].length; i++) {
				if (i == files.getBlocks().length-1) 
					writer.println(files.getBlockIDs()[i][j]+",");
				else writer.print(files.getBlockIDs()[i][j]+",");
			}
		}
	}
	
	private void writeBlockImages() {
		writer.println("-M-");
		for (int i = 0; i < files.getMapImages().length; i++) {
			for (int j = 0; j < files.getMapImages()[i].length; i++) {
				if (i == files.getMapImages().length-1) 
					writer.println("f"+files.getMapImages()[i][j]+",");
				else writer.print("f"+files.getMapImages()[i][j]+",");
			}
		}
	}
	
	private void writePeople() {
		writer.println("-P-");
		for (int i = 0; i < files.getPeople().length; i++) {
			Person person = files.getPeople()[i];
			
			writer.print(person.getClassID()+person.getFirstName()+"|");
			if (person.getPeopleType() == PeopleType.FAMILY) writer.print("\\p_ln|");
			else writer.print(person.getLastName()+"|");
			writer.print(person.getDisplayName()+"|");
			
			for (int j = 0; j < PeopleType.values().length; j++)
				if (person.getPeopleType() == PeopleType.values()[j])
					writer.print(j+"|");
			
			if (person.isMale()) writer.print("M|");
			else writer.print("F|");
			writer.print(person.getID()+"|");
			
			//TODO
		}
	}
	
	private void writeItems() {
		writer.println("-I-");
		for (int i = 0; i < files.getItems().length; i++) {
			if (files.getItems()[i].isHidden()) writer.print("H");
			else if (files.getItems()[i].isPatch()) writer.print("P");
			else writer.print("B");
			writer.println("i."+files.getItems()[i].getItem().getID()
					+"{"+files.getItems()[i].getX()+","+files.getItems()[i].getY()
					+"}f"+files.getItems()[i].getImageVal());
		}
	}
	
	private void writePokemon() {
		writer.println("-W-");
		for (int i = 0; i < files.getPokemon().length; i++) {
			PokemonData poke = files.getPokemon()[i];
			writer.println(poke.getID()+"|"+poke.getRarity()+"|"+poke.getBlockID()
				+"|"+poke.getLower()+"~"+poke.getUpper());
		}
	}
	
}
