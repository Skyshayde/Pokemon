package pokemon;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class EditorPokemon extends JFrame implements ActionListener {
	private PokemonGeneric pokemon;
	private JPanel panel;
	//Change ID number
	private JTextField nameBox;
	private JTextField descriptionBox;
	private JComboBox<String> rarityBox;
	private JCheckBox[] elementBoxes;
	private JCheckBox[] moveBoxes;
	private JButton saveButton;
	
	public static void main(String[] a) {
		PokemonGeneric b = new PokemonGeneric("Paris", Element.BUG, 1, "A poisonous bug pokemon", 20);
		new EditorPokemon(b);
	}
	
	public EditorPokemon(PokemonGeneric selectedValue) {
		setDesign();
		pokemon = selectedValue;
		setTitle(selectedValue.getName());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(1000, 600);
		setVisible(true);
		setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 6, 200);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(230, 230, 230));
		add(panel);
		
		addTextFields();
		addElementBoxes();
		addRarity();
		addSave();
	}

	private void addTextFields() {
		JLabel nameLabel = new JLabel("Pokemon Name:");
		panel.add(nameLabel);
		nameLabel.setBounds(15, 32, 200, 20);
		
		nameBox = new JTextField();
        panel.add(nameBox);
        nameBox.setBounds(15, 50, 220, 30);
        nameBox.setText(pokemon.getName());
        
        JLabel descriptionLabel = new JLabel("Description:");
		panel.add(descriptionLabel);
        descriptionLabel.setBounds(15, 92, 200, 20);
		
		descriptionBox = new JTextField();
        panel.add(descriptionBox);
        descriptionBox.setBounds(15, 110, 220, 30);
        descriptionBox.setText(pokemon.getDescription());
	}
	
	private void addElementBoxes() {
		JLabel elementLabel = new JLabel("Elements:");
		panel.add(elementLabel);
		elementLabel.setBounds(15, 160, 200, 20);
		
		elementBoxes = new JCheckBox[17];
		String[] elements = {"Bug", "Dark", "Dragon", "Electric", "Fighting", 
				"Fire", "Flying", "Ghost", "Grass", "Ground", "Ice", "Normal", 
				"Poison", "Psychic", "Rock", "Steel", "Water"};
		int x = 0;
		int y = 0;
		for (int i = 0; i < 17; i++) {
			elementBoxes[i] = new JCheckBox();
			elementBoxes[i].setBackground(new Color(230, 230, 230));
			elementBoxes[i].setText(elements[i]);
			panel.add(elementBoxes[i]);
			elementBoxes[i].setBounds(x + 15, y + 178, 75, 20);
			y += 20;
			if (i == 5 || i == 11) {
				x += 75;
				y = 0;
			}
			
			if (pokemon.getType().toString().equals(elements[i].toUpperCase())) {
				elementBoxes[i].setSelected(true);
			}
		}
	}
	
	private void addRarity() {
		JLabel rarityLabel = new JLabel("Rarity: ");
		panel.add(rarityLabel);
		rarityLabel.setBounds(15, 312, 200, 20);
		
		rarityBox = new JComboBox<String>();
		rarityBox.setBackground(Color.WHITE);
		
		rarityBox.addItem("Ultra Common");
		rarityBox.addItem("Common");
		rarityBox.addItem("Uncommon");
		rarityBox.addItem("Rare");
		rarityBox.addItem("Ultra Rare");
		rarityBox.addItem("Only One");
		
		panel.add(rarityBox);
		rarityBox.setBounds(15, 330, 220, 30);
		rarityBox.setSelectedIndex(pokemon.rarityInt());
	}
	
	private void addSave() {
		saveButton = new JButton("Save & Close");
		saveButton.setBackground(Color.LIGHT_GRAY);
		saveButton.addActionListener(this);
		panel.add(saveButton);
		saveButton.setBounds(850, 500, 110, 40);
	}

	private final void setDesign() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus"
            		+ ".NimbusLookAndFeel");
        } catch(Exception e) {
        }
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == saveButton) dispose();
	}
}
