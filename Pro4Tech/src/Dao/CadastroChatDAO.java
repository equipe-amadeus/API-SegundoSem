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
import modelo.CadastroChat;

/**
 *
 * @author lobat
 */
public class CadastroChatDAO {
    
    Connection conn;
    PreparedStatement pstm;
    
    public void Cadastrar(CadastroChat objChat){
        
        String sql = "INSERT INTO chat(remetente, mensagem, destinatario) VALUES(?,?,?)";
        
        conn = new ConnectionFactory().conectaBD();
        
        try{
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objChat.getRemetente());
            pstm.setString(2, objChat.getMensagem());
            pstm.setString(3, objChat.getDestinatario());
            pstm.execute();
            pstm.close();
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "EnvioMensagem" + erro);
            
        }
}

}
