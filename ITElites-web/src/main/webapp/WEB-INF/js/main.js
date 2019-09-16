/* ******* 主页的js内容 ******* */

    //获取鼠标位置
    function getPos(ev) {
        var scrollTop =
            document.documentElement.scrollTop || document.body.scrollTop;
        var scrollLeft =
            document.documentElement.scrollLeft || document.body.scrollLeft;
            
        return { 
            x: ev.clientX + scrollLeft, 
            y: ev.clientY + scrollTop 
        };
    }
    // 跟随鼠标移动函数
    document.onmousemove = function(ev) {
        var oEvent = ev || event;
        var title = document.getElementById("title");
        var banners1 = document.getElementById("banners1");
        var banners2 = document.getElementById("banners2");
        var pos = getPos(oEvent);

        title.style.left = (pos.x - 760) * 0.01 + "px";
        title.style.top = (pos.y - 237) * 0.01 + "px";
        banners1.style.left = (pos.x - 760) * 0.01 + "px";
        banners1.style.top = (pos.y - 325) * 0.01 + "px";
        banners2.style.left = (pos.x - 760) * 0.01 + "px";
        banners2.style.top = (pos.y - 365) * 0.01 + "px";
    };
    var NavHeight = document.getElementById("header").offsetHeight;

    $(document).ready(function() {
        //主页元素高度适应屏幕
        var windowHeight = $(window).height();
        var Height = windowHeight-0.02;    // 解决position:fixed的margin-top塌陷问题
        $("#LunBo").height(Height);
        $("#shadow").height(Height);
        $(".Achievements").height(2.3*Height);
        $(".AchievementsShadow").height(2*Height);

        //向下滚动动态效果
        function downAnimate() {
            $("#LunBo").css("margin-top",-Height);
            $(".AchievementsTitle").animate({ opacity:"1" },1700,function(){
                $(".AchievementsBanners").animate({ opacity:"1" },800);
                $(".AchievementsNavOuter").animate({ width:"90%" },1400);
                $(".AchievementsNavInner").animate({ width:"80%" },100);
                $(".AchievementsNavTest").fadeIn(800,function(){
                    $(".AchievementsModule").each(function(){
                        $(this).animate({ opacity:"1" },2000);
                    });
                    $("#upBlock").animate({ opacity:"1" },1000);
                });
            });
            $("body").css("overflow-y","visible");
        }
        //向下图标hover事件
        $("#downBlock").hover(
            function() {
                $("#downBlock").css("top", "88%");
                $(this).click(function(){
                    downAnimate();
                });
            },
            function() {
                $("#downBlock").css("top", "85%");
            }
        );
                
        //向上滚动动态效果
        function upAnimate() {
            $("#LunBo").css("margin-top",0);
            $("body").css("overflow-y","hidden");
        }
        //向上图标hover事件
        $("#upBlock").hover(
            function(){
                $("#upBlock").css("top", "3.5%");
                $(this).click(function(){
                    upAnimate();
                });
            },
            function(){
                $("#upBlock").css("top", "5%");
            }
        );

        // 鼠标滚动事件(效果等同点击上下图标)

        // $("#LunBo").scroll(
        //     function(){
        //         var scrollHeight = $(document).scrollTop();  // 滚动高度
        //         var windowHeight = $(window).height();       // 屏幕高度
        //         var contentHeight = $(document).height();    // 内容高度

        //         console.log("222")
        //         if(scrollHeight >= windowHeight-0.02){
        //             console.log("111");
        //         }
        //     }
        // );
        // document.addEventListener('touchstart', function(event) {
        //     // 判断默认行为是否可以被禁用
        //     if (event.cancelable) {
        //         // 判断默认行为是否已经被禁用
        //         if (!event.defaultPrevented) {
        //             event.preventDefault();
        //         }
        //     }
        // }, false);
        // $(window).bind('mousewheel', function(event, delta) {
        //     var dir = delta > 0 ? 'Up' : 'Down';
        //     console.log(dir)
        //     if (dir == 'Up') {
        //         console.log("向上滚动");
        //     } else if(dir == "Down") {
        //         console.log("向下滚动");
        //     }
        //     return false;
        // })


        


    });