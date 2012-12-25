package com.denisneuling.connectfour.gui.components;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.denisneuling.connectfour.gui.components.listener.TileActionListener;
import com.denisneuling.connectfour.service.GridService;

@Component
public class ConnectFourGrid extends JPanel implements InitializingBean {
	private static final long serialVersionUID = 4883973788405021695L;

	@Value("${defaults.grid.x}")
	private String defaultXString;

	@Value("${defaults.grid.y}")
	private String defaultYString;
	
	@Value("${defaults.tile.x}")
	private String defaultTileXString;

	@Value("${defaults.tile.y}")
	private String defaultTileYString;

	@Autowired
	private GridService gridService;

	@Autowired
	private TileActionListener tileActionListener;

	private volatile MigLayout layout;

	private volatile int horizontal;
	private volatile int vertical;
	
	private volatile int tileHorizontal;
	private volatile int tileVertical;

	public int getHorizontal() {
		return horizontal;
	}

	public void setHorizontal(int horizontal) {
		this.horizontal = horizontal;
	}

	public int getVertical() {
		return vertical;
	}

	public void setVertical(int vertical) {
		this.vertical = vertical;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		horizontal = Integer.parseInt(defaultXString);
		vertical = Integer.parseInt(defaultYString);
		
		tileHorizontal = Integer.parseInt(defaultTileXString);
		tileVertical = Integer.parseInt(defaultTileYString);

		this.build();
		this.setVisible(true);
	}

	public void clean() {
		this.removeAll();
		gridService.clean();
	}

	public void build() {
		gridService.build(horizontal, vertical);

		layout = new MigLayout(String.format("wrap %d", horizontal));
		this.setLayout(layout);

		for (int y = vertical; y > 0; y--) {
			for (int x = 0; x < horizontal; x++) {
				Tile tile = new Tile(x,y,tileHorizontal,tileVertical);
				gridService.register(tile);
				tile.addMouseListener(tileActionListener);
				this.add(tile);
			}
		}
	}

	public void rebuild() {
		clean();
		build();
	}
}
