

$(function () {
    var getTeamUrl = '/team/get.do';
    var addGroupUrl = '/group/add.do';
    var teamHtml = '';
    $.ajax({
        url: getTeamUrl,
        type: "GET",
        dataType: 'json',
        success: function (data) {
            if (data.error == 0) {
                data.data.map(function (item,index) {
                    teamHtml += '<option data-id="' + item.teamId + '">' +item.teamName + '</option>';
                });
                $('#team').html(teamHtml);
                teamHtml = '';
            }
        }
    });

    $('#submit').click(function () {
        var groupInfo = {};
        groupInfo.groupName = $('#group-name').val();
        if (groupInfo.groupName == null || groupInfo.groupName.trim() == ''){
            $.toast('请填写小组名称');
            return;
        }
        groupInfo.teamId = $('#team').find('option').not(function () {
            return !this.selected;
        }).attr('data-id');
        if (groupInfo.teamId == null){
            $.toast('请填写有效的大组');
            return;
        }
        groupInfo.groupDesc = $('#group-name').val();
        var verifyCodeActual = $('#j_captcha').val();
        if (verifyCodeActual == null || verifyCodeActual == "" || verifyCodeActual.length != 4){
            $.toast('请填写正确的验证码');
            return;
        }

        $.ajax({
            url: addGroupUrl + '?verifyCodeActual=' +verifyCodeActual.trim(),
            type: "POST",
            data: JSON.stringify(groupInfo),
            contentType: 'application/json',
            dataType: 'json',
            success: function (data) {
                if (data.error == 0) {
                    $.toast('添加成功');
                }else {
                    $.toast('添加失败');
                }
                $('#captcha_img').click();

            }
        });
    });
})