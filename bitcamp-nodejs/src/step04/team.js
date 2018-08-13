// 주졔 : /team/* 요청을 처리할 라우터 만들기


const express = require('express')
const router = express.Router();

// '/team/list' 요청이 들어왔을 때 호출될 메서드 등록
router.get('/list',(req,res)=>{
    res.writeHead(200, {'Content-Type':'text/plain;charset=UTF-8'});
    res.write('팀 목록입니다.');
    res.end();
});

//'/team/view' 요청이 들어왔을 때 호출될 메서드 등록
router.post('/view',(req,res)=>{
    res.writeHead(200, {'Content-Type':'text/plain;charset=UTF-8'});
    res.write('팀 상세정보입니다.');
    res.end();
});

module.exports = router;
