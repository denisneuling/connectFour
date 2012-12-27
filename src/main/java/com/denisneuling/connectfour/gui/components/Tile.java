package com.denisneuling.connectfour.gui.components;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.denisneuling.connectfour.common.Player;

/**
 * <p>Tile class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class Tile extends JPanel{
	private static final long serialVersionUID = -7889536270698819018L;

	private int row;
	private int column;
	
	private Player player;
	
	/**
	 * <p>Constructor for Tile.</p>
	 *
	 * @param x a int.
	 * @param y a int.
	 * @param tileHeight a int.
	 * @param tileWeight a int.
	 */
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

	/**
	 * <p>Getter for the field <code>row</code>.</p>
	 *
	 * @return a int.
	 */
	public int getRow() {
		return row;
	}

	/**
	 * <p>Setter for the field <code>row</code>.</p>
	 *
	 * @param row a int.
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * <p>Getter for the field <code>column</code>.</p>
	 *
	 * @return a int.
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * <p>Setter for the field <code>column</code>.</p>
	 *
	 * @param column a int.
	 */
	public void setColumn(int column) {
		this.column = column;
	}

	/**
	 * <p>Getter for the field <code>player</code>.</p>
	 *
	 * @return a {@link com.denisneuling.connectfour.common.Player} object.
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * <p>Setter for the field <code>player</code>.</p>
	 *
	 * @param player a {@link com.denisneuling.connectfour.common.Player} object.
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "Tile [row=" + row + ", column=" + column + "]";
	}
}
