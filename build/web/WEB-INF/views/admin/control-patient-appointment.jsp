<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:include page="../master/head.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="custom-container">
    <table class="table" border="1" id="table">
        <thead>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>email</th>
            <th colspan="2">action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>${item.email}</td>
                <td><a href="${pageContext.request.contextPath}/admin/patient-appointment?user_id=${item.id}" style="color: black">view all patient appointments(click me)</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<jsp:include page="../master/foot.jsp" />
