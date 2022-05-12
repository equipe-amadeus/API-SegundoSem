package controllers;

import Dao.Cadastro_empresaDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Cadastro_empresa;
import view.ViewFactory;

public class TelaCadastroEmpresaController extends BaseController{

    
    public TelaCadastroEmpresaController(ViewFactory viewFactory, String fxmlName){
        super(viewFactory, fxmlName);
    }    


   @FXML
    private TextField NomeEmpresa;

    @FXML
    private TextField Projeto;

    @FXML
    private TextField Responsavel;
    
    @FXML
    private Label invalidDetails;

    @FXML
    void Voltar(ActionEvent event) {
        viewFactory.TelaInicialSuporte();
        Stage stage = (Stage)Projeto.getScene().getWindow();
        viewFactory.closeStage(stage);
    }
    

    protected
    String successMessage = String.format("-fx-text-fill: GREEN;");
    String errorMessage = String.format("-fx-text-fill: RED;");
    String errorStyle = String.format("-fx-border-color: RED; -fx-border-width: 2; -fx-border-radius: 5;");
    String successStyle = String.format("-fx-border-color: GREEN; -fx-border-width: 2; -fx-border-radius: 5;");
    
    @FXML
    protected void CE (ActionEvent event) throws InterruptedException {

        if (NomeEmpresa.getText().isEmpty() || Projeto.getText().isEmpty() || Responsavel.getText().isEmpty()) {
          invalidDetails.setStyle(errorMessage);
          invalidDetails.setText("Todos os campos são obrigatórios");


            if (NomeEmpresa.getText().isEmpty()) {
                NomeEmpresa.setStyle(errorStyle);

            } 
            else NomeEmpresa.setStyle(successStyle);

            if (Projeto.getText().isEmpty()) {
                Projeto.setStyle(errorStyle);

            } 
            else Projeto.setStyle(successStyle);

            if (Responsavel.getText().isEmpty()) {
                Responsavel.setStyle(errorStyle);

            } 
            else Responsavel.setStyle(successStyle);
        }

        else {
            invalidDetails.setText("Tudo certo!");
            invalidDetails.setStyle(successMessage);
            NomeEmpresa.setStyle(successStyle);
            Projeto.setStyle(successStyle);
            Responsavel.setStyle(successStyle);
            String nome_empresa, responsavel, nome_projeto;

                        nome_empresa = NomeEmpresa.getText();
                        nome_projeto = Projeto.getText();
                        responsavel = Responsavel.getText();
                        

                        Cadastro_empresa objcadastro_empresa = new Cadastro_empresa();
                        objcadastro_empresa.setNome_empresa(nome_empresa);
                        objcadastro_empresa.setResponsavel(responsavel);
                        objcadastro_empresa.setNome_projeto(nome_projeto);


                        Cadastro_empresaDAO objcadastro_empresadao = new Cadastro_empresaDAO();
                        objcadastro_empresadao.cadastrar_empresa(objcadastro_empresa);


            }

    
        }
    
    }
    



