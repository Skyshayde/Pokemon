package writeMaps;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class ImageEditor extends JFrame {
	private static final long serialVersionUID = -2109371523154225959L;

	public ImageEditor() {
		setTitle("Image Editor");
		setSize(640, 450);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
		Insets toolHeight = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());
		setLocation((scrSize.width - getWidth())/2, 
				(scrSize.height - toolHeight.bottom - getHeight())/2);
		setVisible(true);
	}
}
