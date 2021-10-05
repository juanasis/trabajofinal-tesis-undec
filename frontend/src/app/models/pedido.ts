import { ItemPedido } from "./itempedido";
import { Producto } from "./producto";
 
export class Pedido {
    id: number;
    idmozo: number;
    idmesa: number = 0;    
    items: ItemPedido[];
    estado: String;
    fecha: Date;

    constructor(){
        this.items = [];
    }
    agregar(producto : Producto){
      let item = new ItemPedido(producto.id, 1,producto.precio);
      let indice = this.items.indexOf(item)
      
        if(indice === -1){
            this.items.push(item);          
        }else{
            this.items[indice].cantidad += 1; 
        }
        
    }
}

