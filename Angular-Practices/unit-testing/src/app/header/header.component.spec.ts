import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HeaderComponent } from './header.component';

describe('HeaderComponent', () => {
  //let component: HeaderComponent;
  let fixture: ComponentFixture<HeaderComponent>;
  let headingInstance:any;

  beforeEach(()=>{
    fixture = TestBed.createComponent(HeaderComponent);
    headingInstance = fixture.componentInstance;
    fixture.detectChanges();//two way binding and interpolation
  })

  it('should be existing and can be instantiated', () => {
    expect(headingInstance).toBeDefined();
  });
  
  it('should be having property called title', () => { 
    expect(headingInstance.title).toBe('Unit Testing');
  });
  
  it("should be having a method changeTitle", () => {
    headingInstance.changeTitle();
    expect(headingInstance.title).toBe('I am good');
  });

  it("title-on html ",()=>{
    let compiledHtml = fixture.nativeElement;
    let getPTag= compiledHtml.querySelector('p').textContent;
    console.log("Component PTag", getPTag);
    expect(getPTag).toBe('Unit Testing');
  })

  it("Handle Click",() =>{
    let compiledHtml = fixture.nativeElement;
    let getButton = compiledHtml.querySelector('button');
    getButton.click();
    fixture.detectChanges();
    let getPTag = compiledHtml.querySelector('p').textContent;
    expect(getPTag).toBe('I am good');
  })

})

//   beforeEach(async () => {
//     await TestBed.configureTestingModule({
//       declarations: [ HeaderComponent ]
//     })
//     .compileComponents();
//   });

//   beforeEach(() => {
//     fixture = TestBed.createComponent(HeaderComponent);
//     headerInstance = fixture.componentInstance;
//     fixture.detectChanges();
//   });

//   it('should be existing and can be instantiated', () => {
//     expect(headerInstance).toBeDefined();
//   });

//   it('should be having property called title', () => {
//     expect(headerInstance).toBe('Unit Testing');
//   });
//   it("should be having a method changeTitle", () => {
//     headerInstance.changeTitle();
//     expect(headerInstance.title).toBe('I am good');
//   });



//   it('should create', () => {
//     expect(headerInstance).toBeTruthy();
//   });


//   it("title-on html ",()=>{
//     let compiledHtml = fixture.nativeElement;
//     let getPTag= compiledHtml.querySelector('p').textContent;
//     console.log("Component PTag", getPTag);
//     expect(getPTag).toBe('Unit Testing');
//   })

// });
