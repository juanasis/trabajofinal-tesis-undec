import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginI } from '../../app/models/login.interface';
import { ResponseI } from '../../app/models/response.interface';
import { Observable } from 'rxjs';
import { ProductoI } from '../models/producto.interface';
import { Producto } from '../models/producto';


@Injectable({
  providedIn: 'root'
})
export class ApiService {
  url:string = "hhttp://localhost:8080/";

  constructor(private http: HttpClient) {
  }

   
}
