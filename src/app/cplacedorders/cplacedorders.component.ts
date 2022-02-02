import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Items } from '../items';
import { OrderService } from '../order.service';
@Component({
  selector: 'app-cplacedorders',
  templateUrl: './cplacedorders.component.html',
  styleUrls: ['./cplacedorders.component.css']
})
export class CplacedordersComponent implements OnInit {

  placedorder:any;
  odrs!: Items;
  status:any;
  currentCustomer:any;
  cid:any;
  constructor(private orderService: OrderService,private router: Router,private route:ActivatedRoute) { }



  ngOnInit(): void {
    this.currentCustomer=JSON.parse(localStorage.getItem("Customer")!);
    this.cid=this.currentCustomer.customerId;
    this.orderService.getAllplacedOrders(this.cid).subscribe(data=>
      {
          this.placedorder=data;
          console.log(data);
      },error=>console.log(error));
  }

}