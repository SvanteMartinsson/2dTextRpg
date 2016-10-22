package com.firstengine.core;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends JFrame{
	
	/**
	 * This class creates the window
	 */
	private static final long serialVersionUID = 7010896958781686677L;

	public Window(int width, int height, String title, Main game){
		JFrame window = new JFrame();
		window.setTitle(title);
		window.setSize(new Dimension(width, height));
		window.setResizable(false);
		window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
		window.add(game);
		window.setVisible(true);
	}
	
}
