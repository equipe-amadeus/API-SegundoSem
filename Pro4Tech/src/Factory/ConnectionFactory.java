package Factory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author evert
 */
public class ConnectionFactory {
    public Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/pro4tech","root","Ton369811");
        }
        catch(SQLException excecao){
            throw new RuntimeException(excecao);
        }
    }
        
    
}
