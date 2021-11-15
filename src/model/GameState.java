package model;

public interface GameState {
	public String printState();
	public void syncronize(Pokemon p, int step);
}
