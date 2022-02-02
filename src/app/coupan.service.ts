import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CoupanService {

  constructor(private http:HttpClient) { }


  getcount(customerId :any, vendorId : any) : Observable<any>
  {
    return this.http.get(`http://localhost:60320/MLP319/api/coupon/count/${customerId}/${vendorId}`);
  }

  createCoupan(coupan: Object ):Observable<Object> {
    alert("In coupan service");
    return this.http.post(`http://localhost:60320/MLP319/api/coupon/create`,coupan);
  }




}
