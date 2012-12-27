package com.denisneuling.connectfour.gui.components;

import javax.swing.JLabel;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.denisneuling.connectfour.common.Player;

@Component
public class MessagePane extends JLabel implements InitializingBean{
	private static final long serialVersionUID = -942672230228625804L;

	public MessagePane(){
	}
	
	public void setText(String text){
		super.setText("<html><div style=\"text-align: center;\">" + text + "</html>");
		this.updateUI();
	}

	public void setYourTurn(Player player) {
		if(player != null && player.getName() != null && !player.getName().isEmpty()){
			setText(player.getName()+" - It's your turn.");
		}
	}
	
	public void clean(){
		this.setText("");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
	}
}
