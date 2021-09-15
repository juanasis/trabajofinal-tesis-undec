package ar.edu.undec.level.controller.dto;

import ar.edu.undec.level.storage.entity.EstadoPedido;
import ar.edu.undec.level.storage.entity.ItemPedido;
import ar.edu.undec.level.storage.entity.Pedido;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class PedidoDto {
    private EstadoPedido estado;
    private Date fecha;
    private List<ItemProductoDto> itemProductoDtoList = new ArrayList<>();
    private Integer idMesa;


    public PedidoDto() {
    }

    public PedidoDto(Pedido pedido) {
        this.estado = pedido.getEstado();
        this.fecha = pedido.getFecha();
        this.idMesa = pedido.getIdMesa();
        this.itemProductoDtoList = getProdutos(pedido.getItemsList());
    }

    private List<ItemProductoDto> getProdutos(Collection<ItemPedido> itemsList) {
        List<ItemProductoDto> result = new ArrayList<>();
        for (ItemPedido item: itemsList     ) {
            ItemProductoDto itemDto = new ItemProductoDto();
            itemDto.setNombre(item.getProducto().getNombre());
            itemDto.setCantidad(item.getCantidad());
            itemDto.setPrecio(item.getPrecio());
            result.add(itemDto);
        }

        return result;
    }


    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<ItemProductoDto> getItemProductoDtoList() {
        return itemProductoDtoList;
    }

    public void setItemProductoDtoList(List<ItemProductoDto> itemProductoDtoList) {
        this.itemProductoDtoList = itemProductoDtoList;
    }
}
