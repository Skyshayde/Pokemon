package writeMaps;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class ScrollPane extends JScrollPane {
	private static final long serialVersionUID = 5025117313090066472L;

	public ScrollPane(JComponent component) {
		super(component);
		setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		setBorder(BorderFactory.createLineBorder(Color.black, 2));
		getVerticalScrollBar().setUI(new BasicScrollBarUI() {   
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
	}
}
