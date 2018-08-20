'use strict'

var selectedCardNo = 0;
var formState = 'view';


//확인 , 추가 감추기
$('.edit-ctrl').css('display','none')

$(document.body).on('show.detail',(e,no)=>{
//    alert(no);
    $('.form-control').addClass('form-control-plaintext').removeClass('form-control');
    $('.edit-ctrl').css('dispaly','none');
    $('.view-ctrl').css('display','');
    
    formState = 'view';
    
    $.getJSON(`${serverApiAddr}/json/businesscard/${no}`,(result)=>{
        selectedCardNo = no; //성공 했을 때 카드 번호 저장
        if(result.status !== 'success') {
            selectedCardNo = 0;
            return;
        
        }
        $('#f-name').val(result.data.name);
        $('#f-mobile-tel').val(result.data.mobileTel);
        $('#f-tel').val(result.data.tel);
        $('#f-fax').val(result.data.fax);
        $('#f-email').val(result.data.email);
        $('#f-memo').val(result.data.memo);
        
        
      
  })
    
})


$('#add-btn').click(()=>{
    
    formState = 'add';
    
//    alert('okok')
    //클릭할 때 이 메서드를 호출해주세요가 아니라
    //클릭 이벤트를 발생 시키는 것
    //인간이 누르는게 아니라 프로그램으로 누르는 것
//    $('#reset-btn').click();
    $('#reset-btn').trigger('click',['add']);
    
    
    $('.form-control-plaintext').addClass('form-control').removeClass('form-control-plaintext');
    
    $('.edit-ctrl').css('dispaly','');
    $('.view-ctrl').css('display','none');
})

$('#update-btn').click(()=>{
    formState = 'update';
    $('.form-control-plaintext').addClass('form-control').removeClass('form-control-plaintext');
    
    $('.edit-ctrl').css('dispaly','');
    $('.view-ctrl').css('display','none');
})

$('#delete-btn').click(()=>{
    
    $.getJSON(`${serverApiAddr}/json/businesscard/delete`,{
        'no':selectedCardNo
    },(result)=>{
        $(document.body).trigger('refresh.list');
  })
})

$('#reset-btn').click((e,action)=>{
    $('.form-control').addClass('form-control-plaintext').removeClass('form-control');
    
    $('.edit-ctrl').css('dispaly','none');
    $('.view-ctrl').css('display','');
    
    //'추가' 버튼을 클릭한 후 리셋 할 때는
    //기존의 명함 정보를 로딩해서는 안된다. 그냥 빈 입력폼을 출력해야 한다.
    //만약 사용자가 취소 버튼을 눌렀다면,
    //그때는 이전 명함 정보를 로딩해야 한다.
    if(selectedCardNo > 0 && action !== 'add'){
        $(document.body).trigger('show.detail',[selectedCardNo]);
    }
}) 


$('#ok-btn').click(()=>{
    if(formState === 'add'){
        $.post(`${serverApiAddr}/json/businesscard/add`,{ //서버에 넘어가는 값
            'name':$('#f-name').val(),
            'mobileTel':$('#f-mobile-tel').val(),
            'tel':$('#f-tel').val(),
            'fax':$('#f-fax').val(),
            'email':$('#f-email').val(),
            'memo':$('#f-memo').val()
        },(result)=>{
            console.log(result);
            if(result.status !== 'success') return;
            
            $(document.body).trigger('refresh.list');
        },'json')
        .fail(()=>{
            alert('서버 요청 중 오류 발생!');
        });
    }else if(formState === 'update'){
        $.post(`${serverApiAddr}/json/businesscard/update`,{ //서버에 넘어가는 값
            'no':selectedCardNo,
            'name':$('#f-name').val(),
            'mobileTel':$('#f-mobile-tel').val(),
            'tel':$('#f-tel').val(),
            'fax':$('#f-fax').val(),
            'email':$('#f-email').val(),
            'memo':$('#f-memo').val()
        },(result)=>{
            console.log(result);
            if(result.status !== 'success') return;
            
            $(document.body).trigger('refresh.list');
        },'json')
        .fail(()=>{
            alert('서버 요청 중 오류 발생!');
        });
    }
    
    $('.edit-ctrl').css('dispaly','none');
    $('.view-ctrl').css('display','');
    
})





