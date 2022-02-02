import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Menu } from '../menu';
import { MenuService } from '../menu.service';


@Component({
  selector: 'app-vendormenu',
  templateUrl: './vendormenu.component.html',
  styleUrls: ['./vendormenu.component.css']
})
export class VendormenuComponent implements OnInit {

  menuList:any=[];
  menu!: Menu;
  id!: number;
  msg!: string;
  config!: { itemsPerPage: number; currentPage: number; totalItems: number; };

  constructor(private menuService: MenuService,private router: Router,private route:ActivatedRoute)
  {
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




  ngOnInit(): void {
    this.menuService.getAllMenuList().subscribe(data =>{
      this.menuList=data;
      console.log(data);
    },error=>console.log(error));
  }

  getMenuDetails(i:any){
    this.router.navigate([`details/${i}`]);
  }

  deleteMenuItemById(i:any){
    this.menuService.deleteMenuItemById(i).subscribe(data=>{
         this.msg=data;
         this.gotoList();
         console.log(data);
    });

  }
  gotoList(){
    this.menuService.getAllMenuList().subscribe(data=>{
      this.menuList=data;
    })
  }

  updateMenu(i:any){
     this.router.navigate([`update/${i}`]);
  }

  getOrder(o:any){
      localStorage.setItem("order",o);
     this.router.navigate([`order/${o.foodId}`]);
  }

  pageChanged(event: number){
    this.config.currentPage = event;
  }

}
