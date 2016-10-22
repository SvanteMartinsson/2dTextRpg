package com.game.core;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Window(int WIDTH, int HEIGHT, String title, Main game){
		JFrame window = new JFrame();
		window.setTitle(title);
		window.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		window.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		window.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.add(game);
		window.setVisible(true);
		
		game.start();
	}
	
}
