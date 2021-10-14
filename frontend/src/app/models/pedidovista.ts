
import { Producto } from "./producto";
import { ProductoVista } from "./productovista";

export class Pedidovista {
   
    productos: ProductoVista[];

    constructor(){
        this.productos = [];
    }
    agregar(producto: Producto) {
        let productoVista = new ProductoVista(producto, 1);
        //let indice = this.productos.indexOf(productoVista)
        let indice = this.productos.findIndex( s => s.producto.nombre === productoVista.producto.nombre )
        
       
        if(indice === -1){
              this.productos.push(productoVista);          
          }else{
              
              this.productos[indice].producto.cantidad ++;
              
               
          }
        
    }
}
