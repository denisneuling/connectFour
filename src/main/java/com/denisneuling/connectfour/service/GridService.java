package com.denisneuling.connectfour.service;

import java.awt.Color;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sun.net.www.content.text.plain;

import com.denisneuling.connectfour.common.Player;
import com.denisneuling.connectfour.gui.components.Tile;
import com.denisneuling.connectfour.gui.components.WinDialog;

@Service
public class GridService {
	protected Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private DecisionService decisionService;
	
	@Autowired
	private WinDialog winDialog;

	private volatile Tile[][] matrix;

	public void clean() {

	}

	public void build(int x, int y) {
		matrix = new Tile[x][y];
	}

	public void register(Tile tile) {
		if (tile != null) {
			log.debug("Registering tile "+tile);
			
			matrix[tile.getRow()][tile.getColumn()] = tile;
		}

	}

	public void clicked(Tile tile) {
		log.info(tile);
		boolean valid = false;

		for (int i = 0; i < matrix[tile.getRow()].length; i++) {
			if (matrix[tile.getRow()][i].getPlayer() == null) {
				log.info(tile.getRow() + " " + matrix[tile.getRow()][i] + " " + matrix[tile.getRow()][i].getPlayer());
				Player player = decisionService.getCurrentPlayer();
				matrix[tile.getRow()][i].setPlayer(player);
				matrix[tile.getRow()][i].setBackground(player.getColor());
				valid = true;
				break;
			}
		}
		if (valid) {
			Player winner = check4();
			if (winner == null) {
				decisionService.nextPlayer();
			} else {
				winDialog.notifyWinner(winner);
			}
		}
	}

	private Player check4() {
		// horizontal
		for(int y = 0; y < matrix.length; y++){
			for(int x = 0; x < matrix[y].length; x++){
				if(y+1 < matrix.length && y+2 < matrix.length && y+3 < matrix.length){
					Player player = matrix[y][x].getPlayer(); 
					if(
							player != null
						&&	player.equals(matrix[y+1][x].getPlayer()) 
						&& 	player.equals(matrix[y+2][x].getPlayer())
						&& 	player.equals(matrix[y+3][x].getPlayer())
					){
						return player;
					}
				}
			}	
		}
				
		// vertical
		for(int y = 0; y < matrix.length; y++){
			for(int x = 0; x < matrix[y].length; x++){
				if(x+1 < matrix[y].length && x+2 < matrix[y].length && x+3 < matrix[y].length){
					Player player = matrix[y][x].getPlayer(); 
					if(
							player != null
						&&	player.equals(matrix[y][x+1].getPlayer()) 
						&& 	player.equals(matrix[y][x+2].getPlayer())
						&& 	player.equals(matrix[y][x+3].getPlayer())
					){
						return player;
					}
				}
			}	
		}
		
		// TODO still buggy
		// diagonal right to left
		for(int y = 0; y < matrix.length; y++){
			for(int x = 0; x < matrix[y].length; x++){
				if(		
						x+1 < matrix[y].length && x+2 < matrix[y].length && x+3 < matrix[y].length 
					&& 	y+1 < matrix.length && y+2 < matrix.length && y+3 < matrix.length
				){
					Player player = matrix[y][x].getPlayer(); 
					if(
							player != null
							&&	player.equals(matrix[y+1][x+1].getPlayer()) 
							&& 	player.equals(matrix[y+2][x+2].getPlayer())
							&& 	player.equals(matrix[y+3][x+3].getPlayer())
							){
						return player;
					}
					
				}
			}	
		}
		
		// diagonal left to right
		for(int y = 0; y < matrix.length; y++){
			for(int x = 0; x < matrix[y].length; x++){
				if(		
						x-1 >= 0 && x-2 >= 0 && x-3 >= 0 
					&& 	y-1 >= 0 && y-2 >= 0 && y-3 >= 0
				){
					Player player = matrix[y][x].getPlayer(); 
					if(
							player != null
							&&	player.equals(matrix[y-1][x-1].getPlayer()) 
							&& 	player.equals(matrix[y-2][x-2].getPlayer())
							&& 	player.equals(matrix[y-3][x-3].getPlayer())
							){
						return player;
					}
					
				}
			}	
		}
		
		return null;
	}
}
