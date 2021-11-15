package controller;

import application.PokemonGui;
import javafx.application.Platform;
import javafx.scene.paint.Color;
import model.Activator;
import model.Pokemon;

public class Controller {
	private PokemonGui gui;
	private Pokemon pokemon;
	private int counter;
	
	public Controller(PokemonGui gui) {
		this.gui = gui;
		this.pokemon = new Pokemon(this);
	}
	
	public void startGame() {
		Activator activator = new Activator(this);
		((Thread)activator).start();
	}
	
	public void actor(int pos) {
		Platform.runLater(new Runnable(){
			public void run(){
				if(pokemon.getState() == "Charmander!") {
					gui.goForward().drawActor(pos, 15, 15, Color.RED);
				} else if(pokemon.getState() == "Charmeleon!") {
					gui.goForward().drawActor(pos, 20, 20, Color.BLUE);
				} else {
					gui.goForward().drawActor(pos, 25, 25, Color.ORANGE);
				}
				
				System.out.println("Game current state: " + pokemon.getState());
				System.out.println("Step:  " + (Activator.STEP - 1));
				
				// asetetaan näytölle staten nimi
				gui.getStatus(pokemon.getState());
				
				// calling back to pokemon, updating status
				pokemon.syncStatus();
			}
		});
	}
	
	public void stateHandler() {
		Platform.runLater(new Runnable() {
			public void run() {
				pokemon.handleStateChange(Activator.STEP - 1);
			}
		});
	}
	
}
