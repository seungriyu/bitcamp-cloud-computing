"use strict"

var {page, size} = $.parseQuery(location.href);

let tbody = $('#eListTable > tbody'); 
let data = null;

if(page != undefined && size != undefined ){
    loadList(page,size);
}else{
    loadList(1,3);
}

$(ePrevBtn).click(function() {
    loadList(data.page - 1, data.size);
});
$(eNextBtn).click(function() {
    loadList(data.page + 1, data.size);
});

function loadList(page, size) {
    
    $.getJSON(serverApiAddr+'/json/member/list', //첫번째 파라미터 : url
        {
             page : page,//프러퍼티 이름 : 변수명
             size : size //두번쨰 파라미터  : 데이터
        },function(){console.log("로딩성공!")})
        
        .done(function(result){ //세번째 파라미터 : 함수
                data = result; //서버에서 받은 result를 data에 저장하겠다
                tbody.html('');
                for (var item of data.list) {
                    $("<tr>")
                    .html (
                        `<td><a href='#' data-id='${item.id}' class='viewLink'>${item.id}</a></td>
                        <td>${item.email}</td>`)
                   .appendTo(tbody);
                }
                
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

//이 방식은 실행 시점에 존재하는 태그에 대해서만 이벤트 핸들러를 등록할 수 있다.
/*
$('.viewLink').click(function(event) {
    alert('okok');
    event.preventDefault();
    var id = $(event.currentTarget).attr('data-id'); //속성이름만 주면 getter로 사용
    location.href = `view.html?id=${id}&page=${data.page}&size=${data.size}`;
});
*/

//실행 시점에 존재하지 않더라도 이벤트 핸들러를 등록하는 방법은?
// => 앞으롸 생성될 태그의 부모에 리스너를 등록하는 것이다.
tbody.on('click','a.viewLink',function(event){ //viewLink에 소속되어 있는 a태그에 대해서만 메서드가 호출됨
    event.preventDefault();
    var id = $(event.target).attr('data-id'); //속성이름만 주면 getter로 사용
    location.href = `view.html?id=${id}&page=${data.page}&size=${data.size}`;
    //currentTarget 현재 타겟 하면 안됨
    //
});
