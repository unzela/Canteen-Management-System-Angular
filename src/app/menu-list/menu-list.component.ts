import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Bill } from '../bill';
import { Menu } from '../menu';
import { Items } from '../items';
import { OrderService } from '../order.service';
import { MenuService } from '../menu.service';
import { CustService } from '../cust.service';
import { stringify } from '@angular/compiler/src/util';
import { CoupanService } from '../coupan.service';


@Component({
  selector: 'app-menu-list',
  templateUrl: './menu-list.component.html',
  styleUrls: ['./menu-list.component.css']
})


export class MenuListComponent implements OnInit {

  title = 'Hexaware CMS Application';

  diss:any=0;
  countList:any=0;
  calculation:any=0;
  menuList:any=[];
  coupenapplied:number=0;
  favourites:any;
  sum:number=0;
  menu!: Menu;
  id!: number;
  msg!: string;
  stringJson!: any;
  k!:any;
  compare!:any;
  stringObject!:any;
  ordersplaced:any;
  maxdiscount:any;
  custJson!:any;
  custname!:any;
  foodName:any;
  nooftimes:any;
  customerId!: number;
  customerName!: string;
  i: number = 0;
  value : number=0;
  bill!:Bill;
  orderplaced :any;
  token:number = Math.floor(Math.random()*(1000-100+1)+1);
  ordering!: number;
  balance!:any;
  forinserting = new Items(1,1,1,1,1,"dfgh",1,1,"sdfg","dfgh");

  config!: { itemsPerPage: number; currentPage: number; totalItems: number; };

  diff: any;
  date:any;
  date1:any;

  constructor(private menuService: MenuService,private router: Router,private route:ActivatedRoute,private orderService:OrderService,private cust:CustService,private cou:CoupanService){

    for (var i = 0; i < this.menuList.count; i++) {
      this.menuList.data.push(
        {
          id: i + 1,
          value: "items number " + (i + 1)
        }
      );
    }

    this.config = {
      itemsPerPage: 5,
      currentPage: 1,
      totalItems: this.menuList.count
    };

  }
  currentCustomer:any;
  // currentMenu:any;


  ngOnInit(): void {
    this.currentCustomer=JSON.parse(localStorage.getItem("Customer")!);
  this.menuService.getAllMenuList().subscribe(data =>{
    this.menuList=data;

    this.maxdiscount=0;

    console.log(data);
    this.date=new Date();
    var m=Number(this.date.getMonth())+1
    alert("month is"+m);
    this.k=this.date.getFullYear()+"-"+m+"-"+this.date.getDate();
    alert(this.k);

  },error=>console.log(error));
  this.cust.getcountcustomer(this.currentCustomer.customerId).subscribe(cnt=>
    {
        this.nooftimes=cnt;
    });

  }

  Search()
  {
    if(this.foodName == "")
    {
      this.ngOnInit();
    }
    else{
      this.menuList= this.menuList.filter((res: { foodName: any; }) =>
        {
          return res.foodName.toLocaleLowerCase().match(this.foodName.toLocaleLowerCase());
        });
    }
  }


  getMenuDetails(i:any){
    this.router.navigate([`details/${i}`]);

  }

  gotoList(){
    this.menuService.getAllMenuList().subscribe(data=>{
      this.menuList=data;


    })
  }

