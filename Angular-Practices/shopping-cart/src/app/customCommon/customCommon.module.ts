import { NgModule } from "@angular/core";
import { HoverDirective } from "./hover.directive";
import { Lowercase2 } from "./lowercase2.pipe";
import { NumbersOnlyInputDirective } from "./numbersonlyinput.directive";
import { PhoneFormatter } from "./phoneformatter.pipe";

@NgModule({
    imports:[],
    exports:[PhoneFormatter,HoverDirective,Lowercase2,NumbersOnlyInputDirective],
    declarations:[PhoneFormatter,HoverDirective,Lowercase2,NumbersOnlyInputDirective],
    providers:[]
})
export class CustomCommonModule{

}