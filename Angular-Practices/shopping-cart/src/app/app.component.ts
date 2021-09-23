import { Component } from '@angular/core';
import { Observable, of, interval } from 'rxjs';
import { map,take} from 'rxjs/operators';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'shopping-cart';
  constructor(){
    this.buildData();
  }
  buildData(){
    //prints continuously
    const data = interval(100); 
    // data.subscribe(value =>{
    //   console.log(value);
    // }) 
    //prints only first 10 numbers
    data.pipe(take(10)).subscribe(value=>{
      console.log("Observable 1: ",value); 
    });
    data.pipe(take(20)).subscribe(value=>{
      console.log("Observable 2: ",value); 
    });
  }
}
