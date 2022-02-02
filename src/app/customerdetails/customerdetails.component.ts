import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';


@Component({
  selector: 'app-customerdetails',
  templateUrl: './customerdetails.component.html',
  styleUrls: ['./customerdetails.component.css']
})
export class CustomerdetailsComponent implements OnInit {

  currentCustomer:any;
  customer!:Customer;
  cid:any;
  cname:any;
  cemail:any;
  cmobile:any;
  caddress:any;
  cpass:any;
  cwname:any;
  cwamt:any;
  constructor(private cust:CustomerService, private route:Router) { }

  ngOnInit(): void {

    this.currentCustomer=JSON.parse(localStorage.getItem("Customer")!);

    this.cid=this.currentCustomer.customerId;
    this.cname=this.currentCustomer.customerName;
    this.cemail=this.currentCustomer.customerEmail;
    this.cmobile=this.currentCustomer.customerMobile;
    this.caddress=this.currentCustomer.customerAddress;
    this.cpass=this.currentCustomer.customerPassword;
    this.cwname=this.currentCustomer.walletName;
    this.cwamt=this.currentCustomer.walletAmount;
  }

  onSubmit(){
    //alert("cwamt is"+this.cwname);
    this.customer= new Customer();
    this.customer.customerId=this.cid;
    this.customer.customerName=this.cname;
    this.customer.customerEmail=this.cemail;
    this.customer.customerMobile=this.cmobile;
    this.customer.customerAddress=this.caddress;
    this.customer.customerPassword=this.cpass;
    this.customer.walletName=this.cwname;
    this.customer.walletAmount=this.cwamt;

    this.cust.updateCustomer(this.customer).subscribe(data => {
      console.log(data);


    },error=>console.log(error));
    this.route.navigate(['menu']);
  }


}