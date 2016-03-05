package com.junkgrave.space.main;

import javax.swing.*;
import java.awt.*;

public class Game extends Canvas implements Runnable {
	public static final int width     = 800;
	public static final int height    = 800;
	public static final String title  = "Space Time 2000";

	private boolean running = false;
	private Thread thread;

	public Game() {
		setPreferredSize(new Dimension(width, height));
		setMinimumSize(new Dimension(width, height));
		setMaximumSize(new Dimension(width, height));
	}

	private synchronized void start() {
		if (running) return;

		running = true;
		thread  = new Thread(this);
		thread.start();
	}

	private synchronized void stop() {
		if ( ! running) return;

		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(1);
	}

	public void run() {
		long timer = System.currentTimeMillis();
		long lastTime = System.nanoTime();

		// Desired ticks per second.
		final long desiredTPS = 60;

		// Number of nanoseconds that need to pass between each tick.
		long perTick = 1000000000 / desiredTPS;

		// How many nanoseconds have passed since the last tick.
		long sinceTick = 0;

		// Actual ticks per second.
		int tps = 0;

		// Actual frames per second.
		int fps = 0;

		while (running) {
			long now = System.nanoTime();
			sinceTick += now - lastTime;
			lastTime = now;

			// The body of this if-block is executed at most 60 times per second.
			if (sinceTick > perTick) {
				tick();
				++tps;
				sinceTick = 0;
			}
			
			render();
			++fps;

			// The body of this if-block is executed once per second.
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + fps + " UPDATES: " + tps);
				tps = fps = 0;
			}
		}
		stop();
	}

	private void tick() {

	}

	private void render() {

	}

	public static void main(String [] args) {
		Game game = new Game();

		JFrame frame = new JFrame(title);
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		game.start();
	}
}
