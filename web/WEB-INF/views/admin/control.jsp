<jsp:include page="../master/head.jsp"/>
<%@ page contentType="text/html; charset=UTF-8" %>
<div class="container-admin">
    <h1>Admin</h1>
    <a href="admin/doctor-control" style="color: black">Quản lý bác sĩ</a><br>
    <a href="admin/speciality-control" style="color: black">Quản lý chuyên khoa</a><br>
    <a href="admin/patients-control" style="color: black">Quản lý bệnh nhân</a><br>
    <a href="admin/doctor-schedule-control" style="color: black">Quản lý lịch của bác sĩ</a><br>
    <a href="admin/patient-appointment-control" style="color: black">Xem bệnh nhân</a><br>
    <a href="admin/blog-control" style="color: black">Quản lý cẩm nang</a><br>
</div>
<jsp:include page="../master/foot.jsp" />















<style>
.container-admin {
  background-color: #e9f9e7;
  padding: 20px;
  border-radius: 5px;
  width: 300px;
  margin: 0 auto;
  text-align: center;
 font-family: Arial;
}

.container-admin h1 {
  color: #333;
  font-size: 24px;
  margin-bottom: 10px;
  line-height: 1;
}

.container-admin a {
  display: block;
  text-decoration: none;
  color: black;
  font-weight: bold;
  padding: 10px 0;
  margin-bottom: 10px;
  transition: background-color 0.3s ease;
}

.container-admin a:last-child {
  margin-bottom: 0;
}

.container-admin a:hover {
  background-color: #5aac4e;
  color: white;
}
</style>