import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class BillService {

  constructor(private http: HttpClient) { }

  getBillItem(id: number): Observable<any>{
    return this.http.get(`http://localhost:60320/MLP319/api/order/bill/${id}`);
  }

}
