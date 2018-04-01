var ajaxUrl = "rest/roles/";
var datatableApi;

$(function () {

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