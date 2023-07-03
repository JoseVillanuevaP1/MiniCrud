package control;

import config.bd.ConectarBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Persona;

public class Operaciones {

    ConectarBD cn = new ConectarBD();
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    Persona p = new Persona();

    public boolean agregarpersona(Persona persona) {
        boolean respuesta = false;
        String sql = " INSERT INTO PERSONA(NOMBRE, APELLIDO, DNI, SALARIO) "
                + " VALUES(  "
                + "'" + persona.getNombre() + "', "
                + "'" + persona.getApellido() + "', "
                + "'" + persona.getDni() + "', "
                + persona.getSalario()
                + "); ";
        try {
            con = cn.getConnection();
            stmt = con.createStatement();
            int filasAfectadas = stmt.executeUpdate(sql);

            if (filasAfectadas > 0) {
                respuesta = true;
            }

            stmt.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("No se pudo insertar");
        }
        return respuesta;
    }

    public List listarpersona() {
        ArrayList<Persona> personas = new ArrayList<>();
        String sql = " SELECT * "
                + " FROM PERSONA "
                + " ORDER BY APELLIDO; ";
        try {
            con = cn.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Persona persona = new Persona();
                persona.setIdpersona(rs.getInt("idpersona"));
                persona.setNombre(rs.getString("nombre"));
                persona.setApellido(rs.getString("apellido"));
                persona.setDni(rs.getString("dni"));
                persona.setSalario(rs.getDouble("salario"));
                personas.add(persona);
            }

            stmt.close();
            con.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println("No se puede listar");
        }
        return personas;
    }

    public List listarpersonaEmpiezaPor(String columna, String palabra) {

        ArrayList<Persona> personas = new ArrayList<>();
        String sql = " SELECT *"
                + " FROM PERSONA"
                + " WHERE " + columna + " LIKE '" + palabra + "%' ORDER BY APELLIDO;";

        try {
            con = cn.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Persona persona = new Persona();
                persona.setIdpersona(rs.getInt("idpersona"));
                persona.setNombre(rs.getString("nombre"));
                persona.setApellido(rs.getString("apellido"));
                persona.setDni(rs.getString("dni"));
                persona.setSalario(rs.getDouble("salario"));
                personas.add(persona);
            }

            stmt.close();
            con.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println("No se puede listar" + e);
        }
        return personas;
    }
    
    public List listarpersonaTerminaEn(String columna, String palabra) {

        ArrayList<Persona> personas = new ArrayList<>();
        String sql = " SELECT *"
                + " FROM PERSONA "
                + " WHERE " + columna + " LIKE '%" + palabra + "' ORDER BY APELLIDO; ";

        try {
            con = cn.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Persona persona = new Persona();
                persona.setIdpersona(rs.getInt("idpersona"));
                persona.setNombre(rs.getString("nombre"));
                persona.setApellido(rs.getString("apellido"));
                persona.setDni(rs.getString("dni"));
                persona.setSalario(rs.getDouble("salario"));
                personas.add(persona);
            }

            stmt.close();
            con.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println("No se puede listar" + e);
        }
        return personas;
    }

    public List listarpersonaContiene(String columna, String palabra) {
        ArrayList<Persona> personas = new ArrayList<>();
        String sql = " SELECT *"
                + " FROM PERSONA "
                + " WHERE " + columna + " LIKE '%" + palabra + "%' ORDER BY APELLIDO; ";

        try {
            con = cn.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Persona persona = new Persona();
                persona.setIdpersona(rs.getInt("idpersona"));
                persona.setNombre(rs.getString("nombre"));
                persona.setApellido(rs.getString("apellido"));
                persona.setDni(rs.getString("dni"));
                persona.setSalario(rs.getDouble("salario"));
                personas.add(persona);
            }

            stmt.close();
            con.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println("No se puede listar" + e);
        }
        return personas;
    }

    public boolean eliminarPersona(int idPersona) {

        boolean respuesta = false;
        String sql = "DELETE FROM PERSONA WHERE IDPERSONA = " + idPersona + ";";
        try {
            con = cn.getConnection();
            stmt = con.createStatement();
            int filasAfectadas = stmt.executeUpdate(sql);

            if (filasAfectadas > 0) {
                respuesta = true;
            } else if (filasAfectadas == 0) {
                System.out.println("No se encontró la persona con el ID indicado");
            }

            stmt.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e);
        }
        return respuesta;
    }

    public Persona obtenerPersona(int idPersona) {
        Persona persona = new Persona();

        String sql = "SELECT * FROM PERSONA WHERE IDPERSONA = " + idPersona + ";";
        try {
            con = cn.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                persona.setIdpersona(rs.getInt("IDPERSONA"));
                persona.setNombre(rs.getString("NOMBRE"));
                persona.setApellido(rs.getString("APELLIDO"));
                persona.setDni(rs.getString("DNI"));
                persona.setSalario(rs.getDouble("SALARIO"));
            } else {
                System.out.println("No se encontró la persona con el ID indicado");
            }

            stmt.close();
            con.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println("Error al obtener la persona: " + e.getMessage());
        }

        return persona;
    }

    public boolean actualizarPersona(Persona persona) {

        boolean respuesta = false;
        String sql = " UPDATE PERSONA "
                + " SET "
                + " NOMBRE = '" + persona.getNombre() + "', "
                + " APELLIDO = '" + persona.getApellido() + "', "
                + " DNI = '" + persona.getDni() + "', "
                + " SALARIO = " + persona.getSalario() + " "
                + " WHERE"
                + " IDPERSONA = " + persona.getIdpersona() + ";";

        try {
            con = cn.getConnection();
            stmt = con.createStatement();
            int filasAfectadas = stmt.executeUpdate(sql);

            if (filasAfectadas > 0) {
                respuesta = true;
            } else if (filasAfectadas == 0) {
                System.out.println("No se encontró la persona con el ID indicado");
            }

            stmt.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e);
        }
        return respuesta;
    }

}
