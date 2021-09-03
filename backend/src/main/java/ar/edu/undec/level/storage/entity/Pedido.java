package ar.edu.undec.level.storage.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pedido implements Serializable {
    private Integer id;
    private Integer idmozo;
    private Integer idmesa;

    private EstadoPedido estado;
    private Date fecha;
    private static final long serialVersionUID = 1L;


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId(){
        return id;
    }
    @Column(name = "idmozo")
    public Integer getIdMozo() {
        return idmozo;
    }
    @Column(name = "idmesa")
    public Integer getIdMesa() {
        return idmesa;
    }

    @Column(name = "estado")
    public EstadoPedido getEstado() {
        return estado;
    }
    @Column(name = "fecha")
    public Date getFecha() {
        return fecha;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIdMozo(Integer idmozo) {
        this.idmozo = idmozo;
    }

    public void setIdMesa(Integer idmesa) {
        this.idmesa = idmesa;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
