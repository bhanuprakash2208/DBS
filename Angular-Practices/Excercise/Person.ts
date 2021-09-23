interface IPerson{
    getFullname():string;
    getAddress():string;
}
class Person implements IPerson{
    FirstName:any;
    Lastname:any;
    Age:any;
    Gender:any;
    inAgreeTerms:any;
    constructor(){
        this.FirstName='Bhanu';
        this.Lastname='Prakash';
        this.Age=10;
        this.Gender='M';
        this.inAgreeTerms='';
    }
    getFullname(){
        return this.FirstName +' '+ this.Lastname;
    }
    getFirstName(){
        return this.FirstName;
    }
    getAddress(){
        return '';
    }
}

class Employee extends Person{

}

var y = new Employee();


