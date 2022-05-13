package controllers;

import Dao.CadastroClienteDAO;
import com.mysql.cj.protocol.Resultset;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import modelo.CadastroCliente;
import view.ViewFactory;

public class LoginWindowController extends BaseController {

    public LoginWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    @FXML
    private TextField areaEmail;

    @FXML
    private PasswordField areaSenha;

    @FXML
    void Entrar(ActionEvent event) throws IOException {
        try {

            String Email;
            Email = areaEmail.getText();

            CadastroCliente objCadastroCliente = new CadastroCliente();
            objCadastroCliente.setEmail(Email);

            CadastroClienteDAO objCadastroClienteDAO = new CadastroClienteDAO();
            ResultSet rsCadastroClienteDAO = objCadastroClienteDAO.autenticacaoUsuario(objCadastroCliente);

            if (rsCadastroClienteDAO.next()) {
                //CHAMAR TELA QUE EU QUERO ABRIR.

                viewFactory.TelaInicialSuporte();
                Stage stage = (Stage) areaEmail.getScene().getWindow();
                viewFactory.closeStage(stage);

            } else {
                //ENVIAR MENSAGEM DIZENDO INCORRETO.
                JOptionPane.showMessageDialog(null, "usuario Inválido");

            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "LoginWindowEntrar" + erro);
        }
    }

}
