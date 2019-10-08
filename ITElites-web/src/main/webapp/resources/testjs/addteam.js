
$(function () {
    var url = '/team/add.do';
    $('#submit').click(function () {
        var verifyCodeActual = $('#j_captcha').val();
        if (verifyCodeActual == null || verifyCodeActual.trim() == "" || verifyCodeActual.length != 4) {
            $.toast('请填写正确的验证码');
            return;
        }
        var team = {};
        team.teamName = $('#team-name').val();
        team.teamDesc = $('#team-desc').val();
        if (team.teamName == null || team.teamName.trim() == ""){
            $.toast("请填写大组名称");
        }
        alert(JSON.stringify(team));
        $.ajax({
            url: url + "?verifyCodeActual=" + verifyCodeActual.trim(),
            type: 'POST',
            data: JSON.stringify(team),
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