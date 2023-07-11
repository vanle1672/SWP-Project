<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:include page="master/head.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-md-8 border-right">
    <form action="${pageContext.request.contextPath}/patient/profile" method="post">
        <div class="p-3 py-5">
            <div class="d-flex justify-content-between align-items-center mb-3">
                <h4 class="text-right">Chỉnh sửa trang cá nhân</h4>
            </div>
            <div class="row mt-3">
                <div class="col-md-12">
                    <label class="labels">Họ và tên</label>
                    <input type="text" class="form-control" value="${listinfo.name}" name="name">
                </div>

                <div class="col-md-12">
                    <label class="labels">Ngày sinh</label>
                    <input type="date" class="form-control" value="${listinfo.dob}" name="DOB" >
                </div>
                <br><br>
                <div class="col-md-12">
                    <label class="labels">Giới tính</label>
                    <br>
                    <select class="form-control" name="gender">
                        <option value="1" <c:if test="${listinfo.gender}">selected</c:if>>Nam</option>
                        <option value="0" <c:if test="${!listinfo.gender}">selected</c:if>>Nữ</option>
                        </select>
                    </div>
                    <div class="col-md-12">
                        <label class="labels">Địa chỉ</label>
                        <input type="text" class="form-control" value="${listinfo.address}" name="address">
                </div>

                <div class="col-md-12">
                    <label class="labels">Email</label>
                    <input type="text" class="form-control" value="${listinfo.email}" name="email" readonly="">
                </div>

                <div class="col-md-12">
                    <label class="labels">Password</label>
                    <input type="password" class="form-control" value="${listinfo.password}" name="password"readonly="" >
                </div>

                <div class="col-md-12">
                    <label class="labels">Số điện thoại</label>
                    <input type="tel" class="form-control" placeholder="" value="${listinfo.phone}" name="phone">
                </div>

            </div>

            <div class="button-container">
                <div class="mt-5 text-center">
                    <button class="btn btn-primary profile-button" type="submit">Lưu thay đổi</button>
                </div>
            </div>
        </div>
    </form>
</div>
<jsp:include page="master/foot.jsp" />

