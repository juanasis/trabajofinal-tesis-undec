import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
 
import { CajerosComponent } from "./cajeros/cajeros.component";
import { ClientesComponent } from "./clientes/clientes.component";
import { CocinerosComponent } from "./cocineros/cocineros.component";
import { MozosComponent } from "./mozos/mozos.component";
import { ProductoitemComponent } from './clientes/productoitem/productoitem.component';
import { AdministradorComponent } from './administrador/administrador.component';




@NgModule({
    declarations: [
      
      ProductoitemComponent,
      
      AdministradorComponent],
    imports: [
      CommonModule
    ],
    exports: [
           
    ]
  })
  export class PagesModule {
  }