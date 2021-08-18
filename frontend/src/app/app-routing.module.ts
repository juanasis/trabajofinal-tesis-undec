import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdministradorComponent } from './pages/administrador/administrador.component';
import { CajerosComponent } from './pages/cajeros/cajeros.component';
import { ClientesComponent } from './pages/clientes/clientes.component';
import { CocinerosComponent } from './pages/cocineros/cocineros.component';
import { MozosComponent } from './pages/mozos/mozos.component';
 
const routes: Routes = [  {
  path: 'cajeros',
  component: CajerosComponent
},
{
  path: 'mozos',
  component: MozosComponent
},
{
  path: 'cocineros',
  component: CocinerosComponent
},
{
  path: 'administrador', component: AdministradorComponent
},
{
  path: 'clientes',
  component: ClientesComponent
},
{
  path: '**',
  redirectTo: 'Inicio'
} ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
