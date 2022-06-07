package Dao;

import Factory.ConnectionFactory;
import static controllers.LoginWindowController.nome;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.CadastroChat;
import modelo.CadastroCliente;


public class CadastroChatDAO {
    
    public static Connection conn;
    PreparedStatement pstm;
    public static List<CadastroCliente> usuarios;
    public static String destinatario;
    
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
    
    public static String ListarChat() throws SQLException{
        conn = new ConnectionFactory().conectaBD();
        ResultSet rs;
        PreparedStatement stmt;
        

        try {
            String sql = "SELECT * FROM cadastro WHERE nome <> ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            rs = stmt.executeQuery();
            rs.next();
            
               /* String usuario = rs.getString("nome");
                
                cli.setNome(usuario);
                cli.setEmail(".");
                cli.setCargo(".");
                cli.setSenha(".");
                cli.setNome_empresa(".");
                cli.setTelefone(".");
                */
                destinatario = rs.getString("nome");
            return destinatario;
            
        }catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro na busca" + erro);
        }   
        return null;
    }

/*
    public List<CadastroChat> ListarMensagens(CadastroChat mensagem) {
        
        conn = new ConnectionFactory().conectaBD();
        ResultSet rs;
        PreparedStatement stmt;
        String sql = "SELECT * FROM chat";
        List<CadastroChat> mensagens = null;
        
        try {
            stmt = conn.prepareStatement(sql);
            
            rs = stmt.executeQuery();
            while(rs.next()){
            
             mensagem.destinatario = rs.getString("destinatario");
             mensagem.remetente = rs.getString("rementente");
             mensagem.mensagem = rs.getString("mensagem");
             
             mensagens.add(mensagem);
            
            }
            return mensagens;
            
        }catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro na busca" + erro);
            return null;
        }
    
    }
    */
}

    