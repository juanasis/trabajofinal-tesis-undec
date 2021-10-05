export class ItemPedido {
    producto: number;
    cantidad: number;
    precio: number;

    constructor(producto: number, cantidad:number,precio:number){
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;

    }
    
}