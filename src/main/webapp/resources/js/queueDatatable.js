var ajaxUrl = "rest/queue/";
var datatableApi;

var param = $("#param");

$(function () {
    $.get("rest/contracts/", function (data) {
        param.empty();
        $.each(data, function() {
            param.append($("<option></option>")
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
                "data": "date",
                "render": function (data, type, row, mete) {
                    var dataArray = data.toString().split(',');
                    return (dataArray[2].length == 2 ? dataArray[2] : "0" + dataArray[2])
                        + "." + (dataArray[1].length == 2 ? dataArray[1] : "0" + dataArray[1])
                        + "." + dataArray[0]
                        + " " + (dataArray[3].length == 2 ? dataArray[3] : "0" + dataArray[3])
                        + ":" + (dataArray[4].length == 2 ? dataArray[4] : "0" + dataArray[4])
                        + ":" + (dataArray[5].length == 2 ? dataArray[5] : "0" + dataArray[5]);
                }
            },
            {
                "data": "status"
            },
            {
                "data": "dateFrom",
                "render": function (data, type, row, mete) {
                    var dataArray = data.toString().split(',');
                    return (dataArray[2].length == 2 ? dataArray[2] : "0" + dataArray[2])
                        + "." + (dataArray[1].length == 2 ? dataArray[1] : "0" + dataArray[1])
                        + "." + dataArray[0];
                }
            },
            {
                "data": "dateTo",
                "render": function (data, type, row, mete) {
                    var dataArray = data.toString().split(',');
                    return (dataArray[2].length == 2 ? dataArray[2] : "0" + dataArray[2])
                    + "." + (dataArray[1].length == 2 ? dataArray[1] : "0" + dataArray[1])
                    + "." + dataArray[0];
                }
            },
            {
                "data": "param"
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

    http://xdsoft.net/jqplugins/datetimepicker/
    var startDate = $('#dateFrom');
    var endDate = $('#dateTo');

    startDate.datetimepicker({
        timepicker: false,
        format: 'd-m-Y',
        formatDate: 'd-m-Y',
        onShow: function (ct) {
            this.setOptions({
                maxDate: endDate.val() ? endDate.val() : false
            })
        }
    });
    endDate.datetimepicker({
        timepicker: false,
        format: 'd-m-Y',
        formatDate: 'd-m-Y',
        onShow: function (ct) {
            this.setOptions({
                minDate: startDate.val() ? startDate.val() : false
            })
        }
    });
});