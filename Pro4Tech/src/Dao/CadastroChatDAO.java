/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.CadastroChat;
import modelo.Usuario;

/**
 *
 * @author lobat
 */
public class CadastroChatDAO {
    
    Connection conn;
    PreparedStatement pstm;
    
    public void Cadastrar(CadastroChat objChat){
        
        SimpleDateFormat formatoData = new SimpleDateFormat("hh:mm:ss");
        String hora = formatoData.format(new Date());
        
        String sql = "INSERT INTO chat(remetente, mensagem, destinatario, hora) VALUES(?,?,?,?)";
        
        conn = new ConnectionFactory().conectaBD();
        
        try{
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objChat.getRemetente());
            pstm.setString(2, objChat.getMensagem());
            pstm.setString(3, objChat.getDestinatario());
            pstm.setString(4, hora);
            pstm.execute();
            pstm.close();
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "EnvioMensagem" + erro);
            
        }
}
    
   /* public List<Usuario> ListarUsers(Usuario objUsuario) {
        
        String sql = "SELECT nome FROM cadastro";
        
        conn = new ConnectionFactory().conectaBD();
        
        try{
            pstm = conn.prepareStatement(sql);
            
            
            
            
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Usuario não encontrado" + erro);
        }
        
        
        return null;
        
        
        
    } */
    

}
