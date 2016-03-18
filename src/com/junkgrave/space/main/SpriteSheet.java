package com.junkgrave.space.main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpriteSheet {
	private BufferedImage image;

	public SpriteSheet(String path) {
		try {
			image = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BufferedImage grabImage(int x, int y, int width, int height) {
		return image.getSubimage(x, y, width, height);
	}
}
