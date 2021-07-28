package ar.edu.undec.level.service;

import ar.edu.undec.level.controller.dto.PedidoRequest;
import ar.edu.undec.level.controller.dto.Response;
import ar.edu.undec.level.storage.entity.EstadoPedido;
import ar.edu.undec.level.storage.entity.Pedido;
import ar.edu.undec.level.storage.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidosService {
    @Autowired
    private PedidosRepository pedidosRepo;


    public Response save(PedidoRequest pedidos) {
        Response response = new Response();
        Pedido entity = new Pedido();
        entity.setIdMozo(pedidos.getIdMozo());
        entity.setIdMesa(pedidos.getIdMesa());
        entity.setIdProducto(pedidos.getIdProducto());
        entity.setEstado(EstadoPedido.ENCOLA);
        pedidosRepo.save(entity);
        response.setData("guardado");
        return response;
    }

    public Response findAll() {
        Response  response = new Response();
        List<Pedido> pedidosList = pedidosRepo.findAll();
        /*if(pedidosList.isEmpty())
            response.setMessage("No hay Pedidos");
        else */
        response.setData(pedidosList);
        return response;
    }
}
