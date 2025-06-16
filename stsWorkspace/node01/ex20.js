const fs = require('fs');

// const msg = fs.readdirSync('./');
// console.log(msg);

fs.writeFileSync('test02.txt', 'hello javascript', { flag: 'w' });

const buf1 = fs.readFileSync('test02.txt');
console.log(buf1.toString());
