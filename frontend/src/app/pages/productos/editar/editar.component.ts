import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { ProductoI } from '../../../models/producto.interface';
import { ApiService } from '../../../services/api.service';
import { FormGroup, FormControl, Validator } from '@angular/forms';


@Component({
  selector: 'app-editar',
  templateUrl: './editar.component.html',
  styleUrls: ['./editar.component.css']
})
export class EditarComponent implements OnInit {

  constructor(private activaterouter:ActivatedRoute, private router: Router, private api:ApiService) { }

  datosProducto: ProductoI;
  editarFor = new FormGroup({
     nombre: new FormControl('')
  })

  ngOnInit(): void {
    let productoid = this.activaterouter.snapshot.paramMap.get('id');
    console.log(productoid);
    this.api.getSingleProducto(productoid).subscribe(data =>{
      this.datosProducto = data[0];
      console.log(this.datosProducto);
    })
  }
  
  salir(){
    this.router.navigate(['administrador']);
   }
}
