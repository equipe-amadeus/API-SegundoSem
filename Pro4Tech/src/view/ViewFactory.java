package view;

import fxml.EmailManager;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import controllers.BaseController;
import controllers.LoginWindowController;
import controllers.TelaCadastroClienteController;

public class ViewFactory{
	private EmailManager emailManager;
	protected javax.swing.text.ViewFactory viewFactory;
	
	public ViewFactory(EmailManager emailManager) {
		this.emailManager = emailManager;
	}
	public void showLoginWindow() throws IOException {
		BaseController controller = new LoginWindowController(emailManager, this.viewFactory, "LoginWindow.fxml");
		initializeStage(controller);
    } 
	public void showMainWindow() throws IOException {
	BaseController controller = new TelaCadastroClienteController(emailManager, this.viewFactory, "TelaCadastroMensagem.fxml");
	initializeStage(controller);
    }
	
    private void initializeStage(BaseController baseController) throws IOException {
	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(baseController.getFxmlName()));
	fxmlLoader.setController(baseController);
	Parent parent = fxmlLoader.load();
	
	
    Scene scene = new Scene (parent);
    Stage stage = new Stage();
    stage.setScene(scene);
    stage.show();
 
    }
    public void closeStage(Stage stageToClose) {
    	stageToClose.close();
    }
	}
