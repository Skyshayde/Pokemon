package pokemon;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageFile {
	private static BufferedImage image;
	private static String location;
	
	public ImageFile(String location) { //TODO static ??
		ImageFile.location = location;
	}

    public static void image() {  
        try {
            image = ImageIO.read(new File(location));
        } catch (IOException e) { e.printStackTrace(); }
    }
    
    protected void paintComponent(Graphics g) {
        scale(image);
        g.drawImage(image, 0, 0, null);
        
    }
    
    public void scale(Image g) { //TODO
        int x = 0;
        int y = 0;
        g.getScaledInstance(x, y, Image.SCALE_SMOOTH);
    }
}
