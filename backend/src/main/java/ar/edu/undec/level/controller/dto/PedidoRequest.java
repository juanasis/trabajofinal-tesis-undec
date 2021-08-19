package ar.edu.undec.level.controller.dto;

public class PedidoRequest {
    private Integer idmozo;
    private Integer idmesa;
    private Integer idproducto;
    private Integer iditempedido;


    public Integer getIdMozo() {
        return idmozo;
    }

    public Integer getIdMesa() {
        return idmesa;
    }

    public Integer getIditempedido() {
        return iditempedido;
    }

    public void setIditempedido(Integer iditempedido) {
        this.iditempedido = iditempedido;
    }

    public Integer getIdProducto() {
        return idproducto;
    }

    public PedidoRequest(Integer idmozo, Integer idmesa, Integer idproducto, Integer iditempedido) {
        this.idmozo = idmozo;
        this.idmesa = idmesa;
        this.idproducto = idproducto;
        this.iditempedido = iditempedido;
    }
}
