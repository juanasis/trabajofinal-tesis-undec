import { Component, OnInit } from '@angular/core';
import { TokenService } from 'src/app/pages/login/service/token.service';

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
      path: '/administrador', name: 'Administracion'
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
  
  isLogged = false;
  constructor(private tokenService: TokenService) { }
  onLogOut(): void {
    this.tokenService.logOut();
    window.location.reload();
  }
  ngOnInit(): void {
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

}
