import { Component, OnInit } from '@angular/core';
import { Producto } from 'src/app/models/producto';


@Component({
  selector: 'app-productoitem',
  templateUrl: './productoitem.component.html',
  styleUrls: ['./productoitem.component.css']
})
export class ProductoitemComponent implements OnInit {
  producto: Producto;
  constructor() { }

  ngOnInit(): void {
  }

}
