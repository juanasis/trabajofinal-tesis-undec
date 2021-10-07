
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
        let indice = this.productos.findIndex( s => s.producto.nombre == productoVista.producto.nombre )
        console.log("indice: " + indice); 
       
        if(indice === -1){
              this.productos.push(productoVista);          
          }else{
              console.log("dentro del else");
              this.productos[indice].cantidad += 1; 
          }
          console.log("cantidad de productos: " + (this.productos.length)); 
          console.log("cantidad de tragos: " + (this.productos[0].producto.cantidad)); 
    }
}
