var myFirstDate = new Promise((resolve,reject)=>{
var badManager="A";
if(badManager=='B'){
    reject("you dont care me!!!")
}
else{
    resolve("Life is imp than job")
}

})

myFirstDate.then(result=>{
    console.log(result)
}).catch(err=>{
    console.log(err);
});