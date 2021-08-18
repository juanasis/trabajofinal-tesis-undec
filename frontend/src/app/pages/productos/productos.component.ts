import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Producto } from 'src/app/models/producto';



@Component({
  selector: 'app-productos',
  templateUrl: './productos.component.html',
  styleUrls: ['./productos.component.css']
})
export class ProductosComponent implements OnInit {

  productosArray: Producto[];
  bebidasArray: Producto[];
  oldproducto: Producto = new Producto();
  selectedProducto: Producto = new Producto();

  constructor(private http: HttpClient) { }

  listarBebidas(){
    this.productosArray.forEach(element => {
      if (element.categoria = 'bebidas') {
        this.bebidasArray.push(element);        
      }
      console.log("click");
    });
    
  }
  ngOnInit(): void {
    this.http.get("http://localhost:8080/productos",{responseType: 'json'}).subscribe(
      (resp:any) =>{
      this.productosArray = resp.data;
       console.log(this.productosArray); })

  }

}
