package com.denisneuling.connectfour.gui.components.listener;

import java.awt.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.denisneuling.connectfour.gui.components.GameDialog;
import com.denisneuling.connectfour.gui.components.MenuPanel;

@Component
public class GameMenuItemListener extends BaseMenuItemListener{

	@Autowired
	private GameDialog gameDialog;
	
	@Autowired
	private MenuPanel menuPanel;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		menuPanel.disableItems();
		
		gameDialog.setVisible(true);
	}
}
