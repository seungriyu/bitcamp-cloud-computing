<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>멤버 목록</title>
</head>
<body>
<h1>멤버 목록5</h1>
<p><a href='form'>새회원</a></p>

<table id="eListTable" border='1'>
<thead>
  <tr><th>아이디</th><th>이메일</th></tr>
</thead>
<tbody></tbody>
</table>

<div>
  <button id="ePrevBtn">이전</button>
  <span id="ePageNo"></span> 
  <button id="eNextBtn">다음</button>
</div>


<script src="../js/common.js"></script>
<script>
"use strict"
var {page, size} = parseQuery(location.href);
let tbody = document.querySelector('#eListTable > tbody'); 
let data = null;
if (page != undefined && size != undefined) {
    loadList(page, size);
} else {
    loadList(1, 3);
}
ePrevBtn.onclick = function() {
    loadList(data.page - 1, data.size);
};
eNextBtn.onclick = function() {
    loadList(data.page + 1, data.size);
};
function loadList(page, size) {
    var xhr = new XMLHttpRequest();
    
    xhr.onreadystatechange = function() {
        if (xhr.readyState < 4) return;
        if (xhr.status !== 200) {
            alert("서버에서 오류 발생!");
            return;
        }
        data = JSON.parse(xhr.responseText);
        tbody.innerHTML = '';
        for (var item of data.list) {
            var tr = document.createElement("tr");
            tr.innerHTML = 
                `<td><a href='#' data-id='${item.id}' onclick='clickViewLink(event)'>${item.id}</a></td>
                <td>${item.email}</td>`;
            tbody.appendChild(tr);
        }
        
        ePageNo.innerHTML = data.page;
        if (data.page <= 1)
            ePrevBtn.setAttribute('disabled', '');
        else 
            ePrevBtn.removeAttribute('disabled');
        
        if (data.page >= data.totalPage)
            eNextBtn.setAttribute('disabled', '');
        else
            eNextBtn.removeAttribute('disabled');
    };
    
    xhr.open('GET', 
            `../../json/member/list?page=${page}&size=${size}`, 
            true);
    xhr.send();
}
function clickViewLink(event) {
    event.preventDefault();
    var id = event.currentTarget.getAttribute('data-id');
    location.href = `view.html?id=${id}&page=${data.page}&size=${data.size}`;
}
</script>

</body>
</html>