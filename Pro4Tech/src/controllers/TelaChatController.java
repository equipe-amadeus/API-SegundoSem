/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import Dao.CadastroChatDAO;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import modelo.CadastroChat;
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
    private VBox Vbox;
    
    @FXML
    private ScrollPane SP;
    
    @FXML
    private TextArea MessageBox;
    
    @FXML
    private Button sendButton;

    @FXML
    private Button voltar;
    
    
    


    @FXML
    void SendMessage(ActionEvent event) throws IOException {
        
        String remetente, mensagem, destinatario;
        
        remetente = "lobatodepaulo";
        mensagem = MessageBox.getText();
        destinatario = "diogobatista";
        
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
                " -fx-background-radius: 20px;");
        
        textFlow.setPadding(new Insets(5, 10, 5, 10));
        text.setFill(Color.color(0.934, 0.945, 0.996));
        
        hBox.getChildren().add(textFlow);
        Vbox.getChildren().add(hBox);
        
        
        objCadastroChat.Cadastrar(chat);
        
        MessageBox.clear();
        
        }    
    }
    
    @FXML
    void Voltar(ActionEvent event) {
        viewFactory.TelaInicialSuporte();
        Stage stage = (Stage)voltar.getScene().getWindow();
        viewFactory.closeStage(stage);
    }

}

    

