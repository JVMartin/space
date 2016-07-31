package com.junkgrave.space.main;

import java.awt.*;

public abstract class Entity {
	protected double x;
	protected double y;

	protected double velX;
	protected double velY;

	protected double accX;
	protected double accY;

	public abstract void tick();
	public abstract void render(Graphics g);

}
