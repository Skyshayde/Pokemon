package pokemon;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URL;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TextBox extends JPanel implements KeyListener {
	private static final long serialVersionUID = 6611054568025778753L;
	private Game game;
	private JLabel text;
	private Font font;

	public TextBox(Game game, String words) { //TODO wrap text and next features, appear letter by letter or not
		this.game = game;
		text = new JLabel(words);
		setBox();
		
		Song sound = new Song("/sounds/ping.wav");
		sound.play();
	}
	
	private void setBox() {
		setLayout(null);
		setOpaque(false);
		setBounds(0, 0, game.gameFrame.getWidth(), game.gameFrame.getHeight());		
		font();
		
		ImageFile image = new ImageFile(getClass().getResource("/windowImages/Message_Sign.png"));
		image.scale(getWidth()-40, getHeight()/4);
		JLabel box = new JLabel(image);
		box.setBounds(20, getHeight()-image.getIconHeight()-45, image.getIconWidth(), image.getIconHeight());
		
		text.setBounds(box.getX()+40, box.getY()+12, box.getWidth()-200, 40);
		text.setFont(font);
		add(text);
		add(box);
	}
	
	private void font() {
		URL fontURL = getClass().getResource("/windowImages/pkmnfl.ttf");
	    try {
			font = Font.createFont(Font.TRUETYPE_FONT, fontURL.openStream());
			font = font.deriveFont(28.0f);
		} catch (FontFormatException | IOException e) {
			// TODO send message of missing files and what to do
			e.printStackTrace();
		}
	}

	@Override
	public void keyPressed(KeyEvent ke) {
		game.gameLayer.remove(game.box);
		game.gameLayer.repaint();
		game.gameFrame.removeKeyListener(this);
		game.setMenuClosed();
		game.addListener();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
