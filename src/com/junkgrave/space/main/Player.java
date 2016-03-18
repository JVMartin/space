package com.junkgrave.space.main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player {
	private int x;
	private int y;
	private int velX;

	private BufferedImage straight;
	private BufferedImage left;
	private BufferedImage right;

	public Player(SpriteSheet sheet) {
		straight = sheet.grabImage(39, 0, 39, 37);
		left     = sheet.grabImage(0, 0, 29, 37);
		right    = sheet.grabImage(86, 0, 29, 37);

		x = 100;
		y = 700;
		velX = 0;
	}

	public void tick() {
		if (velX < 0 && x <= 0) {
			x = 0;
		} else if (velX > 0 && x >= Game.width - 32) {
			x = Game.width - 32;
		} else {
			x += velX;
		}
	}

	public void goLeft() {
		velX = -5;
	}

	public void goRight() {
		velX = 5;
	}

	public void stop() {
		velX = 0;
	}

	public void render(Graphics g) {
		if (velX == 0) {
			g.drawImage(straight, x, y, null);
		}
		else if (velX < 0) {
			g.drawImage(left, x, y, null);
		}
		else {
			g.drawImage(right, x, y, null);
		}
	}
}
