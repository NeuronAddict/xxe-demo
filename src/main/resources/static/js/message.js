$('submit').onclick(function () {
    message = $('message').value;
    $.ajax({
        type: "POST",
        url: "/api/send",
        dataType: "xml",
        data: '<Message><text>' + message + '</text></Message>',
        success: function(xml) {
            $('feedback').innerText = "message envoyé";
        },
        error: function (jqXHR, textStatus, errorThrown) {
            $('feedback').innerText = textStatus + " " + errorThrown;
        }
    });
    return false;
});