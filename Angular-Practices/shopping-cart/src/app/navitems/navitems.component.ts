import { Component, OnInit } from '@angular/core';
import { DataService } from '../services/data.service';

@Component({
  selector: 'app-navitems',
  templateUrl: './navitems.component.html',
  styleUrls: ['./navitems.component.css']
})
export class NavitemsComponent  {

 

  //navitems:any=[]

  navitems:Array<any>
  //currentDate:any;
 // price:any;
  currentDate=new Date();
  price:number=4000.1234969; // in pipe it is rounding min:3, max:4 setted in pipe by manually
  number:number = 1234567890;
  country:any;
  countryList:any;
  constructor(private dataservice:DataService) {
    this.country='';
    this.countryList = this.dataservice.getCountryList();

    //this.currentDate = new Date();
    //this.price = 1000;
    this.navitems = [{
      text: "Login",
      link: "login"
    },
    {
      text: "Register",
      link: "register"
    },
    {
      text: "Products",
      link: "products"
    },
    {
      text: "Cart",
      link: "cart"
    }
    ]
   }


}
