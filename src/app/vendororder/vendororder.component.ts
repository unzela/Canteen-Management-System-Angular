import { hasLifecycleHook } from '@angular/compiler/src/lifecycle_reflector';
import { Component, OnInit, SystemJsNgModuleLoader } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CustService } from '../cust.service';
import { Items } from '../items';
import { OrderService } from '../order.service';

@Component({
  selector: 'app-vendororder',
  templateUrl: './vendororder.component.html',
  styleUrls: ['./vendororder.component.css']
})
export class VendororderComponent implements OnInit {

  orderList:any;
  availableqty:any;
  order!: Items;
  status:any;
  bal!:any;
  constructor(private orderService: OrderService,private router: Router,private route:ActivatedRoute,private cust :CustService) { }

  ngOnInit(): void {
    this.orderService.getAllOrderList().subscribe(data =>{
      this.orderList=data;
      console.log(data);
    },error=>console.log(error));
  }

  placeOrder(i:any){
      this.orderService.getMenuQty(i.foodId).subscribe(data=>
        {
          this.availableqty=data;
            if(i.noOfItems>data)
          {
            alert("can't Place order");
            this.cancleOrder(i);
            i.status="Not Placed";
          }
          else{
            i.status="Placed";
            this.orderService.getUpdateQty(i.foodId,this.availableqty-i.noOfItems).subscribe(data=>
              {
                  alert("Quantity is updated");
              });
            this.orderService.acceptOrder(i.orderId,i.status).subscribe(data=>
              {

              });

          }
        },error=>alert(error));

 }

 cancleOrder(i:any){
 JSON.stringify(i);
  if(i.status==="Placed")
  alert("Cant Cancel orders that are already placed");
  else if(i.status!="Not Placed")
  {

    i.status="Not Placed";
    this.orderService.acceptOrder(i.orderId,i.status).subscribe(data=>
      {

      });
      // alert("customer id is"+i.customerId);
      // this.cust.customerwalletamount(i.customerId).subscribe(added=>
      //   {
      //     this.bal=added;
      //     alert("two"+this.bal);
      //   });

      this.cust.customerwalletamount(i.customerId).subscribe(amt=>
        {

            amt+=i.amountToBePaid;

            this.cust.updatewalletamount(i.customerId,amt).subscribe(asd=>
              {

              });
        });

  }




}


}
