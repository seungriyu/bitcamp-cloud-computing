'use strict'

var liTemplateSrc = $('#li-template').text();
var template = Handlebars.compile(liTemplateSrc);

loadList();


$('#name-list').on('click','li', function(){
//    alert('okok')
//    console.log($(this).attr('data-no'))
    $('#name-list li.list-group-item-secondary').removeClass('list-group-item-secondary');
    $(this).addClass('list-group-item-secondary');
    var no = $(this).attr('data-no')
    $(document.body).trigger('show.detail',[no])
    
    
}) //부모에 대해 버블링해서 클릭 될텐데
// 이벤트 트리거가 li일 때 만 함수를 실행해라

//arrow function을 사용하고 싶을 때
//$('#name-list').on('click','li', (e)=>{
//    console.log($(e.target).attr('data-no'))
//})

$(document.body).on('refresh.list',() => loadList())


function loadList(){
    $.getJSON(`${serverApiAddr}/json/businesscard/list`,(result)=>{
        //    console.log(result); //클라이언트로 제대로 왔는지 확인
        var html = template(result);
        $('#name-list').html(html);
        $('#name-list li:first-child').click();
        
        
    }) //name-list가 없는 상태에서 list를 실행하라고 하니까 안뜸
}