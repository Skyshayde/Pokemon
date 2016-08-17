package pokemon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

@SuppressWarnings("serial")
public class Editor extends JFrame implements ActionListener, MouseListener, KeyListener {
	private JPanel mainMenu;
	private JPanel mainWindow;
	
	private JFrame objectFrame;
	private JSplitPane mainObjectPane;
	private JPanel objectTreePanel;
	private JTree objectTree;
	private TreePath path;
	private JPanel objectListPanel;
	private JList<PokemonGeneric> pokeList;
	
	private JFrame windowFrame;
	
	
	private JFrame placesFrame;
	
	
	private Pokedex pokedex;
	private final Color STANDARD_COLOR = new Color(250, 250, 250);
	
	public static void main(String[] args) {
		new Editor();
	}
	
	public Editor() {
		setTitle("Pokemon Game Maker");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width + 100, 
				Toolkit.getDefaultToolkit().getScreenSize().height - 45);
		setLocation(-7, 1);
		pokedex = new Pokedex();
		
		mainMenu = new JPanel();
		mainWindow = new JPanel();
		setupPanels();
		add(mainMenu);
		add(mainWindow);
		setVisible(true);
			
		objectFrame = new JFrame();
		setupObjectFrame();
		
		windowFrame = new JFrame();
		setupWindowFrame();
		
