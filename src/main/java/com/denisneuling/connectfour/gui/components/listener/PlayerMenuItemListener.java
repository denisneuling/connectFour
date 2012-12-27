package com.denisneuling.connectfour.gui.components.listener;

import java.awt.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.denisneuling.connectfour.gui.dialog.PlayerDialog;

@Component
/**
 * <p>PlayerMenuItemListener class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class PlayerMenuItemListener extends BaseMenuItemListener{

	@Autowired
	private PlayerDialog playerDialog;
	
	/** {@inheritDoc} */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		playerDialog.relocate();
		playerDialog.setVisible(true);
	}
}
