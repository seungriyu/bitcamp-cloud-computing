//주제 : 데이터베이스 프로그래밍 - select 실행 II

const mysql  = require('mysql');

//console.log(mysql);


var con = mysql.createConnection({
    host:'13.209.76.8',
    database:'studydb',
    user:'study',
    password:'1111'
});



con.connect(function(err){
    if(err) throw err;
    
    console.log('연결 성공!');
    
    //연결에 성공 했을 때만 SQL을 실행하라고 예약할 수 있다.
    //당장 실행하라는 뜻이 아님
    con.query('select * from pms2_member',function(err,results){
        if(err) throw err;
        
        //results 파라미터에 결과가 들어있다.
        for(var row of results){
            //row 객체에서 값을 꺼낼 때는 SQL에서 지정한 칼럼명 또는 별명을 사용한다.
            console.log(row.email,row.mid,row.pwd);
        }
    });
});

//이 예제에서는 연결 완료 후 END를 먼저 실행하라고 예약했기 때문에 
//connect()에 등록한 함수가 호출되어 SQL문을 예약하더라도 end보다 그 이후에 실행되기 때문에 
//SQL 실행 오류가 발생할 것이다.
//
//해결책? end는 sql 실행을 먼저 예약한 다음에 end 실행을 예약하라!
//=> ex06.js를 보라!
con.end(function(err){
    if(err) throw err;
    console.log('연결을 끊었습니다!');
});
console.log('select 실행');
