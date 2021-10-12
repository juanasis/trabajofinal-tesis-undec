import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ItemPedido } from 'src/app/models/itempedido';
import { Pedido } from 'src/app/models/pedido';

@Component({
  selector: 'app-pedidos',
  templateUrl: './pedidos.component.html',
  styleUrls: ['./pedidos.component.css']
})
export class PedidosComponent implements OnInit {

  pedidosArray: Pedido[];
  oldpedido: Pedido = new Pedido();
  selectedPedido: Pedido = new Pedido();

  openForEdit(pedido: Pedido){
    this.selectedPedido = pedido;
  }
  borrar(){
    if(confirm('Estas seguro de eliminar?')){
      this.pedidosArray = this.pedidosArray.filter(x => x != this.selectedPedido);
      
      this.http.delete("http://localhost:8080/pedidos/"+this.selectedPedido.id).subscribe(
        data  => {
        console.log("DELETE Request is successful ", data);
        },
        error  => {
        
        console.log("Error", error);
        
        }
        
        );
        this.selectedPedido=new Pedido();
    }

  }
  constructor(private http: HttpClient) { }
  ngOnInit(): void {
    this.http.get("http://localhost:8080/pedidos",{responseType: 'json'}).subscribe(
      (resp:any) =>{
      this.pedidosArray = resp.data;
       
       
        })
}
 
 
  total(pedido:Pedido):number{
    let result:number;
     
    result = 0;
    
    pedido.items.forEach(item => {
      console.log(item.producto_id);
      result += (item.precio * item.cantidad);
    });
    return result;
  }

}
