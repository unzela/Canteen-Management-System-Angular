import { Component, OnInit } from '@angular/core';
import { FormControl ,FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CustService } from '../cust.service';




@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  title="Customer Registration Form";

  constructor(private router: Router,private cust:CustService) { }

  ngOnInit(): void {
  }
  c!:Customerobj;







  contactFrom = new FormGroup({
    cid: new FormControl('', [Validators.required, Validators.minLength(5)]),
    cname: new FormControl('', [Validators.required,Validators.minLength(5)]),
    cemail: new FormControl('', [Validators.required,Validators.email]),
    cmobile: new FormControl('', [Validators.required,Validators.minLength(10)]),
    cpassword: new FormControl('', [Validators.required]),
    caddress: new FormControl('', [Validators.required]),
    cwallet: new FormControl('', [Validators.required]),
    camount: new FormControl('', [Validators.required])
      })

 onSubmit(){

    this.c=new Customerobj(
      this.contactFrom.get('cid')?.value,
      this.contactFrom.get('cname')?.value,
      this.contactFrom.get('cemail')?.value,
      this.contactFrom.get('cmobile')?.value,
      this.contactFrom.get('cpassword')?.value,
      this.contactFrom.get('caddress')?.value,
      this.contactFrom.get('cwallet')?.value,
      this.contactFrom.get('camount')?.value
    );
    this.cust.customerregister(this.c).subscribe(data=>
      {
        // if(data==='true')
        // {
        //   alert ("register succes");
        // }
        // else
        // {
        //   alert("not sucees");

        // }
        console.log(data);
        this.router.navigate(['menu']);
      })
  }


}

export class Customerobj
{
  customerId! : number;
  customerName! :string;
  customerEmail!: string;
  customerMobile!:string;
  customerPassword!:string;
  customerAddress!:string;
  walletName!:string;
  walletAmount!:number;


  constructor(
  customerId : number,
  customerName :string,
  customerEmail: string,
  customerMobile:string,
  customerPassword:string,
  customerAddress:string,
  walletName:string,
  walletAmount:number
  )
  {
      this.customerId=customerId;
      this.customerName=customerName;
      this.customerEmail=customerEmail;
      this.customerMobile=customerMobile;
      this.customerPassword=customerPassword
      this.customerAddress=customerAddress;
      this.walletName=walletName;
      this.walletAmount=walletAmount;
  }

}


