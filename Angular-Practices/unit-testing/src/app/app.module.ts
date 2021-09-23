import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { PhoneFormatter } from './phoneformatter.pipe';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    PhoneFormatter
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
