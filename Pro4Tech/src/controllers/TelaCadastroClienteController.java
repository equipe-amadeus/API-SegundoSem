package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

import fxml.EmailManager;

public class TelaCadastroClienteController extends BaseController{

	  public TelaCadastroClienteController(EmailManager emailManager, javax.swing.text.ViewFactory viewFactory, String fxmlName) {
		super(emailManager, viewFactory, fxmlName);
		// TODO Auto-generated constructor stub
	}
	   @FXML
	    private VBox cadastroCliente;
	   @FXML
	    private VBox cadastroMensagens;

	    @FXML
	    private Button botao1;

	    @FXML
	    private Button botao2;
	    
	    @FXML
	    private Button botaoCM;

	    @FXML
	    private Button botaoCC;

	    @FXML
	    private Button botaoCE;
	    @FXML
	    private Button btncadastrarMensagens;

	    @FXML
	    private Button cadastrarButton;

	    @FXML
	    private TextField cargoTextArea;

	    @FXML
	    private TextField emailTextField;

	    @FXML
	    private TextField empresaTextField;

	    @FXML
	    private TextField nomeTextField;

	    @FXML
	    private TextField numeroTextField;

	    @FXML
	    private TextField projetoTextField;
       //Botao de mjudar telas
	    @FXML
	    void acaoCC(ActionEvent event) {
	    	cadastroCliente.setVisible(true);
	    	cadastroCliente.managedProperty().bind(cadastroCliente.visibleProperty());
	      	cadastroMensagens.setVisible(false);
	    	cadastroMensagens.managedProperty().bind(cadastroMensagens.visibleProperty());

	    }

	    @FXML
	    void acaoCE(ActionEvent event) {

	    }

	    @FXML
	    void acaoCM(ActionEvent event) {
	      	cadastroCliente.setVisible(false);
	    	cadastroCliente.managedProperty().bind(cadastroCliente.visibleProperty());
	      	cadastroMensagens.setVisible(true);
	    	cadastroMensagens.managedProperty().bind(cadastroMensagens.visibleProperty());

	    }
	    //fim da acao

	    @FXML
	    void cadastrarCliente(ActionEvent event) {

	    }
	    @FXML
	    void cadastrarMensagens(ActionEvent event) {

	    }
	    }
	    
	    	
	    
	   
	    

	   

	   // @FXML
	    //void test(ActionEvent event) {
	    	//grid1.setVisible(false);
	    	//grid1.managedProperty().bind(grid1.visibleProperty());
	    	
	    	//grid2.setVisible(true);
	    	//grid2.managedProperty().bind(grid2.visibleProperty());
	    
	    	//grid1.managedProperty().bind(grid1.visibleProperty());

	    


	 


