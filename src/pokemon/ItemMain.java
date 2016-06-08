package pokemon;

public class ItemMain extends Item {

	private boolean[] effect;
	private Status status;
	private int hp;
	private int percent;
	private Condition condition;
	private EV effortValue;
	private int change;
	private Element element;
	private boolean maxRevive;
	private int time;
	private Move move;
	private boolean increase;
	private boolean isHold;
	
	public ItemMain(String name, int price, int sell, String description) {
		super(name, ItemType.MAIN, price, sell, description);
		// TODO Auto-generated constructor stub
	}
	
	public void use(Pokemon pokemon) {
		//TODO
	}
	
	public void activateInBattle() {
		//TODO
	}
	
	public void isHold() {
		isHold = true;
	}
	
	public void setRestoresHP(int hp) {
		resetEffect();
		effect[0] = true;
		this.hp = hp;
	}
	
	public void setCuresStatus(Status status) {
		resetEffect();
		effect[1] = true;
		this.status = status;
	}
	
	public void setCuresAllStatus() {
		resetEffect();
		effect[2] = true;
	}
	
	public void setCuresAllCondition() {
		resetEffect();
		effect[3] = true;
	}
	
	public void setCuresStatusAndCondition() {
		resetEffect();
		effect[4] = true;
	}
	
	public void setRestoresHPAndClearStatus() {
		resetEffect();
		effect[5] = true;
	}
	
	public void revive(boolean maxRevive) {
		resetEffect();
		effect[6] = true;
		this.maxRevive = maxRevive;
	}
	
	public void changePPforMove(int change) {
		resetEffect();
		effect[7] = true;
		this.change = change;
	}
	
	public void changeWildEncounterRate(int percent) {
		resetEffect();
		effect[8] = true;
		this.percent = percent;
	}
	
	public void noEncountersByTime(int time) {
		resetEffect();
		effect[9] = true;
		this.time = time;
	}
	
	public void relearnMove(Move move) {
		resetEffect();
		effect[10] = true;
		this.move = move;
	}
	
	public void setChangeEV(EV effortValue, int change) {
		resetEffect();
		effect[11] = true;
		this.effortValue = effortValue;
		this.change = change;
	}
	
	public void changeAllEV(boolean increase) {
		resetEffect();
		effect[12] = true;
		this.increase = increase;
	}
	
	public void levelUp() {
		resetEffect();
		effect[13] = true;
	}
	
	public void setChangesCriticalRatio(int change) {
		resetEffect();
		effect[14] = true;
		this.change = change;
	}
	
	public void evolve() {
		resetEffect();
		effect[15] = true;
	}
	
	public void raiseAccuracy(int percent) {
		resetEffect();
		effect[16] = true;
		this.percent = percent;
	}
	
	public void raiseEvasion(int percent) {
		resetEffect();
		effect[17] = true;
		this.percent = percent;
	}
	
	public void causeCondition(Condition condition) {
		resetEffect();
		effect[18] = true;
		this.condition = condition;
	}
	
	public void causeFlinch(int percent) {
		resetEffect();
		effect[19] = true;
		this.percent = percent;
	}
	
	public void battleEscape() {
		resetEffect();
		effect[20] = true;
	}
	
	public void increaseMoneyGiven(int percent) {
		resetEffect();
		effect[21] = true;
		this.percent = percent;
	}
	
	
	//------------------------------------------------------
	
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
	
	private void resetEffect() {
		for (int i = 0; i < effect.length; i++) {
			effect[i] = false;
		}
	}

}
