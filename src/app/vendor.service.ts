import { HttpClient,HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Vendorobj } from './vendor/vendor.component';

@Injectable({
  providedIn: 'root'
})
export class VendorService {

  constructor(private http:HttpClient) { }

  vendorlogin(email:string, password:string)
  {
    return this.http.get(`http://localhost:60320/MLP319/api/vendors/find/`+email+'/'+password);
  }

  vendorregister(v:Vendorobj)
  {
    return this.http.post(`http://localhost:60320/MLP319/api/vendors/create`,v,{responseType:'text'});
  }

}

