<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:include page="../master/head.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-md-8 border-right">
    <form action="${pageContext.request.contextPath}/doctor/profile" method="post">
        <div class="p-3 py-5">
            <div class="d-flex justify-content-between align-items-center mb-3">
                <h4 class="text-right">Chỉnh sửa trang cá nhân </h4>
            </div>
            <div class="row mt-3">
                <div class="col-md-12">
                    <label class="labels">Họ và tên</label>
                    <input type="text" class="form-control" value="${doctor.name}" name="name">
                </div>
                <div class="col-md-12">
                    <label class="labels">Email</label>
                    <input type="text" class="form-control" value="${doctor.email}" name="email" readonly="">
                </div>
               
                <div class="col-md-12">
                    <label class="labels">Bằng cấp</label>
                    <input type="text" class="form-control" value="${doctor.degree}" name="degree" >
                </div>
                <div class="col-md-12">
                    <label class="labels">Năm kinh nghiệm</label>
                    <input type="text" class="form-control" value="${doctor.experience}" name="experience" >
                </div>
                <div class="col-md-12">
                  <label class="labels">Chuyên khoa</label><br>  
                   <select name="specialty" id="speciality_id">
                            <option value="0" selected></option>
                            <c:forEach var="item" items="${speciality_list}">
                                <option ${item.id == doctor.speciality_id ? "selected" : ""} value="${item.id}">${item.getName()}</option>
                            </c:forEach>
                        </select>
                </div>

                <div class="col-md-12">
                    <label class="labels">Số điện thoại</label>
                    <input type="tel" class="form-control" placeholder="" value="${doctor.phone}" name="phone">
                </div>
                <div class="col-md-12">
                    <label class="labels">Ngày sinh</label>
                    <input type="date" class="form-control" value="${doctor.dob}" name="DOB" >
                </div>
                <div class="col-md-12">
                    <label class="labels">Giới tính</label><br> 
                    <select class="form-control" name="gender">
                        <option value="1" <c:if test="${doctor.gender}">selected</c:if>>Nam</option>
                        <option value="0" <c:if test="${!doctor.gender}">selected</c:if>>Nữ</option>
                        </select>
                    </div>
                    <div class="col-md-12">
                        <label class="labels">Địa chỉ</label>
                        <input type="text" class="form-control" value="${doctor.address}" name="address">
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
<jsp:include page="../master/foot.jsp" />
