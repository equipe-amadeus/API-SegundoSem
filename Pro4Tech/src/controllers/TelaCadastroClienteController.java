package controllers;

 
import Dao.CadastroClienteDAO;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.CadastroCliente;
import view.ViewFactory;


public class TelaCadastroClienteController extends BaseController{
    
    public TelaCadastroClienteController(ViewFactory viewFactory, String fxmlName){
        super(viewFactory, fxmlName);
    }
    
    
    
    @FXML
    public ComboBox<String> Cargo;
    

    @FXML
    private TextField Email;
    
    @FXML
    private PasswordField Senha;

    @FXML
    private TextField Empresa;

    @FXML
    private TextField Nome;

    @FXML
    private TextField Projeto;

    @FXML
    private TextField Telefone;

    @FXML
    private Label invalidDetailsCliente;

    @FXML
    private VBox cadastroCliente;
    
    ObservableList<String> lista = FXCollections.observableArrayList("Cliente", "Suporte", "Administrador");
    @FXML
    public void initialize(){
        Cargo.getItems().addAll(lista);
    }

    @FXML
    void Voltar(ActionEvent event) {
        viewFactory.TelaInicialSuporte();
        Stage stage = (Stage)Telefone.getScene().getWindow();
        viewFactory.closeStage(stage);
    }


    protected
    String successMessage = String.format("-fx-text-fill: GREEN;");
    String errorMessage = String.format("-fx-text-fill: RED;");
    String errorStyle = String.format("-fx-border-color: RED; -fx-border-width: 2; -fx-border-radius: 5;");
    String successStyle = String.format("-fx-border-color: GREEN; -fx-border-width: 2; -fx-border-radius: 5;");
    
    @FXML
    protected void CC (ActionEvent event) throws InterruptedException {

        if (Cargo.getValue().trim().isEmpty() || Email.getText().isEmpty() || Empresa.getText().isEmpty() || Nome.getText().isEmpty() || Projeto.getText().isEmpty() || Telefone.getText().isEmpty() || Senha.getText().isEmpty()) {
            invalidDetailsCliente.setStyle(errorMessage);
            invalidDetailsCliente.setText("Todos os campos são obrigatórios");
            
            if (Cargo.getValue().trim().isEmpty()){
                Cargo.setStyle(errorStyle);
            }
            else Cargo.setStyle(successStyle);
            
            if (Email.getText().isEmpty()) {
                Email.setStyle(errorStyle);

            } 
            else Email.setStyle(successStyle);

            if (Empresa.getText().isEmpty()) {
                Empresa.setStyle(errorStyle);

            } 
            else Empresa.setStyle(successStyle);

            if (Nome.getText().isEmpty()) {
            Nome.setStyle(errorStyle);

            }
            else Nome.setStyle(successStyle);
            
            if (Projeto.getText().isEmpty()) {
            Projeto.setStyle(errorStyle);

            } 
            else Projeto.setStyle(successStyle);

            if (Telefone.getText().isEmpty()) {
            Telefone.setStyle(errorStyle);

            } 
            else Telefone.setStyle(successStyle);
            
            if (Senha.getText().isEmpty()){
                Senha.setStyle(errorStyle);
            }
            else Senha.setStyle(successStyle);
            
        }

        else {
          invalidDetailsCliente.setText("Tudo certo!");
          invalidDetailsCliente.setStyle(successMessage);
          Cargo.setStyle(successStyle);
          Email.setStyle(successStyle);
          Empresa.setStyle(successStyle);
          Nome.setStyle(successStyle);
          Projeto.setStyle(successStyle);
          Telefone.setStyle(successStyle);
          Senha.setStyle(successStyle);
          String cargo, nome, email, nome_empresa, projetos, telefone, senha;
                  
                  cargo = (String) Cargo.getValue();
                  nome = Nome.getText();
                  email = Email.getText();
                  nome_empresa = Empresa.getText();
                  projetos = Projeto.getText();
                  telefone = Telefone.getText();
                  senha = Senha.getText();

                  CadastroCliente objcadastro = new CadastroCliente();
                  objcadastro.setCargo(cargo);
                  objcadastro.setNome(nome);
                  objcadastro.setEmail(email);
                  objcadastro.setNome_empresa(nome_empresa);
                  objcadastro.setProjetos(projetos);
                  objcadastro.setTelefone(telefone);
                  objcadastro.setSenha(senha);

                  CadastroClienteDAO objcadastrodao = new CadastroClienteDAO();
                  objcadastrodao.cadastrar(objcadastro);

            } 

        }
                    
    }
	   
	    
	    	
	    
	   
	    

	   

	   // @FXML
	    //void test(ActionEvent event) {
	    	//grid1.setVisible(false);
	    	//grid1.managedProperty().bind(grid1.visibleProperty());
	    	
	    	//grid2.setVisible(true);
	    	//grid2.managedProperty().bind(grid2.visibleProperty());
	    
	    	//grid1.managedProperty().bind(grid1.visibleProperty());

	    


	 


