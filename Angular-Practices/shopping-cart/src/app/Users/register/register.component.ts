import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { DataService } from '../../services/data.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  userProfile: any;
  countryList: Array<any>;
  loginForm: FormGroup;
  countryDropdownSchema :any;
  stateSchema:any;
  constructor(private datasvc:DataService) {




    this.loginForm = new FormGroup({
      username: new FormControl('', [Validators.required,
     
      ]),
      password: new FormControl('', [Validators.required,
      Validators.minLength(6),
      Validators.maxLength(10),
      Validators.pattern(/^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{6,10}$/)
      ])

    })

    this.userProfile = {
      email: 'Bhanu@gmail.com',
      password: 'Test@123',
      phone: '',
      country: '',
      gender: 'M'
    };

    this.countryList = this.datasvc.getCountryList();
    // [{ name: "India", code: "In" }, { name: "USA", code: "usa" }]


  }

  
  ngOnInit():void{
    this.datasvc.getDataFromApi('https://restcountries.eu/rest/v2/all')
    .subscribe((result:any)=>{
      this.countryList = result.map((item:any)=>{
        return {name:item.name,key:item.alpha3Code};
      });
      this.countryDropdownSchema={
        labelName:"Country",
        selectedValue:"UK",
        controlName:"country",
        options:this.countryList,
        defaultLabel:"Select Country"
      }
      this.stateSchema={
        labelName:"State",
        selectedValue:"",
        controlName:"state",
        options:[],
        defaultLabel:"Select State"
      }
      
    },err=>{
      console.log(err);
    })

    
  }

  apiResult={
    success:false,
    error:false
  }
  handleRegister() {
    let url = 'http://51.81.71.198:3000/api/members/register'
    let payLoad = {
      "EMAIL": this.userProfile.email,
      "MOBILE_NUMBER": this.userProfile.phone,
      "PASSWORD": this.userProfile.password
    }
    this.datasvc.postApi(url, payLoad).subscribe(result => {
      console.log(result);
      this.apiResult.success=true;
      this.apiResult.error =false;
    }, err => {
      this.apiResult.success=false;
      this.apiResult.error =true;
    })

  }



  countrySelected(data:any){
    this.userProfile.country = data;
  }

  // handleLogin() {
  //   console.log(this.loginForm.controls['username'].valid);
  //   console.log(this.loginForm.controls['username'].value);
  // }
  // get username() {
  //   return this.loginForm.controls['username'];
  // }
  // get password() {
  //   return this.loginForm.controls['password'];
  // }


}