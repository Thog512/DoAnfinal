package dienThoai;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class connectsql {
    public static Connection getConnection() throws SQLException{
        try {
            Connection cons=null;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cons=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=KhoDienThoai;username=sa;password=1120032412D!t;encrypt=false");
            return cons;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(connectsql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static void main(String[] args) throws SQLException{
        Connection c=getConnection();
        System.out.println(c.toString());
        c.close();
    }
}
