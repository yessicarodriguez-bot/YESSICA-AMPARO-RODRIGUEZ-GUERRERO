package modelo;

/**
 * Clase de objeto: representa un producto de la tienda.
 * Todos los atributos son privados (encapsulamiento) y se accede a ellos
 * mediante getters y setters.
 */
public class Producto {

    private int codigo;
    private String nombre;
    private double precio;
    private int cantidad;
    private String categoria;

    public Producto(int codigo, String nombre, double precio, int cantidad, String categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        setPrecio(precio);      // los setters validan que no haya valores negativos
        setCantidad(cantidad);
        this.categoria = categoria;
    }

    // ----- Getters y setters -----

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa.");
        }
        this.cantidad = cantidad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    // ----- Métodos del objeto -----

    /** Valor del producto en el inventario: precio por cantidad. */
    public double calcularValor() {
        return precio * cantidad;
    }

    public void mostrarInformacion() {
        System.out.println("Código: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Categoría: " + categoria);
        System.out.println("Precio: " + precio);
        System.out.println("Cantidad: " + cantidad);
    }
}
