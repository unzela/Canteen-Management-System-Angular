import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Customerobj } from './customer/customer.component';

@Injectable({
  providedIn: 'root'
})
export class CustService {

  constructor(private http:HttpClient) { }

  customerlogin(email:string,password:string)
  {
    return this.http.get(`http://localhost:60320/MLP319/api/customers/find/`+email+'/'+password);
  }

  customerregister(c:Customerobj)
  {
    return this.http.post(`http://localhost:60320/MLP319/api/customers/create/`,c,{responseType:'text'});
  }

  customerwalletamount(id:any)
  {
    return this.http.get(`http://localhost:60320/MLP319/api/customers/walletamount/`+id);
  }

  getcountcustomer(id:any)
  {
    return this.http.get(`http://localhost:60320/MLP319/api/order/count/`+id);
  }



  updatewalletamount(id :any, amount :any)
  {
    return this.http.put(`http://localhost:60320/MLP319/api/customers/updatewa/`+id+'/'+amount,{responseType:'text'});
  }

}
