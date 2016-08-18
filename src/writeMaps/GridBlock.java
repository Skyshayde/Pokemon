package writeMaps;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import pokemon.ImageFile;

public class GridBlock extends JButton implements MouseListener {
	private static final long serialVersionUID = 2975640342661236922L;
	private Editor editor;
	private int x, y;
	private boolean activate;
	
	public GridBlock(int x, int y, Editor editor) {
		this.editor = editor;
		this.x = x;
		this.y = y;
		setFocusable(false);
		setBorder(BorderFactory.createLineBorder(Color.gray));
		setLayout(null);
		setBackground(new Color(240, 240, 240));
		setPreferredSize(new Dimension(getWidth(), getWidth()));
		addMouseListener(this);
	}
	
	public int getBlockPosX() { return x; }
	
	public int getBlockPosY() { return y; }
	
	@Override
	public void mousePressed(MouseEvent arg0) { 
		editor.setGridRollover(true); 
		ImageFile image = editor.getCurrentImage();
		if (image != null) {
			setBorder(null);
			ImageIcon icon = image.scaleNewImage(getWidth(), getHeight());
			setIcon(icon);
		}
	}
	@Override
	public void mouseReleased(MouseEvent arg0) { editor.setGridRollover(false); }
	@Override
	public void mouseClicked(MouseEvent arg0) {}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		if (editor.gridRollover()) activate = true;
		if (activate) {
			ImageFile image = editor.getCurrentImage();
			if (image != null) {
				setBorder(null);
				ImageIcon icon = image.scaleNewImage(getWidth(), getHeight());
				setIcon(icon);
			}
		}
	}
	@Override
	public void mouseExited(MouseEvent arg0) { activate = false; }
}
