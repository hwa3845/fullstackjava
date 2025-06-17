const express = require('express');
const bodyParser = require('body-parser');
const cookieParser = require('cookie-parser');
var cookieSession = require('cookie-session');
let ejs = require('ejs');
const app = express();
const port = 3000;

// parse application/x-www-form-urlencoded
app.use(bodyParser.urlencoded()); //default '/' 생략

// parse application/json
app.use(bodyParser.json()); //json 으로 넘어오는 값 받기

//app.use(cookieParser());

app.use(
  cookieSession({
    name: 'session',
    keys: ['asdflkjewlkvncxweifjh'],

    // Cookie Options
    maxAge: 24 * 60 * 60 * 1000, // 24 hours
  })
);

app.set('view engine', 'ejs');

//모든 요청이 여기를 거쳐서 가게끔, logging 역할을 하게 됨
app.use('/', (req, res, cb) => {
  console.log(req.url, req.session);
  cb();
});

app.use('/dept', require('./dept/dept.js'));
app.use('/emp', require('./emp/emp.js'));

app.get('/', (req, res) => {
  const arr = [];
  arr.push({ deptno: 1111, dname: 'user' });
  arr.push({ deptno: 2222, dname: 'user' });
  arr.push({ deptno: 3333, dname: 'user' });
  arr.push({ deptno: 4444, dname: 'user' });
  //   console.log('index');
  //   res.send('수정!' + req.session.name);
  res.render('dept/list', { arr });
});

app.get('/ex01', (req, res) => {
  //   console.log('param', req.body);
  //   console.log('param', req.params);
  console.log('param', req.query); //get방식
  req.session.name = 'scott';
  res.send('ex01 page!');
});

app.post('/ex02', (req, res) => {
  console.log('param', req.body); //post 방식
  req.session = {};
  res.send('ex02 page!');
});

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`);
});
