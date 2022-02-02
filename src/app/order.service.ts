import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Items } from './items';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http:HttpClient) { }

  createOrder(item:any){
    JSON.stringify(item);
    return this.http.post(`http://localhost:60320/MLP319/api/order/create`,item,{responseType:"text"});

  }

  getAllOrderList(): Observable<any>{
    return this.http.get(`http://localhost:60320/MLP319/api/order/list`);
  }

  getAllOrdersByCustomer(customerid: any) : Observable<any>
  {
    return this.http.get(`http://localhost:60320/MLP319/api/order/listcus/${customerid}`);
  }



  acceptOrder(orderid : any , status: any)
  {
    return this.http.put(`http://localhost:60320/MLP319/api/order/updatestatus/${orderid}/${status}`,{responseType:"text"});
  }

  rejectOrder(orderid : any, status :any)
  {
    return this.http.put(`http://localhost:60320/MLP319/api/order/updatestatus/${orderid}/${status}`,{responseType:"text"});
  }

  getWalletAmount(customerid : any)
  {
    return this.http.get(`http://localhost:60320/MLP319/api/customers/amount/${customerid}`,{responseType:"text"});
  }


  getAllOrdersByStatus(customerid: any) : Observable<any>
  {
    return this.http.get(`http://localhost:60320/MLP319/api/order/list/${customerid}/placed`);
  }
  getAllplacedOrders(customerid: any) : Observable<any>
  {
    return this.http.get(`http://localhost:60320/MLP319/api/order/listplaced/${customerid}/placed`);
  }


  getAllordersbytoken(token:any) : Observable<any>
  {
    return this.http.get(`http://localhost:60320/MLP319/api/order/sameorder/${token}`);
  }

  getMenuQty(foodId:any)
  {
    return this.http.get(`http://localhost:60320/MLP319/api/menu/qty/${foodId}`);
  }


  getUpdateQty(foodId : any, foodQty :any)
  {
    return this.http.put(`http://localhost:60320/MLP319/api/menu/update/{foodId}/{foodQty}`,{responseType:"text"});
  }

  addFav(foodId : any, customerId : any, foodName :any , foodPrice :any)
  {
    alert("calling..............");
    return this.http.post(`http://localhost:60320/MLP319/api/order/addfav/${foodId}/${customerId}/${foodName}/${foodPrice}`,{responseType:"text"});
  }

  remFav(foodId : any, customerId : any)
  {
    alert("deleting");
    return this.http.delete(`http://localhost:60320/MLP319/api/order/del/${foodId}/${customerId}`);
  }

  getFav(customerId:any) : Observable<any>
  {
    alert("calling fav");
    return this.http.get(`http://localhost:60320/MLP319/api/order/listfav/${customerId}`);
  }

  getBydate(customerId : any)
  {
    return this.http.get(`http://localhost:60320/MLP319/api/order/cntbydate/${customerId}`);
  }

  getcntbyvendor(customerId : any, vendorId : any)
  {
    return this.http.get(`http://localhost:60320/MLP319/api/order/cntbyvendor/${customerId}/${vendorId}`);
  }

  getvendororders(customerId :any, vendorId : any) : Observable<any>
  {
    return this.http.get(`http://localhost:60320/MLP319/api/order/counting/${customerId}/${vendorId}`);
  }


}