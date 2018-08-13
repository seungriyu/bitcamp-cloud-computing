// 주졔 : express 사용하기 - 요청 핸들러를 모듈로 분리하기


const express = require('express')
const app = express();



//POST 요청 데이터 처리와 관련된 설정
const bodyParser = require('body-parser')
app.use(bodyParser.urlencoded({extended: false}))

//정적 HTML 파일 처리
app.use(express.static('./public'))

//통합 템플릿 엔진 관리자 모듈 코딩
// => 템플릿 엔진이 아니라 템플릿 엔진을 중간에서 관리 해주는 역할을 수행한다.
const consolidate = require('consolidate')

//Express에 템플릿 엔진을 등록한다. 
// => consolidate에 대해 handlebars를 지정하면 이 템플릿 관리자는 Node 모듈에서 handlebars를 찾아 리턴한다.
// => express에 여러 개의 엔진을 등록할 수 있다. 
app.engine('html', consolidate.handlebars)

// 등록된 템플릿 엔진 중에 사용할 엔진을 지정한다.
app.set('view engine','html')

// 템플릿 파일이 있는 디렉토리 경로를 지정한다.
//=> 디렉토리가 한 개일 때는 문자열로 지정한다.
//=> 디렉토리가 여러 개 일떄는 배열에 담아 지정한다.
const path = require('path')
app.set('views',path.join(__dirname),'templates')

// "/member/*" URL을 처리할 라우터와 '/team/*' URL을 처리할 라우터를 로딩한다.
var memberRouter = require('./member')
var teamRouter = require('./team')

//=> 라우터를 Express의 웹 서버에 등록한다.
app.use('/member',memberRouter)
app.use('/team',teamRouter)




app.get('/test01',(req, res) => {
    res.writeHead(200,{'Content-Type': 'text/plain;charset=UTF-8'});
    res.write(`name=${req.body.name}\n`);
    res.write(`age=${req.body.age}\n`);
    res.end();
});

app.post('/test02',(req, res) => {
    res.writeHead(200,{'Content-Type': 'text/plain;charset=UTF-8'});
    res.write(`name=${req.body.name}\n`);
    res.write(`age=${req.body.age}\n`);
    res.end();
});

app.get('/test03',(req, res) => {
    res.render('template01',req.query)
});

//=> 서버 실행하기
app.listen(8000, () => {
    console.log('서버 실행중..');
})