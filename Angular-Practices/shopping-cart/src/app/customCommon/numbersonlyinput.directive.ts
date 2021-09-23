import { Directive, ElementRef, HostListener, Input } from '@angular/core';
@Directive({
  selector: '[validInput]'//'input[type=number], input[numbersOnly]'
})
export class NumbersOnlyInputDirective {
  constructor(private elRef: ElementRef) { }
  @HostListener('keydown',['$event'])
  handleInput(evt:any):any{
      const pattern = this.elRef.nativeElement.pattern;
      console.log(pattern);
      var reg = new RegExp(pattern);
      this.elRef.nativeElement.style = "background-color:#EAF159"
      if(evt.keyCode == 8){
          return true;
      }
      else if(!reg.test(evt.key)){
          evt.printDefault();
      }

  }
//   @HostListener('input', ['$event']) onInputChange(event:any) {
//     const initalValue = this.elRef.nativeElement.value;
//     this.elRef.nativeElement.value = initalValue.replace(/[^0-9]*/, '');
//     this.elRef.nativeElement.style = "background-color:#EAF159"
//     if ( initalValue !== this.elRef.nativeElement.value) {
//       event.stopPropagation();
//     }
//   }
}