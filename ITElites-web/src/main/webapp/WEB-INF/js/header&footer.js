$(document).ready(function() {
    //搜索框样式
    $("#searchInput").css({"display":"block"}).hide();   //解决刷新页面情况下闪藏问题
    $("#sBlockIcon").css({"display":"block"}).hide();
    $("#search").css({"width":"0","border":"0"});
    $("#searchblock").hover(function(){
        $("#search").css({"width":"15%","border":"1px solid #a5a5a8","transition":"0.8s"});
        $("#searchIcon").hide();
        $("#sBlockIcon").show();
        $("#searchInput").show();
    }
    ,function(){
        var value = $("#searchInput").val();
        if(value == ""){
            $("#searchInput").hide();
            $("#sBlockIcon").hide();
            $("#search").css({"width":"0","border":"0","transition":"1s"});
            $("#searchIcon").show();
        }
    })
    
})