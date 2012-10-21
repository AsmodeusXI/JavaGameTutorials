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
	public static int moveRate = 5;
	public static int ballRadius = 20;
	
	int x, y;
	private Image dbImage;
	private Graphics dbg;
	
	public class AL extends KeyAdapter {
		
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			
			if(keyCode == KeyEvent.VK_LEFT) {
				if(x <= 0) {
					x = 0;
				}
				x-=moveRate;
			}
			if(keyCode == KeyEvent.VK_RIGHT) {
				if(x >= width-ballRadius) {
					x = width-ballRadius;
				}
				x+=moveRate;
			}
			if(keyCode == KeyEvent.VK_UP) {
				if(y <= ballRadius) {
					y = ballRadius;
				}
				y-=moveRate;
			}
			if(keyCode == KeyEvent.VK_DOWN) {
				if(y >= height-ballRadius) {
					y = height-ballRadius;
				}
				y+=moveRate;
			}
			if(keyCode == KeyEvent.VK_LEFT && keyCode == KeyEvent.VK_UP) {
				if(x <= 0) {
					x = 0;
				}
				if(y <= ballRadius) {
					y = ballRadius;
				}
				x-=moveRate;
				y-=moveRate;
			}
			if(keyCode == KeyEvent.VK_LEFT && keyCode == KeyEvent.VK_DOWN) {
				if(x <= 0) {
					x = 0;
				}
				if(y >= height-ballRadius) {
					y = height-ballRadius;
				}
				x-=moveRate;
				y+=moveRate;
			}
			if(keyCode == KeyEvent.VK_RIGHT && keyCode == KeyEvent.VK_UP) {
				if(x >= width-ballRadius) {
					x = width-ballRadius;
				}
				if(y <= ballRadius) {
					y = ballRadius;
				}
				x+=moveRate;
				y-=moveRate;
			}
			if(keyCode == KeyEvent.VK_RIGHT && keyCode == KeyEvent.VK_DOWN) {
				if(x >= width-ballRadius) {
					x = width-ballRadius;
				}
				if(y >= height-ballRadius) {
					y = height-ballRadius;
				}
				x+=moveRate;
				y+=moveRate;
			}
		}
		
		public void keyReleased(KeyEvent e) {
			//int keyCode = e.getKeyCode();
		}
		
	}
	
	public JavaGame() {
		
		addKeyListener(new AL());	//adds user created key listener
		setTitle("Java Game");
		setSize(width, height);
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
		
		g.fillOval(x, y, ballRadius, ballRadius);
		
		repaint();
	}

	public static void main(String[] args) {
		JavaGame javaGame = new JavaGame();
	}
	
}
