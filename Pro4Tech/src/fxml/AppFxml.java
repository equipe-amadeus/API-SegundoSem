package fxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.ViewFactory;


public class AppFxml extends Application{
	public static void main(String[] args) {launch(args);}

	@Override
	public void start(Stage stage) throws Exception{
		// TODO Auto-generated method stub
		ViewFactory viewFactory = new ViewFactory(new EmailManager());
		viewFactory.showLoginWindow();
		
		
		
	}

}
