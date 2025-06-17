// ~ mysql 5.x
var mysql = require('mysql2');

var con = mysql.createConnection({
  host: 'localhost',
  user: 'root',
  password: 'mysql',
  port: '33306',
  database: 'mydb',
});

con.connect(function (err) {
  if (err) throw err;
  console.log('Connected!');
  const begin = 10;
  const end = 14;
  var sql = `SELECT * FROM customers where id<${end} and id>${begin} order by name desc`;

  con.query(sql, [7, 3], function (err, result, fields) {
    if (err) throw err;
    // console.log(result, fields);
    result.forEach((ele) => {
      console.log(ele.id, ele.name, ele.address);
    });
  });
  con.end();
});
