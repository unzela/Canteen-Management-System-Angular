import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-rating',
  templateUrl: './rating.component.html',
  styleUrls: ['./rating.component.css']
})
export class RatingComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
    const isClassBinding=true;
  }

  showAlert()
  {
    alert("Thank You for the feedback");
    this.router.navigate(['']);

  }

}