		placesFrame = new JFrame();
		setupPlacesFrame();
	}

	private void setupObjectFrame() {
		objectFrame.setTitle("Object Window");
		objectFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		objectFrame.setSize(950, 850);
		
		objectTreePanel = new JPanel();
		setupObjectTreePanel();
		objectListPanel = new JPanel();
		setupObjectListPanel(0);
		
		mainObjectPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				objectTreePanel, objectListPanel);
		mainObjectPane.setOneTouchExpandable(true);
		mainObjectPane.setDividerLocation(200);
		objectFrame.add(mainObjectPane);
		
		objectFrame.setVisible(true);
		objectFrame.setLocation(5, 150);
	}

	private void setupObjectTreePanel() {
		objectTreePanel.setBackground(STANDARD_COLOR);
		objectTreePanel.setLayout(new BorderLayout());
		DefaultMutableTreeNode all = new DefaultMutableTreeNode("All Objects");
		objectTree = new JTree(all);
		objectTree.addMouseListener(this);
		objectTree.addKeyListener(this);

		DefaultMutableTreeNode pokemon = new DefaultMutableTreeNode("Pokemon");
		all.add(pokemon);
			DefaultMutableTreeNode bug = new DefaultMutableTreeNode("Bug");
			pokemon.add(bug);
			DefaultMutableTreeNode dark = new DefaultMutableTreeNode("Dark");
			pokemon.add(dark);
			DefaultMutableTreeNode dragon = new DefaultMutableTreeNode("Dragon");
			pokemon.add(dragon);
			DefaultMutableTreeNode electric = new DefaultMutableTreeNode("Electric");
			pokemon.add(electric);
			DefaultMutableTreeNode fighting = new DefaultMutableTreeNode("Fighting");
			pokemon.add(fighting);
			DefaultMutableTreeNode fire = new DefaultMutableTreeNode("Fire");
			pokemon.add(fire);
			DefaultMutableTreeNode flying = new DefaultMutableTreeNode("Flying");
			pokemon.add(flying);
			DefaultMutableTreeNode ghost = new DefaultMutableTreeNode("Ghost");
			pokemon.add(ghost);
			DefaultMutableTreeNode grass = new DefaultMutableTreeNode("Grass");
			pokemon.add(grass);
			DefaultMutableTreeNode ground = new DefaultMutableTreeNode("Ground");
			pokemon.add(ground);
			DefaultMutableTreeNode ice = new DefaultMutableTreeNode("Ice");
			pokemon.add(ice);
			DefaultMutableTreeNode normal = new DefaultMutableTreeNode("Normal");
			pokemon.add(normal);
			DefaultMutableTreeNode poison = new DefaultMutableTreeNode("Poison");
			pokemon.add(poison);
			DefaultMutableTreeNode psychic = new DefaultMutableTreeNode("Psychic");
			pokemon.add(psychic);
			DefaultMutableTreeNode rock = new DefaultMutableTreeNode("Rock");
			pokemon.add(rock);
			DefaultMutableTreeNode steel = new DefaultMutableTreeNode("Steel");
			pokemon.add(steel);
			DefaultMutableTreeNode water = new DefaultMutableTreeNode("Water");
			pokemon.add(water);
		DefaultMutableTreeNode people = new DefaultMutableTreeNode("People");
		all.add(people);
			DefaultMutableTreeNode trainers = new DefaultMutableTreeNode("Trainers");
			people.add(trainers);
			DefaultMutableTreeNode mainChar = new DefaultMutableTreeNode("Main Characters");
			people.add(mainChar);
			DefaultMutableTreeNode standardPeep = new DefaultMutableTreeNode("Standard People");
			people.add(standardPeep);
		DefaultMutableTreeNode items = new DefaultMutableTreeNode("Items");
		all.add(items);
			DefaultMutableTreeNode mainItems = new DefaultMutableTreeNode("Main Items");
			items.add(mainItems);
			DefaultMutableTreeNode balls = new DefaultMutableTreeNode("Pokeballs");
			items.add(balls);
			DefaultMutableTreeNode berries = new DefaultMutableTreeNode("Berries");
			items.add(berries);
			DefaultMutableTreeNode hm = new DefaultMutableTreeNode("HMs");
			items.add(hm);
			DefaultMutableTreeNode tm = new DefaultMutableTreeNode("TMs");
			items.add(tm);
			DefaultMutableTreeNode key = new DefaultMutableTreeNode("Key Items");
			items.add(key);
		DefaultMutableTreeNode moves = new DefaultMutableTreeNode("Moves");
		all.add(moves);
			DefaultMutableTreeNode physical = new DefaultMutableTreeNode("Physical");
			moves.add(physical);
			DefaultMutableTreeNode status = new DefaultMutableTreeNode("Status");
			moves.add(status);
			DefaultMutableTreeNode special = new DefaultMutableTreeNode("Special");
			moves.add(special);
		DefaultMutableTreeNode events = new DefaultMutableTreeNode("Events");
		all.add(events);
			DefaultMutableTreeNode main = new DefaultMutableTreeNode("Main Events");
			events.add(main);
			DefaultMutableTreeNode side = new DefaultMutableTreeNode("Side Events");
			events.add(side);
		
		path = new TreePath(all);
		objectTree.expandPath(path);
		objectTree.setFont(new Font("Calibri", Font.PLAIN, 18));
		objectTreePanel.add(objectTree);
	}

	private void makeList(PokemonGeneric[] pokemon, Element type, boolean all) {
		objectListPanel.removeAll();
		
		JLabel label2 = new JLabel("pokemon: ");
		objectListPanel.add(label2);
		PokemonGeneric[] pokes = new PokemonGeneric[pokemon.length];
		int j = 0;
		for (int i = 0; i < pokemon.length; i++) {
			if (pokemon[i].getType()[0] == type || all) {
				pokes[j] = pokemon[i];
				j++;
			}
		}

		pokeList = new JList<PokemonGeneric>(pokes);
		pokeList.setBackground(STANDARD_COLOR);
		pokeList.setFont(new Font("Calibri", Font.PLAIN, 40));
		pokeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		objectListPanel.add(new JScrollPane(pokeList));
		
		//pokeList.addMouseListener(this);
		pokeList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent le) {
				new EditorPokemon(pokeList.getSelectedValue());
			}
		});
		mainObjectPane.setDividerLocation(200);
	}
	
	private void setupObjectListPanel(int page) {
		objectListPanel.setLayout(new FlowLayout());
		objectListPanel.setBackground(STANDARD_COLOR);
		switch (page) {
		case 1:
			makeList(pokedex.getPokemon(), Element.WATER, true);
			break;
		case 2:
			makeList(pokedex.getPokemon(), Element.BUG, false);
			break;
		case 3:
			makeList(pokedex.getPokemon(), Element.DARK, false);
			break;
		case 4:
			makeList(pokedex.getPokemon(), Element.DRAGON, false);
			break;
		case 5:
			makeList(pokedex.getPokemon(), Element.ELECTRIC, false);
			break;
		case 6:
			makeList(pokedex.getPokemon(), Element.FIGHTING, false);
			break;
		case 7:
			makeList(pokedex.getPokemon(), Element.FIRE, false);
			break;
		case 8:
			makeList(pokedex.getPokemon(), Element.FLYING, false);
			break;
		case 9:
			makeList(pokedex.getPokemon(), Element.GHOST, false);
			break;
		case 10:
			makeList(pokedex.getPokemon(), Element.GRASS, false);
			break;
		case 11:
			makeList(pokedex.getPokemon(), Element.GROUND, false);
			break;
		case 12:
			makeList(pokedex.getPokemon(), Element.ICE, false);
			break;
		case 13:
			makeList(pokedex.getPokemon(), Element.NORMAL, false);
			break;
		case 14:
			makeList(pokedex.getPokemon(), Element.POISON, false);
			break;
		case 15:
			makeList(pokedex.getPokemon(), Element.PSYCHIC, false);
			break;
		case 16:
			makeList(pokedex.getPokemon(), Element.ROCK, false);
			break;
		case 17:
			makeList(pokedex.getPokemon(), Element.STEEL, false);
			break;
		case 18:
			makeList(pokedex.getPokemon(), Element.WATER, false);
			break;
		case 19:

			break;
		case 20:

			break;
		case 21:

			break;
		case 22:

			break;
		case 23:

			break;
		case 24:

			break;
		case 25:

			break;
		case 26:

			break;
		case 27:

			break;
		case 28:

			break;
		case 29:

			break;
		case 30:

			break;
		case 31:

			break;
		case 32:

			break;
		case 33:

			break;
		case 34:

			break;
		case 35:

			break;
		default:
			break;
		}
	}

	private void setupWindowFrame() {
		windowFrame.setTitle("Game Window");
		windowFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		windowFrame.setSize(950, 500);
		windowFrame.setVisible(true);
		windowFrame.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 2, 150);
	}

	private void setupPlacesFrame() {
		placesFrame.setTitle("Places Window");
		placesFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		placesFrame.setSize(950, 300);
		placesFrame.setVisible(true);
		placesFrame.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 2, 700);
	}

	private void setupPanels() {
		JPanel topPanel = new JPanel();
		topPanel.setBackground(STANDARD_COLOR);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent ae) {
		if (ae.getSource() == objectTree) {
			if (objectTree.getLastSelectedPathComponent().toString() == "Pokemon") {
				setupObjectListPanel(1);
			}
			else if (objectTree.getLastSelectedPathComponent().toString() == "Bug") {
				setupObjectListPanel(2);
			}
			else if (objectTree.getLastSelectedPathComponent().toString() == "Dark") {
				setupObjectListPanel(3);
			}
			else if (objectTree.getLastSelectedPathComponent().toString() == "Dragon") {
				setupObjectListPanel(4);
			}
			else if (objectTree.getLastSelectedPathComponent().toString() == "Electric") {
				setupObjectListPanel(5);
			}
			else if (objectTree.getLastSelectedPathComponent().toString() == "Fighting") {
				setupObjectListPanel(6);
			}
			else if (objectTree.getLastSelectedPathComponent().toString() == "Fire") {
				setupObjectListPanel(7);
			}
			else if (objectTree.getLastSelectedPathComponent().toString() == "Flying") {
				setupObjectListPanel(8);
			}
			else if (objectTree.getLastSelectedPathComponent().toString() == "Ghost") {
				setupObjectListPanel(9);
			}
			else if (objectTree.getLastSelectedPathComponent().toString() == "Grass") {
				setupObjectListPanel(10);
			}
			else if (objectTree.getLastSelectedPathComponent().toString() == "Ground") {
				setupObjectListPanel(11);
			}
			else if (objectTree.getLastSelectedPathComponent().toString() == "Ice") {
				setupObjectListPanel(12);
			}
			else if (objectTree.getLastSelectedPathComponent().toString() == "Normal") {
				setupObjectListPanel(13);
			}
			else if (objectTree.getLastSelectedPathComponent().toString() == "Poison") {
				setupObjectListPanel(14);
			}
			else if (objectTree.getLastSelectedPathComponent().toString() == "Psychic") {
				setupObjectListPanel(15);
			}
			else if (objectTree.getLastSelectedPathComponent().toString() == "Rock") {
				setupObjectListPanel(16);
			}
			else if (objectTree.getLastSelectedPathComponent().toString() == "Steel") {
				setupObjectListPanel(17);
			}
			else if (objectTree.getLastSelectedPathComponent().toString() == "Water") {
				setupObjectListPanel(18);
			}
			else if (objectTree.getLastSelectedPathComponent().toString() == "Peeple") {
				setupObjectListPanel(19);
			}
			else if (objectTree.getLastSelectedPathComponent().toString() == "Trainers") {
				setupObjectListPanel(20);
			}
			else if (objectTree.getLastSelectedPathComponent().toString() == "Main Characters") {
				setupObjectListPanel(21);
			}
			else if (objectTree.getLastSelectedPathComponent().toString() == "Standard People") {
				setupObjectListPanel(22);
			}
			else if (objectTree.getLastSelectedPathComponent().toString() == "Items") {
				setupObjectListPanel(22);
			}
			else if (objectTree.getLastSelectedPathComponent().toString() == "Main Items") {
				setupObjectListPanel(23);
			}
			else if (objectTree.getLastSelectedPathComponent().toString() == "Pokeballs") {
				setupObjectListPanel(24);
			}
			else if (objectTree.getLastSelectedPathComponent().toString() == "Berries") {
				setupObjectListPanel(25);
			}
			else if (objectTree.getLastSelectedPathComponent().toString() == "HMs") {
				setupObjectListPanel(26);
			}
			else if (objectTree.getLastSelectedPathComponent().toString() == "TMs") {
				setupObjectListPanel(27);
			}
			else if (objectTree.getLastSelectedPathComponent().toString() == "Key Items") {
				setupObjectListPanel(28);
			}
			else if (objectTree.getLastSelectedPathComponent().toString() == "Moves") {
				setupObjectListPanel(29);
			}
			else if (objectTree.getLastSelectedPathComponent().toString() == "Physical") {
				setupObjectListPanel(30);
			}
			else if (objectTree.getLastSelectedPathComponent().toString() == "Status") {
				setupObjectListPanel(31);
			}
			else if (objectTree.getLastSelectedPathComponent().toString() == "Special") {
				setupObjectListPanel(32);
			}
			else if (objectTree.getLastSelectedPathComponent().toString() == "Events") {
				setupObjectListPanel(33);
			}
			else if (objectTree.getLastSelectedPathComponent().toString() == "Main Events") {
				setupObjectListPanel(34);
			}
			else if (objectTree.getLastSelectedPathComponent().toString() == "Side Events") {
				setupObjectListPanel(35);
			}
			
			/*if (pokeList.getSelectedValue() != null) {
				if (pokeList.getSelectedValue().getType() == Element.WATER) {
					objectListPanel.setBackground(Color.blue);
				}
				else if (pokeList.getSelectedValue().getType() == Element.GRASS) {
					objectListPanel.setBackground(Color.green);
				}
				else if (pokeList.getSelectedValue().getType() == Element.FIRE) {
					objectListPanel.setBackground(Color.red);
				}
			}*/
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
