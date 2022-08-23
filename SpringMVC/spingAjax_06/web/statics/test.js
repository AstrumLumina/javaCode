//函数 例子
$.ajax({
    //提交数据的类型 POST GET
    type:"POST",
    //提交的网址
    url:"${path}/dependentOffice/checkName",
    //提交的数据
    data: JSON.stringify(GetJsonData()),
    //参数格式为json
    contentType: "application/json; charset=utf-8",
    //返回数据的格式
    datatype: "json",//"xml", "html", "script", "json", "jsonp", "text".
    //成功返回之后调用的函数
    success:function(data){
        alert(data);
    },
    //调用出错执行的函数
    error: function(){
        //请求出错处理
        alert("请求失败");
    }
});
$(function(){
    //隐藏警告信息
    $(".alert-warning").hide();

    $("#dependentName").blur(function(){
        $.ajax({
            //提交数据的类型 POST GET
            type:"POST",
            //提交的网址
            url:"${path}/dependentOffice/checkName",
            //提交的数据
            data: JSON.stringify(GetJsonData()),　　　　　　　　　　  //参数格式为json
            contentType: "application/json; charset=utf-8",
            //返回数据的格式
            datatype: "json",//"xml", "html", "script", "json", "jsonp", "text".
            //成功返回之后调用的函数
            success:function(data){
                alert(data);
            },
            //调用出错执行的函数
            error: function(){
                //请求出错处理
                alert("请求失败");
            }

        });
    });
    //json格式的数据源
    function GetJsonData() {
        var json = {
            "userName": 'Tom',
            "tel": '10086'
        };
        return json;
    }

});