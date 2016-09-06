package pokemon;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URL;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class GUIMenu extends JPanel implements KeyListener {
	private static final long serialVersionUID = -3208377282930650081L;
	private Game game;
	private JLayeredPane layerPane;
	private JLabel menu;
	private JLabel pointer;
	private JPanel pokedex, pokemon, bag, iphone, player, save, option;
	private Font font;
	private int position;
	private int maxPos;
	private boolean optionIsActive;

	public GUIMenu(Game game) {
		this.game = game;
		setLayout(null);
		setOpaque(false);
		layerPane = new JLayeredPane();
		layerPane.setBounds(0, 0, game.gameFrame.getWidth(), game.gameFrame.getHeight());
		add(layerPane);
		
		optionIsActive = false;

		URL fontURL = getClass().getResource("/windowImages/pkmnfl.ttf");
	    try {
			font = Font.createFont(Font.TRUETYPE_FONT, fontURL.openStream());
			font = font.deriveFont(28.0f);
		} catch (FontFormatException | IOException e) {
			// TODO send message of missing files and what to do
			e.printStackTrace();
		}
	}
	
	public void setIcons(int max) {
		maxPos = max; maxPos = 6;
		menu();
		pointer();
		layerPane.add(menu, new Integer(0));
		layerPane.add(pointer, new Integer(1));
	}
	
	private void menu() {
		menu = new JLabel();
		ImageFile image = new ImageFile(getClass().getResource("/windowImages/Menu.png"), 10);
		if (maxPos == 4) {
			image = new ImageFile(getClass().getResource("/windowImages/MenuSize3.png"), 10);
		}
		else if (maxPos == 6) {
			image = new ImageFile(getClass().getResource("/windowImages/MenuSize2.png"), 10);
		}
		menu.setIcon(image);System.out.println();
		menu.setBounds(getWidth()-image.getIconWidth()-3, 3, image.getIconWidth(), image.getIconHeight());
		
		String strOptions[];
		if (maxPos == 4) {
			strOptions = new String[] {"BAG", Player.getFirstName().toUpperCase(), 
					"SAVE", "OPTION", "EXIT"};
		}
		else if (maxPos == 6) {
			strOptions = new String[] {"POKÈDEX", "POKÈMON", "BAG", 
					Player.getFirstName().toUpperCase(), "SAVE", "OPTION", "EXIT"};
		}
		else {
			strOptions = new String[]{"POKÈDEX", "POKÈMON", "BAG", "iPHONE", 
					Player.getFirstName().toUpperCase(), "SAVE", "OPTION", "EXIT"};
		}
		
		for (int i = 0; i < strOptions.length; i++) {
			JLabel option = new JLabel(strOptions[i]);
			option.setFont(font);
			option.setForeground(new Color(65, 65, 65));
			option.setBounds(36, 34+33*i, 100, 30);
			menu.add(option);
		}
		
		pokedex = new JPanel(); //TODO have a method that starts all panels up?
		pokemon = new JPanel();
		bag = new JPanel();
		iphone = new JPanel();
		player = new JPanel();
		save = new JPanel();
		option = new JPanel();
	}
	
	private void pointer() {
		ImageFile image = new ImageFile(getClass().getResource("/windowImages/Pointer.png"), 2);
		pointer = new JLabel(image);
		pointer.setBounds(getWidth()-menu.getWidth()+12, 44, image.getIconWidth(), image.getIconHeight());
	}
	
	private void setPokedex() {
		System.out.println(getWidth() +" "+ getHeight());
	}

	@Override
	public void keyPressed(KeyEvent ke) {
		if (ke.getKeyCode() == KeyEvent.VK_Z || ke.getKeyCode() == KeyEvent.VK_ENTER) {
			if (position == 0 && (maxPos == 6 || maxPos == 7)) {
				pokedex.setLayout(null);
				pokedex.setBounds(0, 0, getWidth(), getHeight());
				ImageFile image = new ImageFile(getClass().getResource("/windowImages/pokedex.png"));
				image.scale(getWidth(), getHeight());
				JLabel pokedexLabel = new JLabel(image);
				pokedexLabel.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
				pokedex.add(pokedexLabel);
				setPokedex();
				layerPane.add(pokedex, new Integer(2));
				optionIsActive = true;
			}
			else if (position == 1 && (maxPos == 6 || maxPos == 7)) {

				optionIsActive = true;
				System.out.println("Pokemon");
			}
			else if ((position == 0 && maxPos == 4) || (position == 2 && (maxPos == 6 || maxPos == 7))) {

				optionIsActive = true;
				System.out.println("Bag");
			}
			else if (position == 3 && maxPos == 7) {

				optionIsActive = true;
				System.out.println("iPhone");
			}
			else if (position == maxPos - 3) {

				optionIsActive = true;
				System.out.println("Frodo");
			}
			else if (position == maxPos - 2) {

				optionIsActive = true;
				System.out.println("Save");
			}
			else if (position == maxPos - 1) {
				option.setLayout(null);
				option.setBounds(0, 0, getWidth(), getHeight());
				JLabel l = new JLabel("Options are not available at this time");
				l.setFont(font);
				l.setBounds(20, getHeight()-100, 500, 40);
				JLabel l2 = new JLabel("Press B to Exit");
				l2.setFont(font);
				l2.setBounds(20, getHeight()-60, 200, 35);
				option.add(l);
				option.add(l2);
				layerPane.add(option, new Integer(2));
				optionIsActive = true;
			}
			else if (position == maxPos && !optionIsActive) {
				game.menuOpen = false;
				game.gameLayer.remove(game.menu);
				game.gameLayer.repaint();
				game.gameFrame.removeKeyListener(this);
				game.setMenuClosed();
			}
		}
		
		if (ke.getKeyCode() == KeyEvent.VK_UP && !optionIsActive) {
			if (position == 0) {
				position = maxPos;
				pointer.setBounds(pointer.getX(), pointer.getY()+33*maxPos, 
						pointer.getWidth(), pointer.getHeight());
			}
			else {
				position -= 1;
				pointer.setBounds(pointer.getX(), pointer.getY()-33, 
						pointer.getWidth(), pointer.getHeight());
			}
		}
		else if (ke.getKeyCode() == KeyEvent.VK_DOWN && !optionIsActive) {
			if (position == maxPos) {
				position = 0;
				pointer.setBounds(pointer.getX(), pointer.getY()-33*maxPos, 
						pointer.getWidth(), pointer.getHeight());
			}
			else {
				position += 1;
				pointer.setBounds(pointer.getX(), pointer.getY()+33, 
						pointer.getWidth(), pointer.getHeight());
			}
		}
		
		if (ke.getKeyCode() == KeyEvent.VK_X && !optionIsActive) {
			game.gameLayer.remove(game.menu);
			game.gameLayer.repaint();
			game.gameFrame.removeKeyListener(this);
			game.setMenuClosed();
		}
		else if (ke.getKeyCode() == KeyEvent.VK_X) {
			if (pokedex.isValid()) layerPane.remove(pokedex);
			else if (pokemon.isValid()) layerPane.remove(pokemon);
			else if (bag.isValid()) layerPane.remove(bag);
			else if (iphone.isValid()) layerPane.remove(iphone);
			else if (player.isValid()) layerPane.remove(player);
			else if (save.isValid()) layerPane.remove(save);
			else if (option.isValid()) layerPane.remove(option);
			layerPane.repaint();
			optionIsActive = false;
		}
	}

	@Override
	public void keyReleased(KeyEvent ke) { //TODO fix or set b inactive for standing
		if (ke.getKeyCode() == KeyEvent.VK_X && !optionIsActive) {
			game.menuOpen = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent ke) {}
	
}
