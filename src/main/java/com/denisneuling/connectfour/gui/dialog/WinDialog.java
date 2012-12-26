package com.denisneuling.connectfour.gui.dialog;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
	
	@Autowired
	private GameDialog gameDialog;
	
	private MigLayout layout;
	
	private JButton okButton;
	
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
		setLayout(new MigLayout("fill"));
		this.setLayout(layout);
	}
	
	/**
	 * <p>notifyWinner.</p>
	 *
	 * @param player a {@link com.denisneuling.connectfour.common.Player} object.
	 */
	public void notifyWinner(Player player){
		String content = "";
		
		if(player == null){
			this.setTitle("Stalemate!");
			content = "<html><h1>You are Stalemates!</h1><br>You both won this game.<br></html>";

		}else{
			this.setTitle("Victory!");
			content = "<html><h1>Congratulations!</h1><br>"+player.getName()+"<br>has beaten you in this match.<br></html>";
		}
		
		JLabel text = new JLabel();
		text.setText(content);
		this.add(text);
		
		JPanel buttonPanel = new JPanel(new MigLayout("fillx,insets 0"));
		
		//Ok button
		okButton = new JButton("Ok");
		okButton.setMnemonic('O');
		okButton.addActionListener(this);
		buttonPanel.add(okButton, "split,right,width 100!");
		this.add(buttonPanel, "");
		
		this.setSize(new Dimension(350,125));
		this.setResizable(false);
		this.setVisible(true);
	}

	/** {@inheritDoc} */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.setVisible(false);
		
		gameDialog.setVisible(true);
	}
}
