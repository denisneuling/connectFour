package com.denisneuling.connectfour.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.denisneuling.connectfour.common.Player;
import com.denisneuling.connectfour.gui.components.MessagePane;
import com.denisneuling.connectfour.gui.components.Tile;
import com.denisneuling.connectfour.gui.components.listener.TileActionListener;
import com.denisneuling.connectfour.gui.dialog.WinDialog;

@Service
/**
 * <p>GridService class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class GridService {
	protected Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private PlayerService playerService;
	
	@Autowired
	private MessagePane messagePane;
	
	@Autowired
	private WinDialog winDialog;
	
	@Autowired
	private TileActionListener tileActionListener;

	private volatile Tile[][] matrix;
	private volatile int tiles;
	private volatile int clickCount = 0;

	/**
	 * <p>build.</p>
	 *
	 * @param x a int.
	 * @param y a int.
	 */
	public void build(int x, int y) {
		matrix = new Tile[x][y];
		clickCount = 0;
		tiles = x*y;
	}

	/**
	 * <p>register.</p>
	 *
	 * @param tile a {@link com.denisneuling.connectfour.gui.components.Tile} object.
	 */
	public void register(Tile tile) {
		if (tile != null) {
			log.debug("Registering tile "+tile);
			
			matrix[tile.getRow()][tile.getColumn()] = tile;
		}
	}

	/**
	 * <p>clicked.</p>
	 *
	 * @param tile a {@link com.denisneuling.connectfour.gui.components.Tile} object.
	 */
	public void clicked(Tile tile) {
		log.debug(tile);
		
		boolean valid = false;

		for (int i = 0; i < matrix[tile.getRow()].length; i++) {
			if (matrix[tile.getRow()][i].getPlayer() == null) {
				Player player = playerService.getCurrentPlayer();
				log.debug("Using row{"+tile.getRow() + "} -> {" + matrix[tile.getRow()][i] + "}, player {" + player + "}");
				matrix[tile.getRow()][i].setPlayer(player);
				matrix[tile.getRow()][i].setBackground(player.getColor());
				valid = true;
				break;
			}
		}
		if (valid) {
			clickCount ++;

			Player winner = check4();
			if (winner == null) {
				
				if(clickCount >= tiles){
					winDialog.relocate();
					winDialog.notifyWinner(null);
				}else{
					Player player = playerService.getNextPlayer();
					playerService.setCurrentPlayer(player);
					messagePane.setYourTurn(player);
				}
			} else {
				messagePane.clean();
				tileActionListener.disable();
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
		
		// diagonal right to left
		for(int y = 0; y < matrix.length; y++){
			for(int x = 0; x < matrix[y].length; x++){
				if(		
						x-1 >= 0 && x-2 >= 0 && x-3 >= 0 
					&& 	y+1 < matrix.length && y+2 < matrix.length && y+3 < matrix.length
				){
					Player player = matrix[y][x].getPlayer(); 
					if(
							player != null
							&&	player.equals(matrix[y+1][x-1].getPlayer()) 
							&& 	player.equals(matrix[y+2][x-2].getPlayer())
							&& 	player.equals(matrix[y+3][x-3].getPlayer())
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
