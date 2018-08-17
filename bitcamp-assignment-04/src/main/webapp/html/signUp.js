
'use strict'

$('#addBtn').click(()=>{
//   console.log('====>');
   $.post(`${serverApiAddr}/json/member/signUp`,{ //서버에 넘어가는 값
       'email':$('#fEmail').val(),
       'name':$('#fName').val(),
       'password':$('#fPassword').val()
   },(result)=>{
//       console.log(result);
       if(result.status === 'success'){
           location.href = 'signIn.html'
       }else{
           alert('회원 가입 실패!')
           console.log(result.message)
       }
   },'json')
   .fail(()=>{
       alert('회원 가입 중 오류 발생!');
   });
});

