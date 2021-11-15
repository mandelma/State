package application;
	
import controller.Controller;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.Pokemon;
import view.GameCanvas;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;


public class PokemonGui extends Application {
	private Controller controller;
	private GameCanvas gameCanvas;
	private Button startBtn;
	private Label info;
	public void init() {
		controller = new Controller(this);
	}
	
	@Override
	public void start(Stage primaryStage) {
		
		try {
			primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			    @Override
			    public void handle(WindowEvent t) {
			        Platform.exit();
			        System.exit(0);
			    }
			}); 
			
			gameCanvas = new GameCanvas(400, 400);
			
			BorderPane root = new BorderPane();
			
			root.setCenter((Canvas)gameCanvas);
			
			info = new Label();
			info.setText("State - Charmander!");
			info.setFont(new Font("Arial", 30));
			
			startBtn = new Button("Start");
			BorderPane.setAlignment(startBtn, Pos.BOTTOM_CENTER);
			BorderPane.setAlignment(info, Pos.TOP_CENTER);
			root.setTop(info);
			
			root.setBottom(startBtn);
			startBtn.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	            	startBtn.setDisable(true);
	                controller.startGame();
	            }
	        });
			
			Scene scene = new Scene(root,500,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	public GameCanvas goForward() {
		 return gameCanvas;
	}
	
	
	
	
	public void getStatus(String status) {
		info.setText("State - " + status);
	}
	

	
	public static void main(String[] args) {
		launch(args);
	}
}
