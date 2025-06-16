function Fun01(){this.su1=1111;}

console.log(new Fun01().su1);
class Fun02{
    su1=1111;
    func1=function(){console.log('메서드',this)};
    func3=()=>{console.log('메서드',this)};
    func2(a){console.log('메서드2',a,this)};
    constructor(a){
        this.su2=a;
    }
}
console.log(new Fun02(3333));
new Fun02(3333).func2(1111);