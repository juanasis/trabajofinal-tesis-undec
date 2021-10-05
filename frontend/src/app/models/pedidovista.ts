
import { Producto } from "./producto";
import { ProductoVista } from "./productovista";

export class Pedidovista {
   
    productos: ProductoVista[];

    constructor(){
        this.productos = [];
    }
    agregar(producto: Producto) {
        let productoVista = new ProductoVista(producto, 1);
        let indice = this.productos.indexOf(productoVista)
        
          if(indice === -1){
              this.productos.push(productoVista);          
          }else{
              this.productos[indice].cantidad += 1; 
          }
          
    }
}
