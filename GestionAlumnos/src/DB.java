import java.sql.*;

public class DB {

    String URL = "jdbc:mysql://localhost:3306/Kime";
    String USER = "root";
    String PASS = "admin";

    Connection conn = DriverManager.getConnection(URL,USER,PASS);
    Statement state = conn.createStatement();
    ResultSet rs = state.executeQuery("SELECT * FROM minas");

    DB () throws SQLException {}

    void insertarActualizar(String consulta) throws SQLException {
        state.executeUpdate(consulta);
    }

    void borrar(String consulta) throws SQLException {
        state.executeUpdate(consulta);
    }

    int sacarId(String columna,int id) throws SQLException {
        while (rs.next()){
            id = rs.getInt(columna);
        }
        return id;
    }

    void sacarRegistros() throws SQLException {
        while (rs.next()){
            System.out.println("El alumno " + rs.getString("nombre") + " " + rs.getString("apellido1") + " paga por mes " + rs.getString("pagoMensualidad") + " euros");
        }
    }
}