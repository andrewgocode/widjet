<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<jsp:include page="parts/header.jsp"></jsp:include>
<jsp:include page="parts/body.jsp"></jsp:include>
<script type="text/javascript" src="resources/js/tableUtil.js" defer></script>
<script type="text/javascript" src="resources/js/roleDatatable.js" defer></script>

<div>
    <div id="main_container" class="container">
        <jsp:include page="parts/nuv_bar.jsp"/>
        <h3>
            <spring:message code="role.title"/>
        </h3>
        <br/>
        <a class="btn btn-primary" onclick="add()">
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
            <spring:message code="common.add"/>
        </a>
        <br/>
        <br/>
        <table class="table table-striped display" width="100%" id="datatable">
            <thead>
            <tr>
                <th><spring:message code="role.name"/></th>
                <th></th>
                <th></th>
            </tr>
            </thead>
        </table>
    </div>
</div>


<div class="modal fade" id="editRow">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h2 class="modal-title" id="modalTitle"></h2>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="detailsForm">
                    <input type="hidden" id="id" name="id">

                    <div class="form-group">
                        <label for="name" class="control-label col-xs-3"><spring:message code="role.name"/></label>

                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="name" name="name" placeholder=<spring:message code="role.name"/> />
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-xs-offset-3 col-xs-9">
                            <button type="button" onclick="save()" class="btn btn-primary">
                                <span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<jsp:include page="parts/footer.jsp"/>
</body>
<script type="text/javascript">
    i18n["addTitle"] = '<spring:message code="role.add"/>';
    i18n["editTitle"] = '<spring:message code="role.edit"/>';
</script>
</html>
