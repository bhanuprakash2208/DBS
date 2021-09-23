import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { Footercomponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { LeftMenuComponent } from './left-menu/left-menu.component';
import { RightMenuComponent } from './right-menu/right-menu.component';
import { NavitemsComponent } from './navitems/navitems.component';
import { EmployeeTableComponent } from './employee-table/employee-table.component';
import { LoginFormComponent } from './Users/login-form/login-form.component';
import { HttpClientModule} from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { ProductsComponent } from './products/products.component';
import { RegisterComponent } from './Users/register/register.component';
import { CartComponent } from './cart/cart.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Lowercase2 } from './customCommon/lowercase2.pipe';
import { PhoneFormatter } from './customCommon/phoneformatter.pipe';
import { DataService } from './services/data.service';
import { CustomersComponent } from './customers/customers.component';
import { DropdownComponent } from './dropdown/dropdown.component';
import { HoverDirective } from './customCommon/hover.directive';
import { NumbersOnlyInputDirective } from './customCommon/numbersonlyinput.directive';
import { UserModule } from './Users/user.module';
import { CustomCommonModule } from './customCommon/customCommon.module';
import { MatSliderModule } from '@angular/material/slider';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    Footercomponent,
    LeftMenuComponent,
    RightMenuComponent,
    NavitemsComponent,
    EmployeeTableComponent,
    //LoginFormComponent,
    ProductsComponent,
    //RegisterComponent,
    CartComponent,
    //Lowercase2,
    //PhoneFormatter,
    CustomersComponent,
    //DropdownComponent,
    //HoverDirective,
    //NumbersOnlyInputDirective
    
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    UserModule,
    CustomCommonModule,
    MatSliderModule,
    RouterModule.forRoot([{
      path:"products", component:ProductsComponent
    },
    {
    path:"login",component:LoginFormComponent
    },
    {
      path:"cart",component:CartComponent
      },
      {
        path:"register",component:RegisterComponent
        },
        {
          path:"",component:LoginFormComponent
          }
  ]),
    BrowserAnimationsModule
  ],
  providers: [DataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
