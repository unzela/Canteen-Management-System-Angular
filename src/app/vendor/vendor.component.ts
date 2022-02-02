import { Component, OnInit } from '@angular/core';
import { FormControl ,FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { VendorService } from '../vendor.service';

@Component({
  selector: 'app-vendor',
  templateUrl: './vendor.component.html',
  styleUrls: ['./vendor.component.css']
})
export class VendorComponent implements OnInit {

    title="Vendor Registration Form";

    constructor(private router: Router,private vend:VendorService) { }

    ngOnInit(): void {
    }

    v!:Vendorobj;





    contactFrom = new FormGroup({
      vid: new FormControl('', [Validators.required, Validators.minLength(1)]),
      vname: new FormControl('', [Validators.required]),
      vemail: new FormControl('', [Validators.required,Validators.email]),
      vmobile: new FormControl('', [Validators.required]),
      vpassword: new FormControl('', [Validators.required,Validators.minLength(6),Validators.pattern('((?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,30})')]),
      vaddress: new FormControl('', [Validators.required])
        })

   onSubmit(){
    JSON.stringify(this.contactFrom.value);
        this.v=new Vendorobj(
          this.contactFrom.get('vid')?.value,
          this.contactFrom.get('vname')?.value,
          this.contactFrom.get('vemail')?.value,
          this.contactFrom.get('vmobile')?.value,
          this.contactFrom.get('vpassword')?.value,
          this.contactFrom.get('vaddress')?.value
        );

        this.vend.vendorregister(this.v).subscribe(data=>
          {

            this.router.navigate(['vendorlogin']);
          })
      }
    }



  export class Vendorobj
  {


vendorId:number;
vendorName:string;
vendorEmail:string;
vendorContactNo:string;
vendorAddress:string;
vendorPassword:string;

    constructor(
    vendorId : number,
    vendorName :string,
    vendorEmail: string,
    vendorContactNo:string,
    vendorAddress:string,
    vendorPassword:string

    )
    {
        this.vendorId=vendorId;
        this.vendorName=vendorName;
        this.vendorEmail=vendorEmail;
        this.vendorContactNo=vendorContactNo;
        this.vendorAddress=vendorAddress;
        this.vendorPassword=vendorPassword;

    }

  }


