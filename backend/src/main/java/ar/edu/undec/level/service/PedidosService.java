package ar.edu.undec.level.service;

import ar.edu.undec.level.controller.dto.PedidoRequest;
import ar.edu.undec.level.controller.dto.Response;
import ar.edu.undec.level.storage.entity.EstadoPedido;
import ar.edu.undec.level.storage.entity.Pedido;
import ar.edu.undec.level.storage.repository.PedidosRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.LoggerFactory;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PedidosService {
    @Autowired
    private PedidosRepository pedidosRepo;
    static final Logger LOGGER = LoggerFactory.getLogger(PedidosService.class);


    public Response save(PedidoRequest pedidos) {
        Response response = new Response();
        System.out.println(pedidos.getIdMesa()+" "+pedidos.getIdMozo()+" "+pedidos.getIdProducto());
        Pedido entity = new Pedido();
        entity.setIdMozo(pedidos.getIdMozo());
        entity.setIdMesa(pedidos.getIdMesa());
        entity.setEstado(EstadoPedido.ENCOLA);
        entity.setFecha(nuevaFecha());

        try {
           entity = pedidosRepo.save(entity);
           response.setData(entity);

       } catch (Exception e) {
           LOGGER.error(e.getMessage());
           e.printStackTrace();
           throw e;
       }
        return response;
    }
   /*  public Response save(Pedido pedido) {
       Response response = new Response();
       try {
           pedido = pedidosRepo.save(pedido);
           response.setData(pedido);

       } catch (Exception e) {
           LOGGER.error(e.getMessage());
           e.printStackTrace();
           throw e;
       }
       return response;
   }*/

    public Response findAll() {
        Response  response = new Response();
        try {
            List<Pedido> pedidoList = pedidosRepo.findAll();
            response.setData(pedidoList);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return response;
    }
    private Date nuevaFecha(){
        System.out.println(new Date());
        return new Date();
    }
    public Response update(Object input) {
        Response response = new Response();
        try {

            response.setData(input);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return response;
    }

    public Response delete(Integer id) {
        Response response = new Response();
        try {
            Pedido pedido = pedidosRepo.findById(id).get();
            // setear campos
            pedidosRepo.save(pedido);

            response.setMessage("Eliminado correctamente.");

        } catch (NoSuchElementException e) {
            LOGGER.error("No existe.");
            throw e;
        } catch (Exception e) {
            LOGGER.error("Error general.");
            throw e;
        }
        return response;

    }
    public Response findOneById(String id) {
        Response response = new Response();
        try {
            Pedido pedido = pedidosRepo.findById(Integer.parseInt(id)).get();
            response.setData(pedido);

        } catch (NoSuchElementException e) {
            LOGGER.error("No existe.");
            throw e;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return response;
    }
}
