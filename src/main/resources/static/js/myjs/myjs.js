function initSelect(url,elem,obj){

    $.ajax({
        type:"post",
        url:url,
        cache:false,
        async:false,
        data:obj,
        success:function (result) {
            var data = result.data;
            if(data == null){
                return;
            }
            for(var i=0;i<data.length;i++){
                elem.append("<option  value='"+ data[i].id+"'>"+data[i].name +"</option>");
            }
        }
    });
}