
'use strict'

var serverApiAddr = "http://localhost:8080/bitcamp-assignment-04";

//DOM api를 완성했을 때 실행해라
//페이지를 다 로딩하고 맨 끝에 어떤 작업을 하고 싶을 때 3개중 하나 사용
//$(document.body).ready(()=>{
//    console.log('ready().....')
//})
//
//$(()=>{
//    console.log('1111')
//});
//
//window.onload = ()=>{
//    console.log('onload()....')
//}

$(()=>{
    $('footer').load(`${serverApiAddr}/html/footer.html`) 
});