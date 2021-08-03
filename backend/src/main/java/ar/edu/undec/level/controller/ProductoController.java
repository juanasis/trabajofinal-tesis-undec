package ar.edu.undec.level.controller;

import ar.edu.undec.level.controller.dto.ProductoRequest;
import ar.edu.undec.level.controller.dto.Response;
import ar.edu.undec.level.service.ProductosService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/productos")
public class ProductoController {
    private static final Logger LOG = LoggerFactory.getLogger(ProductoController.class);

    @Autowired
    private ProductosService productosService;

    @PostMapping("/agregar")
    public ResponseEntity<Response> save(@Valid @RequestBody ProductoRequest request  ){
        Response response = productosService.save(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<Response> getProductos(){
        Response response;
        response = productosService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathVariable(value = "id") Integer productoId) {
        Response response = productosService.delete(productoId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }




}
