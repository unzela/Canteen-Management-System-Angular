import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Menu } from '../menu';
import { MenuService } from '../menu.service';

@Component({
  selector: 'app-create-menu',
  templateUrl: './create-menu.component.html',
  styleUrls: ['./create-menu.component.css']
})
export class CreateMenuComponent implements OnInit {

  menu: Menu = new Menu();
  submitted=false;

  menuList:any;

  constructor(private menuService: MenuService,private router: Router) { }

  ngOnInit(): void {

  }

  newMenu(): void {
    this.gotoList();
    this.submitted=false;
    this.menu= new Menu();
  }

  save(){
    this.menuService.createMenu(this.menu).subscribe(data => {
      this.gotoList();
      console.log(data);
      this.menu = new Menu();

    });
  }

  onSubmit(){

    this.submitted=true;
    this.save();
  }
  gotoList(){
    this.menuService.getAllMenuList().subscribe(data =>{
      this.menuList=data;
    });
    this.router.navigate(['vendorlogin']);
  }

  list() {
    this.router.navigate(['menu']);
  }


}
