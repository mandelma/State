package view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import model.Activator;
import model.GameState;
import model.Pokemon;


public class GameCanvas extends Canvas {
	private GraphicsContext gc;
	private int index;
	
	public GameCanvas(int w, int h) {
		super(w, h);
		gc = this.getGraphicsContext2D();
		this.index = 0;
		buildScreen();
	}
	
	public void buildScreen() {
		initGround();
	}
	
	private void initGround() {
		gc.setFill(Color.RED);
		gc.fillRect(0, 100, 15, 15);
		
		
	    createLines();
	}
	
	public void clearScreen() {
		gc.clearRect(0, 0, this.getWidth(), this.getHeight());
	}
	
	public void createCharacter() {
		gc.setFill(Color.YELLOW);
		gc.fillRect(100, 100, 15, 15);
	}
	
	public void createLines() {
		gc.setStroke(Color.BLUE);
	    gc.strokeLine(65, 50, 65, 200);
	    
	    gc.setStroke(Color.ORANGE);
	    gc.strokeLine(115, 50, 115, 200);
	    
	    gc.setStroke(Color.RED);
	    gc.strokeLine(175, 50, 175, 200);
	    
	    gc.setStroke(Color.BLUE);
	    gc.strokeLine(215, 50, 215, 200);
	    
	    gc.setStroke(Color.ORANGE);
	    gc.strokeLine(270, 50, 270, 200);
	    
	    gc.setStroke(Color.RED);
	    gc.strokeLine(300, 50, 300, 200);
	}
	
	public void drawActor(int position, int x, int y, Color color) {
		this.index = position;
		clearScreen();
		createLines();
		gc.setFill(color);
		gc.fillRect(5 * position, 100, x, y);
		
	}

	public void stateInfo(Object object) {  
		gc.setFill(Color.BLUE);
		gc.fillRect(10, 20, 140, 20);
		gc.setFill(Color.WHITE);
		gc.setFont(new Font(21));
		gc.fillText("State now: " + object, 0, 10, 40);
	}
	
}
