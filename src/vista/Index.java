package vista;

import control.Operaciones;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import modelo.Persona;
import utils.Lectura;

public class Index {

    private static final Lectura leer = new Lectura();

    public static void agregarpersona() {
        String nombre;
        String apellido;
        String dni;
        double salario;
        System.out.println("Agregar Persona: ");
        System.out.print("> Nombre: ");
        nombre = leer.cadena();
        System.out.print("> Apellido: ");
        apellido = leer.cadena();
        System.out.print("> DNI: ");
        dni = leer.cadena();
        System.out.print("> Salario: ");
        salario = leer.decimal();
        Persona persona = new Persona(nombre, apellido, dni, salario);
        Operaciones o = new Operaciones();
        o.agregarpersona(persona);

        int op;
        System.out.println("Desea agregar a otra persona: ");
        System.out.println("1. Si");
        System.out.println("2. No");
        System.out.print("Seleccione una opcion [1-2]: ");
        op = leer.entero();
        if (op == 1) {
            agregarpersona();
        }

    }

    public static void eliminarpersona() {
        listarpersona();
        System.out.print("Indique el ID de la persona que desea eliminar: ");
        int id = leer.entero();
        Operaciones o = new Operaciones();

        if (o.eliminarPersona(id)) {

            System.out.println("Se elimino correctamente");

        } else {
            System.out.println("No se pudo eliminar");
        }

        int op;
        System.out.println("Desea eliminar a otra persona: ");
        System.out.println("1. Si");
        System.out.println("2. No");
        System.out.print("Seleccione una opcion [1-2]: ");
        op = leer.entero();
        if (op == 1) {
            eliminarpersona();
        }

    }

    public static void buscarPersona() {

        System.out.println("Buscar persona: ");
        System.out.println("1. Empieza por...");
        System.out.println("2. Termina por...");
        System.out.println("3. Contiene...");
        System.out.print("Escoja opción [1-3]: ");
        int opcion = leer.entero();

        //en caso haya seleccionado una opcion valida pedimos por que campo desea buscar
        String palabra = "";
        String campo = "";
        if (opcion == 1 || opcion == 2 || opcion == 3) {

            System.out.println("Buscar por: ");
            System.out.println("1. Nombre");
            System.out.println("2. Apellido");
            int opc;

            do {
                System.out.print("Escoja opción [1-2]: ");
                opc = leer.entero();
                campo = (opc == 1) ? "nombre" : "apellido";

            } while (opc != 1 && opc != 2);

            System.out.print("Digite la palabra : ");
            palabra = leer.cadena();
        }

        //recibimos la lista de Personas
        Operaciones o = new Operaciones();
        List<Persona> personas;

        List<String[]> data = new ArrayList<>();

        switch (opcion) {
            case 1:

                personas = o.listarpersonaEmpiezaPor(campo, palabra);

                // Recorremos el ArrayList de Personas y agregamos los datos a la lista "data"
                for (Persona persona : personas) {

                    String nombreCompleto = persona.getNombreCompleto();
                    if (nombreCompleto.length() > 30) { // Límite de caracteres para mostrar
                        nombreCompleto = nombreCompleto.substring(0, 27) + "...";
                    }

                    String[] rowData = {
                        String.valueOf(persona.getIdpersona()),
                        nombreCompleto,
                        persona.getDni(),
                        String.valueOf(persona.getSalario())
                    };
                    data.add(rowData);

                }

                if (!data.isEmpty()) {
                    printReport(data);
                } else {
                    System.out.println("No se encontro registros");
                }

                break;
            case 2:

                personas = o.listarpersonaTerminaEn(campo, palabra);

                // Recorremos el ArrayList de Personas y agregamos los datos a la lista "data"
                for (Persona persona : personas) {

                    String nombreCompleto = persona.getNombreCompleto();
                    if (nombreCompleto.length() > 30) { // Límite de caracteres para mostrar
                        nombreCompleto = nombreCompleto.substring(0, 27) + "...";
                    }

                    //validamos el metodo de busqueda
                    String[] rowData = {
                        String.valueOf(persona.getIdpersona()),
                        nombreCompleto,
                        persona.getDni(),
                        String.valueOf(persona.getSalario())
                    };
                    data.add(rowData);

                }

                if (!data.isEmpty()) {
                    printReport(data);
                } else {
                    System.out.println("No se encontro registros");
                }
                break;
            case 3:

                personas = o.listarpersonaContiene(campo, palabra);

                // Recorremos el ArrayList de Personas y agregamos los datos a la lista "data"
                for (Persona persona : personas) {

                    String nombreCompleto = persona.getNombreCompleto();
                    if (nombreCompleto.length() > 30) { // Límite de caracteres para mostrar
                        nombreCompleto = nombreCompleto.substring(0, 27) + "...";
                    }

                    //validamos el metodo de busqueda
                    String[] rowData = {
                        String.valueOf(persona.getIdpersona()),
                        nombreCompleto,
                        persona.getDni(),
                        String.valueOf(persona.getSalario())
                    };
                    data.add(rowData);

                }

                if (!data.isEmpty()) {
                    printReport(data);
                } else {
                    System.out.println("No se encontro registros");
                }

                break;
            default:
                break;
        }

    }

