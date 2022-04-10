package Factory;


import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author evert
 */
public class Test {

    /**
     * @param args the command line arguments
     * @throws SQLException 
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        Connection connection = new ConnectionFactory().getConnection();
        System.out.println("conexao aberta");
        connection.close();
    };
}