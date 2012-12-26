package com.denisneuling.connectfour.service;

import java.awt.Color;

import org.springframework.stereotype.Service;

import com.denisneuling.connectfour.common.Player;

@Service
/**
 * <p>DecisionService class.</p>
 *
 * @author ska
 * @version $Id: $Id
 */
public class DecisionService {

	private volatile Player a = new Player("Player 1", Color.BLUE);
	private volatile Player b = new Player("Player 2", Color.RED);

	private volatile Player currentPlayer;
	
	/**
	 * <p>Getter for the field <code>currentPlayer</code>.</p>
	 *
	 * @return a {@link com.denisneuling.connectfour.common.Player} object.
	 */
	public Player getCurrentPlayer(){
		if(currentPlayer==null){
			nextPlayer();
		}
		return currentPlayer;
	}

	/**
	 * <p>nextPlayer.</p>
	 */
	public void nextPlayer() {
		if(currentPlayer == null){
			currentPlayer = a;
		}else if(a.equals(currentPlayer)){
			currentPlayer = b;
		}else if(b.equals(currentPlayer)){
			currentPlayer = a;
		}
	}
}
