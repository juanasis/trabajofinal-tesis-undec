package ar.edu.undec.level.storage.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Producto implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre")
   private String nombre;
    @Column(name = "descripcion")
   private String descripcion;
    @Column(name = "cantidad")
   private Integer cantidad;
    @Column(name = "categoria")
   private  String categoria;
    @Column(name = "imgpath")
    private  String imgpath;
    @Column(name = "precio")
   private Double precio;
   private Collection<ItemPedido> pedidosList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }
    @OneToMany(mappedBy = "producto")
    public Collection<ItemPedido> getPedidosList() {
        return pedidosList;
    }

    public void setPedidosList(Collection<ItemPedido> pedidosList) {
        this.pedidosList = pedidosList;
    }
}
