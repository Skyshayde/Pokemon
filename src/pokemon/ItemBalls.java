package pokemon;

public class ItemBalls extends Item {
	private boolean pokeBall;
	private boolean greatBall;
	private boolean ultraBall;
	private boolean masterBall;
	private boolean healBall;
	private boolean repeatBall;
	private boolean timerBall;
	private boolean safariBall;
	private int catchRate;
	private ImageFile image;
	
	public ItemBalls(String name, int price, int sell, String description, int ballType) {
		super(name, ItemType.BALL, price, sell, description);
		setBall(ballType);
	}
	
	public void catchRate(int rate) {
		catchRate = rate;
	}

	public int getCatchRate() {
		return catchRate;
	}
	
	public ImageFile getImage() {
		return image;
	}
	
	private void refreshBallType() {
		pokeBall = false;
		greatBall = false;
		ultraBall = false;
		masterBall = false;
		healBall = false;
		repeatBall = false;
		timerBall = false;
		safariBall = false;
	}
	
	public void setBall(int ballType) {
		refreshBallType();
		switch (ballType) {
			case 0:
				greatBall = true;
				catchRate = 200;
				break;
			case 1:
				ultraBall = true;
				catchRate = 150;
				break;
			case 2:
				masterBall = true;
				catchRate = 0;
				break;
			case 3: 
				healBall = true;
				catchRate = 255;
				break;
			case 4:
				repeatBall = true;
				catchRate = 255;
				if (Player.hasPokemon(EventBattle.getOpponent())) {
					catchRate = 80;
				}
				break;
			case 5:
				timerBall = true;
				catchRate = 255;
				/*TODO
				implement number of turns in battle through Event
				(1 + number of turns passed in battle * 1229/4096)×, maximum 4× (reached at 10 turns)
				*/
				break;
			case 6:
				safariBall = true;
				catchRate = 150;//??
				//TODO Safari Ball
				break;
			default:
				pokeBall = true;
				catchRate = 255;
				break;
		}
	}
	
	public void setImage(String location) {
		//TODO
		if (pokeBall) {
			
		}
		else if (greatBall) {
			
		}
		else if (ultraBall) {
			
		}
		else if (masterBall) {
			
		}
		else if (healBall) {
			
		}
		else if (repeatBall) {
			
		}
		else if (timerBall) {
			
		}
		else if (safariBall) {
			
		}
	}
	
	public void use(Pokemon pokemon) {
		//TODO
		if (healBall) {
			pokemon.setHealth(pokemon.getMaxHP());
		}
		pokemon.setBall(this);
		Player.removeItem(this);
	}

}
