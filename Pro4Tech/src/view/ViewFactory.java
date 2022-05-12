package view;

import controllers.BaseController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import controllers.LoginWindowController;
import controllers.TelaCadastroClienteController;
import controllers.TelaCadastroEmpresaController;
import controllers.TelaCadastroMensagemController;
import controllers.TelaChatController;
import controllers.TelaInicialController;
import controllers.TelaInicialSuporteController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;

public class ViewFactory{
    
    
    public ViewFactory(){
        
    }
        public void TelaLogin(){
            BaseController controller = new LoginWindowController(this, "LoginWindow.fxml");
            initializeStage(controller);
        
        }
        public void TelaInicialSuporte(){
            BaseController controller = new TelaInicialSuporteController(this, "TelaInicialSuporte.fxml");
            initializeStage(controller);
                    }
        public void TelaCadastroCliente(){
            BaseController controller = new TelaCadastroClienteController(this, "TelaCadastroCliente.fxml");
            initializeStage(controller);
                    }
        public void TelaCadastroEmpresa(){
            BaseController controller = new TelaCadastroEmpresaController(this, "CadastroEmpresa.fxml");
            initializeStage(controller);
                    }
        public void TelaCadastroMensagem(){
            BaseController controller = new TelaCadastroMensagemController(this, "TelaCadastroMensagem.fxml");
            initializeStage(controller);
                    }
        public void TelaChat(){
            BaseController controller = new TelaChatController(this, "TelaChat.fxml");
            initializeStage(controller);
        
        }
        
        public void initializeStage(BaseController baseController){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(baseController.getFxmlName()));
            fxmlLoader.setController(baseController);
            Parent parent;
            try{
                parent = fxmlLoader.load();
            }
            catch(IOException e){
                e.printStackTrace();
                return;
            }
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        }
        public void closeStage(Stage stageToClose){
            stageToClose.close();
        }
}
