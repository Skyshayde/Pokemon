package battle;

import pokemon.Condition;
import pokemon.EV;
import pokemon.Element;
import pokemon.Move;
import pokemon.Pokemon;
import pokemon.Status;

public class BattleCalculator {
	
	public void invokeStatus(Pokemon target) {
		Status status = target.getStatus();
		switch (status) {
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
	    	case NONE:
	    		break;
		}
	}
	
	public void attack(Pokemon target, Move move) {
		
	}

	private void attackDamage(Pokemon target, int damage) {
		
	}
	
	private void attackStatus(Pokemon target, Status status) {
		
	}
	
	private void attackCondition(Pokemon target, Condition condition) {
		
	}
	
	private void attackEV(Pokemon target, EV ev) {
		
	}
	
	private void attackEnvironment(Element element) {
		
	}
	
	private void attackEvent(Pokemon target, Move move) { //delayed time attacks? or have them as conditions?
		
	}
}
