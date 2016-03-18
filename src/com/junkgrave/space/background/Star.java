package com.junkgrave.space.background;

import com.junkgrave.space.main.Game;
import com.junkgrave.space.main.ToolBelt;

import java.awt.*;

public class Star {
	private int x;
	private double y;
	private double velY;
	private int size;
	private Color color;

	public Star() {
		init();
	}

	public void tick() {
		if (y > Game.height) {
			reset();
		}
		else {
			y += velY;
		}
	}

	public void render(Graphics g) {
		g.setColor(color);
		g.fillRect(x, (int) y, size, size);
	}

	private void shared() {
		color = Color.white;
		size = ToolBelt.randomBetween(1, 3);
		velY = size * ToolBelt.rand.nextFloat();
		velY += ToolBelt.rand.nextFloat() * ToolBelt.randomBetween(0, 2);
		x = ToolBelt.randomBetween(0, Game.width);
	}

	private void init() {
		shared();
		y = ToolBelt.randomBetween(0, Game.height);
	}

	private void reset() {
		shared();
		y = -1 * size;
	}
}
