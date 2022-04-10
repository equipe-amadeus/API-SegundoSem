
module Pro4Tech {
	requires javafx.controls;
	requires javafx.graphics;
	requires java.desktop;
	requires javafx.fxml;
	requires javafx.web;
	requires javafx.base;
	requires java.sql;
    requires mysql.connector.java;
	
	opens fxml;
	opens controllers;
	opens view;
	opens Factory;
	opens Dao;

	
}