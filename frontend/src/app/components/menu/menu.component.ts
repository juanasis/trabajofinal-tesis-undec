import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  rutas = [
    {
      path: '/cajeros',
      name: 'Cajeros'
    },
    {
      path: '/clientes',
      name: 'Clientes'
    },
    {
      path: '/cocineros',
      name: 'Cocineros'
    },
    {
      path: '/mozos',
      name: 'Mozos'
    }
  ];

  constructor() { }

  ngOnInit(): void {
  }

}