    public static void editarpersona() {
        listarpersona();
        System.out.print("Indique el ID de la persona que desea editar: ");
        int id = leer.entero();
        Operaciones o = new Operaciones();

        Persona persona = new Persona();
        persona = o.obtenerPersona(id);

        //validar si no envio un objeto vacio o no encontro a la persona
        if (persona.getIdpersona() == 0) {
            return;
        }

        //Enviamos y recibimos la nueva informacion
        System.out.println("Editar Persona: ");
        System.out.println("> Nombre Actual: " + persona.getNombre());
        System.out.print("> Nuevo Nombre: ");
        String nombre = leer.cadena();
        System.out.println("> Apellido Actual: " + persona.getApellido());
        System.out.print("> Nuevo Apellido: ");
        String apellido = leer.cadena();
        System.out.println("> DNI Actual: " + persona.getDni());
        System.out.print("> Nuevo DNI: ");
        String dni = leer.cadena();
        System.out.println("> Salario Actual: " + persona.getSalario());
        System.out.print("> Nuevo Salario: ");
        Double salario = leer.decimal();

        Persona personaActualizada = new Persona(persona.getIdpersona(), nombre, apellido, dni, salario);

        if (o.actualizarPersona(personaActualizada)) {

            System.out.println("Se actualizo correctamente");

        } else {

            System.out.println("No se pudo actualizar");

        }

        int op;
        System.out.println("Desea editar a otra persona: ");
        System.out.println("1. Si");
        System.out.println("2. No");
        System.out.print("Seleccione una opcion [1-2]: ");
        op = leer.entero();
        if (op == 1) {
            editarpersona();
        }

    }

    public static void listarpersona() {
        Operaciones o = new Operaciones();
        List<Persona> personas = o.listarpersona();
        System.out.println("Listado de Personas:");
        List<String[]> data = new ArrayList<>();

        // Recorremos el ArrayList de Personas y agregamos los datos a la lista "data"
        for (Persona persona : personas) {

            String nombreCompleto = persona.getNombreCompleto();
            if (nombreCompleto.length() > 30) { // Límite de caracteres para mostrar
                nombreCompleto = nombreCompleto.substring(0, 27) + "...";
            }

            String[] rowData = {
                String.valueOf(persona.getIdpersona()),
                nombreCompleto,
                persona.getDni(),
                String.valueOf(persona.getSalario())
            };
            data.add(rowData);
        }

        if (!data.isEmpty()) {
            printReport(data);
        } else {
            System.out.println("No se encontro registros");
        }
    }

    public static void printReport(List<String[]> data) {
        int[] columnWidths = calculateColumnWidths(data);

        String[] columnTitles = {"ID", "Nombre Completo", "DNI", "Salario"};

        for (int i = 0; i < columnTitles.length; i++) {
            String formattedTitle = String.format("%-" + (columnWidths[i] + 5) + "s", columnTitles[i]);
            System.out.print(formattedTitle);
        }
        System.out.println();

        // Imprimir la línea separadora
        String separador = "-".repeat(Arrays.stream(columnWidths).sum() + (columnWidths.length * 5));
        System.out.println(separador);

        for (String[] row : data) {
            for (int i = 0; i < row.length; i++) {
                String formattedValue = String.format("%-" + (columnWidths[i] + 5) + "s", row[i]);
                System.out.print(formattedValue);
            }
            System.out.println();
        }
    }

    public static int[] calculateColumnWidths(List<String[]> data) {
        int[] columnWidths = new int[data.get(0).length];

        for (String[] row : data) {
            for (int i = 0; i < row.length; i++) {
                if (row[i].length() > columnWidths[i]) {
                    columnWidths[i] = row[i].length();
                }
            }
        }

        return columnWidths;
    }

    public static void salir() {
        System.out.println("Gracias por su visita....");
    }

    public static void error() {
        System.out.println("- Opción fuera de rango");
    }

    public static void menu() {
        System.out.println("\n\tPersonas");
        System.out.println("----------------------");
        System.out.println("1. Agregar ");
        System.out.println("2. Eliminar");
        System.out.println("3. Editar ");
        System.out.println("4. Listar ");
        System.out.println("5. Buscar ");
        System.out.println("6. Salir");
        System.out.print("Escoja opción [1-5]: ");
    }

    public static void inicio() {
        int opcion;
        do {
            menu();
            opcion = leer.entero();
            switch (opcion) {
                case 1:
                    agregarpersona();
                    break;
                case 2:
                    eliminarpersona();
                    break;
                case 3:
                    editarpersona();
                    break;
                case 4:
                    listarpersona();
                    break;
                case 5:
                    buscarPersona();
                    break;
                case 6:
                    salir();
                    break;
                default:
                    error();
                    break;
            }
        } while (opcion != 6);
    }

    public static void main(String[] args) {
        inicio();
    }
}
