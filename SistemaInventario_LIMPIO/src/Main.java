import excepciones.ProductoNoEncontradoException;
import modelo.Inventario;
import modelo.Producto;
import modelo.ProductoPerecedero;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventario inventario = new Inventario();
        int opcion = 0;

        do {
            System.out.println("=================================");
            System.out.println("      SISTEMA DE INVENTARIO");
            System.out.println("=================================");
            System.out.println("1. Registrar producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Buscar producto");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            // Error 1: entrada inválida (try-catch estándar)
            try {
                opcion = Integer.parseInt(scanner.nextLine().trim());

                switch (opcion) {
                    case 1:
                        registrarProducto(scanner, inventario);
                        break;
                    case 2:
                        inventario.mostrarTodos();
                        break;
                    case 3:
                        buscarProducto(scanner, inventario);
                        break;
                    case 4:
                        System.out.println("Hasta pronto.");
                        break;
                    default:
                        System.out.println("Opción no válida. Elija un número del 1 al 4.");
                }
            } catch (NumberFormatException e) {
                opcion = 0;
                System.out.println("Debe ingresar un número válido.");
            }
            System.out.println();
        } while (opcion != 4);

        scanner.close();
    }

    private static void registrarProducto(Scanner scanner, Inventario inventario) {
        System.out.print("Código: ");
        int codigo = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine().trim();
        System.out.print("Precio: ");
        double precio = Double.parseDouble(scanner.nextLine().trim());
        System.out.print("Cantidad: ");
        int cantidad = Integer.parseInt(scanner.nextLine().trim());

        Inventario.mostrarCategorias();
        System.out.print("Seleccione la categoría: ");
        int indice = Integer.parseInt(scanner.nextLine().trim());
        if (indice < 1 || indice > Inventario.getCategorias().length) {
            System.out.println("Categoría no válida. No se registró el producto.");
            return;
        }
        String categoria = Inventario.getCategorias()[indice - 1];

        System.out.print("¿Es perecedero? (s/n): ");
        boolean perecedero = scanner.nextLine().trim().equalsIgnoreCase("s");
        String vencimiento = "";
        if (perecedero) {
            System.out.print("Fecha de vencimiento (dd/mm/aaaa): ");
            vencimiento = scanner.nextLine().trim();
        }

        // Error 2 (extra): segundo try-catch para validar precio/cantidad negativos o código repetido
        try {
            Producto p;
            if (perecedero) {
                p = new ProductoPerecedero(codigo, nombre, precio, cantidad, categoria, vencimiento);
            } else {
                p = new Producto(codigo, nombre, precio, cantidad, categoria);
            }
            inventario.agregar(p);
            System.out.println("Producto registrado correctamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void buscarProducto(Scanner scanner, Inventario inventario) {
        System.out.print("Ingrese el código: ");
        int codigo = Integer.parseInt(scanner.nextLine().trim());

        // Excepción personalizada
        try {
            Producto p = inventario.buscarPorCodigo(codigo);
            p.mostrarInformacion();
        } catch (ProductoNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
