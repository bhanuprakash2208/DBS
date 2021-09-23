import { NgModule } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { CustomCommonModule } from "../customCommon/customCommon.module";
import { DropdownComponent } from "../dropdown/dropdown.component";
import { LoginFormComponent } from "./login-form/login-form.component";
import { RegisterComponent } from "./register/register.component";

@NgModule({
    declarations:[DropdownComponent,RegisterComponent,LoginFormComponent],
    imports:[
        FormsModule,
        ReactiveFormsModule,
        CustomCommonModule
    ],
    providers:[],
    exports:[]

})
export class UserModule{}