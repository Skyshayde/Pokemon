package writeMaps;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.WindowConstants;
import javax.swing.plaf.basic.BasicScrollBarUI;

import pokemon.ImageFile;

public class Editor extends JFrame {
	private static final long serialVersionUID = -2073445832146296219L;
	private RadioButton[] mapItems;
	private JPanel mainPanel, worldWindow, imageBar;
	private JScrollPane scrollbar;
	private JButton[] img;
	private ImageFile currentImage;
	private int gridSize;
	private int selectedItem;
	private boolean gridRollover;

	public Editor() {
		setTitle("Map Editor");
		setSize(892, 625);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
		Insets toolHeight = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());
		setLocation((scrSize.width - getWidth())/2, 
				(scrSize.height - toolHeight.bottom - getHeight())/2);
		
		gridSize = 15; //default
		setComponenets();
		setMenuBar();
	}
	
	public void setComponenets() {
		mainPanel = new JPanel();
		mainPanel.setSize(getWidth(), getHeight());
		mainPanel.setBackground(new Color(160, 160, 160));
		mainPanel.setLayout(null);
		add(mainPanel);
		
		/**
		 * Map Item bar
		 */
		JPanel mapItemBar = new JPanel();
		mapItemBar.setBounds(5, 5, 140, getHeight()-62);
		mapItemBar.setBackground(new Color(255, 240, 198));
		mapItemBar.setLayout(null);
		mapItemBar.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		
		JLabel blocksLabel = new JLabel("<HTML><U>Blocks</U></HTML>");
		blocksLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
		blocksLabel.setBounds(10, 8, 150, 20);
		mapItemBar.add(blocksLabel);
		
		ButtonGroup mapItemGroup = new ButtonGroup();
		mapItems = new RadioButton[23];
		mapItems[0] = new RadioButton("Standard");
		mapItems[1] = new RadioButton("Tall Grass");
		mapItems[2] = new RadioButton("Cave");
		mapItems[3] = new RadioButton("Desert");
		mapItems[4] = new RadioButton("Building Material");
		mapItems[5] = new RadioButton("Ridge");
		mapItems[6] = new RadioButton("Tree");
		mapItems[7] = new RadioButton("Tree [4 blocks]");
		mapItems[8] = new RadioButton("Lake");
		mapItems[9] = new RadioButton("Pond");
		mapItems[10] = new RadioButton("Puddle");
		mapItems[11] = new RadioButton("Waterfall");
		mapItems[12] = new RadioButton("Berry Soil");
		mapItems[13] = new RadioButton("Door");
		mapItems[14] = new RadioButton("Flower");
		mapItems[15] = new RadioButton("PokeBall");
		mapItems[16] = new RadioButton("Sign");
		mapItems[17] = new RadioButton("Wooden Sign");
		mapItems[18] = new RadioButton("Tree (cut)");
		mapItems[19] = new RadioButton("Rock (rock smash)");
		mapItems[20] = new RadioButton("Rock (strength)");
		mapItems[21] = new RadioButton("Person");
		mapItems[22] = new RadioButton("Player");
		int separator = 0;
		for (int i = 0; i < 23; i++) {
			if (i == 4 || i == 8 || i == 12 || i == 18 || i == 21) separator += 10;
			mapItems[i].setWindowAccess(this);
			mapItems[i].setBounds(5, 34+20*i+separator, 150, 25);
			mapItems[i].setOpaque(false);
			mapItems[i].setFont(new Font("Calibri", Font.PLAIN, 14));
			mapItems[i].setID(i);
			mapItems[i].setImages(i);
			mapItemGroup.add(mapItems[i]);
			mapItemBar.add(mapItems[i]);
		}
		mainPanel.add(mapItemBar);
		mapItems[0].setSelected(true);
		mapItems[0].selected(true);
		
		/**
		 * World Window
		 */
		worldWindow = new JPanel();
		worldWindow.setBounds(150, 5, getWidth()-237, getHeight()-62);
		worldWindow.setLayout(null);
		worldWindow.setBackground(Color.gray);
		worldWindow.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		mainPanel.add(worldWindow);
		
		GridBlock[] gridBlocks = new GridBlock[gridSize*gridSize];
		int shiftX = 0, shiftY = 0, borderX = 0, borderY = 0;
		int size = (worldWindow.getHeight()-4)/gridSize;
		int yspace = (worldWindow.getHeight()-(size*gridSize+2)-3)/2;
		for (int i = 0; i < gridSize; i++) {
			for (int j = 0; j < gridSize; j++) {
				if (j == 0) borderX = 2;
				else borderX = 0;
				if (i == 0) borderY = 2;
				else borderY = 0;
				gridBlocks[gridSize*i+j] = new GridBlock(j, i, this);
				gridBlocks[gridSize*i+j].setBounds(yspace+borderX+shiftX, yspace+borderY+shiftY, size, size);
				shiftX = gridBlocks[gridSize*i+j].getX() + gridBlocks[gridSize*i+j].getWidth()-yspace;
				worldWindow.add(gridBlocks[gridSize*i+j]);
				if (j == gridSize-1) {
					shiftX = 0;
					shiftY = gridBlocks[gridSize*i+j].getY() + gridBlocks[gridSize*i+j].getHeight()-yspace;
				}
			}
		}
		int oldWidth = worldWindow.getWidth();
		worldWindow.setSize(shiftY+2*yspace+2, worldWindow.getHeight());
		setSize(getWidth()-(oldWidth-worldWindow.getWidth()), 625);
		
		/**
		 * Image Bar
		 */
		imageBar = new JPanel();
		imageBar.setLayout(new BoxLayout(imageBar, BoxLayout.Y_AXIS));
		img = new JButton[mapItems[selectedItem].getNumImages()];
		for(int i = 0; i < mapItems[selectedItem].getNumImages(); i++) {
			final int k = i;
			img[i] = new JButton();
			img[i].setLayout(null);
			img[i].setPreferredSize(new Dimension(50, 50));
			img[i].setBackground(new Color(255, 240, 198));
			img[i].addActionListener(new ActionListener() {
				int i = k;
				@Override
				public void actionPerformed(ActionEvent e) {
					updateImagesColor();
					currentImage = mapItems[selectedItem].getImage(i);
					img[i].setBackground(new Color(255, 140, 30));
				}
			});
			JLabel l = new JLabel(mapItems[selectedItem].getImage(i));
			l.setBounds(5, 5, 40, 40);
			l.setBorder(BorderFactory.createLineBorder(Color.gray));
			img[i].add(l);
			imageBar.add(img[i]);
		}
		scrollbar = new JScrollPane(imageBar);
		scrollbar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollbar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollbar.setBounds(getWidth()-82, 5, 72, getHeight()-62);
		scrollbar.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		scrollbar.getVerticalScrollBar().setUI(new BasicScrollBarUI() {   
	        @Override
	        protected JButton createDecreaseButton(int orientation) {
	        	JButton button = super.createDecreaseButton(orientation);
	        	button.setBackground(Color.white);
	        	return button;
	        }
	        @Override    
	        protected JButton createIncreaseButton(int orientation) {
	        	JButton button = super.createIncreaseButton(orientation);
	        	button.setBackground(Color.white);
	        	return button;
	        }
	        @Override 
	        protected void configureScrollBarColors() {
	        	super.configureScrollBarColors();
	        	trackColor = new Color(229, 229, 229);
	        	thumbDarkShadowColor = new Color(120, 120, 120);
	        	thumbLightShadowColor = new Color(180, 180, 180);
	        	thumbHighlightColor = new Color(249, 249, 249);
	        	thumbColor = new Color(209, 209, 209);
	        }
	    });
		mainPanel.add(scrollbar);
	}
	
	public void updateImages() {
		imageBar.removeAll();
		img = new JButton[mapItems[selectedItem].getNumImages()];
		for(int i = 0; i < mapItems[selectedItem].getNumImages(); i++) {
			final int k = i;
			img[i] = new JButton();
			img[i].setLayout(null);
			img[i].setPreferredSize(new Dimension(50, 50));
			img[i].setBackground(new Color(255, 240, 198));
			img[i].addActionListener(new ActionListener() {
				int i = k;
				@Override
				public void actionPerformed(ActionEvent e) {
					updateImagesColor();
					currentImage = mapItems[selectedItem].getImage(i);
					img[i].setBackground(new Color(255, 140, 30));
				}
			});
			JLabel l = new JLabel(mapItems[selectedItem].getImage(i));
			l.setBounds(5, 5, 40, 40);
			l.setBorder(BorderFactory.createLineBorder(Color.black));
			img[i].add(l);
			imageBar.add(img[i]);
		}
		scrollbar.updateUI();
		imageBar.repaint();
	}
	
	public void updateImagesColor() {
		for(int i = 0; i < mapItems[selectedItem].getNumImages(); i++) {
			img[i].setBackground(new Color(255, 240, 198));
		}
	}
	
	public void setSelectedItem(int item) { selectedItem = item; }

	public void unSelectButtons() {
		for (int i = 0; i < 23; i++) {
			mapItems[i].selected(false);
		}
	}
	
	public ImageFile getCurrentImage() { return currentImage; }
	
	public void updateWorldWindow() {
		worldWindow.removeAll();
		GridBlock[] gridBlocks = new GridBlock[gridSize*gridSize];
		int shiftX = 0, shiftY = 0, borderX = 0, borderY = 0;
		int size = (worldWindow.getHeight()-4)/gridSize;
		int yspace = (worldWindow.getHeight()-(size*gridSize+2)-3)/2;
		for (int i = 0; i < gridSize; i++) {
			for (int j = 0; j < gridSize; j++) {
				if (j == 0) borderX = 2;
				else borderX = 0;
				if (i == 0) borderY = 2;
				else borderY = 0;
				gridBlocks[gridSize*i+j] = new GridBlock(j, i, this);
				gridBlocks[gridSize*i+j].setBounds(yspace+borderX+shiftX, yspace+borderY+shiftY, size, size);
				shiftX = gridBlocks[gridSize*i+j].getX() + gridBlocks[gridSize*i+j].getWidth()-yspace;
				worldWindow.add(gridBlocks[gridSize*i+j]);
				if (j == gridSize-1) {
					shiftX = 0;
					shiftY = gridBlocks[gridSize*i+j].getY() + gridBlocks[gridSize*i+j].getHeight()-yspace;
				}
			}
		}
		int oldWidth = worldWindow.getWidth();
		worldWindow.setSize(shiftY+2*yspace+2, worldWindow.getHeight());
		setSize(getWidth()-(oldWidth-worldWindow.getWidth()), 625);
		repaint();
	}
	
	public void setGridRollover(boolean bool) { gridRollover = bool; }
	
	public boolean gridRollover() { return gridRollover; }
	
	public void setMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		menuBar.add(fileMenu);
		
		JMenuItem exitMenuItem = new JMenuItem("Exit", KeyEvent.VK_E);
		exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, ActionEvent.ALT_MASK));
		exitMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		fileMenu.add(exitMenuItem);
		
		JMenu mapMenu = new JMenu("Map");
		mapMenu.setMnemonic(KeyEvent.VK_O);
		menuBar.add(mapMenu);
		
		JMenuItem Map_EditSize = new JMenuItem("Edit Map Size");
		Map_EditSize.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		Map_EditSize.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFrame sizeEdit = new JFrame();
				sizeEdit.setLayout(new FlowLayout());
				sizeEdit.setSize(200, 100);
				sizeEdit.setFocusable(true);
				
				JLabel label = new JLabel("Choose Map Size: ");
				sizeEdit.add(label);
				
				SpinnerModel spinnerTimeModel = new SpinnerNumberModel(gridSize, 15, 60, 1);
				JSpinner delaySpinner = new JSpinner(spinnerTimeModel);
				delaySpinner.setSize(30, 20);
				sizeEdit.add(delaySpinner);
				
				JButton set = new JButton("Set");
				set.setSize(sizeEdit.getWidth()-20, sizeEdit.getHeight()/3);
				set.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						gridSize = (int) delaySpinner.getValue();
						updateWorldWindow();
						sizeEdit.dispose();
					}
				});
				sizeEdit.add(set);
				
				sizeEdit.addKeyListener(new KeyListener() {
					@Override
					public void keyPressed(KeyEvent ke) {
						if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
							gridSize = (int) delaySpinner.getValue();
							updateWorldWindow();
							sizeEdit.dispose();
						}
						else if (ke.getKeyCode() == KeyEvent.VK_UP && (int) delaySpinner.getValue() < 60) {
							delaySpinner.setValue((int)delaySpinner.getValue()+1);
						}
						else if (ke.getKeyCode() == KeyEvent.VK_DOWN && (int) delaySpinner.getValue() > 15) {
							delaySpinner.setValue((int)delaySpinner.getValue()-1);
						}
					}
					@Override
					public void keyReleased(KeyEvent arg0) {}
					@Override
					public void keyTyped(KeyEvent arg0) {}
				});
				sizeEdit.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
				Insets toolHeight = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());
				sizeEdit.setLocation((scrSize.width - sizeEdit.getWidth())/2, 
						(scrSize.height - toolHeight.bottom - sizeEdit.getHeight())/2);
				sizeEdit.setVisible(true);
			}
		});
		mapMenu.add(Map_EditSize);
		
		JMenuItem Map_Pokemon = new JMenuItem("Wild Pokemon");
		Map_Pokemon.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
		Map_Pokemon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//TODO
			}
		});
		mapMenu.add(Map_Pokemon);
		
		JMenu objectMenu = new JMenu("Objects");
		objectMenu.setMnemonic(KeyEvent.VK_O);
		menuBar.add(objectMenu);
		
		JMenuItem imageMenuItem = new JMenuItem("Edit Images", KeyEvent.VK_E);
		imageMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		imageMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new ImageEditor();
			}
		});
		objectMenu.add(imageMenuItem);
	}
}
