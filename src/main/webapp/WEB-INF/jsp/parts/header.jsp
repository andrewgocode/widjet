<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><spring:message code="main.name"/></title>
    <base href="${pageContext.request.contextPath}/"/>

    <link rel="stylesheet" href="resources/css/style.css">
    <link rel="stylesheet" href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
    <link rel="stylesheet" href="webjars/datatables/1.10.16/css/jquery.dataTables.css">
    <%--<link rel="stylesheet" href="webjars/datatables/1.10.16/css/dataTables.bootstrap.min.css">--%>
    <link rel="stylesheet" href="webjars/noty/3.1.0/lib/noty.css"/>
    <link rel="stylesheet" href="webjars/datetimepicker/2.5.11/jquery.datetimepicker.css">

    <script type="text/javascript" src="webjars/jquery/3.2.1/dist/jquery.min.js" defer></script>
    <script type="text/javascript" src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js" defer></script>
    <script type="text/javascript" src="webjars/datatables/1.10.16/js/jquery.dataTables.min.js" defer></script>
    <%--<script type="text/javascript" src="webjars/datatables/1.10.16/js/dataTables.bootstrap.min.js" defer></script>--%>
    <script type="text/javascript" src="webjars/noty/3.1.0/lib/noty.min.js" defer></script>
    <script type="text/javascript" src="webjars/datetimepicker/2.5.11/build/jquery.datetimepicker.full.min.js" defer></script>



    <script type="text/javascript">
        var i18n = [];

        <c:forEach var="key" items='<%=new String[]{"common.deleted","common.saved","common.errorStatus","table.loadingRecords"}%>'>
        i18n["${key}"] = "<spring:message code="${key}"/>";
        </c:forEach>
    </script>



</head>