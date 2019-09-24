
$(function () {
    var url = '/team/add.do';
    $('#submit').click(function () {
        var team = {};
        team.teamName = $('#team-name').val();
        team.teamDesc = $('#team-desc').val();
        alert(team);
        alert(JSON.stringify(team));
        $.ajax({
            url: url,
            type: 'POST',
            data: JSON.stringify(team),
            contentType: 'application/json',
            dataType: 'json',
            success: function (data) {
                if (data.error == 0) {
                    $.toast('添加成功');
                }else{
                    $.toast('添加失败');
                    console(data.reason);
                }
            }
        })
    })
})