package com.junkgrave.space.main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpriteSheet {
	private final int width  = 32;
	private final int height = 32;

	private BufferedImage image;

	public SpriteSheet(String path) {
		try {
			image = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BufferedImage grabImage(int x, int y) {
		return image.getSubimage(width * x, height * y, width, height);
	}
}
