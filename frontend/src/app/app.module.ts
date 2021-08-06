import { HttpClientModule } from "@angular/common/http";
import { NgModule } from "@angular/core";
import { FormsModule } from "@angular/forms";
import { BrowserModule } from "@angular/platform-browser";
import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { MenuComponent } from "./components/menu/menu.component";
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
    ClientesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,  
    PagesModule,    
    FormsModule,    
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
