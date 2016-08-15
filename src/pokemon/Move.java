package pokemon;

public class Move { //TODO have Move Generic class and extend to Move for individual pokemon to use.
	private int numCode;
	private String name;
	private Element[] elements;
	private String category;
	private int maxPP;
	private int pp;
	private int power;
	private int accuracy;
	private int criticalRatio;
	private int priority;
	private Item item;
	private boolean eventChange;
	private int moneyToGive;
	private boolean giveMoneyToPlayer;
	private boolean effortValueChangePositive;
	private int effortValueAmount;
	private EV effortValue;
	private String description;
	
	public Move(int numCode, String name, Element element, String category, int maxPP, 
			int power, int accuracy, int criticalRatio, int priority, String description) {
		this.numCode = numCode;
		this.name = name;
		elements = new Element[17];
		elements[0] = element;
		this.category = category;
		this.maxPP = maxPP;
		this.power = power;
		this.accuracy = accuracy;
		this.criticalRatio = criticalRatio;
		this.priority = priority;
		this.description = description;
		eventChange = false;
		pp = maxPP;
	}
	
	public void addElement(Element element) {
		elements[elements.length] = element;
	}
	
	public void changeEV() {
		if (effortValueChangePositive) {
			EventBattle.getPokemonOnTurn().changeEV(effortValue, effortValueAmount);
		}
		else {
			EventBattle.getPokemonOnTarget().changeEV(effortValue, effortValueAmount);
		}
	}
	
	public void changeEvent() { //Event event) {  Always battle?
		// TODO Auto-generated method stub
		if (EventBattle.isActive()){
			EventBattle.end();
		}
	}
	
	public int getAccuracy() {
		return accuracy;
	}
	
	public String getCategory() {
		return category;
	}
	
	public int getCriticalRatio() {
		return criticalRatio;
	}
	
	public String getDescription() {
		return description;
	}
	
	public Element[] getElements() {
		return elements;
	}
	
	public int getMaxPP() {
		return maxPP;
	}
	
	public String getName() {
		return name;
	}
	
	public int getNumCode() {
		return numCode;
	}
	
	public int getPower() {
		return power;
	}
	
	public int getPP() {
		return pp;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public void giveItem() {
		if (item != null) {
			Player.addItem(item);
		}
	}
	
	public void giveMoney() {
		if (giveMoneyToPlayer) {
			Player.addMoney(moneyToGive);
		}
		else if (EventBattle.isActive()){
			EventBattle.getTrainer().addMoney(moneyToGive);
		}
	}
	
	public void reducePP() {
		pp--;
	}
	
	public void reducePP(int reduction) {
		pp -= reduction;
	}

	public void refreshPP() {
		pp = maxPP;
	}
	
	public void setChangeEV(EV effortValue, int amount, boolean positive) {
		this.effortValue = effortValue;
		this.effortValueAmount = amount;
		this.effortValueChangePositive = positive;
	}
	
	public void setCriticalRatio(int criticalRatio) {
		this.criticalRatio = criticalRatio;
	}
	
	public void setGiveMoney(int money, boolean toPlayer) {
		moneyToGive = money;
		giveMoneyToPlayer = toPlayer;
	}
	
	public void setIfEventChange(boolean change) {
		eventChange = change;
	}
	
	public void setItemToGive(Item item) {
		this.item = item;
	}
	
	public void use() {
		changeEV();
		giveItem();
		giveMoney();
		if (eventChange) {
			changeEvent();
		}
		reducePP();
	}
	
}
