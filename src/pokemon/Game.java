package pokemon;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

public class Game {
	private KeyAction keyListener;
	private JFrame gameFrame;
	private JPanel gamePanel;
	private JLabel player;
	private JLabel map;

	public Game() {
		new Player();
		new Places();
		
		setGameFrame();
		setStateMap();
		
		keyListener = new KeyAction();
		gameFrame.addKeyListener(keyListener);
	}
	
	public void setGameFrame() {
		gameFrame = new JFrame("Pokemon Jade");
		gameFrame.setSize(640, 450);
		gameFrame.setResizable(false);
		gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
		Insets toolHeight = Toolkit.getDefaultToolkit().getScreenInsets(gameFrame.getGraphicsConfiguration());
		gameFrame.setLocation((scrSize.width - gameFrame.getWidth())/2, 
				(scrSize.height - toolHeight.bottom - gameFrame.getHeight())/2);
		
		gamePanel = new JPanel();
		gamePanel.setLayout(null);
		gamePanel.setSize(gameFrame.getWidth(), gameFrame.getHeight());
		gameFrame.add(gamePanel);
		
		setMenuBar();
		gameFrame.setVisible(true);
	}
	
	public void setMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		gameFrame.setJMenuBar(menuBar);
		
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		menuBar.add(fileMenu);
		
