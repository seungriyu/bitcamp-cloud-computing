//주제 : 데이터베이스 프로그래밍 - update 실행

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

var email = 'user001@test.comxxx';
var mid = 'user0001';
var pwd = '1111';

con.query(
        `update pms2_member set email='user02@test.com'
        where mid='${mid}'`,
    function(err,result){
        if(err) throw err;
    
    console.log('변경 성공');
});


con.end(function(err){
    if(err) throw err;
    console.log('연결을 끊었습니다!');
});
console.log('insert 실행');
