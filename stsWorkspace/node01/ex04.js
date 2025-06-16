const obj1={"k1":"v1"};
const obj2={'k1':'v1'};
var k1='a1';
const obj3={k1:'v1'}; //문자열을 썼다는 전제조건 하에 가능한 문법

obj3[k1]='v2';
console.log(JSON.stringify(obj3));

const obj4={k1};
const obj5={k1:k1};
console.log(JSON.stringify(obj4));
console.log(JSON.stringify(obj5));
