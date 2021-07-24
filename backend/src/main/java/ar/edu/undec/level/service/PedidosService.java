package ar.edu.undec.level.service;

import ar.edu.undec.level.controller.dto.PedidoRequest;
import ar.edu.undec.level.controller.dto.Response;
import ar.edu.undec.level.storage.entity.Pedido;
import ar.edu.undec.level.storage.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidosService {
    @Autowired
    private PedidosRepository pedidosRepo;


    public Response save(PedidoRequest pedido) {
        Response response = new Response();
        Pedido entity = new Pedido();
        //hacer el constructor con los get
        pedidosRepo.save(entity);
        response.setData("guardado");
        return response;
    }

}
