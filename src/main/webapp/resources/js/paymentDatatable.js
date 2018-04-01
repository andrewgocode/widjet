var ajaxUrl = "rest/payments/";
var datatableApi;

function createChart (data) {
    var contractName = "";
    var year = "";
    if (data.length > 0){
        contractName = data[0].contractName;
        year = data[0].year;
    }


    var sumArr = [12];

    for (var i = 0; i < 12; i++){
        sumArr[i] = 0;
    }

    for (var i = 0; i < data.length; i++){
        sumArr[i] = data[i].sum;
    }

    //var v = data[1].sum;
    myChart = document.getElementById('myChart').getContext('2d');

    // Global Options
    Chart.defaults.global.defaultFontFamily = 'Lato';
    Chart.defaults.global.defaultFontSize = 18;
    Chart.defaults.global.defaultFontColor = '#000';

    massPopChart = new Chart(myChart, {
        type:'bar', // bar, horizontalBar, pie, line, doughnut, radar, polarArea
        data:{
            labels:['Январь', 'Февраль', 'Март', 'Апрель', 'Май', 'Июнь', 'Июль', 'Авгут', 'Сентябрь', 'Октябрь', 'Ноябрь', 'Декабрь'],
            datasets:[{
                label:year + " г.",
                data:[
                    sumArr[0],
                    sumArr[1],
                    sumArr[2],
                    sumArr[3],
                    sumArr[4],
                    sumArr[5],
                    sumArr[6],
                    sumArr[7],
                    sumArr[8],
                    sumArr[9],
                    sumArr[10],
                    sumArr[11]
                ],
                backgroundColor:'rgba(75, 192, 192, 0.6)',
//                backgroundColor:[
//                    'rgba(255, 99, 132, 0.6)',
//                    'rgba(54, 162, 235, 0.6)',
//                    'rgba(255, 206, 86, 0.6)',
//                    'rgba(75, 192, 192, 0.6)',
//                    'rgba(153, 102, 255, 0.6)',
//                    'rgba(255, 159, 64, 0.6)',
//                    'rgba(255, 99, 132, 0.6)'
//                ],
                borderWidth:1,
                borderColor:'#777',
                hoverBorderWidth:3,
                hoverBorderColor:'#000'
            }]
        },
        options:{
            title:{
                display:true,
                text:contractName,
                fontSize:25
            },
            legend:{
                display:true,
                position:'right',
                labels:{
                    fontColor:'#000'
                }
            },
            layout:{
                padding:{
                    left:50,
                    right:0,
                    bottom:0,
                    top:0
                }
            },
            tooltips:{
                enabled:true
            }
        }
    });
}

function setChart(contract_id, year) {
    $.ajax({
        type: "GET",
        dataType: "json",
        url: "rest/payments/getAggregateSum/"+year+"/"+contract_id
    }).done(createChart);

    var chartMolal = $('#chart');
    chartMolal.modal();
}

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
                "data": "contract.name"
            },
            {
                "data": "contract.user.name"
            },
            {
                "data": "sum",
                "render": function (data, type, row, mete) {
                    return data.toLocaleString();
                }
            },
            {
                "data": "quantity",
                "render": function (data, type, row, mete) {
                    return data.toLocaleString();
                }
            },
            {
                "data": "contract.sum",
                "render": function (data, type, row, mete) {
                    return data.toLocaleString();
                }
            },
            {
                "data": "contract.quantity",
                "render": function (data, type, row, mete) {
                    return data.toLocaleString();
                }
            },
            {
                "data": "potential_sum",
                "render": function (data, type, row, mete) {
                    return data.toLocaleString();
                }
            },
            {
                "data": "potential_quantity",
                "render": function (data, type, row, mete) {
                    return data.toLocaleString();
                }
            },
            {
                "data": "diff_sum",
                "render": function (data, type, row, mete) {
                    return data.toLocaleString();
                }
            },
            {
                "data": "diff_quantity",
                "render": function (data, type, row, mete) {
                    return data.toLocaleString();
                }
            },
            {
                "orderable": false,
                "defaultContent": "",
                "render": renderChartBtn
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

    function renderChartBtn(data, type, row) {
        if (type === "display") {
            return "<a onclick='setChart(" + row.contract.id + "," + row.year + ");'>" +
                "<span class='glyphicon glyphicon-object-align-bottom' aria-hidden='true'></span></a>";
        }
    }

    function getByMonthAndYear(month, year) {
        $.ajax({
            type: "GET",
            dataType: "json",
            url: "rest/payments/getByMonthAndYear/" + month + "/" + year
        }).done(updateTableByData);
    }

    var modal_filter = $('#modal_filter');

    $('#chart').on('hidden.bs.modal', function () {
        massPopChart.destroy();
    });

    $('#show_filter').on('click', function () {
        modal_filter.modal();
    });

    $('#filter').on('click', function () {
        getByMonthAndYear($('#month').val(), $('#year').val());
        modal_filter.modal('hide')
    });

    var currentDate = new Date();
    $('#year').val(currentDate.getFullYear());
    $('#month').val(currentDate.getMonth() + 1);

});

