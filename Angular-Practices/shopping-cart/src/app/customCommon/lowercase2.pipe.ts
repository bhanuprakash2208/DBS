import { Pipe,PipeTransform } from "@angular/core";
@Pipe({
    name: 'lowercase2'
})
export class Lowercase2 implements PipeTransform{
    transform(input:any){
        if(typeof input == 'string'){
            //return input.toUpperCase(); if wants to return in upper cae
            return input.toLowerCase();
        }
        else{
            return input;
        }
    }
}