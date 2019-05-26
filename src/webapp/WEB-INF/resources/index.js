$(function() {
    var url='diaisheng/admin/getvaluebetweendate';
    var formData=new FormData();

    $("#submit").click(function () {
        var pointId = $("#pointId").value();
        var beginDate = $('#beginDate').value();
        var endDate = $('#endDate').value();

        formData.append("dataPointId", pointId);
        formData.append("startDate", beginDate);
        formData.append("endDate", endDate);

        $.ajax({
            url: url,
            type: 'GET',
            data: formData,
            contentType: false,
            processData: false,
            cache: false,
            success: function (data) {
                if (data.success) {
                    alert('提交成功');
                } else {
                    alert('提交失败!' + data.errorMsg);
                }
            },
            error:function (data,error) {
                alert(error);

            }

        });
    });

}