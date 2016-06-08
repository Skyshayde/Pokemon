package pokemon;

public class PokemonGeneric {
	private String name;
	private int id;
	private Element[] element;
	private Move[] movesNotAllowed;
	private MoveMap moves;
	private String description;
    private String rarity;
    private int rarityInt;

    public PokemonGeneric(String name, Element element, 
    		int rarityInt, String description, int id) {
    	this.element = new Element[4];
    	movesNotAllowed = new Move[20];
    	setRarity(rarityInt);
    	
    	this.name = name;
    	this.id = id;
    	this.element[0] = element;
    	this.rarityInt = rarityInt;
    	this.description = description;
    }
    
    public void addElement(Element newElement) {
    	element[element.length] = newElement;
    }
    
    private void setRarity(int rarityInt) {
    	switch (rarityInt) {
    	case 0:
    		rarity = "Ultra Common";
    		break;
    	case 1:
    		rarity = "Common";
    		break;
    	case 2:
    		rarity = "Uncommon";
    		break;
    	case 3:
    		rarity = "Rare";
    		break;
    	case 4:
    		rarity = "Ultra Rare";
    		break;
    	case 5:
    		rarity = "Only One";
    		break;
    	}
    }
    
    public void setAllMoves() {
    	//param HashMap<Move[], int>
    }
    
    /**
     * Returns the string of the pokemon's type.
     * @return pokeType
     */
    public Element[] getType() {
        return element;
    }
    
    public String getName() {
    	return name;
    }
    
    public int getID() {
    	return id;
    }
    
    public String getDescription() {
    	return description;
    }

    /**
     * Returns the catch rate of the pokemon.
     * @return catchRate
     */
    public String rarity() {
        return rarity;
    }
    
    public int rarityInt() {
        return rarityInt;
    }
    
    public void addMove(Move move, int level) {
    	for (int i = 0; i < movesNotAllowed.length; i++) {
    		if (!movesNotAllowed[i].getName().equals(move.getName())) {
    			moves.addMove(move, level);
    		}
    	}
    }
    
    public int getLevel(Move move) {
    	return moves.getLevel(move);
    }
    
    public Move getMove(int level) {
    	return moves.getMove(level);
    }
    
    public MoveMap getMoves() {
    	return moves;
    }
    
    public Move[] getMovesNotAllowed() {
    	return movesNotAllowed;
    }
    
    public void addMoveNotAllowed(Move move) {
    	if ((movesNotAllowed.length + 1) % 20 != 0) {
    		movesNotAllowed[movesNotAllowed.length] = move;
    	}
    	else {
    		Move[] temp = movesNotAllowed;
    		movesNotAllowed = new Move[temp.length + 10];
    		for (int i = 0; i < temp.length; i++) {
    			movesNotAllowed[i] = temp[i];
    		}
    	}
    }
    
    public String toString() {
    	StringBuilder builder = new StringBuilder();
    	builder.append(id);
    	builder.append(", ");
    	builder.append(name);
    	builder.append(", ");
    	//for (int i = 0; i < element.length; i++) {
    		builder.append(element);//[i]);
    		//if (i + 1 == element.length) {
    	    	builder.append(", ");
    		//}
        	//builder.append(" ");
    	//}
    	builder.append(rarity);
    	builder.append(", ");
    	builder.append(description);
    	return builder.toString();
    }
    
    private class MoveMap {
    	private Move[] moves;
    	private int[] levels;
    	
    	private MoveMap() {
    		moves = new Move[20];
    		levels = new int[20];
    	}
    	
    	private void addMove(Move move, int level) {
    		if ((moves.length + 1) % 20 == 0) {
    			expandArray();
    		}
    		moves[moves.length] = move;
    		levels[levels.length] = level;
    	}
    	
    	private int getLevel(Move move) {
    		for (int i = 0; i < moves.length; i++) {
    			if (moves[i].getName().equals(move.getName())) {
    				return levels[i];
    			}
    		}
    		return 0;
    	}
    	
    	private Move getMove(int level) {
    		for (int i = 0; i < levels.length; i++) {
    			if (levels[i] == level) {
    				return moves[i];
    			}
    		}
    		return null;
    	}
    	
    	private void expandArray() {
    		Move[] tempMove = moves;
    		moves = new Move[tempMove.length + 10];
    		for (int i = 0; i < tempMove.length; i++) {
    			moves[i] = tempMove[i];
    		}
    		
    		int[] tempLevel = levels;
    		levels = new int[tempLevel.length + 10];
    		for (int i = 0; i < tempLevel.length; i++) {
    			levels[i] = tempLevel[i];
    		}
    	}
    }
}
