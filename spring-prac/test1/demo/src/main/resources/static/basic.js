
$(document).ready(function (){
    getMemo();
})

function writeMemo(){
    $.ajax({
        type:"POST",
        url: "/memos",
        contentType:"application/json",
        data:JSON.stringify({content:$('#content').val()}),
        success:function (response){
            if(confirm("저장하시겠습니까?")){
                window.location.reload();
            }else{
                $('#content').val('');
            }
        }
    })
}

function getMemo(){
    $.ajax({
        type:"GET",
        url: "/memos",
        success:function (response){
            $('#acticle').empty();
            for(let i=0;i<response.length;i++){
                let memo = response[i];
                $("#acticle").append(`<p>${memo.content}</p>`);
            }
        }
    })
}

