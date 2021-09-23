import { ThrowStmt } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { DataService } from '../services/data.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  //products:any;
  //total=0;
  constructor(public dataSvc:DataService) { 
    // this.products = this.dataSvc.getCartItems();
    // this.total = this.dataSvc.getCartTotal();
  }

  ngOnInit(): void {
  }
  addToCart(item:any){
    this.dataSvc.addToCart(item)
  }
  removeFromCart(item:any){
    this.dataSvc.removeFromCart(item);
  }
}