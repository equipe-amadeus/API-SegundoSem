package controllers;


import java.io.IOException;

import fxml.EmailManager;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import view.ViewFactory;

public class LoginWindowController extends BaseController{

   

	@FXML
    private TextArea areaEmail;

    @FXML
    private PasswordField areaSenha;

    @FXML
    public void Entrar() throws IOException {
    	ViewFactory viewFactory2 = new ViewFactory(null);
		viewFactory2.showMainWindow();
		Stage stage = (Stage) areaEmail.getScene().getWindow();
		viewFactory2.closeStage(stage);
		
    	

    }
    public LoginWindowController(EmailManager emailManager, javax.swing.text.ViewFactory viewFactory, String fxmlName) {
		super(emailManager, viewFactory, fxmlName);
		// TODO Auto-generated constructor stub
	}

}
