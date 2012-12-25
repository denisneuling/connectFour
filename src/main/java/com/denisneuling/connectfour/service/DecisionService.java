package com.denisneuling.connectfour.service;

import java.awt.Color;

import org.springframework.stereotype.Service;

import com.denisneuling.connectfour.common.Player;

@Service
public class DecisionService {

	private volatile Player a = new Player("Player 1", Color.BLUE);
	private volatile Player b = new Player("Player 2", Color.RED);

	private volatile Player currentPlayer;
	
	public Player getCurrentPlayer(){
		if(currentPlayer==null){
			nextPlayer();
		}
		return currentPlayer;
	}

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
