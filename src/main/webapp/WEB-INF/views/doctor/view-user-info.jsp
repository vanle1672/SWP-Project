<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:include page="../master/head.jsp"/>
<div class="custom-container">
  <h1>Thông tin bệnh nhân</h1>
  <h3>Tên : ${user.getName()}</h3>
  <h3>Email : ${user.getEmail()}</h3>
  <h3>Số điện thoại : ${user.getPhone()}</h3>
  <h3>Địa chỉ : ${user.getAddress()}</h3>
  <h3>Ngày sinh : ${user.getDob()}</h3>
  <h3>Giới tính : ${user.isGender() == true ? "Nam" :  "Nữ"}</h3>
</div>
<jsp:include page="../master/foot.jsp"/>
