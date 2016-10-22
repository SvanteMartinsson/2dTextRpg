package com.shooter.core;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends JFrame{
	
	public Window(int WIDTH, int HEIGHT, String title, Main game){
		JFrame window = new JFrame();
		window.setTitle(title);
		window.setSize(new Dimension(WIDTH, HEIGHT));
		window.setFocusable(true);
		window.setResizable(false);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.add(game);
		window.setVisible(true);
	}
	
}
