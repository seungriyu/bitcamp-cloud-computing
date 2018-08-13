// 주졔 : express 사용하기 - 정적 HTML 파일을 서비스하기

const express = require('express')
const app = express();

//POST 요청 데이터 처리와 관련된 설정
const bodyParser = require('body-parser')
app.use(bodyParser.urlencoded({extended: false}))

//정적 HTML 파일 처리
app.use(express.static('./public'))
// public 안에 잇는 것들은 실행을 하는게 아니라 그대로 읽어서 클라이언트에게 던져주는 것이다 
// 프론트 엔드쪽임 
// ~.js가 있더라도 웹브라우저쪽에 던져주는 것이다.

app.get('/test01',(req, res) => {
    res.writeHead(200,{'Content-Type': 'text/plain;charset=UTF-8'});
    res.write(`name=${req.query.name}\n`);
    res.write(`age=${req.query.age}\n`);
    res.end();
});

app.post('/test01',(req, res) => {
    res.writeHead(200,{'Content-Type': 'text/plain;charset=UTF-8'});
    res.write(`name=${req.body.name}\n`);
    res.write(`age=${req.body.age}\n`);
    res.end();
});

//=> 서버 실행하기
app.listen(8000, () => {
    console.log('서버 실행중..');
})