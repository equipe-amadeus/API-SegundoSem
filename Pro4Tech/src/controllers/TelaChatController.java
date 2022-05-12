/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
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
    private TextArea MessageBox;
    
    @FXML
    private Button sendButton;

    @FXML
    private Button voltar;

    @FXML
    void SendMessage(ActionEvent event) throws IOException {
        
    }
    
    @FXML
    void Voltar(ActionEvent event) {
        viewFactory.TelaInicialSuporte();
        Stage stage = (Stage)voltar.getScene().getWindow();
        viewFactory.closeStage(stage);
    }

}

    

