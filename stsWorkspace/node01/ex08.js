function f1(a,b){console.log('test',a,b); return 1234;}
let f2=(a,b)=>{console.log('test',a,b); return 1234;};
let f3=(a,b)=>{return 1234;};
let f4=(a,b)=>4321;
let f5=(a)=>4321;
let f6=a=>4321;
let result = f6();
console.log(result);