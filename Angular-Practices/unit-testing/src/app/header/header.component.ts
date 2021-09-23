import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  title:string;
  constructor() { 
    this.title="Unit Testing";
  }

  ngOnInit(): void {
  }
  changeTitle(){
    this.title="I am good";
  }
}