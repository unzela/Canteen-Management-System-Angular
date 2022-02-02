import { HttpClient } from '@angular/common/http';
import { EventEmitter, Injectable, Input } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Customer } from './customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

username!: string;
password!: string;
email!:string;

  private baseUrl = "http://localhost:60320/MLP319/api/customers";

  private baseUrl1 = "http://localhost:60320/MLP319/api/customers/find";



  constructor(private http: HttpClient,private router: Router) { }


  createCustomer(customer:Object): Observable<Object> {

    return this.http.post(`${this.baseUrl}/create`, customer);
  }

   logincustomer(logincustomer: Customer): Observable<any>{
    return  this.http.get(`${this.baseUrl1}/${logincustomer.customerEmail}/${logincustomer.customerPassword}`,{ responseType: 'text' });
   }

   deleteCustomer(id: number){
     return this.http.delete(`${this.baseUrl1}/delete/${id}`,{ responseType: 'text'});
   }

  sendUser(username:string){
   return  this.username=username;
  }

  getUser(){
    return this.username;
  }

 updateCustomer(customer:Object): Observable<Object> {
  return this.http.put(`${this.baseUrl}/update`, customer);
 }

 getAllOrdersByStatus(customerid: any,status:any) : Observable<any>
  {
    return this.http.get(`http://localhost:60320/MLP319/api/order/list/${customerid}/${status}`,{responseType:'text'});
  }



}
