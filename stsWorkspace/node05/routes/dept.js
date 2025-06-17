const express = require('express');
const mysql = require('mysql2');
const router = express.Router();

// const getConnection = () =>
//   mysql.createConnection({
//     host: 'localhost',
//     user: 'root',
//     password: 'mysql',
//     port: 33306,
//     database: 'xe',
//   });

const pool = mysql.createPool({
  host: process.env.db_url?process.env.db_url:'localhost',
  user: 'root',
  password: 'mysql',
  port: 33306,
  database: 'xe',
  waitForConnections: true,
  connectionLimit: 10,
  maxIdle: 10, // max idle connections, the default value is the same as `connectionLimit`
  idleTimeout: 6000, // idle connections timeout, in milliseconds, the default value 60000
});

router.get('/', (req, res) => {
  pool.getConnection(function (err, conn) {
    if (err) throw err;
    pool.query(
      'SELECT * FROM dept order by deptno desc',
      function (err, result, fields) {
        if (err) throw err;
        const arr = result.map((ele) => ele);
        res.render('dept/list', { arr });
      }
    );
    pool.releaseConnection(conn);
  });
});

router.get('/add', (req, res) => {
  res.render('dept/add');
});

router.post('/', (req, res) => {
  const dept = req.body;
  let sql = `insert into dept values (${dept.deptno},'${dept.dname}','${dept.loc}')`;
  pool.getConnection((err, conn) => {
    if (err) throw err;
    pool.query(sql, (err) => {
      if (err) throw err;
      res.redirect('./');
      pool.releaseConnection(conn);
    });
  });
});

router.get('/:deptno', (req, res) => {
  const deptno = Number(req.params.deptno);
  let sql = `select * from dept where deptno=${deptno}`;
  pool.getConnection((err, conn) => {
    if (err) throw err;
    pool.query(sql, (err, data) => {
      if (err) throw err;
      res.render('dept/dept', { bean: data[0] });
      pool.releaseConnection(conn);
    });
  });
});

router.put('/:deptno', (req, res) => {
  const dept = req.body;
  let sql = `update dept set dname='${dept.dname}',loc='${dept.loc}' where deptno=${dept.deptno}`;
  pool.getConnection((err, conn) => {
    if (err) throw err;
    pool.query(sql, (err, result) => {
      if (err) throw err;
      res.json({ result: result.affectedRows });
      pool.releaseConnection(conn);
    });
  });
});

router.delete('/:deptno', (req, res) => {
  const deptno = req.params.deptno;
  let sql = `delete from dept where deptno=${deptno}`;
  pool.getConnection((err, conn) => {
    if (err) throw err;
    pool.query(sql, (err) => {
      if (err) throw err;
      res.json({ result: true });
      pool.releaseConnection(conn);
    });
  });
});

module.exports = router;
