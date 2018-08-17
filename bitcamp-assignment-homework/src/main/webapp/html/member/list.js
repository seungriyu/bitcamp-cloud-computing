"use strict";

var trTemplateSrc = $('#tr-template-src').text();
var trTemplateFn = Handlebars.compile(trTemplateSrc);
let tbody = $('#eListTable > tbody'); 

nameList(1, 14);

function nameList(page,size){
    $.getJSON( "../../json/member/list",
        {
            page:page,
            size:size
        },function(){console.log("로딩성공!")})
        
        .done(function(data){ //세번째 파라미터 : 함수
            console.log(tbody);
            var trListHTML = trTemplateFn({list:data.list}); //data를 list라는 이름으로 보내라
            tbody.html(trListHTML);
            
            $(ePageNo).html(data.page);
            if (data.page <= 1)
                $(ePrevBtn).attr('disabled', '');
            else 
                $(ePrevBtn).removeAttr('disabled');
            
            if (data.page >= data.totalPage)
                $(eNextBtn).attr('disabled', '');
            else
                $(eNextBtn).removeAttr('disabled');

            //서버에서 데이터를 받아와서 태그를 만들어야 실행 됨
            //일을
    
       });
}