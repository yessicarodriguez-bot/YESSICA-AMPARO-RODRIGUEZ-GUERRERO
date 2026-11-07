package modelo;

/**
 * Herencia: un producto perecedero ES un Producto, pero además
 * tiene una fecha de vencimiento.
 */
public class ProductoPerecedero extends Producto {

    private String fechaVencimiento;

    public ProductoPerecedero(int codigo, String nombre, double precio, int cantidad,
                              String categoria, String fechaVencimiento) {
        super(codigo, nombre, precio, cantidad, categoria);
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    /** Polimorfismo: sobrescribe el método de la clase base y agrega la fecha. */
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Fecha de vencimiento: " + fechaVencimiento + " (perecedero)");
    }
}
