package modelo;

import excepciones.ProductoNoEncontradoException;

import java.util.ArrayList;

/**
 * Clase contenedora: el Inventario contiene (tiene una lista de) Productos.
 */
public class Inventario {

    // Arreglo simple con las categorías disponibles
    private static final String[] CATEGORIAS = {"Aseo", "Alimentos", "Tecnología"};

    private ArrayList<Producto> productos = new ArrayList<>();

    public static String[] getCategorias() {
        return CATEGORIAS;
    }

    /** Recorre el arreglo de categorías y las imprime numeradas. */
    public static void mostrarCategorias() {
        System.out.println("Categorías disponibles:");
        for (int i = 0; i < CATEGORIAS.length; i++) {
            System.out.println("  " + (i + 1) + ". " + CATEGORIAS[i]);
        }
    }

    public void agregar(Producto p) {
        for (Producto existente : productos) {
            if (existente.getCodigo() == p.getCodigo()) {
                throw new IllegalArgumentException("Ya existe un producto con el código " + p.getCodigo() + ".");
            }
        }
        productos.add(p);
    }

    /** Recorre la lista, muestra cada producto y calcula el valor total del inventario. */
    public void mostrarTodos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }
        double valorTotal = 0;
        System.out.println("----- PRODUCTOS -----");
        for (Producto p : productos) {
            p.mostrarInformacion();   // polimorfismo: cada tipo de producto se muestra a su manera
            System.out.println();
            valorTotal += p.calcularValor();
        }
        System.out.println("Valor total del inventario: " + valorTotal);
    }

    public Producto buscarPorCodigo(int codigo) throws ProductoNoEncontradoException {
        for (Producto p : productos) {
            if (p.getCodigo() == codigo) {
                return p;
            }
        }
        throw new ProductoNoEncontradoException("El producto no fue encontrado.");
    }
}
