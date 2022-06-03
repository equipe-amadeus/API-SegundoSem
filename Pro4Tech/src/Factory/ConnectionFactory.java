package Factory;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author evert
 */
public class ConnectionFactory {
    public Connection conectaBD(){     
        Connection conn= null;
        
        try {
            String url = "jdbc:mysql://bd-pro4tech.mysql.database.azure.com:3306/pro4tech?user=myadimin_api&password= fatec@123";
            conn = DriverManager.getConnection(url);
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"ConnectionFactory" + erro.getMessage());
        }
        return conn;
        
    }
}
