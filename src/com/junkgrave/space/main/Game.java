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
		while (running) {
			System.out.println("Hello!");
		}
		stop();
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
