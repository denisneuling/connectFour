package com.denisneuling.connectfour.gui.components.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.denisneuling.connectfour.gui.components.Tile;
import com.denisneuling.connectfour.service.GridService;

@Component
public class TileActionListener implements MouseListener{
	Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private GridService gridService;
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		log.debug("Mouse clicked");
		log.debug(arg0.getSource().toString());
		
		Object source = arg0.getSource();
		if(Tile.class.equals(source.getClass())){
			gridService.clicked((Tile)source);
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		log.debug("Mouse entered");
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		log.debug("Mouse exited");
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		log.debug("Mouse pressed");
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		log.debug("Mouse released");
	}

}
