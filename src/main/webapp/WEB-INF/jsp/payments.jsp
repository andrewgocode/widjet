<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<jsp:include page="parts/header.jsp"></jsp:include>
<jsp:include page="parts/body.jsp"></jsp:include>
<script type="text/javascript" src="resources/js/tableUtil.js" defer></script>
<script type="text/javascript" src="resources/js/Chart.bundle.js" defer></script>
<script type="text/javascript" src="resources/js/paymentDatatable.js" defer></script>

<div>
    <div id="main_container" class="container">

        <div class="row justify-content-md-center">
            <div class="col-lg-2"></div>
            <div class="col-md-auto">
                <%------%>
                <jsp:include page="parts/nuv_bar.jsp"/>
                <h3>
                    <spring:message code="payment.title"/>
                </h3>
                <br/>

                <button id="show_filter" type="button" class="btn btn-info">Фильтр</button>
                <br/><br/>

                <div style="overflow-y: auto;">
                    <table class="table table-striped hove display" width="100%" id="datatable">
                        <thead>
                        <tr>
                            <th><spring:message code="payment.contract"/></th>
                            <th><spring:message code="payment.manager_name"/></th>
                            <th><spring:message code="payment.sum"/></th>
                            <th><spring:message code="payment.quantity"/></th>
                            <th><spring:message code="payment.total_sum"/></th>
                            <th><spring:message code="payment.total_quantity"/></th>
                            <th><spring:message code="payment.potential_sum"/></th>
                            <th><spring:message code="payment.potential_quantity"/></th>
                            <th><spring:message code="payment.diff_sum"/></th>
                            <th><spring:message code="payment.diff_quantity"/></th>
                            <th></th>
                        </tr>
                        </thead>
                    </table>
                </div>
                <%------%>
            </div>
            <div class="col-lg-2"></div>
        </div>
    </div>
</div>

<div class="modal fade" id="chart">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h2 class="modal-title">Объемы</h2>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <canvas id="myChart"></canvas>
                </form>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="modal_filter">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h2 class="modal-title">Фильтр</h2>
            </div>
            <div class="modal-body">
                <table class="table">
                    <tr class="warning">
                        <td>Месяц</td>
                        <td>
                            <select class="btn btn-default" name="year" id="year">
                                <option value="2017">2017</option>
                                <option value="2018">2018</option>
                                <option value="2019">2019</option>
                                <option value="2020">2020</option>
                            </select>
                        </td>
                    </tr>
                    <tr class="warning">
                        <td>Год</td>
                        <td>
                            <select class="btn btn-default" name="month" id="month">
                                <option value="1">Январь</option>
                                <option value="2">Февраль</option>
                                <option value="3">Март</option>
                                <option value="4">Апрель</option>
                                <option value="5">Май</option>
                                <option value="6">Июнь</option>
                                <option value="7">Июль</option>
                                <option value="8">Август</option>
                                <option value="9">Сентябрь</option>
                                <option value="10">Октябрь</option>
                                <option value="11">Ноябрь</option>
                                <option value="12">Декабрь</option>
                            </select>
                        </td>
                    </tr>
                    <tr>

                        <td colspan="2">
                            <button type="button" class="btn btn-success" id="filter">Применить фильтр</button>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</div>

<jsp:include page="parts/footer.jsp"/>

</body>


</html>
