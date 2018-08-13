//주제 : 요청정보 다루기 - URL 분석하기


const http = require('http')

//URL 분석에 사용할 모듈 로딩
const url = require('url')

const server = http.createServer((req,res)=>{
    console.log('요청 받았음');
    
    res.writeHead(200,{
        'Content-Type' : 'text/plain;charset=UTF-8'
    });
    
    res.write(req.url+'\n');
    
    
    //URL 분석기를 이용하여 URL을 분석해 보자!
    var urlInfo = url.parse(req.url);
    
    res.write(`href=${urlInfo.href}\n`);  ///aaa/bbb/ccc?name=hone&age=20
    res.write(`pathname=${urlInfo.pathname}\n`); ///aaa/bbb/ccc
    res.write(`search=${urlInfo.search}\n`); //?name=hone&age=20
    res.write(`query=${urlInfo.query}\n`); //name=hone&age=20
    

    res.end(); 
    
});
        
    

server.listen(8000,()=>{
    console.log('서버가 시작됨')
})



