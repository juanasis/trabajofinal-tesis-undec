import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginI } from '../../app/models/login.interface';
import { ResponseI } from '../../app/models/response.interface';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ApiService {
  url:string = "hhttp://localhost:8080";

  constructor(private http: HttpClient) {
  }

  loginByEmail(form:LoginI):Observable<ResponseI>{
    let direccion = this.url 
     
    return this.http.post<ResponseI>(direccion,form);
  }
   
}
