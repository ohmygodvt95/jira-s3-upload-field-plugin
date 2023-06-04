AJS.toInit(function ($) {
    console.log('toInit')
    $(document).on('click', '#s3-upload', function () {
        console.log('s3-upload')
        AJS.$.ajax({
            url: '/jira/rest/s3-field/1.0/message',
            type: 'GET',
            dataType: 'json',
            success: function (data) {
                // Thông tin nhận được từ API sẽ có trong biến data
                alert(data.message);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert('Error: ' + textStatus + ' ' + errorThrown);
            }
        });
    })
});