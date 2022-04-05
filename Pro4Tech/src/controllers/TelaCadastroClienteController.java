package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

import fxml.EmailManager;

public class TelaCadastroClienteController extends BaseController{

	  public TelaCadastroClienteController(EmailManager emailManager, javax.swing.text.ViewFactory viewFactory, String fxmlName) {
		super(emailManager, viewFactory, fxmlName);
		// TODO Auto-generated constructor stub
	}

	  @FXML
	    private Button botao1;
	    @FXML
	    private Button botao2;
	    @FXML
	    private GridPane grid1 ;
	    @FXML
	    private GridPane grid2 ;

	    @FXML
	    void teste(ActionEvent event) {
	    	grid1.setVisible(false);
	    	grid1.managedProperty().bind(grid1.visibleProperty());
	    	
	    	grid2.setVisible(true);
	    	grid2.managedProperty().bind(grid2.visibleProperty());
	    
	    	//grid1.managedProperty().bind(grid1.visibleProperty());

	    }


	 


}