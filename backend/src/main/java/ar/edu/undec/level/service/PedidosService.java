package ar.edu.undec.level.service;

import ar.edu.undec.level.controller.dto.ItemPedidoDto;
import ar.edu.undec.level.controller.dto.PedidoDto;
import ar.edu.undec.level.controller.dto.PedidoRequest;
import ar.edu.undec.level.controller.dto.Response;
import ar.edu.undec.level.storage.entity.EstadoPedido;
import ar.edu.undec.level.storage.entity.ItemPedido;
import ar.edu.undec.level.storage.entity.Pedido;
import ar.edu.undec.level.storage.repository.ItemPedidoRepository;
import ar.edu.undec.level.storage.repository.PedidosRepository;
import ar.edu.undec.level.storage.repository.ProductosRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PedidosService {
    @Autowired
    private PedidosRepository pedidosRepo;
    @Autowired
    private ItemPedidoRepository itemPedidoRepo;
    @Autowired
    private ProductosRepository productosRepo;
    static final Logger LOGGER = LoggerFactory.getLogger(PedidosService.class);


    public Response save(PedidoRequest request) {
        Response response = new Response();
        Pedido entity = new Pedido();
        entity.setIdMozo(request.getIdMozo());
        entity.setIdMesa(request.getIdMesa());
        entity.setEstado(EstadoPedido.ENCOLA);
        entity.setFecha(nuevaFecha());


        try {
           entity = pedidosRepo.save(entity);
           entity.setitemsList(getListaItems(request, entity));
           response.setData(entity);

       } catch (Exception e) {
           LOGGER.error(e.getMessage());
           e.printStackTrace();
           throw e;
       }
        return response;
    }

    private List<ItemPedido> getListaItems(PedidoRequest pedidoRequest, Pedido entity) {
        List<ItemPedido> result = new ArrayList<>();

        for (ItemPedidoDto itemPedidoDto: pedidoRequest.getItems()) {
            ItemPedido item = new ItemPedido(itemPedidoDto);
            item.setPedido(entity);
            item.setProducto(productosRepo.getOne(itemPedidoDto.getProducto_id()));
            result.add(item);
            itemPedidoRepo.save(item);
        }
        return result;
    }
    public Response findAll() {
        Response  response = new Response();
        try {
            List<Pedido> pedidosList = pedidosRepo.findAll();
            List<PedidoDto> pedidosDto = new ArrayList<>();
            for (Pedido pedidoEntity: pedidosList                ) {
                 PedidoDto pedidoDto  = new PedidoDto(pedidoEntity);
                 pedidosDto.add(pedidoDto);
            }
            response.setData(pedidosDto);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return response;
    }
   public Response findOneById(String id) {
        Response response = new Response();
        try {
            Pedido pedido = pedidosRepo.findById(Integer.parseInt(id)).get();
            PedidoDto pedidoDto = new PedidoDto(pedido);
            response.setData(pedidoDto);

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

    //Formatear fecha
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

}
