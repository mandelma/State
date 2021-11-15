package model;

public class Charmeleon implements GameState{
	private static Charmeleon INSTANCE = null;
	
	public static Charmeleon getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new Charmeleon();
		}
		return INSTANCE;
	}

	@Override
	public String printState() {
		return "Charmeleon!";
	}

	@Override
	public void syncronize(Pokemon p, int step) {
		if(step == 19 || step == 50) {
			p.changeState(Charizard.getInstance());
		}
	}
}
