package com.denisneuling.connectfour.gui.dialog;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.denisneuling.connectfour.common.Player;
import com.denisneuling.connectfour.gui.components.MenuPanel;
import com.denisneuling.connectfour.gui.components.MessagePane;
import com.denisneuling.connectfour.service.PlayerService;

@Component
/**
 * <p>PlayerDialog class.</p>
 *
 * @author ska
 * @version $Id: $Id
 */
public class PlayerDialog extends BaseDialog implements WindowListener, ActionListener, InitializingBean {
	private static final long serialVersionUID = 4621566363518596409L;
	protected Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private MenuPanel menuPanel;
	
	@Autowired
	private PlayerService playerService;
	
	@Autowired
	private MessagePane messgaePane;
	
	private MigLayout layout;
	
	private JTextField player1;
	private JTextField player2;
	
	private JButton okButton;
	private JButton cancelButton;
	
	/**
	 * <p>Constructor for GameDialog.</p>
	 */
	public PlayerDialog(){
		this.setTitle("Player options");
		this.setSize(new Dimension(350,125));
		this.setResizable(false);
		
		layout = new MigLayout("fillx", "[right]rel[grow,fill]", "[]10[]");
		this.setLayout(layout);
		
		this.add(new JLabel("Name of player 1:"),   "");
		player1 = new JTextField();
		this.add(player1,          "wrap");
		
		this.add(new JLabel("Name of player 2:"), "");
		player2 = new JTextField();
		this.add(player2,          "wrap");
		
		// TODO find workaround for better line feed
		this.add(new JLabel(), "");
		
		JPanel buttonPanel = new JPanel(new MigLayout("fillx,insets 0"));

		//Ok button
		okButton = new JButton("Ok");
		okButton.setMnemonic('O');
		okButton.addActionListener(this);
		buttonPanel.add(okButton, "split,right,width 100!");

		//Cancel button
		cancelButton = new JButton("Cancel");
		cancelButton.setMnemonic('C');
		cancelButton.addActionListener(this);
		buttonPanel.add(cancelButton, "width 100!");
		
		this.add(buttonPanel, "");
	}
	
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
		menuPanel.enableItems();
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
		
		relocate();
		
		player1.setText(playerService.getPlayer1().getName());
		player2.setText(playerService.getPlayer2().getName());
	}

	/** {@inheritDoc} */
	@Override
	public void afterPropertiesSet() throws Exception {
		this.addWindowListener(this);
	}

	/** {@inheritDoc} */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		log.info(arg0.toString());
		
		if(okButton.equals(arg0.getSource())){
			
			String player1Name = player1.getText();
			String player2Name = player2.getText();
			
			playerService.getPlayer1().setName(player1Name);
			playerService.getPlayer2().setName(player2Name);
			
			
			Player currentPlayer = playerService.getCurrentPlayer();
			messgaePane.setYourTurn(currentPlayer);
			
			this.setVisible(false);
		}else if(cancelButton.equals(arg0.getSource())){
			this.setVisible(false);
		}
	}
}
