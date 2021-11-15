package model;

public class Charizard implements GameState {
	private static Charizard INSTANCE = null;
	
	public static Charizard getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new Charizard();
		}
		return INSTANCE;
	}

	@Override
	public String printState() {
		return "Charizard!";
	}

	@Override
	public void syncronize(Pokemon p, int step) {
		if(step == 30 || step == 55) {
			p.changeState(Charmander.getInstance());
		}
	}
}
