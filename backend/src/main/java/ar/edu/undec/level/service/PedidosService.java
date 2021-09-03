package ar.edu.undec.level.service;

import ar.edu.undec.level.controller.dto.PedidoRequest;
import ar.edu.undec.level.controller.dto.Response;
import ar.edu.undec.level.storage.entity.EstadoPedido;
import ar.edu.undec.level.storage.entity.Pedido;
import ar.edu.undec.level.storage.repository.PedidosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PedidosService {
    @Autowired
    private PedidosRepository pedidosRepo;


    public Response save(PedidoRequest pedidos) {
        Response response = new Response();
        System.out.println(pedidos.getIdMesa()+" "+pedidos.getIdMozo()+" "+pedidos.getIdProducto());
        Pedido entity = new Pedido();
        entity.setIdMozo(pedidos.getIdMozo());
        entity.setIdMesa(pedidos.getIdMesa());

        entity.setEstado(EstadoPedido.ENCOLA);
        entity.setFecha(nuevaFecha());

        pedidosRepo.save(entity);
        response.setData("guardado");
        return response;
    }

    public Response findAll() {
        Response  response = new Response();
        List<Pedido> pedidoList = pedidosRepo.findAll();
        if(pedidoList.isEmpty())
            response.setMessage("No hay Pedidos");
        else
        response.setData(pedidoList);
        return response;
    }
    private Date nuevaFecha(){
        System.out.println(new Date());
        return new Date();
    }

    public Response delete(Integer id) {
            Response response = new Response();
            pedidosRepo.delete(pedidosRepo.getOne(id));
            response.setData("ok");
            return response;


    }
}
