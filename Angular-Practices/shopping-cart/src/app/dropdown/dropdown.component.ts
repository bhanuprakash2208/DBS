import { Component, Input, OnInit, Output,EventEmitter} from '@angular/core';

@Component({
  selector: 'app-dropdown',
  templateUrl: './dropdown.component.html',
  styleUrls: ['./dropdown.component.css']
})
export class DropdownComponent implements OnInit {
  @Input()
  schema: any;

  // 1) Creating the output decorator
  @Output()
  handleChange:EventEmitter<any>;

  constructor() {
    this.schema = {
      options: [{ name: "", key: "" }],
      labelName: '',
      cssClass: "",
      selectedValue: "",
      controlName:"",
      defaultLabel:""
    }
    // 2) Initiliaze the output
    this.handleChange = new EventEmitter<any>();
  }

  // 3) Handle the dropdown change
  handleDropdownchange(){
  //  4) Emit the drop down selected value
    this.handleChange.emit(this.schema.selectedValue);
  }

  ngOnInit(): void {
  }

}