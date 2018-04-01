<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript">





    var i18n = [];

    <c:forEach var="key" items='<%=new String[]{
            "common.deleted",
            "common.saved",
            "common.errorStatus",
            "table.loadingRecords",
            "table.info",
            "table.infoEmpty",
            "table.infoFiltered",
            "table.search",
            "table.previous",
            "table.next",
            "table.lengthMenu",
            "table.emptyTable",
            "table.zeroRecords"
    }%>'>
    i18n["${key}"] = "<spring:message code="${key}"/>";
    </c:forEach>
</script>
