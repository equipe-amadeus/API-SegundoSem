/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Cadastro_mensagem;

/**
 *
 * @author diego
 */
public class Cadastro_mensagemDAO {
    Connection conn;
    PreparedStatement pstm;
    
    public void cadastrar_mensagem(Cadastro_mensagem objcadastro_mensagem){
        
        String sql = "INSERT INTO mensagem(titulo, categoria, nome, meio_comunicacao, conteudo) VALUES(?,?,?,?,?)";
        
        conn = new ConnectionFactory().conectaBD();
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objcadastro_mensagem.getTitulo());
            pstm.setString(2, objcadastro_mensagem.getCategoria());
            pstm.setString(3, objcadastro_mensagem.getNome());
            pstm.setString(4, objcadastro_mensagem.getMeio_comunicacao());
            pstm.setString(5, objcadastro_mensagem.getConteudo());
            pstm.execute();
            pstm.close();
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"Cadastro_mensagemDAO" + erro);
        }
    }

}
