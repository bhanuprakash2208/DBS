import { Component } from "@angular/core";

@Component({
    selector:'app-header',
    templateUrl:'./header.component.html',
    styleUrls:['./header.component.css']

})
export class HeaderComponent {
    CompanyDetails:any;
    constructor(){
        this.CompanyDetails = {
            name : "DBS",
            logo :"https://www.dbs.com/in/iwov-resources/flp/splitter/images/dbs_logo.svg"

        };

    }
    
}