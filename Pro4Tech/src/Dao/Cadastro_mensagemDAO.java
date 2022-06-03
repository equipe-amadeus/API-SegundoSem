/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.SimpleTimeZone;
import javax.swing.JOptionPane;
import modelo.Cadastro_mensagem;

/**
 *
 * @author diego
 */
public class Cadastro_mensagemDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<Cadastro_mensagem> lista = new ArrayList<>();
    LocalDateTime data_hora;
        
    SimpleDateFormat formatoData = new SimpleDateFormat("dd/M/yyyy hh:mm");
    String data = formatoData.format(new Date());
    
        
    public void cadastrar_mensagem(Cadastro_mensagem objcadastro_mensagem) {

        String sql = "INSERT INTO mensagem(titulo, categoria, meio_comunicacao, conteudo, data_hora) VALUES(?,?,?,?,?)";

        conn = new ConnectionFactory().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objcadastro_mensagem.getTitulo());
            pstm.setString(2, objcadastro_mensagem.getCategoria());
            pstm.setString(3, objcadastro_mensagem.getMeio_comunicacao());
            pstm.setString(4, objcadastro_mensagem.getConteudo());
            pstm.setString(5, data);
            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Cadastro_mensagemDAO" + erro);
        }
    }
    
    public ArrayList<Cadastro_mensagem> ListarMensagem() {
        String sql = "SELECT * FROM mensagem";
        conn = new ConnectionFactory().conectaBD();
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Cadastro_mensagem objCadastro_mensagem = new Cadastro_mensagem();
                objCadastro_mensagem.setId_mensagem(rs.getInt("id_mensagem"));
                objCadastro_mensagem.setCategoria(rs.getString("categoria"));
                objCadastro_mensagem.setMeio_comunicacao(rs.getString("meio_comunicacao"));
                objCadastro_mensagem.setTitulo(rs.getString("titulo"));
                objCadastro_mensagem.setConteudo(rs.getString("conteudo"));
                lista.add(objCadastro_mensagem);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Cadastro_mensagemDAO Listar: " + erro);
        }
        return lista;
    }

    public void alterarMensagem(Cadastro_mensagem objCadastro_mensagem) {

        String sql = "UPDATE mensagem SET titulo = ?, categoria = ?, meio_comunicacao = ?, conteudo = ? WHERE id_mensagem = ?";
        conn = new ConnectionFactory().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objCadastro_mensagem.getTitulo());
            pstm.setString(2, objCadastro_mensagem.getCategoria());
            pstm.setString(3, objCadastro_mensagem.getMeio_comunicacao());
            pstm.setString(4, objCadastro_mensagem.getConteudo());
            pstm.setInt(5, objCadastro_mensagem.getId_mensagem());
            
            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Cadastro_mensagemDAO Alterar" + erro);
        }
    }
    public void excluirMensagem(Cadastro_mensagem objCadastro_mensagem){
         String sql = "DELETE FROM mensagem WHERE id_mensagem = ?";
         conn = new ConnectionFactory().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objCadastro_mensagem.getId_mensagem());
            
            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Cadastro_mensagemDAO Excluir" + erro);
      }
    
   }
}
