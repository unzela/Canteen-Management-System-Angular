import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Vendor } from './vendor';

@Injectable({
  providedIn: 'root'
})
export class VnedorService {

  username!: string;
  password!: string;
  email!:string;

  private baseUrl = "http://localhost:60320/MLP319/api/vendor";

  constructor(private router: Router,private http:HttpClient) { }

  loginvendor(loginVendor:Vendor): Observable<any>{
    return  this.http.get(`${this.baseUrl}/${loginVendor.vendorEmail}/${loginVendor.vendorPassword}`,{ responseType: 'text' });
   }

}
