package pokemon;

import java.util.Random;

public class Pokemon extends PokemonGeneric {
	private String nickName;
    private Status status;
    private int health;
    private Item hold;
    private int maxHP;
    private int level;
    private int xp;
    private Move[] moveSet;
    private int numOfMoves; //TODO make it easier to change and add moves
    private int friendAmount;
    private boolean restrict;
    private double catchRate;
    private int neededXP;
	private boolean wild;
	private ExperienceRate experienceRate;
	private int[] effortValues;
	private ItemBalls ball;
	private boolean fainted;
	private boolean supereffectiveImmune;

    public Pokemon(String name, Element element, ExperienceRate exRate, 
    		int rarity, String description, int id, boolean wild) {
    	super(name, element, rarity, description, id);
    	setHealth(100);
        if (wild) {
            checkLocation();
        }
        levelUp();
        restrict = false;
        setExperienceRate(exRate);
        effortValues = new int[6];
        fainted = false;
        supereffectiveImmune = false;
    }
    
    public void addHealth(int hp) {
    	health += hp;
    	if (health > maxHP) {
    		health = maxHP;
    	}
    }
	
	public void changeEV(EV effortValue, int amount) {
		switch (effortValue) {
			case HP:
				effortValues[0] += amount;
				break;
			case ATTACK:
				effortValues[1] += amount;
				break;
			case DEFENSE:
				effortValues[2] += amount;
				break;
			case SPEED:
				effortValues[3] += amount;
				break;
			case SP_ATK:
				effortValues[4] += amount;
				break;
			case SP_DEF:
				effortValues[5] += amount;
				break;
		}
	}

    public void checkLocation() { //TODO
        //get map coordinates and set random ints for level.

        Random lv = new Random();
        level = lv.nextInt(2);
        level = level + 3;
    }
	
	public Pokemon clone() {
		Pokemon clone = new Pokemon(getName(), getType()[0], experienceRate, 
				rarityInt(), getDescription(), getID(), wild);
		for (int i = 1; i < getType().length; i++) {
			clone.addElement(getType()[i]);
		}
		return clone;
	}

	public void criticalRatioIncrease(int change) {
		// TODO Auto-generated method stub
	}

    public float getAttack(float attack) {
        //attack = Move.damage();
        return attack;
    }
    
    public ItemBalls getBall() {
    	return ball;
    }

    public double getCatchRate() {
        return catchRate;
    }

	public Condition getCondition() {
		// TODO Auto-generated method stub
		return null;
	}

    public int getFriendship() {
        return friendAmount;
    }

    public int getHealth() { 
    	return health;
    }

    public Item getHold() {
        return hold;
    }

    public int getLevel() { return level; }

    public int getMaxHP() { return maxHP; }

    public Move[] getMoveset() {
        return moveSet;
    }
    
    public String getNickName() {
    	return nickName;
    }

    public Status getStatus() {
        return status;
    }
    
    public int getXP() {
        return xp;
    }
    
    public boolean hasMove(Move move) {
    	for (int i = 0; i < moveSet.length; i++) {
    		if (move.getNumCode() == moveSet[i].getNumCode()) return true;
    	}
    	return false;
    }

	public void heal() {
		// TODO Auto-generated method stub
		health = maxHP;
		status = Status.NONE;
		for (int i = 0; i < numOfMoves; i++) {
			moveSet[i].refreshPP();
		}
	}
    
    public boolean isFainted() { return fainted; }

    public boolean isRestricted() { return restrict; }
    
    public boolean isSupereffectiveImmune() { return supereffectiveImmune; }

    public void levelUp() {
        if (xp == neededXP && level < 100) {
            level++;
            xp = 0;
        }
    }

    public void maxHP(int max) { maxHP = max; }
    
    public void removeHealth(int hp) {
    	health -= hp;
    	if (health < 0) health = 0;
    	if (health == 0) fainted = true;
    }
    
    public void setBall(ItemBalls ball) { this.ball = ball; }

    public void setCatchRate(ItemBalls ball, int rate) {
        int ballRate = ball.getCatchRate();
        double statusBonus = 1;

        if (status.equals(Status.SLEEP) || status.equals(Status.FROZEN)) {
            statusBonus = 2;
        }
        if (status.equals(Status.POISONED) || status.equals(Status.PARALYZED) 
        		|| status.equals(Status.BURNED)) {
            statusBonus = 1.5;
        }

        catchRate = ((3 * maxHP - 2 * health) * rate * ballRate * statusBonus) / (3 * maxHP);
    }

