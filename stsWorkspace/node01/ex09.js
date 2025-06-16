function f1(){
    console.log(this);
}
const obj1={k1:f1,k2:'val2'};
// console.log(new f1());
var f2=()=>{
    console.log(this);
};
const obj2={k1:f2,k2:'val2'};
// console.log(new f2());
// f1();
// f2();
// obj1.k1();
obj2.k1();