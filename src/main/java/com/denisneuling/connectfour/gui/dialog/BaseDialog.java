package com.denisneuling.connectfour.gui.dialog;

import java.awt.Point;

import javax.swing.JDialog;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.denisneuling.connectfour.gui.MainFrame;

@Component
public abstract class BaseDialog extends JDialog {
	protected Logger log = Logger.getLogger(this.getClass());
	private static final long serialVersionUID = 2323710041837666035L;

	@Autowired
	protected MainFrame mainFrame;
	
	public void relocate(){
		log.debug("Relocation.");
		
		Point location = mainFrame.getLocation();
		Point newLocation = new Point((int)location.getX()+40,(int)location.getY()+40);
		this.setLocation(newLocation);
	}
}
