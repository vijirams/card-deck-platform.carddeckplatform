package client.controller.actions;

import java.io.Serializable;

import logic.client.GameLogic;
import carddeckplatform.game.TableView;

public abstract class  ClientAction implements Serializable {
	protected TableView gui;
	protected GameLogic logic;
	public ClientAction() {
	}
	public abstract void incoming();
	public abstract void outgoing();
	public void setGui(TableView gui) {
		this.gui = gui;
	}
	public void setLogic(GameLogic logic) {
		this.logic = logic;
	}
}
