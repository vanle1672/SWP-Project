<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:include page="master/head.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="custom-container">
    ${message}
    <c:if test="${not empty error}">
        <p style="color: red">${error}</p>
    </c:if>
    <table class="table" border="1" id="table">
        <thead>
        <tr>
          
            <th>Trạng thái</th>
            <th>Lời nhắn</th>
            <th>Thời gian bắt đầu</th>
            <th>Thời gian kết thúc</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${appointments}" var="item">
            <tr>
                <td>${item.getStatus()}</td>
                <td>${item.getNote()}</td>
                <td>${item.getStart()}</td>
                <td>${item.getEnd()}</td>
                <td><a href="${pageContext.request.contextPath}/patient/appointment-detail?app_id=${item.id}&doc_id=${item.getDoctor_id()}" style="color: black">Nhấn để xem lịch đã đặt</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<jsp:include page="master/foot.jsp" />
