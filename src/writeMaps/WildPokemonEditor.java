package writeMaps;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import pokemon.Blocks;
import pokemon.Pokedex;
import pokemon.PokemonGeneric;

public class WildPokemonEditor extends JFrame implements MouseListener {
	private static final long serialVersionUID = -7040677781824698421L;
	private JList<String> pokedexList;
	private boolean multiSelect;
	private int totalPercent;
	private DefaultTableModel model;

	public WildPokemonEditor() {
		setTitle("Wild Pokemon Editor");
		setSize(640, 450);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
		Insets toolHeight = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());
		setLocation((scrSize.width - getWidth())/2, 
				(scrSize.height - toolHeight.bottom - getHeight())/2);
		
		setComponents();
		setPokemon();
		
		setVisible(true);
	}
	
	private void setComponents() {
		JPanel mainPanel = new JPanel();
		mainPanel.setSize(getWidth(), getHeight());
		mainPanel.setLayout(null);
		mainPanel.setBackground(new Color(227, 227, 227));
		add(mainPanel);
		
		pokedexList = new JList<String>();
		pokedexList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //TODO
		pokedexList.setLayoutOrientation(JList.VERTICAL);
		pokedexList.setVisibleRowCount(10);
		
		ScrollPane pokedexScroller = new ScrollPane(pokedexList);
		pokedexScroller.setBorder(BorderFactory.createLineBorder(Color.gray));
		pokedexScroller.setBounds(10, 20, 70, 150);
		mainPanel.add(pokedexScroller);
		
		model = new DefaultTableModel();
		model.addColumn("Pokemon");
		model.addColumn("Location");
		model.addColumn("Rarity");
		JTable wildList = new JTable(model);
		wildList.getTableHeader().setEnabled(false);
		wildList.setPreferredScrollableViewportSize(wildList.getPreferredSize());
		wildList.setRowHeight(20);
		wildList.setFillsViewportHeight(true);
		wildList.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		
		JButton add = new JButton("->");
		add.setSize(30, 30);
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				calculatePercent(20);
				Object[] data = {pokedexList.getSelectedValue(), Blocks.TALLGRASS, "%"+20};
				model.addRow(data);
			}
		});
		mainPanel.add(add);
		
		JScrollPane wildScroller = new JScrollPane(wildList);
		wildScroller.setBorder(BorderFactory.createLineBorder(Color.gray));
		wildScroller.setBounds(200, 20, 70, 150);
		mainPanel.add(wildScroller);
	}
	
	private void calculatePercent(int num) {
		int percent = num+totalPercent;
		for (int i = 0; i < model.getRowCount(); i++) {
			model.setValueAt((Integer)model.getValueAt(i, 2)*totalPercent/percent, i, 2);
		}
		totalPercent += num;
	}
	
	private void setPokemon() {
		PokemonGeneric[] pokedex = Pokedex.getPokemon();
		String[] names = new String[pokedex.length];
		for (int i = 0; i < pokedex.length; i++) {
			int id = pokedex[i].getID();
			String idFormat = id+"";
			if (id < 10) idFormat = "00"+id;
			else if (id < 100) idFormat = "0"+id;
			names[i] = idFormat + " | " + pokedex[i].getName() + "  ";
		}
		pokedexList.setListData(names);
	}
	
	@Override
	public void mousePressed(MouseEvent arg0) { //TODO fix!
		multiSelect = true;
	}
	@Override
	public void mouseReleased(MouseEvent arg0) { multiSelect = false; }
	@Override
	public void mouseClicked(MouseEvent arg0) {}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		if (multiSelect)  {
			pokedexList.setSelectedIndex(pokedexList.getSelectedIndex());
		}
	}
	@Override
	public void mouseExited(MouseEvent arg0) { multiSelect = false; }
}
