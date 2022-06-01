package Dao;

import Factory.ConnectionFactory;
import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import javax.swing.JOptionPane;
import modelo.CadastroCliente;

public class CadastroClienteDAO {

    static String token;
    static Connection conn;
    static PreparedStatement pstm;

    public void cadastrar(CadastroCliente objcadastro) {
        String sql = "INSERT INTO cadastro(cargo, nome, email, nome_empresa, projetos, telefone, senha, token) VALUES(?,?,?,?,?,?,?,?)";

        conn = new ConnectionFactory().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objcadastro.getCargo());
            pstm.setString(2, objcadastro.getNome());
            pstm.setString(3, objcadastro.getEmail());
            pstm.setString(4, objcadastro.getNome_empresa());
            pstm.setString(5, objcadastro.getProjetos());
            pstm.setString(6, objcadastro.getTelefone());
            pstm.setString(7, objcadastro.getSenha());
            pstm.setString(8, objcadastro.getToken());
            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "CadastroDAO" + erro);
        }
    }

    public ResultSet autenticacaoUsuario(CadastroCliente objCadastroCliente) {

        conn = new ConnectionFactory().conectaBD();

        try {

            String sql = "SELECT * FROM cadastro WHERE email = ? and senha = ?";

            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, objCadastroCliente.getEmail());
            pstm.setString(2, objCadastroCliente.getSenha());

            ResultSet rs = pstm.executeQuery();
            return rs;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "autenticacaoUsuario: " + erro);
            return null;
        }

    }
    
    
    
    public static String criaToken(){
        
        Random random = new Random();
        int numero;
        do{
            numero = random.nextInt();
        }while(numero < 0);
        
        CadastroClienteDAO.token = String.valueOf(numero);
        
        return CadastroClienteDAO.token;
        
    }
    
    public static String buscaToken(CadastroCliente objcadastro) throws SQLException{
        
        conn = new ConnectionFactory().conectaBD();
        ResultSet rs;
        Statement stmt = conn.createStatement();
        
        
        try {
            
            rs = stmt.executeQuery("SELECT token FROM cadastro WHERE nome LIKE" + objcadastro.getEmail() + '"');
            pstm.close();
            token = rs.getString(token);
        }catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro na busca" + erro);
        }
        
        
        return token;
        

        
    }
}
        

