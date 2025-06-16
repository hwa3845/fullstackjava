const fs = require('fs');

// fs.writeFile('test01.txt', '한글1234', { encoding: 'utf-8' }, () => {
//   fs.readFile('test01.txt', { encoding: 'utf-8' }, (err, data) => {
//     console.log(data.toString());
//   });
// });

(async function () {
  await fs.writeFile(
    'test01.txt',
    '한글123432432423',
    { encoding: 'utf-8' },
    () => {}
  );

  fs.readFile('test01.txt', { encoding: 'utf-8' }, (err, data) => {
    console.log(data.toString());
  });
})();
