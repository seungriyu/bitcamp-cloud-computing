//주제 : 데이터베이스 프로그래밍 - insert 실행

const mysql  = require('mysql');

var con = mysql.createConnection({
    host:'13.209.76.8',
    database:'studydb',
    user:'study',
    password:'1111'
});


con.connect(function(err){
    if(err) throw err;
    
    console.log('연결 성공!');
});

var email = 'ser001@test.com';
var mid = 'user0001';
var pwd = '1111';

con.query(
        `insert into pms2_member(email,mid,pwd)
        values('${email}','${mid}',password('${pwd}'))`,
    function(err,result){
        if(err) throw err;
    
    console.log(result);
});


con.end(function(err){
    if(err) throw err;
    console.log('연결을 끊었습니다!');
});
console.log('insert 실행');
