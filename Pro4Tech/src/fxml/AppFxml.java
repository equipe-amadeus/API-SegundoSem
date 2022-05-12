package fxml;

import javafx.application.Application;
import javafx.stage.Stage;
import view.ViewFactory;


public class AppFxml extends Application{

	@Override
	public void start(Stage stage) throws Exception{
		
            ViewFactory viewFactory = new ViewFactory();
            viewFactory.TelaLogin();
	}
        
}

