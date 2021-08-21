import { HttpClientModule } from "@angular/common/http";
import { NgModule } from "@angular/core";
import { ReactiveFormsModule,FormsModule } from "@angular/forms";
import { BrowserModule } from "@angular/platform-browser";
import { AppRoutingModule, routingComponents} from "./app-routing.module";
import { AppComponent } from "./app.component";
import { MenuComponent } from "./components/menu/menu.component";
import { AdministradorComponent } from "./pages/administrador/administrador.component";
import { CajerosComponent } from "./pages/cajeros/cajeros.component";
import { ClientesComponent } from "./pages/clientes/clientes.component";
import { CocinerosComponent } from "./pages/cocineros/cocineros.component";
import { MozosComponent } from "./pages/mozos/mozos.component";
import { PagesModule } from "./pages/pages.module";
import { PedidosComponent } from "./pages/pedidos/pedidos.component";
import { ProductosComponent } from "./pages/productos/productos.component";
 

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    PedidosComponent,
    ProductosComponent,
    CajerosComponent,
    MozosComponent,
    CocinerosComponent,
    ClientesComponent,
    routingComponents,
    AdministradorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,  
    PagesModule,    
    FormsModule,    
    HttpClientModule,ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
