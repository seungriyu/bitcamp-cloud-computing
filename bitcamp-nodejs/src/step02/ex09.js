//주제 : 데이터베이스 프로그래밍 - delete 실행

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

var mid = 'user0001';


//SQL문을 만들 때 변수의 값을 직접 넣어서 만드는 경우
//해커의 공격을 노출될 수 있다.
//밑에 주석을 막은 mid 변수의 값 처럼 외부 사용자가 값을 입력한다면
//조건이 무조건 참이 되기 때문에 전체 데이터가 삭제되는 결과를 낳는다.
//그래서 SQL문에 변수의 값을 삽입하는 방법을 써서는 안된다.
//var mid = "user0001' or 1=1 or ''='";
//해결책?
//=> in-parameter 방법을 사용하라!


con.query(
        `delete from pms2_member
        where mid='${mid}'`,
    function(err,result){
        if(err) throw err;
    
    console.log('삭제 성공');
});


con.end(function(err){
    if(err) throw err;
    console.log('연결을 끊었습니다!');
});
console.log('delete 실행');
