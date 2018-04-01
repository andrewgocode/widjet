var user_name = $("#username");

$(function () {
    var query = window.location.search.substring(1);
    if (query !== ""){
        var qs = parse_query_string(query);
        if (qs["error"]){
            $('#error_modal').modal();
        }
    }

    $('#login_modal').modal({backdrop: 'static', keyboard: false});
    $.get("login/users/", function (data) {
        user_name.empty();
        $.each(data, function () {
            user_name.append($("<option></option>")
                .attr("value", this.id).text(this.name));
        });
    });


});

