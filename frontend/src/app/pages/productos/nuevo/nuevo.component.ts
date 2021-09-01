import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Producto } from 'src/app/models/producto';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nuevo',
  templateUrl: './nuevo.component.html',
  styleUrls: ['./nuevo.component.css']
})
export class NuevoComponent implements OnInit {
  productosArray: Producto[];
  oldProducto: Producto = new Producto();
  selectedProducto: Producto = new Producto();

  
  constructor(private http: HttpClient, private router: Router) { }
  addOnEdit(){
    
    console.log(this.selectedProducto.id);
    this.productosArray.push(this.selectedProducto);
    this.http.post("http://localhost:8080/Productos/agregar", {
        
      "idmesa":this.selectedProducto.nombre,
      
       
    }).subscribe(
      data  => {
      console.log("POST Request is successful ", data);
      },
      error  => {
      
      console.log("Error", error);
      
      }
      
      );
  
}
salir(){
   this.router.navigate(['administrador']);

}

  ngOnInit(): void {
  }

}
