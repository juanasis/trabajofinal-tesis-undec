import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { ProductoI } from '../../../models/producto.interface';
import { ApiService } from '../../../services/api.service';
import { FormGroup, FormControl, Validator } from '@angular/forms';
import { PedidoDTO } from 'src/app/models/pedidoDTO';


@Component({
  selector: 'app-editar',
  templateUrl: './editarpedido.component.html'
   
})
export class EditarPedidoComponent implements OnInit {

  constructor(private activaterouter:ActivatedRoute, private router: Router, private api:ApiService) { }

  datosPedido: PedidoDTO;
   

  ngOnInit(): void {
    
  }
  
  salir(){
    this.router.navigate(['cajeros']);
   }
}