	public void setCondition(Condition none) {
		// TODO Auto-generated method stub
	}

	public void setEV(int hp, int atk, int def, int spd, int spatk, int spdef) {
		effortValues[0] = hp;
		effortValues[1] = atk;
		effortValues[2] = def;
		effortValues[3] = spd;
		effortValues[4] = spatk;
		effortValues[5] = spdef;
	}

    public void setExperienceRate(ExperienceRate rate) {
    	experienceRate = rate;
    	switch (rate) {
    		case ERRATIC:
    			if (level <= 50) {
                    neededXP = Math.round((level ^ 3 * (100 - level)) / 50);
                }
                else if (level > 50 && level <= 68) {
                    neededXP = Math.round((level ^ 3 * (150 - level)) / 100);
                }
                else if (level > 68 && level <= 98) {
                    neededXP = Math.round((level ^ 3 
                    		* ((1911 - 10 * level) / 3)) / 500);
                }
                else if (level > 98 && level <= 100) {
                    neededXP = Math.round((level ^ 3 * (160 - level)) / 100);
                }
    			break;
			case FAST:
	            neededXP = Math.round((4 * level ^ 3) / 5);
			    break;
			case MEDIUM_FAST:
	            neededXP = Math.round(level ^ 3);
				break;
			case MEDIUM_SLOW:
				neededXP = Math.round((6 * level ^ 3) / 5 
						- 15 * level ^ 2 + 100 * level - 140);
				break;
			case SLOW:
	            neededXP = Math.round((5 * level ^ 3) / 4);
				break;
			case FLUCTUATING:
	            if (level <= 15) {
	                neededXP = Math.round(level ^ 3 
	                		* (((level + 1) / 3 + 24) / 50));
	            }
	            else if (level > 15 && level <= 36) {
	                neededXP = Math.round(level ^ 3 * ((level + 14) / 50));
	            }
	            else if (level > 36 && level <= 100) {
	                neededXP = Math.round(level ^ 3 * ((level / 2 + 32) / 50));
	            }
				break;
    		default: //Medium Fast
    			neededXP = Math.round(level ^ 3);
    			break;
        }
    }

    public void setFriendship(int friend) { friendAmount = friend; }

    public void setHealth(int hp) { health = hp; }

    public void setHold(Item item) { hold = item; }

    public void setLevel(int lv) { level = lv; }

    public void setMoveset(Move[] list) { moveSet = list; }
    
    public void setNickName(String name) { nickName = name; }
	
	public void setOneEV(EV effortValue, int amount) {
		switch (effortValue) {
			case HP:
				effortValues[0] = amount;
				break;
			case ATTACK:
				effortValues[1] = amount;
				break;
			case DEFENSE:
				effortValues[2] = amount;
				break;
			case SPEED:
				effortValues[3] = amount;
				break;
			case SP_ATK:
				effortValues[4] = amount;
				break;
			case SP_DEF:
				effortValues[5] = amount;
				break;
		}
	}

    public void setStatus(Status stat) { //TODO
    	status = stat;
    	switch (stat) {
	    	case POISONED:
	    		/*if (TrainerBattle.battleStat()) {
	            health--;
	        	}*/
	    		break;
	    	case PARALYZED:
	    		/*if (TrainerBattle.battleStat()) {
	            restrict = true;
	        	}*/
	    		break;
	    	case SLEEP:
	    		/*if (TrainerBattle.battleStat()) {
	            int rand = random.nextInt(2);
	            restrict = true;
	        	}*/
	    		break;
	    	case BURNED:
	    		/*if (TrainerBattle.battleStat()){
	            health--;
	        	}*/
	    		break;
	    	case FROZEN:
	    		/*if (TrainerBattle.battleStat()){
	            int rand = random.nextInt(2);
	            restrict = true;
	        	}*/
	    		break;
	    	default:
	    		status = Status.NONE;
	    		restrict = false;
    	}
    }
	
	public void setSupereffectiveImmunity(boolean immune) {
		supereffectiveImmune = immune;
	}

    public void setXP(int experience) {
        xp += experience;
    }

	public boolean trainMove(Move move) {
		// TODO Auto-generated method stub
		if (hasMove(move)){ //check if pokemon can learn move
			
		}
		
		return false;
	}

    public boolean wild() { 
    	return wild;
    }
    
}
