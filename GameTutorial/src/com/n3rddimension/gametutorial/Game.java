package com.n3rddimension.gametutorial;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.n3rddimension.gametutorial.graphics.Screen;

public class Game extends Canvas implements Runnable {

		private static final long serialVersionUID = -5455813289201929748L;
		
		// resolution of screen vars
		public static int width = 300;
		public static int height = width / 16 * 9;
		public static int scale = 3;
		
		// new thread to handle the game itself, outside of the MAIN class
		private Thread gameThread;
		private JFrame frame;
		
		// bool to determine status of game loop
		private boolean running = false;
		
		private Screen screen;
		
		private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
		
		public Game() {
			Dimension size = new Dimension(width * scale, height * scale);
			setPreferredSize(size);
			
			screen = new Screen(width, height);
			frame = new JFrame();
		}
		
		// sync to prevent memory/inconsistency errors; starting game itself
		// thread now contains Game class, because it's Runnable
		public synchronized void start() {
			running = true;
			gameThread = new Thread(this, "Game");
			gameThread.start();		// thread call starts runnable.run
		}
		
		public synchronized void stop() {
			running = false;
			try {
				gameThread.join();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		// contains game loop
		public void run() {
			while(running) {
				update(); 	// updates timeboxed (so all processors the same)
				
				render();	// render as fast as possible
			}
		}
		
		public void update() {
			
		}
		
		public void render() {
			BufferStrategy bs = getBufferStrategy();
			if(bs == null) {
				createBufferStrategy(3); // always have this at 3 -> Triple Buffering
				return;
			}
			
			Graphics g = bs.getDrawGraphics();
			// this is the beginning of graphics happening
			
			g.setColor(new Color(80, 40, 100));	// shapes after this will have its color
			g.fillRect(0, 0, getWidth(), getHeight());	// getWidth/Height ensure you get screen dimensions
			
			// this is the end of graphics happening
			g.dispose(); // disposes of current graphics/releases system resources
			bs.show(); // makes next avail buffer visible
		}
		
		public static void main(String[] args) {
			Game game = new Game();
			
			frameInit(game, "Cherno Tutorial");
			
			game.start();
		}
		
		private static void frameInit(Game newGame, String title) {
			
			newGame.frame.setResizable(false);			// should be the first call on frame
			newGame.frame.setTitle(title);
			newGame.frame.add(newGame);					// adds 'Game' Canvas Component to the JFrame
			newGame.frame.pack();						// packs the fame to preferredSize of embedded component
			newGame.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // deletes process on 'close' button click
			newGame.frame.setLocationRelativeTo(null);	// null centers
			newGame.frame.setVisible(true);				// NEED TO SHOW THE FRAME
			
		}
	
}
