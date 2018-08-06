
var human = 'X',
    computer = "O",
    cells = $('.cell'),
    count = 0,
    isCompleted= false;

$('#cell-box').on('complete',(e,result)=> {
    setTimeout(()=>{
        if(result==1) alert("인간 승!");
        else if(result== -1) alert("컴퓨터 승!");
    });
});
        

$('.cell').click((e)=>{
    if(isCompleted return;
    
    
    
    console.log($(e.target).attr('data-pos'));// 태그의 속성값 알고싶으면 getAttribute
    $(e.target).text(human);
    count++;
    
    var result = computeGame();
    if(result !=0){
        $('#cell-box').trigger('complete',[result]);
        isCompleted = ture;
    }    
//    if(result==1) alert("인간 승!");
//    else if(result== -1) alert("컴퓨터 승!")
    
    if(isCompleted) return;
    
    // 타이머를 가동하여 1초 후에 컴퓨터가 표시하게 한다.
    setTimeout(() => {
        
        while(true){
        
            var no = Math.floor(Math.random()*9);
             
            // console.log(no, Math.floor(no)); // floor: 정수값의 바닥에 맞춰리ㅏ
            // console.log(no, parseInt(no));
            // console.log('computer');
            /*
             * $('.cell').each((i,e)=>{// cell 클래스에 소속된 모든것을 찾고 해당되는
             * //console.log(i,e); console.log($(e).text()); //제이쿼리는 오리지날 태그가
             * 없어서 가공 해야함 });
             */
            
            if(!isCellChecked(no)){
                checkCell(no,'computer');
                break;
            }
        }
        var result = computeGame();
        if(result !=0){
            $('#cell-box').trigger('complete',[result]);
            isCompleted = ture;
        }else if(count ==5){
            alert("비겼다@!")
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

function computeGame(){
    console.log("-------------------------------")
    for (var row=0;row<9;row +=3){
        var countHuman =0;
        var countComputer =0;
        for(var i=row;i<(row+3);i++){
            if(cells[i].innerHTML == human) countHuman++;
            else if(cells[i].innerHTML == computer) countComputer++;
        }
        if(countHuman == 3) return 1;
        else if(countComputer == 3) return -1;
        console.log(countHuman, countComputer);
    }
    
    
    for (var col=0;col<9;col +=3){
        var countHuman =0;
        var countComputer =0;
        for(var i=col;i<=(col+6);i++){
            if(cells[i].innerHTML == human) countHuman++;
            else if(cells[i].innerHTML == computer) countComputer++;
        }
        if(countHuman == 3) return 1;
        else if(countComputer == 3) return -1;
        console.log(countHuman, countComputer);

    }
    
    var countHuman =0;
    var countComputer =0;
    for(var i=0;i<9;i+=4){
        if(cells[i].innerHTML == human) countHuman++;
        else if(cells[i].innerHTML == computer) countComputer++;
    }    
    if(countHuman == 3) return 1;
    else if(countComputer == 3) return -1;
    console.log(countHuman, countComputer);

    var countHuman =0;
    var countComputer =0;
    for(var i=2;i<6;i+=2){
        if(cells[i].innerHTML == human) countHuman++;
        else if(cells[i].innerHTML == computer) countComputer++;
    }    
    if(countHuman == 3) return 1;
    else if(countComputer == 3) return -1;
    console.log(countHuman, countComputer);

    return 0;
        
        
    
}



