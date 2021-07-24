package ar.edu.undec.level.controller.dto;

public class PedidoRequest {
    private Integer idMozo;
    private Integer idMesa;
    private Integer idProducto;

    public Integer getIdMozo() {
        return idMozo;
    }

    public Integer getIdMesa() {
        return idMesa;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public PedidoRequest(Integer idMozo, Integer idMesa, Integer idProducto) {
        this.idMozo = idMozo;
        this.idMesa = idMesa;
        this.idProducto = idProducto;
    }
}
