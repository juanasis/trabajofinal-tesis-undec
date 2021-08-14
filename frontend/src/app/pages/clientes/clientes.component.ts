import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { Pedido } from 'src/app/models/pedido';
import { Pedidovista } from 'src/app/models/pedidovista';
import { Producto } from 'src/app/models/producto';

@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styleUrls: ['./clientes.component.css']
})
export class ClientesComponent implements OnInit {
  productos: Producto[] ;
  pedido: Pedido;
  pedidovista: Pedidovista;
  
  constructor(private http: HttpClient) {// private mozo: Mozo, private) {  
    this.pedido = new Pedido();
    this.pedidovista = new Pedidovista();
    this.pedido.idmozo= 1;
    this.pedido.idmesa = 1;
  }

  agregarProducto(producto: Producto){
    /*chequear si el producto ya existe e incrementar uno*/
    //this.pedido.listadeproductos.push(producto.id, 1);
    this.pedido.idproducto = producto.id;
    this.pedidovista.producto = producto;
    this.pedidovista.cantidad = 1;
  }
  guardarpedido(){
    this.http.post("http://localhost:8080/pedidos/agregar", this.pedido).subscribe(
      data  => {
      console.log("POST Request is successful ", data);
      },
      error  => {
      
      console.log("Error", error);
      
      }
      
    )
    
  }
  /*ngOnInit(): void {
    this.productos = new Array(1);
    this.productos[0] = new Producto();
    this.productos[0].nombre = "Cerveza Negra";
    this.productos[0].precio = 300;
    this.productos[0].imgpath= "../../../assets/productos/budweiser.jpg"
    */
    ngOnInit(): void {
    this.http.get("http://localhost:8080/productos",{responseType: 'json'}).subscribe(
      (resp:any) =>{
      this.productos = resp.data;
       console.log(this.productos); })

  }


 
}

