package controllers;

import javax.swing.text.ViewFactory;

import fxml.EmailManager;

public class BaseController {
	protected EmailManager emailManager;
    protected ViewFactory viewFactory ;
	private String fxmlName;
	
	public BaseController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
		super();
		this.emailManager = emailManager;
		this.viewFactory = viewFactory;
		this.fxmlName = fxmlName;
		
	}

	public String getFxmlName() {
		return fxmlName;
	}

	

}
