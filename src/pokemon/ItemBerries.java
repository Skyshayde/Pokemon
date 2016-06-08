package pokemon;

public class ItemBerries extends Item {
	private boolean[] effect;
	private Element element;
	private Status status;
	private Condition condition;
	private EV effortValue;
	private int hp;
	private int percent;
	private int change;
	private Image image;

	public ItemBerries(String name, String description) {
		super(name, ItemType.BERRY, 0, 0, description); //TODO price and sell???
		effect = new boolean[10];
		resetEffect();
	}
	
	public void use(Pokemon pokemon) {
		if (effect[0] && pokemon.getStatus() == status) {
			pokemon.setStatus(Status.NONE);
		}
		else if (effect[1]) pokemon.setStatus(Status.NONE);
		else if (effect[2]) pokemon.setHealth(hp);
		else if (effect[3]) {
			hp = percent * pokemon.getMaxHP();
			pokemon.addHealth(hp);
		}
		else if (effect[4] && pokemon.getCondition() == condition 
				&& EventBattle.isActive()) {
			pokemon.setCondition(Condition.NONE);
		}
		else if (effect[5] && EventBattle.isActive()) pokemon.setCondition(Condition.NONE);
		else if (effect[6] && EventBattle.isActive()) {
			pokemon.changeEV(effortValue, change);
		}
		else if (effect[7]) {
			int currentPercent = 100 * pokemon.getHealth() / pokemon.getMaxHP();
			if (currentPercent <= percent) pokemon.changeEV(effortValue, change);
		}
		else if (effect[8] && EventBattle.isActive()) {
			for (int i = 0; i < EventBattle.getOpponent().getType().length; i++) {
				if (EventBattle.getOpponent().getType()[i] == element) {
					pokemon.setSupereffectiveImmunityTrue();
				}
			}
			//TODO end after Battle Event
		}
		else if (effect[9] && EventBattle.isActive()) {
			int currentPercent = 100 * pokemon.getHealth() / pokemon.getMaxHP();
			if (currentPercent <= percent) pokemon.criticalRatioIncrease(change);
		}
		Player.removeItem(this);
	}
	
	public void setCuresStatus(Status status) {
		resetEffect();
		effect[0] = true;
		this.status = status;
	}
	
	public void setCuresAllStatus() {
		resetEffect();
		effect[1] = true;
	}
	
	public void setRestoresHP(int hp) {
		resetEffect();
		effect[2] = true;
		this.hp = hp;
	}
	
	public void setRestoresHPbyPercent(int percent) {
		resetEffect();
		effect[3] = true;
		this.percent = percent;
	}
	
	public void setCuresCondition(Condition condition) {
		resetEffect();
		effect[4] = true;
		this.condition = condition;
	}
	
	public void setCuresAllCondition() {
		resetEffect();
		effect[5] = true;
	}
	
	public void setChangeEV(EV effortValue, int change) {
		resetEffect();
		effect[6] = true;
		this.effortValue = effortValue;
		this.change = change;
	}
	
	public void setChangeEVbyHP(EV effortValue, int percent, int change) {
		resetEffect();
		effect[7] = true;
		this.effortValue = effortValue;
		this.percent = percent;
		this.change = change;
	}
	
	public void setDecreaseSupereffectiveDamage(Element element) {
		resetEffect();
		effect[8] = true;
		this.element = element;
	}
	
	public void setChangesCriticalRatio(int percent, int change) {
		resetEffect();
		effect[9] = true;
		this.percent = percent;
		this.change = change;
	}
	
	private void resetEffect() {
		for (int i = 0; i < effect.length; i++) {
			effect[i] = false;
		}
	}
	
	public void activateInBattle() {
		//TODO
	}
	
	public void setImage(String location) {
		//TODO
	}
	
	public Image getImage() {
		return image;
	}
}
