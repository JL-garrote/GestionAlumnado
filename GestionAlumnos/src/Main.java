import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        int opciones;

        Scanner keyboard = new Scanner(System.in);
        Alumnos generico = new Alumnos();

        generico.crearTabla();

        try {

            do {
                System.out.println("[Actualizar pago]");
                System.out.println("[Insertar Alumno]");
                System.out.println("[Dar de baja]");
                System.out.println("[Salida de datos]");
                System.out.println("[Salir]");

                opciones = keyboard.nextInt();

                switch (opciones) {

                    case 1: {
                        generico.actualizarPago();
                        break;
                    }

                    case 2: {
                        generico.insertarAlumno();
                        break;
                    }

                    case 3: {
                        generico.darbaja();
                        break;
                    }

                    case 4: {
                        generico.igualarRegistros();
                        break;
                    }

                    case 5: {
                        break;
                    }
                }
            } while (opciones != 5);
        } catch (Exception e) {
            System.err.println("Error en el menu principal");
        }
    }
}