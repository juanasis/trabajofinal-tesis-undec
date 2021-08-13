import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { Producto } from 'src/app/models/producto';


@Component({
  selector: 'app-productoitem',
  templateUrl: './productoitem.component.html',
  styleUrls: ['./productoitem.component.css']
})
export class ProductoitemComponent implements OnInit {
  productos: Producto[] ;
  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.http.get("http://localhost:8080/productos",{responseType: 'json'}).subscribe(
      (resp:any) =>{
      this.productos = resp.data;
       console.log(this.productos); })

  }
}
