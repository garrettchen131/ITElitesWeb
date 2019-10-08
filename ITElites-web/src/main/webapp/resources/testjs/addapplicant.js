
$(function () {
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
                $('#team-one').html(teamHtml);
                $('#team-two').html(teamHtml);
                teamHtml = '';
            }
        }
    });


    $('#submit').click(function () {
        var verifyCodeActual = $('#j_captcha').val();
        if (verifyCodeActual == null || verifyCodeActual.trim() == "" || verifyCodeActual.length != 4) {
            $.toast('请填写正确的验证码');
            return;
        }
        var applicant = {};
        applicant.applicantNum = $('#num').val();
        applicant.applicantName = $('#name').val();
        applicant.phone = $('#phone').val();
        applicant.qq = $('#qq').val();
        applicant.teamOne = $('#team-one').find('option').not(function () {
            return !this.selected;
        }).attr('data-id');
        applicant.teamTwo = $('#team-two').find('option').not(function () {
            return !this.selected;
        }).attr('data-id');

        //TODO 做一下前端常规验证

        console.log(JSON.stringify(applicant));
        $.ajax({
            url: addApplicantUrl + "?verifyCodeActual=" + verifyCodeActual.trim(),
            type: 'POST',
            data: JSON.stringify(applicant),
            contentType: 'application/json',
            dataType: 'json',
            success: function (data) {
                if (data.error == 0) {
                    $.toast('添加成功');
                } else {
                    $.toast('添加失败');
                    console.log(data.reason);
                }
                $('#captcha_img').click();
            }
        })
    });
})