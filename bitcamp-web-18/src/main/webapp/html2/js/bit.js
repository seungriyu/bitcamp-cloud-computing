// 자주 사용할 함수를 라이브러리화 시킨다. 
"use strict"
let bit = function(value){
    var el = [];
    if(value instanceof HTMLElement){
        el[0] = value;
    }else if(value.startsWith('<')){
        el[0]= document.createElement(value.substr(1,value.length-2));
    }else{
        var list = document.querySelectorAll(value);
        for(var i=0;i<list.length;i++){
            el[i] = list[i];
        }
    }
    //개발자가 쓰기 좋은 함수를 추가해서 리턴하자!
    el.html = function(value){
        if(arguments.length ==0){
            return el[0].innerHTML; //값을 리턴하라!
        }
        for(var e of el)
            e.innerHTML = value;
        return el;
    };
    el.append= function(chile){
        for(var e of el)
            e.appendChild(child);
        return el;
    };
    el.appendTo = function(parent){
        for(var e of el)
            parent[parent.length -1].appendChild(e);//parent의 막내 부모에 appendChild를 추가
        return el;
    };
    el.attr = function(name,value){
        if(arguments.length <2){ //아규먼트가 1개라면 
            return el[0].getAttribute(name); //그 속성의 값을 줘라!
        }
        for(var e of el)
            e.setAttribute(name, value);
        return el;
    };
    el.removeAttr = function(name){
        for(var e of el )
            e.removeAttribute(name);
        return el;
    };
    
    el.on = function(name,p2,p3){
        var selector = null;
        var handler = null;
        
        if(arguments.length == 2) handler = p2;
        if(arguments.length == 3) {
            selector = p2;
            handler = p3;
        }
        for(var e of el) {
            if(!selector){ 
                //selector가 지정되어 있지 않으면,
                //해당 태그에 대해 이벤트가 발생했을 때 핸들러를 호출한다.
                //ex) 이전 , 다음
                e.addEventListener(name,handler);
            }else{
                //selector가 지정되어 있으면
                //핸들러를 호출하기 전에 selector에 해당하는 것인지 검사하는 함수가 먼저 호출되게 한다.
                e.addEventListener(name, function(event){
                    //selectorTargets : 클릭하는 시점에 찾는다.
                    //현재 태그의 자식 태그 중에서 selector 조건에 해당되는 자식 태그들을 찾는다.
                    var selectorTargets = e.querySelectorAll(selector); 
                    
                    //그 자식 태그들 중에 이 이벤트가 발생된 태그를 찾는다.
                    for(var target of selectorTargets){
                        //만약 이벤트가 발생된 태그와 일치하는 자식 태그가 있다면, 
                        //그때서야 핸들러를 호출해준다.
                        if (event.target == target){
                            handler(event);
                            break;
                        }
                    }
                    
                    
                });
            }
        }
        
        return el;
    };
    
    el.click = function(handler){
       
          return el.on('click',handler);
       
    };
    
    return el;
   
};


bit.parseQuery = function(url) {
    var paramMap = {};

    var qs = url.split('?');
    if (qs.length > 1) {
        var params = qs[1].split('&');
        for (var param of params) {
            var kv = param.split('=')
            paramMap[kv[0]] = kv[1];
        }
    }
    return paramMap;
};

bit.ajax = function(url,settings){
    
    if(settings == undefined)
        settings = {};
    if(settings.dataType == undefined) 
        settings.dataType = 'text'; //서버에서 리턴한 걸 그대로 리턴해 !
    if(settings.method == undefined)
        settings.dataType = 'GET';
    
    var xhr = new XMLHttpRequest();
    
    xhr.onreadystatechange = function() {
        if (xhr.readyState < 4) return;
        if (xhr.status !== 200) {
            if(settings.error)
                erro(); //에러라는 함수가 정의되어 있따면 호출
            return;
        }
        
        let data = xhr.responseText;
        
        if(settings.dataType=='json');{
            data = JSON.parse(xhr.responseText);
            //json이라면 객체로 파싱해서 넣어야함
        }
        if(settings.success){//settings라는 객체 안에 성공했을때 호출될 success가 있다면 , 데이타 타입이
            
            settings.success(data);
            
            
        }
        //done()에 의해 등록된  함수가 등록되어 있다면, 그 함수를 호출한다.
        
        if(done){
            done(data);
        }
        
    };
    
    //settings에 서버로 보낼 data가 있다면 url에 포함해야 한다.
    if(settings.data){ //세팅스에 데이터가 있다면
        var qs = ''; 
        for(var propName in settings.data){
            qs += `&${propName}=${settings.data[propName]}`;
        }
        
        if(url.indexOf('?') == -1)//?문자가 포함되지 않았다면 url뒤에다가 ?를 넣어라
            url += '?';
        url += qs; // 물음표 뒤에 그리고 qs 붙여라
    }
    
    console.log(url);
    
    xhr.open(settings.method,url,true);
    xhr.send();
    
    //XMLHttpRequest 객체를 리턴하기 전에 함수를 추가한다.
    let done = null;
    xhr.done = function(func){
        done = func;
    };
    
    return xhr;
    
};

bit.getJSON = function(url, p2, p3){
    let data = {};
    let success = null;
    
    if(arguments.length> 1){
        if(typeof p2 == "function") success = p2; //p2가 함수가 아니라면 data에 p2넣기 
        else data =p2;//만약 p2가 함수라면 success 에 p2넣기
        if(typeof p3 == "function") success = p3;
    
    }
    
    return bit.ajax(url,{
        dataType : 'json',
        data : data,
        success : success
    });
    
}


let $ = bit; //bit나 $나 같은 객체를 가리킨다.


