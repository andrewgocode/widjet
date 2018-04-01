var ajaxUrl = "rest/users/";
var datatableApi;

var roles = $("#role");

$(function () {
    $.get("rest/roles/", function (data) {
        roles.empty();
        $.each(data, function() {
            roles.append($("<option></option>")
                .attr("value", this.id).text(this.name));
        });
    });

    datatableApi = $("#datatable").DataTable({
        "ajax": {
            "url": ajaxUrl,
            "dataSrc":""
        },
        "language": {
            "loadingRecords": i18n["table.loadingRecords"],
            "zeroRecords": i18n["table.zeroRecords"],
            "info":i18n["table.info"],
            "infoEmpty": i18n["table.infoEmpty"],
            "search": i18n["table.search"],
            "paginate": {
                "previous": i18n["table.previous"],
                "next":i18n["table.next"]
            },
            "lengthMenu":i18n["table.lengthMenu"],
            "emptyTable":i18n["table.emptyTable"],
            "infoFiltered": i18n["table.infoFiltered"]
        },
        "paging": true,
        "info": true,
        "columns": [
            {
                "data": "name"
            },
            {
                "data": "role.name"
            },
            {
                "data": "irpsId"
            },
            {
                "orderable": false,
                "defaultContent": "",
                "render": renderEditBtn
            },
            {
                "orderable": false,
                "defaultContent": "",
                "render": renderDeleteBtn
            }
        ],
        "order": [
            [
                0,
                "desc"
            ]
        ],
        "initComplete": makeEditable
    });
});
