package pokemon;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.swing.ImageIcon;

public class ImageFile extends ImageIcon {
	private static final long serialVersionUID = 7274151760373065989L;
	
	public ImageFile(URL url) {
		super(url);
		scale(0);
	}
	
	public ImageFile(URL url, int scale) {
		super(url);
		scale(scale);
	}
	
	public void scale(int scale) {
		setImage(scaleImage(getImage(), getIconWidth()*2+scale, getIconHeight()*2+scale));
	}
	
	private Image scaleImage(Image srcImg, int w, int h) {
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = resizedImg.createGraphics();

	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();

	    return resizedImg;
	}
	
	/*
	private BufferedImage image;
	private String location;
	
	public ImageFile(String location) {
		this.location = location;
	}

    public void image() {  
        try {
            image = ImageIO.read(new File(location));
        } catch (IOException e) { e.printStackTrace(); }
    }
    
    protected void paintComponent(Graphics g) {
        scale();
        g.drawImage(image, 0, 0, null);
        
    }
    
    public void scale() {
    	int w = image.getWidth();
    	int h = image.getHeight();
    	BufferedImage scaledImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
    	AffineTransform at = new AffineTransform();
    	at.scale(2.0, 2.0);
    	AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
    	image = scaleOp.filter(image, scaledImage);
    }*/
}
