package com.denisneuling.connectfour.gui.dialog;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JDialog;
import javax.swing.JLabel;

import net.miginfocom.swing.MigLayout;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.denisneuling.connectfour.common.Player;
import com.denisneuling.connectfour.gui.MainFrame;

@Component
/**
 * <p>WinDialog class.</p>
 *
 * @author ska
 * @version $Id: $Id
 */
public class WinDialog extends JDialog implements WindowListener, ActionListener, InitializingBean {
	private static final long serialVersionUID = 4621566363518596409L;
	protected Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private MainFrame mainFrame;
	
	private MigLayout layout;
	
	/** {@inheritDoc} */
	@Override
	public void windowActivated(WindowEvent e) {
		log.debug("Window activated");
	}

	/** {@inheritDoc} */
	@Override
	public void windowClosed(WindowEvent e) {
		log.debug("Window closed");
	}

	/** {@inheritDoc} */
	@Override
	public void windowClosing(WindowEvent e) {
		log.debug("Window closed");
	}

	/** {@inheritDoc} */
	@Override
	public void windowDeactivated(WindowEvent e) {
		log.debug("Window deactivated");
	}

	/** {@inheritDoc} */
	@Override
	public void windowDeiconified(WindowEvent e) {
		log.debug("Window deiconified");
	}

	/** {@inheritDoc} */
	@Override
	public void windowIconified(WindowEvent e) {
		log.debug("Window iconified");
	}

	/** {@inheritDoc} */
	@Override
	public void windowOpened(WindowEvent e) {
		log.debug("Window opened");
	}

	/** {@inheritDoc} */
	@Override
	public void afterPropertiesSet() throws Exception {
		this.addWindowListener(this);
	}
	
	/**
	 * <p>Constructor for WinDialog.</p>
	 */
	public WinDialog(){
		layout = new MigLayout("fillx,insets 0");
		this.setLayout(layout);
	}
	
	/**
	 * <p>notifyWinner.</p>
	 *
	 * @param player a {@link com.denisneuling.connectfour.common.Player} object.
	 */
	public void notifyWinner(Player player){
		this.setTitle("Victory!");
		
		// TODO fix remove all otherwise after second game the win dialog is whacked
//		this.removeAll();
		
		String content = "<html><h1>Congratulations!</h1><br>"+player.getName()+"<br>has beaten you in this match.</html>";
		
		JLabel text = new JLabel();
		text.setText(content);
		
		this.add(text);
		this.setSize(new Dimension(300, 140));
		this.setResizable(false);
		
		this.setVisible(true);
	}

	/** {@inheritDoc} */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.setVisible(false);
	}
}
