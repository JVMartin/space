package com.junkgrave.space.main;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Player extends Entity {

	private double velXMax;
	private int keyX;

	private BufferedImage straight;
	private BufferedImage left;
	private BufferedImage right;

	public Player(SpriteSheet sheet) {
		straight = sheet.grabImage(39, 0, 39, 37);
		left     = sheet.grabImage(0, 0, 29, 37);
		right    = sheet.grabImage(86, 0, 29, 37);
		x        = 100;
		y        = 700;
		accX     = 0.1;
		velX     = 0;
		velXMax  = 4;
	}

	public void tick() {
		// Find out which arrow key was hit most recently, left or right?
		int leftKey  = Keys.indexOf(KeyEvent.VK_LEFT);
		int rightKey = Keys.indexOf(KeyEvent.VK_RIGHT);

		if (leftKey > rightKey) {
			keyX = KeyEvent.VK_LEFT;
		}
		else if (leftKey < rightKey) {
			keyX = KeyEvent.VK_RIGHT;
		}
		else {
			keyX = -1;
		}

		switch(keyX) {
			case KeyEvent.VK_LEFT:
				velX -= accX;
				if (velX <  -velXMax) {
					velX = -velXMax;
				}
				break;
			case KeyEvent.VK_RIGHT:
				velX += accX;
				if (velX > velXMax) {
					velX = velXMax;
				}
				break;
			case -1:
				// Decelerate towards 0.
				if (velX > 0) {
					velX -= accX * 2;
					if (velX < 0) {
						velX = 0;
					}
				}
				else if (velX < 0) {
					velX += accX * 2;
					if (velX > 0) {
						velX = 0;
					}
				}
				break;
		}

		x += velX;
		shoot();
	}

	public void render(Graphics g) {
		switch(keyX) {
			case KeyEvent.VK_LEFT:
				g.drawImage(left, (int) x, (int) y, null);
				break;
			case KeyEvent.VK_RIGHT:
				g.drawImage(right, (int) x, (int) y, null);
				break;
			case -1:
				g.drawImage(straight, (int) x, (int) y, null);
				break;
		}
	}

	public void shoot() {
		if (Keys.indexOf(KeyEvent.VK_SPACE) == -1) return;

		Game.entityManager.addEntity(new Laser(x + 8, y + 9));
		Game.entityManager.addEntity(new Laser(x + 29, y + 9));
	}

}
