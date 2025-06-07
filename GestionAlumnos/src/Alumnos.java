import java.sql.SQLException;
import java.util.Scanner;

public class Alumnos {

    private int id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String pagoMensualidad;
    private String pagoProtecciones;
    private String pagoPendiente;

    public Alumnos() throws SQLException {}

    DB basededatos = new DB();
    Scanner keyboard = new Scanner(System.in);

    void insertarAlumno() throws SQLException {

        id = basededatos.sacarId("id",id);
        id++;

        System.out.println("[Introducir el nombre del alumno]");
        nombre = keyboard.next().toLowerCase();

        System.out.println("[Introducir los apellidos del alumno]");
        apellido1 = keyboard.next().toLowerCase();
        apellido2 = keyboard.next().toLowerCase();

        System.out.println("[Introducir el pago mensual del alumno]");
        pagoMensualidad = keyboard.next().toLowerCase();

        basededatos.insertarActualizar("INSERT INTO minas (id, nombre, apellido1, apellido2, pagoMensualidad) VALUES (" +
                id + ", '" + nombre + "', '" + apellido1 + "', '" + apellido2 + "', '" + pagoMensualidad + "')"
        );
    }

    void igualarRegistros() throws SQLException {

        String columna;

        System.out.println("[Introduce la columna correspondiente]");
        columna = keyboard.next().toLowerCase();

        switch (columna) {

            case "id": {
                basededatos.sacarId(columna,id);
                break;
            }

            case "pago": {
                basededatos.sacarRegistros();
                break;
            }
        }
    }

    void actualizarPago() throws SQLException {

        System.out.println("[Introduce el nombre del alumno]");
        nombre = keyboard.next().toLowerCase();

        System.out.println("[Intoduce el pago pendiente del alumno]");
        pagoMensualidad = keyboard.next();

        basededatos.insertarActualizar(
                "UPDATE Kime.minas SET pagoPendiente = '" + pagoPendiente + "' WHERE nombre = '" + nombre + "';"

        );
    }

    void darbaja() throws SQLException {

        System.out.println("[Introduce el nombre del alumno]");
        nombre = keyboard.next().toLowerCase();

        basededatos.insertarActualizar(
                "DELETE FROM Kime.minas WHERE nombre ='" + nombre +"';"
        );
    }

    void crearTabla() throws SQLException {

        basededatos.insertarActualizar("CREATE DATABASE IF NOT EXISTS Kime;");

        basededatos.insertarActualizar("CREATE TABLE Minas ( id INT PRIMARY KEY," +
                " nombre VARCHAR(100)," +
                " apellido1 VARCHAR(100)," +
                " apellido2 VARCHAR(100)," +
                " pagoMensualidad VARCHAR(100), " +
                "pagoPendiente VARCHAR(100) );"
        );
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getPagoMensualidad() {
        return pagoMensualidad;
    }

    public void setPagoMensualidad(String pagoMensualidad) {
        this.pagoMensualidad = pagoMensualidad;
    }

    public String getPagoProtecciones() {
        return pagoProtecciones;
    }

    public void setPagoProtecciones(String pagoProtecciones) {
        this.pagoProtecciones = pagoProtecciones;
    }

    public String getPagoPendiente() {
        return pagoPendiente;
    }

    public void setPagoPendiente(String pagoPendiente) {
        this.pagoPendiente = pagoPendiente;
    }
}