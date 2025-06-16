console.log('person.js file...');
const name2 = "Jesse"
const age2 = 40

// export {name:name,age:age};
// export var name=name2;
// export var age=age2;
// export const person ={name2, age2}; 

//단, 하나의 모듈에서 default는 단 하나만 존재
//키 없이 value만 전해주기 때문에
export default {name2,age2};