/* ******* 概况的js内容 ******* */

$(document).ready(function() {
    //概况元素高度适应屏幕
    var windowHeight = $(window).height();
    var Height = windowHeight-0.02;    // 解决position:fixed的margin-top塌陷问题
    $("#Aside").height(Height);
    $("#overshadow").height(Height);
    $(".groupIntroduce").height(Height);


    // 各组介绍(概况)
    function showaAsideStyle(index) {
        $(".asides")
        .eq(index)
        .stop(true)
        .animate(
            { width: "100%", backgroundColor: "#8abde5", left: "0" },
            500,
            function() {
            $(this)
                .children("span")
                .show();
            }
        );
    }
    function hideAsideStyle(index) {
        $(".asides")
        .eq(index)
        .children("span")
        .hide();
        $(".asides")
        .eq(index)
        .stop(true)
        .animate(
            { width: "28%", backgroundColor: "transparent", left: "72%" },
            500
        );
    }
    //侧边栏hover事件
    $(".sort").hide();
    var check = 0;   //当前选中
    $(".sort")
        .eq(0)
        .show();
    $(".asides")
        .eq(0)
        .css({width: "100%", backgroundColor: "#8abde5", left: "0"});
    $(".asides").hover(
        function() {
        var index = $(this).index();
        showaAsideStyle(index);
        $(this).click(
            function(){
            check = index;
            var len = $(".asides").length;
            for(var i = 0; i < len; i++){
                if(i != check){
                hideAsideStyle(i);
                }
            }
            //侧边栏点击定位
            switch(index){
                case(0):
                    var ITTop = $("#introduceITCultivate").offset().top;
                    ScrollTop = ITTop-135;
                    break;
                case(1):
                    var ITTop = $("#BianChengGroup").offset().top;
                    ScrollTop = ITTop-160;
                    break;
                case(2):
                    var ITTop = $("#ArtGroup").offset().top;
                    ScrollTop = ITTop-160;
                    break;
                case(3):
                    var ITTop = $("#productsGroup").offset().top;
                    ScrollTop = ITTop-160;
                    break;
                case(4):
                    var ITTop = $("#teacherSkillGroup").offset().top;
                    ScrollTop = ITTop-160;
                    break;
                case(5):
                    var ITTop = $("#mediaGroup").offset().top;
                    ScrollTop = ITTop-160;
                    break;
            }
            window.scroll(0,ScrollTop);
        });
        },
        function() {
        var index = $(this).index();
        if(check != index){
            hideAsideStyle(index);
        }
        }
    );


    //IT培优介绍 详情按钮
    $("#ITcontent button").hover(
        function(){
            $(this).css({"right":"12%","transition":"1s"});
        },
        function(){
            $(this).css({"right":"15%","transition":"1s"});
        }
    );


    //各小组交互
    $(".groupsBlockTitle").mouseover(function(){
        //初始化各组标签
        $(".groupsBlockTitle_click").attr("class","groupsBlockTitle");
        $(".groupsBlockContent_click").find("p").attr("class","groupsBlockContent_p");
        $(".groupsBlockContent_click").attr("class","groupsBlockContent");
        $(".groupsBlock_click").attr("class","groupsBlock");
        //改变当前标签
        $(".InitialIntroduce").hide();
        $(this).attr("class","groupsBlockTitle_click");
        $(this).next(".groupsBlockContent").attr("class","groupsBlockContent_click");
        $(this).parent(".groupsBlock").attr("class","groupsBlock_click");
        $(this).next(".groupsBlockContent_click").find("p").attr("class","groupsBlockContent_click_p");
        $(this).children().css({"text-decoration":"underline"})
    });
    $(".groupsBlockTitle").mouseout(function(){
        $(this).children().css({"text-decoration":"none"})
    });

    //大组点击交互
    $(".InitialBlockTitle").mouseover(function(){
        $(".groupsBlockTitle_click").attr("class","groupsBlockTitle");
        $(".groupsBlockContent_click").find("p").attr("class","groupsBlockContent_p");
        $(".groupsBlockContent_click").attr("class","groupsBlockContent");
        $(".groupsBlock_click").attr("class","groupsBlock");
        $(".InitialIntroduce").show();
        $(this).children().css({"text-decoration":"underline"})
    });
    $(".InitialBlockTitle").mouseout(function(){
        $(this).children().css({"text-decoration":"none"})
    });

})