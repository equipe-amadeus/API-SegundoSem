/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import view.ViewFactory;

/**
 *
 * @author lobat
 */
public class BaseController {
    
    protected ViewFactory viewFactory;
    protected String fxmlName;

    public BaseController(ViewFactory viewFactory, String fxmlName) {
        this.viewFactory = viewFactory;
        this.fxmlName = fxmlName;
    }
    
    public String getFxmlName() {
        return fxmlName;
    }
    
}
