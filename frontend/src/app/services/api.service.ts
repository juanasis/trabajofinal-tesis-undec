import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';



@Injectable({
  providedIn: 'root'
})
export class ApiService {
  url:string = "hhttp://localhost:8080/";

  constructor(private http: HttpClient) {
  }

   
}
