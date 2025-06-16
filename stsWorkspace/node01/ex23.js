const fs = require('fs');

//flag -> rwx
//a
fs.open('test01.txt', 'a', (err, fd) => {
  console.log(err, fd);
});
