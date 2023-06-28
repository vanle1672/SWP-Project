<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:include page="../master/head.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-md-8 border-right">
    <form action="${pageContext.request.contextPath}/doctor-change-pass" method="post">
        <div class="p-3 py-5">
            <div class="d-flex justify-content-between align-items-center mb-3">
                <h4 class="text-right">Đổi mật khẩu bác sĩ</h4>
                <c:if test="${status == \"error\"}"><p class="text-danger">${message}</p><br></c:if>
                <c:if test="${status == \"success\"}"><p class="text-success">${message}</p><br></c:if>        
                </div>
                <div class="row mt-3">
                    <div class="col-md-12">
                        <label class="labels">Nhập mật khẩu cũ</label>
                        <input type="password" class="form-control"  name="old-pass">
                    </div>
                    <div class="col-md-12">
                        <label class="labels">Nhập mật khẩu mới</label>
                        <input type="password" class="form-control" name="new-pass">
                    </div>

                    <div class="col-md-12">
                        <label class="labels">Nhập lại mật khẩu mới</label>
                        <input type="password" class="form-control" name="confirm-pass" >
                    </div>
                </div> 
            </div>
            <button type="submit" class="btn">Cập nhật</button>
        </form>
    </div>
<jsp:include page="../master/foot.jsp" />
