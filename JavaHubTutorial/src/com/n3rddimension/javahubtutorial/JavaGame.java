package com.n3rddimension.javahubtutorial;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class JavaGame extends JFrame {
	
	private static final long serialVersionUID = 8519431537734601751L;
	
	public static int width = 500;
	public static int height = width / 16 * 9;
	public static int scale = 3;
	
	int x, y;
	private Image dbImage;
	private Graphics dbg;
	
	public class AL extends KeyAdapter {
		
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			
			if(keyCode == KeyEvent.VK_LEFT) {
				x-=10;
			}
			if(keyCode == KeyEvent.VK_RIGHT) {
				x+=10;
			}
			if(keyCode == KeyEvent.VK_UP) {
				y-=10;
			}
			if(keyCode == KeyEvent.VK_DOWN) {
				y+=10;
			}
			if(keyCode == KeyEvent.VK_LEFT && keyCode == KeyEvent.VK_UP) {
				x-=10;
				y-=10;
			}
			if(keyCode == KeyEvent.VK_LEFT && keyCode == KeyEvent.VK_DOWN) {
				x-=10;
				y+=10;
			}
			if(keyCode == KeyEvent.VK_RIGHT && keyCode == KeyEvent.VK_UP) {
				x+=10;
				y-=10;
			}
			if(keyCode == KeyEvent.VK_RIGHT && keyCode == KeyEvent.VK_DOWN) {
				x+=10;
				y+=10;
			}
		}
		
		public void keyReleased(KeyEvent e) {
			//int keyCode = e.getKeyCode();
		}
		
	}
	
	public JavaGame() {
		
		addKeyListener(new AL());	//adds user created key listener
		setTitle("Java Game");
		setSize(width * scale, height * scale);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		x = 150;
		y = 150;
		
	}
	
	public void paint(Graphics g) {
		dbImage = createImage(getWidth(), getHeight());
		dbg = dbImage.getGraphics();
		paintComponent(dbg);
		g.drawImage(dbImage, 0, 0, this);
	}
	
	public void paintComponent(Graphics g) {
		
		g.fillOval(x, y, 15, 15);
		
		repaint();
	}

	public static void main(String[] args) {
		JavaGame javaGame = new JavaGame();
	}
	
}