  getOrder(o:any){
      localStorage.setItem("order",o);
     this.router.navigate([`order/${o.foodId}`]);

  }


billList = new Map();

getAddItem(i:any){
  if (this.billList.has(this.menuList[i].foodId))
    {
      var obj=this.billList.get(this.menuList[i].foodId);
      obj.noOfItems+=1;
      obj.amountToBePaid=obj.amountToBePaid+this.menuList[i].foodPrice;
      this.billList.set(this.menuList[i].foodId,obj);

    }
    else{
      this.value=this.menuList[i].foodPrice;
      var order={"orderId":Math.floor(Math.random()*(1000-100+1)+1),"foodId":this.menuList[i].foodId,"vendorId":this.menuList[i].vendorId,"customerId":this.currentCustomer.customerId,"noOfItems":1,"orderDateTime":this.k,"amountToBePaid":this.menuList[i].foodPrice,"tokenNumber":this.token,"status":"Processing","comment":"poor"};
      this.billList.set(this.menuList[i].foodId,order);

      }
    this.orderplaced=this.billList.values();
}

getRemoveItem(i:any){
  if (this.billList.has(this.menuList[i].foodId))
    {
      var obj=this.billList.get(this.menuList[i].foodId);
      if(obj.noOfItems>1)
      {

      obj.noOfItems-=1;
      obj.amountToBePaid=obj.amountToBePaid-this.menuList[i].foodPrice;
      this.billList.set(this.menuList[i].foodId,obj);
      }

      else
      {
        this.billList.delete(this.menuList[i].foodId);
      }
    }

    else
    {

    }
    this.orderplaced=this.billList.values();
}



favList = new Map();

AddFavourite(i:any)
{
  if (this.favList.has(this.menuList[i].foodId))
  {
      this.favList.delete(this.menuList[i].foodId);
      this.orderService.remFav(this.menuList[i].foodId,this.currentCustomer.customerId).subscribe(data=>
        {

        });

  }
  else
  {
    alert(typeof(this.currentCustomer.customerId));
    var fav = {"foodId": this.menuList[i].foodId,"foodName": this.menuList[i].foodName,"foodQty": this.menuList[i].foodQty,"foodPrice": this.menuList[i].foodPrice,"vendorId": this.menuList[i].vendorId};
    this.favList.set(this.menuList[i].foodId,fav);
    alert("creating into db");
    this.orderService.addFav(this.menuList[i].foodId,this.currentCustomer.customerId,this.menuList[i].foodName,this.menuList[i].foodPrice).subscribe(data=>
      {

      });

  }

  this.favourites=this.favList.values();
  JSON.stringify(this.favourites);
  localStorage.setItem("fav",JSON.stringify(this.favList.values));


}





Checkout(){
  localStorage.setItem("token",this.token.toString());

  if(this.calculation!=1)
  {
    this.sum=0;
    this.maxdiscount=0;
  for (let entry of this.billList.entries())
  {
    this.sum+=entry[1].amountToBePaid;

  }
  // localStorage.setItem("max",this.maxdiscount);
  // localStorage.setItem("totalvalue",this.sum.toString());
  }

  this.cust.customerwalletamount(this.currentCustomer.customerId).subscribe(data=>
    {
        this.balance=data;
        if(this.balance>this.sum)
        {
        var iterator_obj=this.billList.entries();
        var ss=this.billList.size;
        for (let i=0;i<ss;i++){
          var id=JSON.stringify(iterator_obj.next().value[1]);

          this.orderService.createOrder(JSON.parse(id)).subscribe(d=>{

          });


        }
        alert("Thank you for placing order updating wallet amount");

        this.cust.updatewalletamount(this.currentCustomer.customerId,this.balance-this.sum).subscribe(check=>
          {
              alert("updated thank you");
          });
          this.router.navigate(['summary']);
        }
        else
        alert("You dont have sufficient amount!");
    });



}

cancleCoupon()
{
  this.calculation=0;
}

applyCoupon()
{
  localStorage.setItem("token",this.token.toString());
  this.sum=0;
  for (let entry of this.billList.entries())
  {
    this.sum+=entry[1].amountToBePaid;

  }


  localStorage.setItem("totalvalue",this.sum.toString());
  if(this.nooftimes==0 && this.calculation!=1)
  {
  alert("Hurrah you got discount of 10% upto 100 rupees");
  this.maxdiscount=this.sum*0.1;
    if(this.maxdiscount>100)
    {
      this.calculation=1;
    this.maxdiscount=100;
    alert("sum is"+this.sum);
    this.sum-=100;
    alert("sum is"+this.sum);

    localStorage.setItem("max",this.maxdiscount);
    localStorage.setItem("totalvalue",this.sum.toString());
    alert("dis is"+localStorage.getItem("max"));
    alert("amount is"+this.sum);
  }
    else
    this.sum*=0.9;
    localStorage.setItem("max",this.maxdiscount);
    localStorage.setItem("totalvalue",this.sum.toString());
    alert("dis is"+localStorage.getItem("max"));
    alert("amount is"+this.sum);
    this.calculation=1;
  }
  else
  {
    alert("you dant have any coupons");
    this.maxdiscount=0;
    localStorage.setItem("max",this.maxdiscount);
    localStorage.setItem("totalvalue",this.sum.toString());
  }
  alert(this.currentCustomer.customerId);
}

// ThirdCoupon()
// {
//   localStorage.setItem("token",this.token.toString());
//   this.sum=0;
//   for (let entry of this.billList.entries())
//   this.sum+=entry[1].amountToBePaid;

//   localStorage.setItem("totalvalue",this.sum.toString());

// }

SecondCoupon()
{
  localStorage.setItem("token",this.token.toString());
  this.sum=0;
  for (let entry of this.billList.entries())
  this.sum+=entry[1].amountToBePaid;


  localStorage.setItem("totalvalue",this.sum.toString());

 if(this.date.getMonth()+1==4)
 {
    this.orderService.getBydate(this.currentCustomer.customerId).subscribe(data=>
      {

        alert(data+"times");
        if(data>20 && this.calculation!=1)
        {
          this.calculation=1;
          alert("you got discount of 50%");
          this.maxdiscount=this.sum*0.5;
          this.sum*=0.5;
          localStorage.setItem("max",this.maxdiscount);
          localStorage.setItem("totalvalue",this.sum.toString());
          alert("dis is"+localStorage.getItem("max"));
          alert("amount is"+this.sum);
        }
        else{
          alert("Applicable only if order placed >20");
        }
      });


 }
 else
 {
  this.maxdiscount=0;
  localStorage.setItem("max",this.maxdiscount);
  localStorage.setItem("totalvalue",this.sum.toString());
  alert("dis is"+localStorage.getItem("max"));
  alert("amount is"+this.sum);
 }

}

ThirdCoupon()
{
  alert("Calling");
  let bonus=0;
  this.sum=0;
  for (let entry of this.billList.entries())
  {
    this.orderService.getcntbyvendor(this.currentCustomer.customerId,entry[1].vendorId).subscribe(data=>
      {
        alert("cust is "+this.currentCustomer.customerId+" vendor id "+entry[1].vendorId+ " count is "+data);
        if(data==1 && this.calculation!=1)
        {
          this.calculation=1;
          alert("You got discount of 5o percent since it is 1st time");
          let x = entry[1].amountToBePaid*0.5;
          bonus+=x;
          this.sum+=x;
        }
        else{
          this.sum+=entry[1].amountToBePaid;
        }
        alert("Now the bill is "+this.sum);
        localStorage.setItem("totalvalue",this.sum.toString());
        localStorage.setItem("max",bonus.toString());
      });
  }
}

checking()
{
  this.cou.getcount(1,2).subscribe(data=>
    {
        alert(data);
    });
}


creating()
{
  alert("IN menu List");
  var o={"couponName":"Final","dateCoupon":"2021-02-01","custId":4,"venId":2};
  this.cou.createCoupan(o).subscribe(data=>
    {
        alert(data);
    });
}

FourthCoupon()
{

  for (let entry of this.billList.entries())
  {
  this.sum+=entry[1].amountToBePaid;
  alert("Before the sum is"+this.sum);
  this.cou.getcount(1,2).subscribe(data=>
    {

        this.compare=data;
    });
    this.orderService.getvendororders(this.currentCustomer.customerId,entry[1].vendorId).subscribe(data=>
      {


          alert("size is"+data.length);
          this.countList=JSON.stringify(data);



          this.date = new Date(data[0].orderDateTime);
          alert(this.date);
           this.date1=new Date();
          alert(this.date1);
          this.diff=this.date1-this.date;
          // alert(this.diff);
          this.diff=this.diff/1000;
          // alert(this.diff);
          this.diff=this.diff/60;
          // alert(this.diff);
          this.diff=this.diff/60;
          // alert(this.diff);
          this.diff=this.diff/24;
          alert("diff between dates is");
          var difff=Math.round(this.diff);
          alert(Math.round(this.diff));
          if(data.length==1 && difff<15)
          {
          this.diss=this.sum*0.1;
          alert("discount iss"+this.diss);
          this.sum*=0.9;
          alert("total sum is"+this.sum);
          localStorage.setItem("totalvalue",this.sum.toString());
          localStorage.setItem("max",this.diss.toString());
          alert("After sum is"+this.sum);
          }
          else if(data.length==0)
          {
            // var o={"couponName":"Final","dateCoupon":"2021-04-07","custId":this.currentCustomer.customerId,"venId":entry[1].vendorId};
            alert("creating coupen for next order");
            // this.cou.createCoupan(o).subscribe(data=>
            //   {
            //       alert(data);
            //   });
              localStorage.setItem("totalvalue",this.sum.toString());
          localStorage.setItem("max",this.diss.toString());
          alert("After sum is"+this.sum);
          }


          alert("total is "+localStorage.getItem("totalvalue")+"dis is"+localStorage.getItem("max"));

          // var daysDifference = Math.floor(this.diff/1000/60/60);
          // alert(daysDifference);
      });
    }
}




pageChanged(event: number){
  this.config.currentPage = event;
}

gotoCplacedorders()
  {
    alert("You are redirecvting to vendor oredering");
    this.router.navigate(['cplacedorders']);
  }


sortincr()
{
    this.menuList=this.menuList.sort(GetSortOrder("foodPrice"));
}

sortdecr()
{
  this.menuList=this.menuList.sort(Sortprice("foodPrice"));
}


// searchbutton()
// {
//   // var x = document.getElementById("searchbar").t;
//   // alert(x?.innerText);
// }

}


function GetSortOrder(prop :any) {

  return function(a :any, b : any) {
      if (a[prop] > b[prop]) {

          return 1;
      } else if (a[prop] < b[prop]) {

          return -1;
      }
      return 0;
  }
}


function Sortprice(prop :any) {

  return function(a :any, b : any) {
      if (a[prop] > b[prop]) {

          return -1;
      } else if (a[prop] < b[prop]) {

          return 1;
      }
      return 0;
  }



}


