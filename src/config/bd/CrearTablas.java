package config.bd;

import java.sql.*;

public class CrearTablas {

    public static void crearTabla() {

        ConectarBD cn = new ConectarBD();
        // conexion o ruta entre java y SQLite        
        Connection con = null;
        // Envia la order de JAVA a SQLite
        Statement stmt = null;
        try {
            con = cn.getConnection();
            stmt = con.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS PERSONA"
                    + "(IDPERSONA INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + " NOMBRE    TEXT NOT NULL, "
                    + " APELLIDO  TEXT NOT NULL, "
                    + " DNI CHAR(8), "
                    + " SALARIO REAL)";
            stmt.executeUpdate(sql);
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
