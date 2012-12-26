package com.denisneuling.connectfour.gui.components;

import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.denisneuling.connectfour.gui.MainFrame;

/**
 * <p>NewDialog class.</p>
 *
 * @author ska
 * @version $Id: $Id
 */
@Component
public class GameDialog extends JDialog implements WindowListener, InitializingBean {
	private static final long serialVersionUID = 4621566363518596409L;
	protected Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private MenuPanel menuPanel;
	
	@Autowired
	private MainFrame mainFrame;
	
	private MigLayout layout;
	
	private JTextField xAxis;
	private JTextField yAxis;
	
	public GameDialog(){
		this.setTitle("New Game");
		this.setSize(new Dimension(350,125));
		this.setResizable(false);
		
		layout = new MigLayout("fillx", "[right]rel[grow,fill]", "[]10[]");
		this.setLayout(layout);
		
		this.add(new JLabel("Length of Y Axis:"),   "");
		
		yAxis = new JTextField("5");
		xAxis = new JTextField("6");
		
		this.add(yAxis,          "wrap");
		this.add(new JLabel("Length of X Axis:"), "");
		this.add(xAxis,          "wrap");
		
		// TODO find workaround for better line feed
		this.add(new JLabel(), "");
		
		JPanel buttonPanel = new JPanel(new MigLayout("fillx,insets 0"));

		//Ok button
		JButton okButton = new JButton("Ok");
		okButton.setMnemonic('O');
		buttonPanel.add(okButton, "split,right,width 100!");

		//Cancel button
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setMnemonic('C');
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
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		this.addWindowListener(this);
	}
}
