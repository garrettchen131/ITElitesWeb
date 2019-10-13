$(document).ready(function(){
    // 替换背景图片
    var hW = $(document).width();
    $(window).scroll(function(){
        if($(this).scrollTop()>=2000){
            if(hW < 750){
                $(".bgImg").css({"background-image":"url(/resources/static/groundImg_phone.jpg)", "background-position" : "0 0"});
            }
            else{
                $(".bgImg").css({"background-image":"url(/resources/static/groundImg.jpg)", "background-position" : "0 0"});
            }
        }
        else{
            $(".bgImg").css({"background-image":"url(/resources/static/joinbgimg2.jpg)", "background-position" : "0 -30vh"});
        }
    })
    // 表单志愿单选效果
    $("#firstcheckLabel .checkImg").eq(0).attr("src", "/resources/static/checkImg.png");
    $("#secondcheckLabel .checkImg").eq(0).attr("src", "/resources/static/checkImg.png");

    $("#firstcheckLabel>.checklabel").mouseup(function () { 
        $("#firstcheckLabel .checkImg").attr("src", "/resources/static/checkBgImg.png");
        var i = $(this).index()
        $("#firstcheckLabel .checkImg").eq(i).attr("src", "/resources/static/checkImg.png")
    });
    $("#secondcheckLabel>.checklabel").mouseup(function () { 
        $("#secondcheckLabel .checkImg").attr("src", "/resources/static/checkBgImg.png");
        var i = $(this).index()
        $("#secondcheckLabel .checkImg").eq(i).attr("src", "/resources/static/checkImg.png");

    });


    var introTitleH = $(".introTitle").height()*1.2;
    $(".introTitleBlock").height(introTitleH);
    var introTitleTop = introTitleH*(-1);
    $(".introTitle").css({"top":introTitleTop})

    var getTeamUrl = '/team/get.do'; //获取大组的接口
    

    


})

function isSno(str) {
    var reg=/^[2][0-9]{9}$/;
    return reg.test(str);
}
function isTelephone(str) {
    var reg=/^[1][0-9]{10}$/;
    return reg.test(str);
}


function changeVerifyCode(img) {
    img.src = "../Kaptcha?" + Math.floor(Math.random() * 100);
}

var addApplicantUrl = '/applicant/add.do'; //提交表单的接口


$(".submitBtn").click(function(){
    var verifyCodeActual = $("#varifyInput").val();
    if (verifyCodeActual == null || verifyCodeActual.trim() == "" || verifyCodeActual.length != 4) {
        alert('请填写正确的验证码');
        $(verifyCodeActual).val("");
        return;
    }

    var applicant = {};
    applicant.applicantNum = $('#snoInput').val();
    applicant.applicantName = $('#nameInput').val();
    applicant.phone = $('#telInput').val();
    applicant.qq = $('#qqInput').val();
    applicant.teamOne = $("input[name='checklistFirst']:checked").val();
    applicant.teamTwo = $("input[name='checklistSecond']:checked").val();


    if(applicant.applicantName == null || applicant.applicantName.trim() == ""){
        alert("姓名不能为空");
        return ;
    }
    else if(applicant.applicantNum == null || applicant.applicantNum.trim() == ""){
        alert("学号不能为空");
        return ;
    }
    else if(!isSno(applicant.applicantNum)){
        alert("请填写正确的学号");
        return ;
    }
    else if(applicant.phone == null || applicant.phone.trim() == ""){
        alert("电话号码不能为空");
        return ;
    }
    else if(!isTelephone(applicant.phone)){
        alert("请填写正确的电话号码");
        return ;
    }
    else if(applicant.qq == null || applicant.qq.trim() == ""){
        alert("QQ不能为空");
        return ;
    }

    $("#nameInput").val("");
    $("#snoInput").val("");
    $("#telInput").val("");
    $("#qqInput").val("");
    $("input[name='checklistFirst']:checked").val("0");
    $("input[name='checklistSecond']:checked").val("0");

    $.ajax({
        url: addApplicantUrl + "?verifyCodeActual=" + verifyCodeActual.trim(),
        type: 'POST',
        data: JSON.stringify(applicant),
        contentType: 'application/json',
        dataType: 'json',
        success: function (data) {
            if (data.error == 0) {
                alert('添加成功');
            } else {
                alert('添加失败 ' + data.reason);
            }
            $('#verifyImg').click();
        }
    });
})
//TODO 做一下前端常规验证


