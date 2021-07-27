package ar.edu.undec.level.storage.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pedido implements Serializable {
    private Integer id;
    private Integer idMozo;
    private Integer idMesa;
    private Integer idProducto;
    private EstadoPedido estado;
    private Date fecha;
    private static final long serialVersionUID = 1L;


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId(){
        return id;
    }

    @Column(name = "idMozo")
    public Integer getIdMozo() {
        return idMozo;
    }
    @Column(name = "idMesa")
    public Integer getIdMesa() {
        return idMesa;
    }
    @Column(name = "idProducto")
    public Integer getIdProducto() {
        return idProducto;
    }
    @Column(name = "estado")
    public EstadoPedido getEstado() {
        return estado;
    }
    @Column(name = "fecha")
    public Date getFecha() {
        return fecha;
    }
    
    public void setIdMozo(int idMozo){
        this.idMozo = idMozo;
    }
    public void setIdMesa(int idMesa){
        this.idMesa = idMesa;
    }
    public void setIdProducto(int idProducto){
        this.idProducto = idProducto;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
