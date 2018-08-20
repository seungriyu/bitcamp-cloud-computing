
'use strict'

$('#loginBtn').click(()=>{
    
//    console.log($('#fSaveEmail').is(':checked'));
//    console.log($('#fSaveEmail').prop('checked'));
    
    
   $.post(`${serverApiAddr}/json/auth/signIn`,{ //서버에 넘어가는 값
       'email':$('#fEmail').val(),
       'password':$('#fPassword').val(),
       'saveEmail': $('#fSaveEmail').is(':checked')
   },(result)=>{
//       console.log(result);
       if(result.status === 'success'){
           location.href = 'businesscard/index.html'
       }else{
           alert('로그인 실패!')
       }
   },'json')
   .fail(()=>{
       alert('서버 요청 중 오류 발생!');
   });
   
});

