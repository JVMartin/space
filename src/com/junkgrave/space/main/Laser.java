package com.junkgrave.space.main;

import java.awt.*;

public class Laser extends Entity {

	public Laser(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void tick() {
		--y;
	}

	public void render(Graphics g) {
		g.setColor(new Color(0xDC791B));
		g.drawRect((int) x, (int) y, 1, 4);
	}
}
