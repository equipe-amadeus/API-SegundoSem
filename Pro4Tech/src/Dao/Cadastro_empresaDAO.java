/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Cadastro_empresa;



/**
 *
 * @author diego
 */
public class Cadastro_empresaDAO {
    Connection conn;
    PreparedStatement pstm;
    
    public void cadastrar_empresa(Cadastro_empresa objcadastro_empresa){
        String sql = "INSERT INTO empresa(nome_empresa, responsavel, nome_projeto) VALUES(?,?,?)";
        
        conn = new ConnectionFactory().conectaBD();
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objcadastro_empresa.getNome_empresa());
            pstm.setString(2, objcadastro_empresa.getResponsavel());
            pstm.setString(3, objcadastro_empresa.getNome_projeto());

            pstm.execute();
            pstm.close();
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"Cadastro_empresaDAO" + erro);
        }
    }
}
