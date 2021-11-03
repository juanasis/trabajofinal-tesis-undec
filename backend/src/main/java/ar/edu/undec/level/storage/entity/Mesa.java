package ar.edu.undec.level.storage.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Mesa implements Serializable {

    private Integer id;
    private Integer numero;
    private EstadoMesa estado;

    private static final long serialVersionUID = 1L;


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId(){
        return id;
    }
    @Column(name = "numero")
    public Integer getNumero() {
        return numero;
    }
    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    @Column(name = "estado")
    public EstadoMesa getEstado() {
        return estado;
    }
    public void setEstado(EstadoMesa estado) {
        this.estado = estado;
    }
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
