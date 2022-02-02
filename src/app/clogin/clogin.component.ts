
import { Component, OnInit } from '@angular/core';
import { FormControl ,FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
 import { CustService } from '../cust.service';
 import { Observable } from 'rxjs';
import { Customer } from '../customer';



@Component({
  selector: 'app-clogin',
  templateUrl: './clogin.component.html',
  styleUrls: ['./clogin.component.css']
})
export class CloginComponent implements OnInit {
  title="Customer Login Form";

  constructor(private router: Router,private cust:CustService) { }

  ngOnInit(): void {
  }
email!:string;
password!:string;
customer!: Observable<Customer>;
  stringJSON: any;
  stringObject: any;
  customerId:any;
  customerName:any;
  balance!:any;

  contactFrom = new FormGroup({
    cemail: new FormControl('', [Validators.required,Validators.email]),
    cpassword: new FormControl('', [Validators.required])
      })



 onSubmit(){
    this.cust.customerlogin(this.email,this.password).subscribe(data=>
      {



          // var succ = data;
          //this.stringJSON = JSON.stringify(succ);
          // alert("json obj is"+this.stringJSON);
          // alert("gerwgterg"+this.stringJSON.get("customerId"));
          // for(var key in this.stringJSON)
          // {
          //    console.log("key: " + key + ", value: " + this.stringJSON[key])
          //    if(this.stringJSON[key] instanceof Object)
          //    {
          //     alert(this.stringJSON[key]);
          //    }
          // }

        localStorage.setItem("Customer",JSON.stringify(data));

        if(data!=null)
        this.router.navigate(['menu']);
        else
        alert("Enter correct email id and password");

      });

      // alert("returns the cust wallet amount");


      // this.cust.updatewalletamount(1,3000).subscribe(data=>
      //   {

      //   });
  }


}


