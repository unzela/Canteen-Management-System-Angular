// import { Component, OnInit } from '@angular/core';
// import { ActivatedRoute, Router } from '@angular/router';
// import { CustomerService } from '../customer.service';
// import { Items } from '../items';
// import { OrderService } from '../order.service';
// @Component({
//   selector: 'app-customerorders',
//   templateUrl: './customerorders.component.html',
//   styleUrls: ['./customerorders.component.css']
// })
// export class CustomerordersComponent implements OnInit {

//   orderList:any;
//   orderList1:any;
//   order!: Items;
//   status:any;
//   cid!:any;
//   constructor(private orderService: OrderService,private router: Router,private route:ActivatedRoute,private cust:CustomerService) { }

//   ngOnInit(): void {
//     this.cid=JSON.parse(localStorage.getItem("Customer")!);
//     alert(this.cid.customerId);
//     this.orderService.getAllOrdersByCustomer(this.cid.customerId).subscribe(data=>
//       {
//           this.orderList=data;
//           console.log(data);
//       },error=>console.log(error));



//   }





// }

import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Items } from '../items';
import { OrderService } from '../order.service';
@Component({
  selector: 'app-customerorders',
  templateUrl: './customerorders.component.html',
  styleUrls: ['./customerorders.component.css']
})
export class CustomerordersComponent implements OnInit {

  orderList:any;
  placedorder:any;
  order!: Items;
  status:any;
  cid:any;
  currentCustomer:any;
  constructor(private orderService: OrderService,private router: Router,private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.currentCustomer=JSON.parse(localStorage.getItem("Customer")!);
    this.cid=this.currentCustomer.customerId;
    this.orderService.getAllOrdersByStatus(this.cid).subscribe(data=>
      {
          this.orderList=data;
          console.log(data);
      },error=>console.log(error));

      this.orderService.getAllplacedOrders(this.cid).subscribe(data=>
        {
            this.placedorder=data;
            console.log(data);
        },error=>console.log(error));



  }

}