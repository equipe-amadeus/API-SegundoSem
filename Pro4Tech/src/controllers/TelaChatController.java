package controllers;

import Dao.CadastroChatDAO;
import static Dao.CadastroChatDAO.destinatario;
import Factory.ConnectionFactory;
import static controllers.LoginWindowController.nome;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import modelo.CadastroChat;
import modelo.CadastroCliente;
import view.ViewFactory;

/**
 *
 * @author lobat
 */
public class TelaChatController extends BaseController{
    
    public TelaChatController(ViewFactory viewFactory, String fxmlName){
        super(viewFactory, fxmlName);
    }
    
    
    @FXML
    private VBox ListaUsuarios;
    
    @FXML
    private ComboBox ListarUsuarios;
    
    @FXML
    private VBox Vbox;
    
    @FXML
    private ScrollPane SP;
    
    @FXML
    private TextArea MessageBox;
    
    @FXML
    private Button sendButton;

    @FXML
    private Button voltar;
    
    public static String destino;
    
    List<Button> buttonList = new ArrayList();
    
    
    @FXML
    void ListarUsuarios(ActionEvent event) throws SQLException {
        
        List<String> listaUsuario = new ArrayList<>();
        
        listaUsuario.add(destinatario);
        
            for (String item : listaUsuario) {
                Button botao = new Button();
                botao.setText(item);
                botao.setStyle("-fx-text-fill: white;" +
                               "-fx-background-color: #FAC341;");
                botao.setPadding(new Insets(10,10,10,10));
                VBox.setMargin(botao, new Insets(10, 10, 10, 10));
                botao.addEventHandler(ActionEvent.ACTION, (ActionEvent actionEvent) -> {
                    destino = botao.getText();
                });
                buttonList.add(botao);
                ListaUsuarios.getChildren().addAll(buttonList);
            }
        }
        
    
    
    @FXML
    public void initialize() throws SQLException{
        CadastroChatDAO.ListarChat();
        ListaUsuarios.getChildren();
            
    }
     
    @FXML
    void SendMessage(ActionEvent event) throws IOException {
        
        String remetente, mensagem, destinatario;
        
        remetente = LoginWindowController.nome;
        mensagem = MessageBox.getText();
        destinatario = destino;
        
        
        CadastroChat chat = new CadastroChat();
        
        if(! mensagem.isEmpty()){
        chat.setRemetente(remetente);
        chat.setMensagem(mensagem);
        chat.setDestinatario(destinatario);
        
        CadastroChatDAO objCadastroChat = new CadastroChatDAO();
  
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.TOP_RIGHT);
        
        hBox.setPadding(new Insets(5, 5, 5, 10));
        Text text = new Text(mensagem);
        TextFlow textFlow = new TextFlow(text);
        textFlow.setStyle("-fx-color: rgb(239,242,255);" + 
                "-fx-background-color: rgb(15,125,242);" + 
                " -fx-background-radius: 20px;" +
                "-fx-font-size: 14px;");
        
        textFlow.setPadding(new Insets(5, 10, 5, 10));
        text.setFill(Color.color(0.934, 0.945, 0.996));
        
        hBox.getChildren().add(textFlow);
        Vbox.getChildren().add(hBox);
        
        
        objCadastroChat.Cadastrar(chat);
        
        MessageBox.clear();
        
        }    
    }
    
    void CarregaMensagem(CadastroChat usuario){
        
        
        
    }

    
    @FXML
    void Voltar(ActionEvent event) {
        viewFactory.TelaInicialSuporte();
        Stage stage = (Stage)voltar.getScene().getWindow();
        viewFactory.closeStage(stage);
    }

    

}

    

