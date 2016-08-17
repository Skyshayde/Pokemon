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
	private JFrame gameFrame;
	private JPanel gamePanel;
	private JLabel player;
	private JLabel map;
	private boolean isMoving;
	private boolean useLeftFoot;
	private int facing;
	
	private boolean[] keys;

	public Game() {
		new Player();
		new Places();
		
		setGameFrame();
		setStateMap();
	}
	
	public void setGameFrame() {
		gameFrame = new JFrame("Pokemon Jade");
		gameFrame.setSize(640, 450);
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
		player.setBounds(gamePanel.getWidth()/2-20, gamePanel.getHeight()/2-28, Player.imageUP.getIconWidth(), Player.imageUP.getIconHeight());
		gamePanel.add(player);
		Player.setPosition(19, 21);
		
		map = new JLabel(Places.getMap(0));
		map.setBounds(-527, -731, Places.getMap(0).getIconWidth(), Places.getMap(0).getIconHeight());
		gamePanel.add(map);

		keys = new boolean[41]; //TODO Hashmap?
		Arrays.fill(keys, false);
		gameFrame.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent ke) {
				if (!(keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_RIGHT] || 
						keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_LEFT])) {
					keys[ke.getKeyCode()] = true;
					move();
				}
				if (ke.getKeyCode() == KeyEvent.VK_SPACE) {
					System.out.println(map.getX() + " " + map.getY());
				}
			}
			@Override
			public void keyReleased(KeyEvent ke) {
				keys[ke.getKeyCode()] = false;
			}
			@Override
			public void keyTyped(KeyEvent ke) {}
		});
	}
	
	private void move() {
		if (keys[KeyEvent.VK_UP] && !isMoving) {
			if (!turn(map)) animateMapMove(map, 0);
	    }
		else if (keys[KeyEvent.VK_RIGHT] && !isMoving) {
			if (!turn(map)) animateMapMove(map, 1);
	    }
		else if (keys[KeyEvent.VK_DOWN] && !isMoving) {
			if (!turn(map)) animateMapMove(map, 2);
	    }
		else if (keys[KeyEvent.VK_LEFT] && !isMoving) {
			if (!turn(map)) animateMapMove(map, 3);
	    }
	}
	
	private boolean turn(JLabel map) {
		if (keys[KeyEvent.VK_UP] && facing != 0) {
			player.setIcon(Player.imageUP);
			facing = 0;
			wait(20);
			return true;
	    }
		else if (keys[KeyEvent.VK_RIGHT] && facing != 1) {
			player.setIcon(Player.imageRIGHT);
			facing = 1;
			wait(20);
			return true;
	    }
		else if (keys[KeyEvent.VK_DOWN] && facing != 2) {
			player.setIcon(Player.imageDOWN);
			facing = 2;
			wait(20);
			return true;
	    }
		else if (keys[KeyEvent.VK_LEFT] && facing != 3) {
			player.setIcon(Player.imageLEFT);
			facing = 3;
			wait(20);
			return true;
	    }
		return false;
	}
	
	private void animateMapMove(JLabel map, int direction) {
		isMoving = true;
		Timer moveTimer = new Timer();
		
		int i = 0, j = 0;
		if (keys[KeyEvent.VK_UP]) i = -1;
		else if (keys[KeyEvent.VK_RIGHT]) j = 1;
		else if (keys[KeyEvent.VK_DOWN]) i = 1;
		else if (keys[KeyEvent.VK_LEFT]) j = -1;
		
		Blocks block = Places.getPlaces()[0].getBlock(Player.getX()+j, Player.getY()+i);
		if (block != Blocks.BARRIER && block != Blocks.SIGN 
				&& block != Blocks.WATER && block != Blocks.DOOR) {
			moveTimer.scheduleAtFixedRate(new TimerTask() {
				int i = 0;
				@Override
				public void run() {
					if (direction == 0 && i < 43) map.setLocation(map.getX(), map.getY()+1);
					else if (direction == 1 && i < 43) map.setLocation(map.getX()-1, map.getY());
					else if (direction == 2 && i < 43) map.setLocation(map.getX(), map.getY()-1);
					else if (direction == 3 && i < 43) map.setLocation(map.getX()+1, map.getY());
					
					if (i == 8) {
						if (useLeftFoot) {
							if (facing == 0) player.setIcon(Player.imageUP_L);
							else if (facing == 1) player.setIcon(Player.imageRIGHT_L);
							else if (facing == 2) player.setIcon(Player.imageDOWN_L);
							else player.setIcon(Player.imageLEFT_L);
							useLeftFoot = false;
						}
						else {
							if (facing == 0) player.setIcon(Player.imageUP_R);
							else if (facing == 1) player.setIcon(Player.imageRIGHT_R);
							else if (facing == 2) player.setIcon(Player.imageDOWN_R);
							else player.setIcon(Player.imageLEFT_R);
							useLeftFoot = true;
						}
					}
					else if (i == 43) {
						if (facing == 0) {
							player.setIcon(Player.imageUP);
							Player.setPosition(Player.getX(), Player.getY()-1);
						}
						else if (facing == 1) {
							player.setIcon(Player.imageRIGHT);
							Player.setPosition(Player.getX()+1, Player.getY());
						}
						else if (facing == 2) {
							player.setIcon(Player.imageDOWN);
							Player.setPosition(Player.getX(), Player.getY()+1);
						}
						else {
							player.setIcon(Player.imageLEFT);
							Player.setPosition(Player.getX()-1, Player.getY());
						}
					}
					
					if (i == 55) {
						moveTimer.cancel();
						isMoving = false;
						move();
					}
					i++;
				}
			}, 10, 3);
		}
		else isMoving = false;
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
		}, 10, 5);
	}

}
