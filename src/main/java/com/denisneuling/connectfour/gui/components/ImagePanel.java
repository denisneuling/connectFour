package com.denisneuling.connectfour.gui.components;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

/**
 * <p>ImagePanel class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class ImagePanel extends JPanel {
	private static final long serialVersionUID = 3104257036081096846L;

	private BufferedImage image;

	/**
	 * <p>Constructor for ImagePanel.</p>
	 */
	public ImagePanel() {
	}

	/**
	 * <p>Constructor for ImagePanel.</p>
	 *
	 * @param bufferedImage a {@link java.awt.image.BufferedImage} object.
	 */
	public ImagePanel(BufferedImage bufferedImage) {
		this.image = bufferedImage;
	}

	/**
	 * <p>Getter for the field <code>image</code>.</p>
	 *
	 * @return a {@link java.awt.image.BufferedImage} object.
	 */
	public BufferedImage getImage() {
		return image;
	}

	/**
	 * <p>Setter for the field <code>image</code>.</p>
	 *
	 * @param image a {@link java.awt.image.BufferedImage} object.
	 */
	public void setImage(BufferedImage image) {
		this.image = image;
		this.repaint();
	}

	/**
	 * <p>update.</p>
	 */
	public void update() {
		this.updateUI();
	}

//	@Override
//	protected void paintComponent(Graphics g) {
//		super.paintComponent(g);
//
//		if (image != null) {
//			g.drawImage(image, 0, 0, null);
//		}
//	}
//	
	/** {@inheritDoc} */
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
            if (image != null) {
            // Scale it by width
            int scaledWidth = (int)((image.getWidth() * getHeight()/image.getHeight()));
            // If the image is not off the screen horizontally...
            if (scaledWidth < getWidth()) {
                // Center the left and right destination x coordinates.
                int leftOffset = getWidth() / 2 - scaledWidth / 2;
                int rightOffset = getWidth() / 2 + scaledWidth / 2;
                g.drawImage(image, leftOffset, 0, rightOffset, getHeight(), 0, 0, image.getWidth(), image.getHeight(), null);
            }
            // Otherwise, the image width is too much, even scaled
            // So we need to center it the other direction
            else {
                int scaledHeight = (image.getHeight() * getWidth()) / image.getWidth();
                int topOffset = getHeight() / 2 - scaledHeight / 2;
                int bottomOffset = getHeight() / 2 + scaledHeight / 2;
                g.drawImage(image, 0, topOffset, getWidth(), bottomOffset, 0, 0, image.getWidth(), image.getHeight(), null);
            }
        }
    }
}
