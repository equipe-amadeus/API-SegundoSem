package controllers;

import Dao.CadastroClienteDAO;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
    
    
    
    

    @FXML
    public TextField areaEmail;
    @FXML
    private PasswordField areaSenha;
    
    
    
    @FXML
    void Entrar(ActionEvent event) throws IOException {
        try {

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

            } else {
                //ENVIAR MENSAGEM DIZENDO INCORRETO.
                JOptionPane.showMessageDialog(null, "Usuario ou Senha Inválida");

            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "LoginWindowEntrar" + erro);
        }
    }

}
