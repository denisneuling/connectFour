package com.denisneuling.connectfour.gui.components;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Tile extends JPanel{
	private static final long serialVersionUID = -7889536270698819018L;

	private int row;
	private int column;
	
	public Tile(int x , int y, int tileHeight, int tileWeight){
		this.row = x;
		this.column = y;
		
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		
		Dimension dimension = new Dimension(tileWeight, tileHeight);
		this.setSize(dimension);
		this.setPreferredSize(dimension);
		this.setMinimumSize(dimension);
		this.setMaximumSize(dimension);
		this.setVisible(true);
	}

	@Override
	public String toString() {
		return "Tile [row=" + row + ", column=" + column + "]";
	}
}
