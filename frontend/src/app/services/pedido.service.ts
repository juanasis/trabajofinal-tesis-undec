import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Pedido } from '../models/pedido';
 
@Injectable({
  providedIn: 'root'
})
export class PedidoService {

  pedidoURL = 'http://localhost:8080/pedidos';

  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<Pedido[]> {
    return this.httpClient.get<Pedido[]>(this.pedidoURL);
  }

  public detail(id: number): Observable<Pedido> {
    return this.httpClient.get<Pedido>(this.pedidoURL + `/${id}`);
  }

 public save(pedido: Pedido): Observable<any> {
    return this.httpClient.post<any>(this.pedidoURL + 'agregar', pedido);
  }

  public update(id: number, pedido: Pedido): Observable<any> {
    return this.httpClient.put<any>(this.pedidoURL + `update/${id}`, pedido);
  }

  public delete(id: number): Observable<any> {
    return this.httpClient.delete<any>(this.pedidoURL + `delete/${id}`);
  }
}