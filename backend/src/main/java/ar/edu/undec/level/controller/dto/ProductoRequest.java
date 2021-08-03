package ar.edu.undec.level.controller.dto;

public class ProductoRequest {
    public String nombre;
    public String descripcion;
    public int cantidad;
    public String categoria;
    public double precio;

    public ProductoRequest(String nombre, String descripcion, int cantidad, String categoria, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.categoria = categoria;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPrecio() {
        return precio;
    }
}
