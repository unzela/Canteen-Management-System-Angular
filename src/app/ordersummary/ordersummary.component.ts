import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OrderService } from '../order.service';

@Component({
  selector: 'app-ordersummary',
  templateUrl: './ordersummary.component.html',
  styleUrls: ['./ordersummary.component.css']
})
export class OrdersummaryComponent implements OnInit {
  summary:any;
  value:any;
  max:any;
  constructor(private orderService: OrderService,private router: Router) { }

  ngOnInit(): void {

    this.value=localStorage.getItem("totalvalue");
    this.orderService.getAllordersbytoken(localStorage.getItem("token")).subscribe(data=>
      {
          this.summary=data;
          this.max=localStorage.getItem("max");
      },error=>console.log(error));
  }

  gotoCustomerOrders()
  {
    this.router.navigate(['customerorders']);
  }



}
