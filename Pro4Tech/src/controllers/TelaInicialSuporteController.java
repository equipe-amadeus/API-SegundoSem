/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import view.ViewFactory;


/**
 *
 * @author lobat
 */
public class TelaInicialSuporteController extends BaseController{
    
    public TelaInicialSuporteController(ViewFactory viewFactory, String fxmlName){
        super(viewFactory, fxmlName);
    }
    TelaConsultaMensagem jframe = new TelaConsultaMensagem();
    
    @FXML
    private Label Ajuda;
    
    @FXML
    void TelaCC(ActionEvent event) {
        viewFactory.TelaCadastroCliente();
        Stage stage = (Stage)Ajuda.getScene().getWindow();
        viewFactory.closeStage(stage);
    }

    @FXML
    void TelaCE(ActionEvent event) {
        viewFactory.TelaCadastroEmpresa();
        Stage stage = (Stage)Ajuda.getScene().getWindow();
        viewFactory.closeStage(stage);
    }

    @FXML
    void TelaCM(ActionEvent event) {
        viewFactory.TelaCadastroMensagem();
        Stage stage = (Stage)Ajuda.getScene().getWindow();
        viewFactory.closeStage(stage);
    }

    @FXML
    void TelaMC(ActionEvent event) {
        jframe.setVisible(true);
        Stage stage = (Stage)Ajuda.getScene().getWindow();
        viewFactory.closeStage(stage);
    }
    @FXML
    void CT(ActionEvent event) {
        viewFactory.TelaChat();
        Stage stage = (Stage)Ajuda.getScene().getWindow();
        viewFactory.closeStage(stage);
    }

    
}
    
