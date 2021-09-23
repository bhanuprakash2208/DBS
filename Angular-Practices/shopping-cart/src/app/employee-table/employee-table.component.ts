import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-employee-table',
  templateUrl: './employee-table.component.html',
  styleUrls: ['./employee-table.component.css']
})
export class EmployeeTableComponent {

  employees:any = []
  selectedEmp:any;
  msgs:any=["A","B","C","D"]
  constructor() {
    this.employees=[{name:"Bhanu", age:22, salary:20000 },
    {name:"Prakash", age:32, salary:40000 },
    {name:"Sai", age:45, salary:80000 },
    {name:"Kiran", age:35, salary:60000 }
  ]

   }
   onSelected(emp:any){
     this.selectedEmp = emp;
   }

 

}
