package com.junkgrave.space.main;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable {
	public static final int width     = 800;
	public static final int height    = 800;
	public static final String title  = "Space Time 2000";

	private boolean running = false;
	private Thread thread;

	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	public SpriteSheet sheet;

	private Player player;

	public Game() {
		setPreferredSize(new Dimension(width, height));
		setMinimumSize(new Dimension(width, height));
		setMaximumSize(new Dimension(width, height));
		sheet  = new SpriteSheet("/sheet.png");
		player = new Player(this);
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
		long nextTick, secondTimer;
		nextTick = secondTimer = System.nanoTime();

		// Desired ticks per second.
		final long desiredTPS = 60;

		// Number of nanoseconds that need to pass between each tick.
		final long perTick = 1000000000 / desiredTPS;

		// Actual frames per second.
		int fps = 0;

		// Actual ticks per second.
		int tps = 0;

		while (running) {
			long now = System.nanoTime();

			// The body of this if-block is executed at most 60 times per second.
			if (now - nextTick >= 0) {
				do {
					nextTick += perTick;
					tick();
					++tps;
				} while (now - nextTick >= 0);
			}

			render();
			++fps;

			// The body of this if-block is executed once per second.
			if (now - secondTimer > 1000000000) {
				System.out.println("FPS: " + fps + " TPS: " + tps);
				fps = tps = 0;
				secondTimer = now;
			}
		}
		stop();
	}

	private void tick() {
		player.tick();
	}

	private void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		player.render(g);
		g.dispose();
		bs.show();
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
