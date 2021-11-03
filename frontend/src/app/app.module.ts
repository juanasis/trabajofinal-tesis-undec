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
import { ToastrModule } from 'ngx-toastr';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { interceptorProvider } from "src/environments/universal-appInterceptor";
import { EditarPedidoComponent } from "./pages/pedidos/editarpedido/editarpedido.component";
import { UploadFilesComponent } from 'src/app/components/upload-files/upload-files.component';
@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    PedidosComponent,
    EditarPedidoComponent,
    ProductosComponent,
    CajerosComponent,
    MozosComponent,
    CocinerosComponent,
    ClientesComponent,
    routingComponents,
    AdministradorComponent,
    UploadFilesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,  
    PagesModule,
    ToastrModule.forRoot(),
    FormsModule,    
    BrowserAnimationsModule,
    HttpClientModule,ReactiveFormsModule
  ],
  providers: [interceptorProvider],
  bootstrap: [AppComponent]
})
export class AppModule { }
