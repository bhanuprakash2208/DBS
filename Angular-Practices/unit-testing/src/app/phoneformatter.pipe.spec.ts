import { PhoneFormatter } from './phoneformatter.pipe';
import { TestBed } from '@angular/core/testing';
import { AppComponent } from './app.component';
describe('PhoneformatPipe', () => {
  beforeEach(async () => {
     TestBed.configureTestingModule({
      declarations: [ AppComponent,PhoneFormatter ],
    })
    .compileComponents();
  });
  it('create an instance', () => {
    const pipe = new PhoneFormatter();
    expect(pipe).toBeTruthy();
  });
  it('should take the phone number as input',()=>{
    const pipe = new PhoneFormatter();
    const output= pipe.transform('1234567890');
    expect(output).toBe("+1-123-456-7890");
  })

  it('should take the phone number and country as input',()=>{
    const pipe = new PhoneFormatter();
    const output= pipe.transform('1234567890',"IN");
    expect(output).toBe("+91-12345-67890");
  })

  it('should take the phone number and country as input',()=>{
    const pipe = new PhoneFormatter();
    const output= pipe.transform('123456790',"IN");
    expect(output).toBe("123456790");
  })

});