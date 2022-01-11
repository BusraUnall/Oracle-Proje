
package Helper;
import java.sql.*;


public class DBConnection {
    private String userName="system";
    private String password="1234";
    private String dbUrl="jdbc:oracle:thin:@localhost:1521:orcl";


public Connection getConnection() throws SQLException{
        
        return DriverManager.getConnection(dbUrl,userName,password);
    }

public void showErrorMessage(SQLException exception){
    System.out.println("Error: "+exception.getMessage());
    System.out.println("Error code: "+exception.getErrorCode());
    }

}
