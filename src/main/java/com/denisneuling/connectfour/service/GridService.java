package com.denisneuling.connectfour.service;

import java.awt.Color;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.denisneuling.connectfour.common.Player;
import com.denisneuling.connectfour.gui.components.Tile;

@Service
public class GridService {
	protected Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private DecisionService decisionService;
	
	private volatile Tile[][] matrix;
	public void clean(){
		
	}
	
	public void build(int x, int y){
		matrix = new Tile[x][y];
	}
	
	public void register(Tile tile){
		if(tile != null){
			log.info(tile);
			matrix[tile.getRow()][tile.getColumn()] = tile;
		}
		
	}
	
	public void clicked(Tile tile){
		log.info(tile);
		boolean valid = false;
		
		for(int i = 0 ; i < matrix[tile.getRow()].length ; i++){
			if(matrix[tile.getRow()][i].getPlayer() == null){
				log.info(tile.getRow() + " " + matrix[tile.getRow()][i] + " "+matrix[tile.getRow()][i].getPlayer());
				Player player = decisionService.getCurrentPlayer();
				matrix[tile.getRow()][i].setPlayer(player);
				matrix[tile.getRow()][i].setBackground(player.getColor());
				valid = true;
				break;
			}
		}
		if(valid){
			decisionService.nextPlayer();
		}
	}
}
