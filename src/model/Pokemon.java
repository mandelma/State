package model;

import controller.Controller;

public class Pokemon {
	private GameState state;
	
	private Controller controller;
	
	public Pokemon(Controller c) {
		controller = c;
		state = Charmander.getInstance();
	}
	
	public String getState() {
		return state.printState();
	}
	
	// updating status
	public void syncStatus() {
		controller.stateHandler();
	}
	
	public void handleStateChange(int step) {
		state.syncronize(this, step);
	}
	
	protected void changeState(GameState state) {
		this.state = state;
	}
}
