package com.denisneuling.connectfour.common;

import java.awt.Color;
import java.util.UUID;

/**
 * <p>Player class.</p>
 *
 * @author ska
 * @version $Id: $Id
 */
public class Player {

	private UUID uuid = UUID.randomUUID();
	private String name;
	private Color color;
	
	/**
	 * <p>Constructor for Player.</p>
	 *
	 * @param name a {@link java.lang.String} object.
	 * @param color a {@link java.awt.Color} object.
	 */
	public Player(String name, Color color){
		this.name = name;
		this.color = color;
	}
	
	/**
	 * <p>Getter for the field <code>name</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getName() {
		return name;
	}
	/**
	 * <p>Setter for the field <code>name</code>.</p>
	 *
	 * @param name a {@link java.lang.String} object.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * <p>Getter for the field <code>color</code>.</p>
	 *
	 * @return a {@link java.awt.Color} object.
	 */
	public Color getColor() {
		return color;
	}
	/**
	 * <p>Setter for the field <code>color</code>.</p>
	 *
	 * @param color a {@link java.awt.Color} object.
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "Player [name=" + name + ", color=" + color + "]";
	}
	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
		return result;
	}
	/** {@inheritDoc} */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		return true;
	}
}
