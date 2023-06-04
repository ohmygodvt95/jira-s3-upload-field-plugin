AJS.toInit(function ($) {
    $(document).on('click', '#s3-upload', function () {
        var fieldId = $(this).attr('data-field-id');
        AJS.$.ajax({
            url: '/jira/rest/s3-field/1.0/upload-presigned-url',
            type: 'GET',
            dataType: 'json',
            success: function (data) {
                // Thông tin nhận được từ API sẽ có trong biến data
                console.log(data.value);
                $('input#' + fieldId).val(data.value);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert('Error: ' + textStatus + ' ' + errorThrown);
            }
        });
    })
});