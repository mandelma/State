package model;

public class Charmander implements GameState {
	private static Charmander INSTANCE = null;
	
	public static Charmander getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new Charmander();
		}
		return INSTANCE;
	}

	@Override
	public String printState() {
		return "Charmander!";
	}

	@Override
	public void syncronize(Pokemon p, int step) {
		if(step == 10 || step == 40) {
			p.changeState(Charmeleon.getInstance());
		}
	}
}