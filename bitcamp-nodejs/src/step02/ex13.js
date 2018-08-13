//주제 : 데이터베이스 프로그래밍 - insert 실행 후 auto_increment PK 칼럼 값 알아내기

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

var title = 'ser001@test.com';
var content = 'user0001';
var pwd = '1111';

con.query(
        `insert into pms2_board(titl,cont,cdt)
        values(?,?,now())`,
        [title,content],
    function(err,result){
        if(err) throw err;
    
    console.log('입력성공');
    console.log(result.insertId);
});


con.end(function(err){
    if(err) throw err;
    console.log('연결을 끊었습니다!');
});
console.log('insert 실행');
