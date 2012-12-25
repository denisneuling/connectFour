package com.denisneuling.connectfour.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.denisneuling.connectfour.gui.components.Tile;

@Service
public class GridService {
	protected Logger log = Logger.getLogger(this.getClass());

	public void clean(){
		
	}
	
	public void build(int x, int y){
		
	}
	
	public void register(Tile tile){
		log.info(tile);
	}
	
	public void clicked(Tile tile){
		log.info(tile);
	}
}
