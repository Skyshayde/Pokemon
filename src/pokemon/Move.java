package pokemon;

public class Move {
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
	
	public Move(String name, Element element, String category, int maxPP, 
			int power, int accuracy, int criticalRatio, int priority, String description) {
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
	}
	
	public void use() {
		changeEV();
		giveItem();
		giveMoney();
		if (eventChange) {
			changeEvent();
		}
	}
	
	public void setItemToGive(Item item) {
		this.item = item;
	}
	
	public void giveItem() {
		if (item != null) {
			Player.addItem(item);
		}
	}
	
	public void setGiveMoney(int money, boolean toPlayer) {
		moneyToGive = money;
		giveMoneyToPlayer = toPlayer;
	}
	
	public void giveMoney() {
		if (giveMoneyToPlayer) {
			Player.addMoney(moneyToGive);
		}
		else if (EventBattle.isActive()){
			EventBattle.getTrainer().addMoney(moneyToGive);
		}
	}
	
	public void setIfEventChange(boolean change) {
		eventChange = change;
	}
	
	public void changeEvent() { //Event event) {  Always battle?
		// TODO Auto-generated method stub
		if (EventBattle.isActive()){
			EventBattle.end();
		}
	}
	
	public void setChangeEV(EV effortValue, int amount, boolean positive) {
		this.effortValue = effortValue;
		this.effortValueAmount = amount;
		this.effortValueChangePositive = positive;
	}
	
	public void changeEV() {
		if (effortValueChangePositive) {
			EventBattle.getPokemonOnTurn().changeEV(effortValue, effortValueAmount);
		}
		else {
			EventBattle.getPokemonOnTarget().changeEV(effortValue, effortValueAmount);
		}
	}
	
	public void addElement(Element element) {
		elements[elements.length] = element;
	}
	
	public void reducePP() {
		pp--;
	}
	
	public void reducePP(int reduction) {
		pp -= reduction;
	}
	
	public void setCriticalRatio(int criticalRatio) {
		this.criticalRatio = criticalRatio;
	}
	
	public String getName() {
		return name;
	}
	
	public Element[] getElements() {
		return elements;
	}
	
	public String getCategory() {
		return category;
	}
	
	public int getMaxPP() {
		return maxPP;
	}
	
	public int getPP() {
		return pp;
	}
	
	public int getPower() {
		return power;
	}
	
	public int getAccuracy() {
		return accuracy;
	}
	
	public int getCriticalRatio() {
		return criticalRatio;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public String getDescription() {
		return description;
	}
}
