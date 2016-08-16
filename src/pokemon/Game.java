package pokemon;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

public class Game {
	private JFrame gameFrame;
	private JPanel gamePanel;

	public Game() {
		setGameFrame();
	}
	
	public void actionMove() {
		gamePanel.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent ke) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyReleased(KeyEvent ke) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void keyTyped(KeyEvent ke) {
				if(ke.getKeyCode() == KeyEvent.VK_UP) {
					
				}
				else if(ke.getKeyCode() == KeyEvent.VK_RIGHT) {
									
				}
				else if(ke.getKeyCode() == KeyEvent.VK_DOWN) {
					
				}
				else if(ke.getKeyCode() == KeyEvent.VK_LEFT) {
					
				}
			}
		});
	}
	
	public void setGameFrame() {
		gameFrame = new JFrame();
		gameFrame.setSize(600, 400);
		gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
		Insets toolHeight = Toolkit.getDefaultToolkit().getScreenInsets(gameFrame.getGraphicsConfiguration());
		gameFrame.setLocation((scrSize.width - gameFrame.getWidth())/2, 
				(scrSize.height - toolHeight.bottom - gameFrame.getHeight())/2);
		
		gamePanel = new JPanel();
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
		fileMenu.getAccessibleContext().setAccessibleDescription(
		        "The only menu in this program that has menu items");
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
	
}
