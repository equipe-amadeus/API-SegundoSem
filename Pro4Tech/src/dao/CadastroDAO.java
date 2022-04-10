
package Dao;

import Factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Cadastro;


public class CadastroDAO {
    Connection conn;
    PreparedStatement pstm;
    
    public void cadastrar(Cadastro objcadastro){
        String sql = "INSERT INTO cadastro(cargo, nome, email, nome_empresa, projetos, whatsapp) VALUES(?,?,?,?,?,?)";
        
        conn = new ConnectionFactory().conectaBD();
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objcadastro.getCargo());
            pstm.setString(2, objcadastro.getNome());
            pstm.setString(3, objcadastro.getEmail());
            pstm.setString(4, objcadastro.getNome_empresa());
            pstm.setString(5, objcadastro.getProjetos());
            pstm.setString(6, objcadastro.getWhatsapp());
            pstm.execute();
            pstm.close();
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"CadastroDAO" + erro);
        }
    }
}
