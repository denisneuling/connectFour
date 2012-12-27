package com.denisneuling.connectfour.gui.components.listener;

import java.awt.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.denisneuling.connectfour.gui.components.MenuPanel;
import com.denisneuling.connectfour.gui.dialog.GameDialog;

@Component
/**
 * <p>GameMenuItemListener class.</p>
 *
 * @author ska
 * @version $Id: $Id
 */
public class GameMenuItemListener extends BaseMenuItemListener{

	@Autowired
	private GameDialog gameDialog;
	
	@Autowired
	private MenuPanel menuPanel;
	
	/** {@inheritDoc} */
	@Override
	public void actionPerformed(ActionEvent e) {
		menuPanel.disableItems();
		
		gameDialog.relocate();
		gameDialog.setVisible(true);
	}
}
