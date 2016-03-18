package com.junkgrave.space.main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player {
	private double x;
	private double y;
	private double accX;
	private double velX;
	private double velXMax;

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
		if (Keys.left) {
			velX -= accX;
			if (velX <  -velXMax) {
				velX = -velXMax;
			}
		}
		else if (Keys.right) {
			velX += accX;
			if (velX > velXMax) {
				velX = velXMax;
			}
		}
		else {
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
		}
		x += velX;
	}

	public void render(Graphics g) {
		if (Keys.left) {
			g.drawImage(left, (int) x, (int) y, null);
		}
		else if (Keys.right) {
			g.drawImage(right, (int) x, (int) y, null);
		}
		else {
			g.drawImage(straight, (int) x, (int) y, null);
		}
	}
}
