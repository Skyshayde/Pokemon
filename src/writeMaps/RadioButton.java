package writeMaps;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JRadioButton;

import pokemon.Blocks;
import pokemon.ImageFile;

public class RadioButton extends JRadioButton implements ActionListener {
	private static final long serialVersionUID = 6310508175185532093L;
	private ImageMap imgMap;
	private Blocks block;
	private Editor editor;
	private int id;
	private boolean selected;
	private ImageFile[] images;

	public RadioButton(String text) {
		super(text);
		imgMap = new ImageMap();
		setIcon(new ColorIcon());
		addActionListener(this);
	}
	
	public void setID(int code) {
		id = code;
		switch (code) {
			case 0: block = Blocks.STANDARD; break;
			case 1: block = Blocks.TALLGRASS; break;
			case 2: block = Blocks.CAVE; break;
			case 3: block = Blocks.DESERT; break;
			case 5: block = Blocks.RIDGE; break;
			case 8: block = Blocks.WATER; break;
			case 9: block = Blocks.POND; break;
			case 10: block = Blocks.PUDDLE; break;
			case 11: block = Blocks.WATERFALL; break;
			case 12: block = Blocks.BERRYSOIL; break;
			case 13: block = Blocks.DOOR; break;
			case 14: block = Blocks.FLOWER; break;
			case 15: block = Blocks.POKEBALL; break;
			case 16: block = Blocks.SIGNBARRIER; break;
			case 17: block = Blocks.SIGN; break;
			case 18: block = Blocks.CUT_TREE; break;
			case 19: block = Blocks.ROCKSMASH_ROCK; break;
			case 20: block = Blocks.STRENGTH_BOULDER; break;
			case 21: block = Blocks.PERSON; break;
			case 22: block = Blocks.PLAYER; break;
			default: block = Blocks.BARRIER; break;
		}
	}
	
	public Blocks getBlock() { return block; }
	
	public void selected(boolean selected) {
		this.selected = selected;
		setIcon(new ColorIcon());
	}
	
	@Override
	public void setSelected(boolean selected) { setIcon(new ColorIcon()); }
	
	public boolean isOn() { return selected; }

	public void setWindowAccess(Editor editor) { this.editor = editor; }

	public void setImages(int code) {
		switch (code) {
			case 0: 
				for (int i = 0; i < 9; i++) images[i] = imgMap.getImages()[i];
				break;
			case 1: 
				
				break;
			case 2: 
				
				break;
			case 3: 
				
				break;
			case 4: 
				
				break;
			case 5: 
				
				break;
			case 6: 
				
				break;
			case 7: 
				
				break;
			case 8: 
				
				break;
			case 9: 
				
				break;
			case 10: 
				
				break;
			case 11: 
				
				break;
			case 12: 
				
				break;
			case 13: 
				
				break;
			case 14: 
				
				break;
			case 15: 
				
				break;
			case 16: 
				
				break;
			case 17: 
				
				break;
			case 18: 
				
				break;
			case 19: 
				
				break;
			case 20: 
				
				break;
			case 21: 
				
				break;
			case 22: 
				
				break;				
		}
		for (int i = 0; i < images.length; i++) {
			images[i].scale(40, 40);
		}
	}
	
	public ImageFile getImage(int i) { 
		if (i < images.length) return images[i]; 
		return null;
	}
	
	public int getNumImages() { return images.length; }

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!selected) {
			editor.unSelectButtons();
			selected = true;
			setIcon(new ColorIcon());
			editor.setSelectedItem(id);
			setImages(id);
			editor.updateImages();
		}
	}
	
	private class ColorIcon implements Icon {
        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
        	Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	        if (selected) {
	            g2.setColor(new Color(255, 140, 30));
	            g2.fillOval(x, y, 10, 10);
	        }
	        else {
	            g2.setColor(new Color(130, 200, 255));
	            g2.fillOval(x, y, 10, 10);
	        }
        }

        @Override
        public int getIconWidth() { return 10; }

        @Override
        public int getIconHeight() { return 10; }
    }
}
