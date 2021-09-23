import { Component, OnInit } from '@angular/core';
import {  FormControl, FormGroup, Validators} from '@angular/forms';
import { MinimumAge } from '../../customCommon/ageValidator';
import { DataService } from '../../services/data.service';
@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  loginForm :FormGroup;
  constructor(private datasvc:DataService) { 
    this.loginForm = new FormGroup({
      username: new FormControl('',[Validators.required,
      Validators.minLength(6),
    Validators.maxLength(40)
   //     Validators.pattern(/^[a-z0-9]+$/i)
      ]),
      password:new FormControl('',[Validators.required,
        Validators.minLength(6),
        Validators.maxLength(20)
      //  Validators.pattern(/^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{6,10}$/)
      ]),
      age:new FormControl('',[MinimumAge])

    })
  }

  ngOnInit(): void {
  }
  apiResult={
    success:false,
    error:false
  }
  handleLogin(){
    console.log(this.loginForm.controls['username'].valid);
    console.log(this.loginForm.controls['username'].value);

    let url = 'http://51.81.71.198:3000/api/members/login'
    let payLoad = {
      "EMAIL": this.loginForm.controls['username'].value,
      "PASSWORD": this.loginForm.controls['password'].value
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
  get username(){
    return this.loginForm.controls['username'];
  }
  get password(){
    return this.loginForm.controls['password'];
  }
  get age() {
    return this.loginForm.controls['age'];
  }
}