		JMenuItem menuItem = new JMenuItem("Exit", KeyEvent.VK_E);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, ActionEvent.ALT_MASK));
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		fileMenu.add(menuItem);
	}
	
	public void setStateMap() {
		player = new JLabel(Player.imageUP);
		player.setBounds(gamePanel.getWidth()/2-25, gamePanel.getHeight()/2-34, Player.imageUP.getIconWidth(), Player.imageUP.getIconHeight());
		gamePanel.add(player);
		Player.setPosition(19, 21);
		
		map = new JLabel(Places.getMap(0));
		map.setBounds(-527, -731, Places.getMap(0).getIconWidth(), Places.getMap(0).getIconHeight());
		gamePanel.add(map);
	}
	
	private void move() {
		if (keyListener.keys[KeyEvent.VK_UP] && !keyListener.isMoving) {
			if (!turn(map)) animateMapMove(map, 0);
	    }
		else if (keyListener.keys[KeyEvent.VK_RIGHT] && !keyListener.isMoving) {
			if (!turn(map)) animateMapMove(map, 1);
	    }
		else if (keyListener.keys[KeyEvent.VK_DOWN] && !keyListener.isMoving) {
			if (!turn(map)) animateMapMove(map, 2);
	    }
		else if (keyListener.keys[KeyEvent.VK_LEFT] && !keyListener.isMoving) {
			if (!turn(map)) animateMapMove(map, 3);
	    }
	}
	
	private boolean turn(JLabel map) {
		if (keyListener.keys[KeyEvent.VK_UP] && keyListener.facing != 0) {
			player.setIcon(Player.imageUP);
			keyListener.facing = 0;
			wait(20);
			return true;
	    }
		else if (keyListener.keys[KeyEvent.VK_RIGHT] && keyListener.facing != 1) {
			player.setIcon(Player.imageRIGHT);
			keyListener.facing = 1;
			wait(20);
			return true;
	    }
		else if (keyListener.keys[KeyEvent.VK_DOWN] && keyListener.facing != 2) {
			player.setIcon(Player.imageDOWN);
			keyListener.facing = 2;
			wait(20);
			return true;
	    }
		else if (keyListener.keys[KeyEvent.VK_LEFT] && keyListener.facing != 3) {
			player.setIcon(Player.imageLEFT);
			keyListener.facing = 3;
			wait(20);
			return true;
	    }
		return false;
	}
	
	private void animateMapMove(JLabel map, int direction) {
		keyListener.isMoving = true;
		Timer moveTimer = new Timer();
		
		int k = 0, j = 0;
		if (keyListener.keys[KeyEvent.VK_UP]) k = -1;
		else if (keyListener.keys[KeyEvent.VK_RIGHT]) j = 1;
		else if (keyListener.keys[KeyEvent.VK_DOWN]) k = 1;
		else if (keyListener.keys[KeyEvent.VK_LEFT]) j = -1;
		Blocks block = Places.getPlaces()[0].getBlock(Player.getX()+j, Player.getY()+k);
		
		moveTimer.scheduleAtFixedRate(new TimerTask() {
			int interval = 1;
			int i = 0;
			@Override
			public void run() {System.out.println(keyListener.facing);
				if (keyListener.running) {
					if (i >= 42) interval = 1;
					else interval = 2;
				}
				
				if (block != Blocks.BARRIER && block != Blocks.SIGN 
						&& block != Blocks.WATER && block != Blocks.DOOR) {
					if (direction == 0 && i < 43) map.setLocation(map.getX(), map.getY()+interval);
					else if (direction == 1 && i < 43) map.setLocation(map.getX()-interval, map.getY());
					else if (direction == 2 && i < 43) map.setLocation(map.getX(), map.getY()-interval);
					else if (direction == 3 && i < 43) map.setLocation(map.getX()+interval, map.getY());
					
					if (i == 43) {
						if (keyListener.facing == 0) Player.setPosition(Player.getX(), Player.getY()-1);
						else if (keyListener.facing == 1) Player.setPosition(Player.getX()+1, Player.getY());
						else if (keyListener.facing == 2) Player.setPosition(Player.getX(), Player.getY()+1);
						else Player.setPosition(Player.getX()-1, Player.getY());
					}
				}
				
				if (i == 8) {
					if (keyListener.useLeftFoot) {
						if (keyListener.facing == 0) {
							if (keyListener.running) player.setIcon(Player.imageRunUP_L);
							else player.setIcon(Player.imageUP_L);
						}
						else if (keyListener.facing == 1) {
							if (keyListener.running) player.setIcon(Player.imageRunRIGHT_L);
							else player.setIcon(Player.imageRIGHT_L);
						}
						else if (keyListener.facing == 2) {
							if (keyListener.running) player.setIcon(Player.imageRunDOWN_L);
							else player.setIcon(Player.imageDOWN_L);
						}
						else {
							if (keyListener.running) player.setIcon(Player.imageRunLEFT_L);
							else player.setIcon(Player.imageLEFT_L);
						}
						keyListener.useLeftFoot = false;
					}
					else {
						if (keyListener.facing == 0) {
							if (keyListener.running) player.setIcon(Player.imageRunUP_R);
							else player.setIcon(Player.imageUP_R);
						}
						else if (keyListener.facing == 1) {
							if (keyListener.running) player.setIcon(Player.imageRunRIGHT_R);
							else player.setIcon(Player.imageRIGHT_R);
						}
						else if (keyListener.facing == 2) {
							if (keyListener.running) player.setIcon(Player.imageRunDOWN_R);
							else player.setIcon(Player.imageDOWN_R);
						}
						else {
							if (keyListener.running) player.setIcon(Player.imageRunLEFT_R);
							else player.setIcon(Player.imageLEFT_R);
						}
						keyListener.useLeftFoot = true;
					}
				}
				else if (i == 43) {
					if (keyListener.facing == 0) {
						if (keyListener.running) player.setIcon(Player.imageRunUP);
						else player.setIcon(Player.imageUP);
					}
					else if (keyListener.facing == 1) {
						if (keyListener.running) player.setIcon(Player.imageRunRIGHT);
						else player.setIcon(Player.imageRIGHT);
					}
					else if (keyListener.facing == 2) {
						if (keyListener.running) player.setIcon(Player.imageRunDOWN);
						else player.setIcon(Player.imageDOWN);
					}
					else {
						if (keyListener.running) player.setIcon(Player.imageRunLEFT);
						else player.setIcon(Player.imageLEFT);
					}
				}
				
				if (i == 50) {
					moveTimer.cancel();
					keyListener.isMoving = false;
					move();
				}
				
				if (keyListener.running) {
					if (i >= 42) i++;
					else i += 2;
				}
				else i++;
			}
		}, 0, 3);
	}
	
	private void wait(int time) {
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			int i = 0;
			@Override
			public void run() {
				if (i == time) {
					move();
					timer.cancel();
				}
				i++;
			}
		}, 0, 5);
	}
	
	private class KeyAction implements KeyListener {
		private boolean isMoving;
		private boolean running; //TODO Hashmap
		private boolean useLeftFoot;
		private int facing;
		private boolean[] keys;
		
		public KeyAction() {
			isMoving = false;
			running = false;
			useLeftFoot = false;
			facing = 2; //South
			keys = new boolean[41]; //TODO Hashmap?
			Arrays.fill(keys, false);
		}

		@Override
		public void keyPressed(KeyEvent ke) {
			if (ke.getKeyCode() == KeyEvent.VK_X) {
				running = true;
				if (keyListener.facing == 0) player.setIcon(Player.imageRunUP);
				else if (keyListener.facing == 1) player.setIcon(Player.imageRunRIGHT);
				else if (keyListener.facing == 2) player.setIcon(Player.imageRunDOWN);
				else player.setIcon(Player.imageRunLEFT);
			}
			
			if (ke.getKeyCode() == KeyEvent.VK_UP || ke.getKeyCode() == KeyEvent.VK_RIGHT || 
					ke.getKeyCode() == KeyEvent.VK_DOWN || ke.getKeyCode() == KeyEvent.VK_LEFT) {
				if ((keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_RIGHT] || 
							keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_LEFT])) {
					if (ke.getKeyCode() == KeyEvent.VK_UP) {
						keys[KeyEvent.VK_UP] = true;
						keys[KeyEvent.VK_RIGHT] = false;
						keys[KeyEvent.VK_DOWN] = false;
						keys[KeyEvent.VK_LEFT] = false;
						move();
					}
					else if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
						keys[KeyEvent.VK_UP] = false;
						keys[KeyEvent.VK_RIGHT] = true;
						keys[KeyEvent.VK_DOWN] = false;
						keys[KeyEvent.VK_LEFT] = false;
						move();					
					}
					else if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
						keys[KeyEvent.VK_UP] = false;
						keys[KeyEvent.VK_RIGHT] = false;
						keys[KeyEvent.VK_DOWN] = true;
						keys[KeyEvent.VK_LEFT] = false;
						move();
					}
					else if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
						keys[KeyEvent.VK_UP] = false;
						keys[KeyEvent.VK_RIGHT] = false;
						keys[KeyEvent.VK_DOWN] = false;
						keys[KeyEvent.VK_LEFT] = true;
						move();
					}
				}
				else {
					keys[ke.getKeyCode()] = true;
					move();
				}
			}
		}
		
		@Override
		public void keyReleased(KeyEvent ke) {
			if (ke.getKeyCode() == KeyEvent.VK_X) {
				running = false;
				if (keyListener.facing == 0) player.setIcon(Player.imageUP);
				else if (keyListener.facing == 1) player.setIcon(Player.imageRIGHT);
				else if (keyListener.facing == 2) player.setIcon(Player.imageDOWN);
				else player.setIcon(Player.imageLEFT);
			}
			
			if (ke.getKeyCode() == KeyEvent.VK_UP || ke.getKeyCode() == KeyEvent.VK_RIGHT || 
					ke.getKeyCode() == KeyEvent.VK_DOWN || ke.getKeyCode() == KeyEvent.VK_LEFT) {
				keys[ke.getKeyCode()] = false;
			}
		}
		
		@Override
		public void keyTyped(KeyEvent ke) {}
		
	}

}
