package controllers;

import Dao.CadastroClienteDAO;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import modelo.CadastroChat;
import modelo.CadastroCliente;
import view.ViewFactory;


public class LoginWindowController extends BaseController {    

    public LoginWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }
    
    public static String nome;
        
    @FXML
    public TextField areaEmail;
    @FXML
    private PasswordField areaSenha;
    @FXML
    private Label invalidDetailsLogin;

    protected
    String successMessage = String.format("-fx-text-fill: GREEN;");
    String errorMessage = String.format("-fx-text-fill: RED;");
    String errorStyle = String.format("-fx-border-color: RED; -fx-border-width: 2; -fx-border-radius: 5;");
    String successStyle = String.format("-fx-border-color: GREEN; -fx-border-width: 2; -fx-border-radius: 5;");
    
    
    @FXML
    void Entrar(ActionEvent event) throws IOException {
        if (areaEmail.getText().isEmpty() || areaSenha.getText().isEmpty()){
          invalidDetailsLogin.setStyle(errorMessage);
          invalidDetailsLogin.setText("Todos os campos são obrigatórios");

          if (areaEmail.getText().isEmpty()){
              areaEmail.setStyle(errorStyle);
          }
          else areaEmail.setStyle(successStyle);

          if (areaSenha.getText().isEmpty()){
              areaSenha.setStyle(errorStyle);
          }
          else areaSenha.setStyle(successStyle);

        }
        else if (areaSenha.getText().length()<7){
            areaSenha.setStyle(errorStyle);
            invalidDetailsLogin.setStyle(errorMessage);
            invalidDetailsLogin.setText("A senha deve ter no mínimo 8 caracteres");
        }
            

        
        try {
            invalidDetailsLogin.setText("Tudo certo!");
            invalidDetailsLogin.setStyle(successMessage);
            areaEmail.setStyle(successStyle);
            areaSenha.setStyle(successStyle);

            String Email, Senha;
            Email = areaEmail.getText();
            Senha = areaSenha.getText();

            CadastroCliente objCadastroCliente = new CadastroCliente();
            objCadastroCliente.setEmail(Email);
            objCadastroCliente.setSenha(Senha);

            CadastroClienteDAO objCadastroClienteDAO = new CadastroClienteDAO();
            ResultSet rsCadastroClienteDAO = objCadastroClienteDAO.autenticacaoUsuario(objCadastroCliente);

            if (rsCadastroClienteDAO.next()) {
                //CHAMAR TELA QUE EU QUERO ABRIR.

                viewFactory.TelaInicialSuporte();
                Stage stage = (Stage) areaEmail.getScene().getWindow();
                areaSenha.getScene().getWindow();
                
                viewFactory.closeStage(stage);
                
                nome = CadastroClienteDAO.buscaToken(objCadastroCliente);

            } else {
                //ENVIAR MENSAGEM DIZENDO INCORRETO.
                JOptionPane.showMessageDialog(null, "Usuario ou Senha Inválida");

            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "LoginWindowEntrar" + erro);
        }
    }

}
