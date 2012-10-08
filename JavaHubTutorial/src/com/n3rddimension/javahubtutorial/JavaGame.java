package com.n3rddimension.javahubtutorial;

import javax.swing.JFrame;

public class JavaGame extends JFrame {
	
	private static final long serialVersionUID = 8519431537734601751L;
	
	public JavaGame() {
		setTitle("Java Game");
		setSize(500, 500);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		JavaGame javaGame = new JavaGame();
	}
	
}
