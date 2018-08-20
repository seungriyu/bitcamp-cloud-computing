'use strict'

var liTemplateSrc = $('#li-template').text();
var template = Handlebars.compile(liTemplateSrc);

$.getJSON(`${serverApiAddr}/json/businesscard/list`,(result)=>{
//    console.log(result); //클라이언트로 제대로 왔는지 확인
    var html = template(result);
    $('#name-list').html(html);
    
})


