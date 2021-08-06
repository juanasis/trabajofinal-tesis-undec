import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
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

  addOnEdit(){
    
      console.log(this.selectedPedido.id);
      this.pedidosArray.push(this.selectedPedido);
      this.http.post("http://localhost:8080/pedidos/agregar", {
          
        "idmesa":this.selectedPedido.idmesa,
        "idmozo":this.selectedPedido.idmozo,
        "idproducto": this.selectedPedido.idproducto,
         
      }).subscribe(
        data  => {
        console.log("POST Request is successful ", data);
        },
        error  => {
        
        console.log("Error", error);
        
        }
        
        );
    
  }
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
      console.log("Funciona la APi REst");
      console.log(this.pedidosArray); })
}
 

}
