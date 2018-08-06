tictactoe05.html
var human = 'X',
    computer = "O",
    cells = $('.cell'),
    count = 0;

$('.cell').click((e)=>{
    console.log($(e.target).attr('data-pos'));//태그의 속성값 알고싶으면 getAttribute
    $(e.target).text(human);
    
    
    //마지막 표시를 했으면 더이상 컴퓨터가 작업하지 않는다.
    if(++count == 5) return;
    
    //타이머를 가동하여 1초 후에 컴퓨터가 표시하게 한다.
    setTimeout(() => {
        
        while(true){
        
            var no = Math.floor(Math.random()*9);
             
            //console.log(no, Math.floor(no)); // floor: 정수값의 바닥에 맞춰리ㅏ
            //console.log(no, parseInt(no)); 
            //console.log('computer');
            /*
               $('.cell').each((i,e)=>{// cell 클래스에 소속된 모든것을 찾고 해당되는
               //console.log(i,e);
                console.log($(e).text()); //제이쿼리는 오리지날 태그가 없어서 가공 해야함
            });  
             */
            
            if(!isCellChecked(no)){
                checkCell(no,'computer');
                return;
            }
        }
    }, 1000);
});

$('#new-game').click((e)=>{
    console.log('new game');
    
});

function isCellChecked(no){
    return cells[no].innerHTML != "" ? true : false;
}

function checkCell(no,gamer){
    cells[no].innerHTML = 
        (gamer == 'computer') ? computer : human;
}





