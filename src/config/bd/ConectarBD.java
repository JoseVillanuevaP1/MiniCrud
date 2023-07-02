package config.bd; 
import java.sql.*; 
 
public class ConectarBD { 
    public Connection getConnection() throws SQLException { 
        Connection con = null; 
        try { 
            Class.forName("org.sqlite.JDBC"); 
            con = DriverManager.getConnection("jdbc:sqlite:BDVentas.db"); 
        } catch (ClassNotFoundException | SQLException e) { 
            System.err.println(e.getClass().getName() + ": " + e.getMessage()); 
            System.exit(0); 
        } 
        return con; 
    } 
}
