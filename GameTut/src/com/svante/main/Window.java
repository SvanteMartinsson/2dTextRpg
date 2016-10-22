package com.svante.main;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Window(int width, int height, String title, Game game){
		JFrame window = new JFrame();
		window.setTitle(title);
		window.setPreferredSize(new Dimension(width, height));
		window.setMaximumSize(new Dimension(width, height));
		window.setMinimumSize(new Dimension(width, height));
		window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.add(game);
		window.setVisible(true);
		
		game.start();
	}
	
}
