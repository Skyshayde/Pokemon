package pokemon;

public class Items {
	private ItemBalls[] balls;
	private ItemBerries[] berries;
	
	public Items() {
		balls = new ItemBalls[8];
		berries = new ItemBerries[100];
	}
	
	public void setItemBalls() {
		balls[0] = new ItemBalls("Poké Ball", 200, 100, "A Ball thrown to catch a wild Pokémon.", -1);
		balls[1] = new ItemBalls("Great Ball", 600, 300, "A good, quality Ball that offers a higher Pokémon catch rate than a standard Poké Ball.", 0);
		balls[2] = new ItemBalls("Ultra Ball", 1200, 600, "A very high-grade Ball that offers a higher Pokémon catch rate than a Great Ball.", 1);
		balls[3] = new ItemBalls("Master Ball", 1000000, 2400, "The best Ball with the ultimate performance. It will catch any wild Pokémon without fail.", 2);
		balls[4] = new ItemBalls("Heal Ball", 300, 150, "A remedial Poké Ball that restores the caught Pokémon's HP and eliminates any status problem.", 3);
		balls[5] = new ItemBalls("Repeat Ball", 1000, 500, "A somewhat different Ball that works especially well on Pokémon caught before.", 4);
		balls[6] = new ItemBalls("Timer Ball", 1000, 500, "A somewhat different Ball that becomes progressively better the more turns there are in a battle.", 5);
		balls[7] = new ItemBalls("Safari Ball", 0, 0, "A special Ball that is used only in the Safari Zone. It is finished with a camouflage pattern.", 6);
	}
	
	public void setItemBerries() {
		berries[0] = new ItemBerries("Cheri Berry", "When held by a Pokémon, it will be used in battle to heal paralysis.");
		berries[0].setCuresStatus(Status.PARALYZED);
		berries[1] = new ItemBerries("Chesto Berry", "When held by a Pokémon, it will be used in battle to wake up.");
		berries[1].setCuresStatus(Status.SLEEP);
		berries[2] = new ItemBerries("Pecha Berry", "When held by a Pokémon, it will be used in battle to cure poison.");
		berries[2].setCuresStatus(Status.POISONED);
		berries[3] = new ItemBerries("Rawst Berry", "When held by a Pokémon, it will be used in battle to heal a burn.");
		berries[3].setCuresStatus(Status.BURNED);
		berries[4] = new ItemBerries("Aspear Berry", "When held by a Pokémon, it will be used in battle for defrosting.");
		berries[4].setCuresStatus(Status.FROZEN);
		berries[5] = new ItemBerries("", "");
		berries[5].setCuresAllStatus();
		berries[6] = new ItemBerries("", "");
		berries[6].setCuresAllStatus();
		berries[7] = new ItemBerries("", "");
		berries[7].setCuresAllStatus();
		berries[8] = new ItemBerries("", "");
		berries[8].setCuresAllStatus();
		berries[9] = new ItemBerries("", "");
		berries[9].setCuresAllStatus();
		berries[10] = new ItemBerries("", "");
		berries[10].setCuresAllStatus();
		berries[11] = new ItemBerries("", "");
		berries[11].setCuresAllStatus();
		berries[12] = new ItemBerries("", "");
		berries[12].setCuresAllStatus();
		berries[13] = new ItemBerries("", "");
		berries[13].setCuresAllStatus();
		berries[14] = new ItemBerries("", "");
		berries[14].setCuresAllStatus();
		berries[15] = new ItemBerries("", "");
		berries[15].setCuresAllStatus();
	}
}
