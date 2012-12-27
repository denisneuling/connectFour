package com.denisneuling.connectfour.gui.components;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.denisneuling.connectfour.gui.MainFrame;
import com.denisneuling.connectfour.gui.components.listener.GameMenuItemListener;
import com.denisneuling.connectfour.gui.components.listener.PlayerMenuItemListener;
import com.denisneuling.connectfour.gui.components.listener.QuitMenuItemListener;
import com.denisneuling.connectfour.gui.dialog.GameDialog;
import com.denisneuling.connectfour.gui.dialog.PlayerDialog;

@Component
/**
 * <p>MenuPanel class.</p>
 *
 * @author ska
 * @version $Id: $Id
 */
public class MenuPanel extends JMenuBar implements InitializingBean {
	private static final long serialVersionUID = -8033351688374778735L;
	protected Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private MainFrame mainFrame;
	
	@Autowired
	private GameDialog gameDialog;
	
	@Autowired
	private PlayerDialog playerDialog;
	
	@Autowired
	private GameMenuItemListener gameMenuItemListener;
	
	@Autowired
	private PlayerMenuItemListener playerMenuItemListener;
	
	@Autowired
	private QuitMenuItemListener quitMenuItemListener;
	
	private JMenu jMenu;
	private JMenuItem quitItem;
	private JMenuItem gameItem;
	private JMenuItem playerItem;
	
	/**
	 * <p>Constructor for MenuPanel.</p>
	 */
	public MenuPanel(){
	}	
	
	/** {@inheritDoc} */
	@Override
	public void afterPropertiesSet() throws Exception {
		this.removeAll();
		
		jMenu = new JMenu("Actions");
		
		quitItem = new JMenuItem("Quit");
		quitItem.addActionListener(quitMenuItemListener);
		gameItem = new JMenuItem("New Game");
		gameItem.addActionListener(gameMenuItemListener);
		playerItem = new JMenuItem("Player options");
		playerItem.addActionListener(playerMenuItemListener);
		
		jMenu.add(gameItem);
		jMenu.add(playerItem);
		jMenu.add(quitItem);
		this.add(jMenu);
		
		this.setVisible(true);
	}
	
	/**
	 * <p>disableItems.</p>
	 */
	public void disableItems(){
		quitItem.setEnabled(false);
		gameItem.setEnabled(false);
	}
	
	/**
	 * <p>enableItems.</p>
	 */
	public void enableItems(){
		quitItem.setEnabled(true);
		gameItem.setEnabled(true);
	}
}
