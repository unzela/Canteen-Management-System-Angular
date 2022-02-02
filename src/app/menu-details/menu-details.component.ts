import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Menu } from '../menu';
import { MenuService } from '../menu.service';

@Component({
  selector: 'app-menu-details',
  templateUrl: './menu-details.component.html',
  styleUrls: ['./menu-details.component.css']
})
export class MenuDetailsComponent implements OnInit {

  id!: number;
  menu!: Menu;

  constructor(private route: ActivatedRoute,private router: Router,private menuService: MenuService) { }

  ngOnInit(): void {

    this.menu = new Menu();
    this.id = this.route.snapshot.params['id'];
    this.menuService.getMenuItem(this.id).subscribe(data => {
      console.log(data)
      this.menu = data;
    },error => {console.log(error)});

  }

  list() {
    this.router.navigate(['menu']);
  }

}
