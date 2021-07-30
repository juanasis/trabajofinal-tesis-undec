package ar.edu.undec.level.controller.dto;

public class PedidoRequest {
    private Integer idmozo;
    private Integer idmesa;
    private Integer idproducto;

    public Integer getIdMozo() {
        return idmozo;
    }

    public Integer getIdMesa() {
        return idmesa;
    }

    public Integer getIdProducto() {
        return idproducto;
    }

    public PedidoRequest(Integer idmozo, Integer idmesa, Integer idproducto) {
        this.idmozo = idmozo;
        this.idmesa = idmesa;
        this.idproducto = idproducto;
    }
}
