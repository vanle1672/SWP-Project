<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:include page="../master/head.jsp"/>
<div class="row d-flex justify-content-center">
    <main class="col-12 col-md-9 col-xl-8 py-md-3 pl-md-5 bd-content">
        <h1>Views Patients</h1>
        <%--        Form Start--%>
        <form action="${pageContext.request.contextPath}/admin/patients-control" method="post" class="bd-example">
            <div class="form-row">
                <div class="form-group col-md-5">
                    <label for="inputEmail4">Email</label>
                    <input type="email" class="form-control custom-input" name="email" id="inputEmail4" placeholder="Email">
                </div>
                <div class="form-group col-md-5">
                    <label for="inputPassword4">Mật khẩu</label>
                    <input type="password" class="form-control custom-input" name="password" id="inputPassword4" placeholder="Password">
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-5">
                    <label for="inputName">Tên</label>
                    <input type="text" class="form-control custom-input" name="name" id="inputName" placeholder="Name">
                </div>
                <div class="form-group col-md-5">
                    <label for="inputPhone">Số điện thoại</label>
                    <input type="text" class="form-control custom-input" name="phone" id="inputPhone" placeholder="Phone">
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-5">
                    <label for="inputDoB">Ngày sinh</label>
                    <input type="date" class="form-control custom-input" name="dob" id="inputDoB">
                </div>
               
                <div class="form-group col-md-5">
                    <label for="address">Địa chỉ</label>
                    <input type="text" class="form-control custom-input" name="address" id="address" placeholder="Address">
                </div>
                 <div class="form-group col-md-5">
                    <h4>Chọn giới tính</h4>
                    <select id="gender" name="gender" >
                        <option value="0">Nữ</option>
                        <option value="1">Nam</option>
                    </select>
                </div>
            </div>
            <button class="button-style" type="submit">Xác nhận</button> 
        </form>

        <br>
        <table class="table" border="1" id="table">
            <thead>
                <tr>
                    <th></th>

                    <th>Tên</th>
                    <th>Email</th>
                    <th>Mật khẩu</th>
                    <th>Số điện thoại</th>
                    <th>Giới tính</th>
                    <th>Ngày sinh</th>
                    <th>Địa chỉ</th>
                    <th colspan="2"></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${list}" var="x" varStatus="status">
                    <tr>
                        <td>${status.index + 1}</td>

                        <td>${x.name}</td>
                        <td>${x.email}</td>
                        <td>${x.password}</td>
                        <td>${x.phone}</td>
                        <td>${x.gender ? "Nam" : "Nữ"} </td>
                        <td>${x.dob}</td>
                        <td>${x.address}</td>
                        <td>
                            <a role="button" class="fa fa-edit" title="Chỉnh sửa" 
                               style="color:black; margin-top: 10px; border:none;" 
                               href="${pageContext.request.contextPath}/admin/update-patients?pid=${x.id}"> Chỉnh sửa</a><br>
                            <a role="button" class="fas fa fa-trash" title="Xóa"style="color:red; margin-top: 10px; border:none;" 
                               href="${pageContext.request.contextPath}/admin/delete-patients?pid=${x.id}">   Xóa</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <%--        table end--%>
    </main>
</div>
<jsp:include page="../master/foot.jsp"/>

<style>
    .button-style{
        background-color: #234821;
        color: #ffffff;
        border: none;
        padding: 10px 20px;
        border-radius: 5px;
        font-size: 16px;
        font-weight: bold;
        cursor: pointer;
    }
</style>