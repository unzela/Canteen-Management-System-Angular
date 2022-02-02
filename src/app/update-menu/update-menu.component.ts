import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Menu } from '../menu';
import { MenuService } from '../menu.service';

@Component({
  selector: 'app-update-menu',
  templateUrl: './update-menu.component.html',
  styleUrls: ['./update-menu.component.css']
})
export class UpdateMenuComponent implements OnInit {

  id!: number;
  menu!: Menu;
  menuList:any;

  constructor(private route: ActivatedRoute,private router:Router,private menuService:MenuService) { }

  ngOnInit(): void {
    this.menu = new Menu();
    this.id = this.route.snapshot.params['id'];

    this.menuService.getMenuItem(this.id).subscribe(data => {
      console.log(data)
      this.menu=data;
    },error => console.log(error));
  }

  updateMenu(){
    this.menuService.updateMenuItem(this.id,this.menu).subscribe(data => {
      console.log(data);
      // this.menu = new Menu();
      // this.gotoList();
      // this.router.navigate(['vendorlogin']);
    },error=>console.log(error));
  }

  gotoList(){
    this.menuService.getAllMenuList().subscribe(data=>{
      this.menuList=data;
      alert("Menu Item is updated");
      this.router.navigate(['vendorlogin']);
    })
  }

  onSubmit(){
    this.updateMenu();
    this.router.navigate(['vendorlogin']);

  }
  list() {
    this.router.navigate(['vendorlogin']);
  }

}
