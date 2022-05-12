package controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import view.ViewFactory;


public class LoginWindowController extends BaseController{
    
    public LoginWindowController(ViewFactory viewFactory, String fxmlName){
        super(viewFactory, fxmlName);
    }  

	 @FXML
	    private TextField areaEmail;

	    @FXML
	    private PasswordField areaSenha;


	 
    @FXML
    void Entrar(ActionEvent event) throws IOException {
        viewFactory.TelaInicialSuporte();
        Stage stage = (Stage)areaEmail.getScene().getWindow();
        viewFactory.closeStage(stage);
    
    }
}
