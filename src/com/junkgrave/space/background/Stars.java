package com.junkgrave.space.background;

import java.awt.*;

public class Stars {
	private int numberOfStars;

	private Star[] stars;

	public Stars(int numberOfStars) {
		this.numberOfStars = numberOfStars;
		stars = new Star[numberOfStars];
		for (int i = 0; i < stars.length; ++i) {
			stars[i] = new Star();
		}
	}

	public void tick() {
		for (int i = 0; i < stars.length; ++i) {
			stars[i].tick();
		}
	}

	public void render(Graphics g) {
		for (int i = 0; i < stars.length; ++i) {
			stars[i].render(g);
		}
	}
}
