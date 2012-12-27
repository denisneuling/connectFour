package com.denisneuling.connectfour.gui.components;

import javax.swing.JLabel;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.denisneuling.connectfour.common.Player;

@Component
/**
 * <p>MessagePane class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class MessagePane extends JLabel implements InitializingBean{
	private static final long serialVersionUID = -942672230228625804L;

	/**
	 * <p>Constructor for MessagePane.</p>
	 */
	public MessagePane(){
	}
	
	/** {@inheritDoc} */
	public void setText(String text){
		super.setText("<html><div style=\"text-align: center;\">" + text + "</html>");
		this.updateUI();
	}

	/**
	 * <p>setYourTurn.</p>
	 *
	 * @param player a {@link com.denisneuling.connectfour.common.Player} object.
	 */
	public void setYourTurn(Player player) {
		if(player != null && player.getName() != null && !player.getName().isEmpty()){
			setText(player.getName()+" - It's your turn.");
		}
	}
	
	/**
	 * <p>clean.</p>
	 */
	public void clean(){
		this.setText("");
	}

	/** {@inheritDoc} */
	@Override
	public void afterPropertiesSet() throws Exception {
	}
}
