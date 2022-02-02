import { Component, OnInit } from '@angular/core';
import { OrderService } from '../order.service';

@Component({
  selector: 'app-fav',
  templateUrl: './fav.component.html',
  styleUrls: ['./fav.component.css']
})
export class FavComponent implements OnInit {
  fList:any=[];
  currentCustomer: any;
  constructor(private orderService:OrderService) { }

  ngOnInit(): void {
    this.currentCustomer=JSON.parse(localStorage.getItem("Customer")!);
    this.orderService.getFav(this.currentCustomer.customerId).subscribe(data=>
      {
          this.fList=data;
      });
  }

}
