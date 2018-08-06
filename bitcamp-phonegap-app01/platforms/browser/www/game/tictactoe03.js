$('.cell').click((e)=>{
    console.log($(e.target).attr('data-pos'));//태그의 속성값 알고싶으면 getAttribute
});

$('#new-game').click((e)=>{
    console.log('new game');
    
});