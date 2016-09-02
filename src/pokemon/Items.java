package pokemon;

public class Items {
	private ItemBalls[] balls;
	private ItemBerries[] berries;
	
	public Items() {
		balls = new ItemBalls[8];
		berries = new ItemBerries[100];
	}
	
	public void setItemBalls() {
		balls[0] = new ItemBalls(0, "Pok� Ball", 200, 100, "A Ball thrown to catch a wild Pok�mon.", -1);
		balls[1] = new ItemBalls(1, "Great Ball", 600, 300, "A good, quality Ball that offers a higher Pok�mon catch rate than a standard Pok� Ball.", 0);
		balls[2] = new ItemBalls(2, "Ultra Ball", 1200, 600, "A very high-grade Ball that offers a higher Pok�mon catch rate than a Great Ball.", 1);
		balls[3] = new ItemBalls(3, "Master Ball", 1000000, 2400, "The best Ball with the ultimate performance. It will catch any wild Pok�mon without fail.", 2);
		balls[4] = new ItemBalls(4, "Heal Ball", 300, 150, "A remedial Pok� Ball that restores the caught Pok�mon's HP and eliminates any status problem.", 3);
		balls[5] = new ItemBalls(5, "Repeat Ball", 1000, 500, "A somewhat different Ball that works especially well on Pok�mon caught before.", 4);
		balls[6] = new ItemBalls(6, "Timer Ball", 1000, 500, "A somewhat different Ball that becomes progressively better the more turns there are in a battle.", 5);
		balls[7] = new ItemBalls(7, "Safari Ball", 0, 0, "A special Ball that is used only in the Safari Zone. It is finished with a camouflage pattern.", 6);
	}
	
	public void setItemBerries() {
		berries[0] = new ItemBerries(8, "Cheri Berry", "When held by a Pok�mon, it will be used in battle to heal paralysis.");
		berries[0].setCuresStatus(Status.PARALYZED);
		berries[1] = new ItemBerries(9, "Chesto Berry", "When held by a Pok�mon, it will be used in battle to wake up.");
		berries[1].setCuresStatus(Status.SLEEP);
		berries[2] = new ItemBerries(10, "Pecha Berry", "When held by a Pok�mon, it will be used in battle to cure poison.");
		berries[2].setCuresStatus(Status.POISONED);
		berries[3] = new ItemBerries(11, "Rawst Berry", "When held by a Pok�mon, it will be used in battle to heal a burn.");
		berries[3].setCuresStatus(Status.BURNED);
		berries[4] = new ItemBerries(12, "Aspear Berry", "When held by a Pok�mon, it will be used in battle for defrosting.");
		berries[4].setCuresStatus(Status.FROZEN);
		berries[5] = new ItemBerries(13, "", "");
		berries[5].setCuresAllStatus();
		berries[6] = new ItemBerries(14, "", "");
		berries[6].setCuresAllStatus();
		berries[7] = new ItemBerries(15, "", "");
		berries[7].setCuresAllStatus();
		berries[8] = new ItemBerries(16, "", "");
		berries[8].setCuresAllStatus();
		berries[9] = new ItemBerries(17, "", "");
		berries[9].setCuresAllStatus();
		berries[10] = new ItemBerries(18, "", "");
		berries[10].setCuresAllStatus();
		berries[11] = new ItemBerries(19, "", "");
		berries[11].setCuresAllStatus();
		berries[12] = new ItemBerries(20, "", "");
		berries[12].setCuresAllStatus();
		berries[13] = new ItemBerries(21, "", "");
		berries[13].setCuresAllStatus();
		berries[14] = new ItemBerries(22, "", "");
		berries[14].setCuresAllStatus();
		berries[15] = new ItemBerries(23, "", "");
		berries[15].setCuresAllStatus();
	}
}
