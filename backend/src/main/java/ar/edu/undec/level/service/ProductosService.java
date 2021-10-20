package ar.edu.undec.level.service;

import ar.edu.undec.level.controller.dto.ProductoRequest;
import ar.edu.undec.level.controller.dto.Response;

import ar.edu.undec.level.storage.entity.Producto;
import ar.edu.undec.level.storage.repository.ProductosRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProductosService {
    @Autowired
    private ProductosRepository productosRepo;
    static final Logger LOGGER = LoggerFactory.getLogger(ProductosService.class);

    public Response findAll() {
        Response  response = new Response();
        List<Producto> productoList = productosRepo.findAll();
        if(productoList.isEmpty())
            response.setMessage("No hay Productos");
        else
            response.setData(productoList);
        return response;
    }
    public Response findOneById(String id) {
        Response response = new Response();
        try {
            ProductoRequest productoDTO = new ProductoRequest().getProductoDTO(productosRepo.findById(Integer.parseInt(id)).get());
            response.setData(productoDTO);

        } catch (NoSuchElementException e) {
            LOGGER.error("No existe.");
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return response;
    }
    public Response save(ProductoRequest productos) {
        Response response = new Response();
        Producto entity = new Producto();
        entity.setNombre(productos.getNombre());
        entity.setDescripcion(productos.getDescripcion());
        entity.setCantidad(productos.getCantidad());
        entity.setCategoria(productos.getCategoria());
        entity.setPrecio(productos.getPrecio());
        entity.setImgpath(productos.getImgpath());
        productosRepo.save(entity);
        response.setData("guardado");
        return response;
    }


    private Date nuevaFecha(){
        System.out.println(new Date());
        return new Date();
    }

    public Response delete(Integer id) {
            Response response = new Response();
        try {
            Producto producto = productosRepo.findById(id).get();
            productosRepo.save(producto);

            response.setMessage("Eliminado correctamente.");

        } catch (NoSuchElementException e) {
            LOGGER.error("No existe.");
        } catch (Exception e) {
            LOGGER.error("Error general.");
            throw e;
        }
        return response;


    }
    public Response findByName(String nombre) {
        Response response = new Response();
        try {
            List<Producto> productoList = productosRepo.findAllByNombreContaining(nombre);
            response.setData(productoList);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return response;
    }

    public boolean existsById(int id){
        return productosRepo.existsById(id);
    }
    public Producto getByNombre(String nombre){
        return productosRepo.findByNombre(nombre);
    }

    public Optional<Producto> getOne(int id){
        return productosRepo.findById(id);
    }

}
