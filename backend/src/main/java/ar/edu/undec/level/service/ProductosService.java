package ar.edu.undec.level.service;

import ar.edu.undec.level.controller.dto.ProductoRequest;
import ar.edu.undec.level.controller.dto.Response;

import ar.edu.undec.level.storage.entity.Producto;
import ar.edu.undec.level.storage.repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductosService {
    @Autowired
    private ProductosRepository productosRepo;


    public Response save(ProductoRequest productos) {
        Response response = new Response();
        Producto entity = new Producto();
        entity.setNombre(productos.getNombre());
        entity.setDescripcion(productos.getDescripcion());
        entity.setCantidad(productos.getCantidad());
        entity.setCategoria(productos.getCategoria());
        entity.setPrecio(productos.getPrecio());
        productosRepo.save(entity);
        response.setData("guardado");
        return response;
    }

    public Response findAll() {
        Response  response = new Response();
        List<Producto> productoList = productosRepo.findAll();
        if(productoList.isEmpty())
            response.setMessage("No hay Productos");
        else
        response.setData(productoList);
        return response;
    }
    private Date nuevaFecha(){
        System.out.println(new Date());
        return new Date();
    }

    public Response delete(Integer id) {
            Response response = new Response();
            productosRepo.delete(productosRepo.getOne(id));
            response.setData("ok");
            return response;


    }
}
