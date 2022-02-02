import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Items } from '../items';
import { Menu } from '../menu';
import { MenuService } from '../menu.service';
import { OrderService } from '../order.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  id!: number;
  menu!: Menu;
  // item!: Items;

  constructor(private route: ActivatedRoute,private router: Router,private menuService: MenuService,private orderService:OrderService) { }

  ngOnInit(): void {

    this.menu = new Menu();
    this.id = this.route.snapshot.params['id'];
    this.orderId =  Math.floor(Math.random() * (1000 - 100 + 1)) + 100;
    this.menuService.getMenuItem(this.id).subscribe(data => {
      console.log(data)
      this.menu = data;
    },error => {console.log(error)});
  }

  qty : any;
  orderId:any;
  amountToBePaid:any;
  cId : any;
  otime:any;
  status:any;
  comment:any;
  token:any;

  onSubmit(){

    // alert("no of items are"+this.item.noOfItems);
    // alert("foodId is"+this.menu.foodId);
    // alert("item"+this.item);


    this.amountToBePaid = this.qty * this.menu.foodPrice;
    localStorage.setItem('orderId',this.orderId);
    var obj = new Items(this.orderId,this.menu.foodId,this.menu.vendorId,this.cId,this.qty,this.otime,this.amountToBePaid,this.token,this.status,this.comment)
    console.log(JSON.stringify(obj));
    //  console.log(this.menu);
     this.orderService.createOrder(obj).subscribe(data => {
      console.log(data);


      this.router.navigateByUrl('billing');

     },error => {console.log(error)});

  }

  list() {
    this.router.navigate(['']);
  }

  mul(price:number,noOfItems:number){
    //alert("product price "+price+" "+"No of items "+noOfItems);
    this.amountToBePaid =(price*noOfItems);
    alert("Total Amount: " + this.amountToBePaid);
  }

  getToken(){
    this.token = Math.floor(Math.random() * (500 - 100 + 1)) + 100;
  }

  getOrderId(){
    this.orderId = Math.floor(Math.random() * (500 - 100 + 1)) + 100;
  }

}