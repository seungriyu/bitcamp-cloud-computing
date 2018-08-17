
'use strict'

$('#loginBtn').click(()=>{
    
//    console.log($('#fSaveEmail').is(':checked'));
//    console.log($('#fSaveEmail').prop('checked'));
    
    
   $.post(`${serverApiAddr}/json/auth/signIn`,{ //서버에 넘어가는 값
       'email':$('#fEmail').val(),
       'password':$('#fPassword').val(),
       'saveEmail': $('#fSaveEmail').is(':checked')
   },(result)=>{
       console.log(result);
   },'json')
   .fail(()=>{
       alert('회원 가입 중 오류 발생!');
   });
   
});

