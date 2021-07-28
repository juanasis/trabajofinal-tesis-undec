package ar.edu.undec.level.controller;

import ar.edu.undec.level.controller.dto.PedidoRequest;
import ar.edu.undec.level.controller.dto.Response;
import ar.edu.undec.level.service.PedidosService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/pedidos")
public class PedidosController {
    private static final Logger LOG = LoggerFactory.getLogger(PedidosController.class);

    @Autowired
    private PedidosService pedidosService;

    @PostMapping("/agregar")
    public ResponseEntity<Response> save(@Valid @RequestBody PedidoRequest request  ){
        Response response = pedidosService.save(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<Response> getPedidos(){
        Response response;
        response = pedidosService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
