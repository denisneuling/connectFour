package com.denisneuling.connectfour.service;

import java.awt.Color;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.denisneuling.connectfour.common.Player;
import com.denisneuling.connectfour.gui.components.MessagePane;

@Service
public class PlayerService {

	private volatile Player player1 = new Player("Player 1", Color.BLUE);
	private volatile Player player2 = new Player("Player 2", Color.RED);

	private volatile Player currentPlayer;
	
	@Autowired
	private MessagePane messagePane;
	
	/**
	 * <p>Getter for the field <code>currentPlayer</code>.</p>
	 *
	 * @return a {@link com.denisneuling.connectfour.common.Player} object.
	 */
	public Player getCurrentPlayer(){
		if(currentPlayer==null){
			currentPlayer = getNextPlayer();
		}
		return currentPlayer;
	}

	/**
	 * <p>nextPlayer.</p>
	 */
	public Player getNextPlayer() {
		if(currentPlayer == null){
			return player1;
		}else if(player1.equals(currentPlayer)){
			return player2;
		}else if(player2.equals(currentPlayer)){
			return player1;
		}else{
			throw new RuntimeException("Next player could not been retrieved.");
		}
	}

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public void setCurrentPlayer(Player player) {
		this.currentPlayer = player;
	}
}
