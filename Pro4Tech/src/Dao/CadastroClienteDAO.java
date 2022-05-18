package Dao;

import Factory.ConnectionFactory;
import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.CadastroCliente;

public class CadastroClienteDAO {

    Connection conn;
    PreparedStatement pstm;

    public void cadastrar(CadastroCliente objcadastro) {
        String sql = "INSERT INTO cadastro(cargo, nome, email, nome_empresa, projetos, telefone, senha) VALUES(?,?,?,?,?,?,?)";

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
}
