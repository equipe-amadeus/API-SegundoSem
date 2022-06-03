package Dao;

import Factory.ConnectionFactory;
import com.mysql.cj.protocol.Resultset;
import static controllers.LoginWindowController.nome;

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
            pstm.setString(8, criaToken());
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
    public static String buscaNome(String email){
        
        Connection conn = new ConnectionFactory().conectaBD();
        ResultSet rs;
        PreparedStatement stmt;
        String sql = "SELECT nome FROM cadastro WHERE email = ?";
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);

            rs = stmt.executeQuery();
            rs.next();
            
            String retorno = rs.getString("nome");
            

            return retorno;
            
        }catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro na busca" + erro);
            return null;
        }
    
    }
    
}
        

