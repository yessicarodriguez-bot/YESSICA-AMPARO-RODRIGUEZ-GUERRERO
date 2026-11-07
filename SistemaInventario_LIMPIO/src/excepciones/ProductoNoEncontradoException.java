package excepciones;

/**
 * Excepción personalizada que se lanza cuando se busca un producto
 * cuyo código no existe en el inventario.
 */
public class ProductoNoEncontradoException extends Exception {

    public ProductoNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}
