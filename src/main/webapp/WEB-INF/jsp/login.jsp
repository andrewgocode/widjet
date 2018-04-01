<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<jsp:include page="parts/header.jsp"></jsp:include>
<jsp:include page="parts/body.jsp"></jsp:include>
<script type="text/javascript" src="resources/js/util.js" defer></script>
<script type="text/javascript" src="resources/js/login.js" defer></script>

<div class="modal fade" id="login_modal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <%--<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>--%>
                <h2 class="modal-title" id="modalTitle">Авторизация</h2>
            </div>
            <div class="modal-body">
                <form:form class="form-horizontal" id="detailsForm" role="form" action="spring_security_check" method="post">
                    <input type="hidden" id="id" name="id">
                    <div class="form-group">
                        <label for="username" class="control-label col-xs-3"><spring:message code="login.name"/></label>

                        <div class="col-xs-9">
                            <select class="btn btn-default" name="username" id="username"></select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="password" class="control-label col-xs-3"><spring:message
                                code="login.password"/></label>

                        <div class="col-xs-9">
                            <input type="password" class="form-control" id="password" name="password"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-xs-offset-3 col-xs-9">
                            <button type="submit" class="btn btn-success">
                                <span class="glyphicon glyphicon-log-in" aria-hidden="true"></span>
                            </button>
                        </div>
                    </div>

                </form:form>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="error_modal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h2 class="modal-title"><spring:message code="common.error"/></h2>
            </div>
            <div class="modal-body">
                <p><spring:message code="common.error_pass"/></p>
            </div>
        </div>
    </div>
</div>
</html>
