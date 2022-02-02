import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Bill } from '../bill';
import { BillService } from '../bill.service';


@Component({
  selector: 'app-bill',
  templateUrl: './bill.component.html',
  styleUrls: ['./bill.component.css']
})
export class BillComponent implements OnInit {

  id!: number;
  bill!: Bill;

  constructor(private route: ActivatedRoute,private router: Router,private billService: BillService) { }

  ngOnInit(): void {
    this.bill = new Bill();
    var id=localStorage.getItem('orderId');
    if(id!=null)
    this.billService.getBillItem(parseInt(id)).subscribe(data=>
      {
          this.bill=data;
      });
    // this.billService.getBillItem(this.id).subscribe(data => {
    //   console.log(data)
    //   this.bill = data;
    // },error => {console.log(error)});
  }

  list() {
    this.router.navigate(['']);
  }

}
