$(document).ready(function() {
    //轮播高度适应屏幕
    var windowHeight = $(window).height();
	var Height = windowHeight;
	$("body").height(8*Height);
	$("#particles").height(Height);
    $(".groundImg").height(Height);
	$(".titleBox").height(0.96*Height);
	$(".signUpBox").height(0.47*Height);
	$.get('../img/groundImg1.jpg');
	$.get('../img/groundImg2.jpg');
	var titleBoxTop = $(".introduce").offset().top;
	var introduceTop = $(".introduce").height();
	var introduceUnderTop = introduceTop-Height;
	
	
	var addApplicantUrl = '/applicant/add.do'; //提交表单的接口
	var getTeamUrl = '/team/get.do'; //获取大组的接口
	var teamHtml = '';  //填充大组的html
	$.ajax({
	    url: getTeamUrl,
	    type: "GET",
	    dataType: 'json',
	    success: function (data) {
	        if (data.error == 0) {
	            data.data.map(function (item,index) {
	                teamHtml += '<option data-id="' + item.teamId + '">' +item.teamName + '</option>';
	            });
	            $('#firstChoice').html(teamHtml);
	            $('#secondChoice').html(teamHtml);
	            teamHtml = '';
	        }
	    }
	});
	
	
	var isGroundImg1 = true;
	$(window).scroll(function(){
		if($(this).scrollTop()>=2600 && isGroundImg1==true){
			isGroundImg1 = false;
			$(".groundImg").css("background-image","url(./img/groundImg2.jpg)");
		}
		if($(this).scrollTop()<2600 && isGroundImg1==false){
			isGroundImg1 = true;
			$(".groundImg").css("background-image","url(./img/groundImg1.jpg)");
		}
		if($(this).scrollTop()>=titleBoxTop){
			$("#particles").css({"position":"fixed"});
		}
		else if($(this).scrollTop()<titleBoxTop){
			$("#particles").css({"position":"relative","top":"0"});
		}
		if($(this).scrollTop()>=introduceTop){
			$("#particles").css({"position":"relative","top":introduceUnderTop});
		}
		else if($(this).scrollTop()<introduceTop){
			$("#particles").css({"top":"0"});
		}
	})
	
	$(".group").click(function(){
		alert("暂未开放，敬请期待");
	})

	$('#particles').particleground({
		// 粒子颜色
		dotColor: 'rgb(105, 220, 255)',
		// 线颜色
		lineColor: 'rgb(133, 130, 130)'
	});
	
	
	function isId(str) {
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
	$(".informationSubmit").click(function(){
		$(".namePrompt").css("visibility","hidden");
		$(".idPrompt").css("visibility","hidden");
		$(".telephonePrompt").css("visibility","hidden");
		$(".QQPrompt").css("visibility","hidden");
		$(".firstChoicePrompt").css("visibility","hidden");
		$(".secondChoicePrompt").css("visibility","hidden");
		$(".verificationCodePrompt").css("visibility","hidden");
		if($(".nameInput").val()==""){
			$(".namePrompt").css("visibility","visible");
			return ;
		}
		if($(".idInput").val()==""){
			$(".idPrompt").html("请输入您的学号");
			$(".idPrompt").css("visibility","visible");
			return ;
		}
		if(!isId($(".idInput").val())){
			$(".idPrompt").html("请正确输入学号");
			$(".idPrompt").css("visibility","visible");
			return ;
		}
		if($(".telephoneInput").val()==""){
			$(".telephonePrompt").html("请输入您的电话号码");
			$(".telephonePrompt").css("visibility","visible");
			return ;
		}
		if(!isTelephone($(".telephoneInput").val())){
			$(".telephonePrompt").html("请正确输入电话号码");
			$(".telephonePrompt").css("visibility","visible");
			return ;
		}
		if($(".QQInput").val()==""){
			$(".QQPrompt").css("visibility","visible");
			return ;
		}
		if($(".firstChoiceInput").val()==""){
			$(".firstChoicePrompt").css("visibility","visible");
			return ;
		}
		if($(".secondChoiceInput").val()==""){
			$(".secondChoicePrompt").css("visibility","visible");
			return ;
		}
		var verifyCodeActual = $('#j_captcha').val();
		if (verifyCodeActual == null || verifyCodeActual.trim() == "" || verifyCodeActual.length != 4) {
		    $(".verificationCodePrompt").css("visibility","visible");
		    return ;
		}
		
		var applicant = {};
		applicant.applicantName = $(".nameInput").val();
		applicant.applicantId = $(".idInput").val();
		applicant.phone = $(".telephoneInput").val();
		applicant.qq = $(".QQInput").val();
		applicant.teamOne = $(".firstChoiceInput").find('option').not(function () {
		    return !this.selected;
		}).attr('data-id');
		applicant.teamTwo = $(".secondChoiceInput").find('option').not(function () {
		    return !this.selected;
		}).attr('data-id');
		
		console.log(JSON.stringify(applicant));
		$.ajax({
		    url: addApplicantUrl + "?verifyCodeActual=" + verifyCodeActual.trim(),
		    type: 'POST',
		    data: JSON.stringify(applicant),
		    contentType: 'application/json',
		    dataType: 'json',
		    success: function (data) {
		        if (data.error == 0) {
		            alert("添加成功");
		        } else {
		            alert("添加失败");
		            console.log(data.reason);
		        }
		        $('#captcha_img').click();
		    }
		})
		
		$(".nameInput").val("");
		$(".idInput").val("");
		$(".telephoneInput").val("");
		$(".QQInput").val("");
		$(".firstChoiceInput").val("");
		$(".secondChoiceInput").val("");
		$(".verificationCodeInput").val("");
	})
  
	
})
