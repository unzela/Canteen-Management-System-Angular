
import { Component, OnInit } from '@angular/core';
import { FormControl ,FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { VendorService } from '../vendor.service';

@Component({
  selector: 'app-vlogin',
  templateUrl: './vlogin.component.html',
  styleUrls: ['./vlogin.component.css']
})
export class VloginComponent implements OnInit {

    title="Vendor Login Form";

    constructor(private router: Router,private vendor:VendorService) { }

    ngOnInit(): void {
    }

    email!:string;
    password!:string;
    contactFrom = new FormGroup({

      vemail: new FormControl('', [Validators.required,Validators.email]),
      vpassword: new FormControl('', [Validators.required])
        })



   onSubmit(){
      console.log(this.contactFrom.value);
      this.vendor.vendorlogin(this.email,this.password).subscribe(data=>
        {
          if(data!=null)
          this.router.navigate(['vendorlogin']);
          else
          alert("Enter correct email id and password");
        });
    }


  }



