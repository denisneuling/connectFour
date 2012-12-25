package com.denisneuling.connectfour.gui.components.listener;

import java.awt.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.denisneuling.connectfour.gui.MainFrame;

@Component
public class QuitMenuItemListener extends BaseMenuItemListener {

	@Autowired
	private MainFrame mainFrame;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		mainFrame.setVisible(false);
		mainFrame.dispose();
		
		// seems to be bit buggy if we call this from an embedded window...
		mainFrame.die();
	}
}
