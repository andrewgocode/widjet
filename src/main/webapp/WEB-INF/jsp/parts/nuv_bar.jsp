<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <ul class="nav navbar-nav">
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#"><spring:message code="main.catalogs"/>
                    <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <sec:authorize access="isAuthenticated()">
                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                            <li><a href="contracts"><spring:message code="nuv_bar.contrats"/></a></li>
                            <li><a href="users"><spring:message code="nuv_bar.users"/></a></li>
                            <li><a href="queue"><spring:message code="nuv_bar.queue"/></a></li>
                        </sec:authorize>
                    </sec:authorize>
                    <li><a href="payments"><spring:message code="nuv_bar.payment"/></a></li>
                </ul>
            </li>
        </ul>
        <div class="collapse navbar-collapse">
            <form:form class="navbar-form navbar-right" action="logout" method="post">
                <button id="expand_or_shrink" type="button" class="btn btn-sm btn-info">Расширить/Сузить</button>
                <button class="btn btn-primary" type="submit">
                    <span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
                </button>
            </form:form>
        </div>
    </div>
</nav>
