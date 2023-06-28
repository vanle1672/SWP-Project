<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:include page="../master/head.jsp"/>
<div class="custom-container">
    <form action="" method="post" enctype="multipart/form-data">
        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <label for="name">Nhập tên bác sĩ</label>
                    <input class="form-control" type="text" id="name" name="name" placeholder="name">
                </div>
                <div class="form-group">
                    <label for="mail">Email</label>
                    <input class="form-control" type="email" id="mail" name="email" placeholder="email">
                </div>
                <div class="form-group">
                    <label for="password">Mật khẩu</label>
                    <input class="form-control" type="password" id="password" name="password" placeholder="password">
                </div>
                <div class="form-group">
                    <label for="degree">Bằng cấp</label>
                    <input class="form-control" type="text" id="degree" name="degree" placeholder="degree">
                </div>
                <div class="form-group">
                    <label for="experience">Năm kinh nghiệm</label>
                    <input class="form-control" type="number" id="experience" name="experience" placeholder="experience">
                </div>
                <div class="form-group">
                    <div class="row ml-2">
                        <h4 class="mr-2 mt-4">Chuyên môn</h4>
                        <select class="ml-2" name="speciality_id" id="speciality_id">
                            <option value="0" selected>Chuyên môn</option>
                            <c:forEach var="item" items="${speciality_list}">
                                <option value="${item.id}">${item.getName()}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <label for="file">Ảnh</label>
                    <input class="form-control" type="file" id="file" name="image">
                </div>
                <div class="form-group">
                    <label for="phone">Số điện thoại</label>
                    <input class="form-control" type="tel" id="phone" name="phone" placeholder="phone">
                </div>
                <div class="form-group">
                    <label for="dob">Ngày sinh</label>
                    <input class="form-control" type="date" id="dob" name="dob">
                </div>
                <div class="form-group">
                    <div class="row ml-2">
                        <h4 class="mr-2 mt-4">Chọn giới tính</h4>
                        <select name="gender" class="ml-2" id="gender">
                            <option value="0">nữ</option>
                            <option value="1">nam</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="address">Nhập địa chỉ</label>
                    <input class="form-control" type="text" id="address" name="address" placeholder="address">
                </div>
            </div>
        </div>
        <input class="form-control" type="hidden" name="_method" value="">


        <button class="btn">submit</button>
    </form>
    <br>
    <table class="table" border="1">
        <tr>
            
            <th>Tên</th>
            <th>email</th>
            <th>Bằng cấp</th>
            <th>Năm kinh nghiệm</th>
            <th>Chuyên khoa</th>
            <th style="max-width: 700px">Ảnh</th>
            <th>Điện thoại</th>
            <th>Giới tính</th>
            <th>Ngày sinh</th>
            <th>Địa chỉ</th>
            <th></th>
        </tr>
        <c:forEach var="item" items="${doctor_list}">
            <tr>
               
                <td>${item.getName()}</td>
                <td>${item.getEmail()}</td>
                <td>${item.getDegree()}</td>
                <td>${item.getExperience()}</td>
                <td>${item.getSpeciality_name()}</td>
                <td style="max-width: 200px"><img style="max-width: 100%; object-fit: cover" src="${pageContext.request.contextPath}/${item.getImage()}"
                                                  alt=""></td>
                <td>${item.getPhone()}</td>
                <td>${item.isGender() == false ? "Nữ" : "Nam"}</td>
                <td>${item.getDob()}</td>
                <td>${item.getAddresses()}</td>
                <th>
                    <form action="" method="post">
                        <input class="form-control" type="hidden" name="_method" value="DELETE">
                        <input class="form-control" type="hidden" name="id" value="${item.id}">
                        <button class="fas fa fa-trash" title="Xóa" style="color:red;margin-top: 60px;border:none;"> Xóa</button>
                    </form>
                        <a href="${pageContext.request.contextPath}/admin/update-doctor?doc_id=${item.id}"><button class="fa fa-edit" title="Chỉnh sửa" 
                                                              style="color:black; margin-top: 10px; border:none;">
                             Chỉnh sửa</button></a>
                </th>
            </tr>
        </c:forEach>
    </table>
</div>
<jsp:include page="../master/foot.jsp"/>
