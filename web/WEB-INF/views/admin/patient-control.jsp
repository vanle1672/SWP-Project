<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:include page="../master/head.jsp"/>
<div class="row d-flex justify-content-center">
    <main class="col-12 col-md-9 col-xl-8 py-md-3 pl-md-5 bd-content">
        <h1>Views Patients</h1>
        <%--        Form Start--%>
        <form action="${pageContext.request.contextPath}/admin/patients-control" method="post" class="bd-example">
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="inputEmail4">Email</label>
                    <input type="email" class="form-control" name="email" id="inputEmail4" placeholder="Email">
                </div>
                <div class="form-group col-md-6">
                    <label for="inputPassword4">Password</label>
                    <input type="password" class="form-control" name="password" id="inputPassword4" placeholder="Password">
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="inputName">Name</label>
                    <input type="text" class="form-control" name="name" id="inputName" placeholder="Name">
                </div>
                <div class="form-group col-md-6">
                    <label for="inputPhone">Phone</label>
                    <input type="text" class="form-control" name="phone" id="inputPhone" placeholder="Phone">
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="inputDoB">DoB</label>
                    <input type="date" class="form-control" name="dob" id="inputDoB">
                </div>
                <div class="form-group col-md-6">
                    <label>Gender</label>
                    <select id="gender" name="gender">
                        <option selected>Select Gender...</option>
                        <option value="0">Nữ</option>
                        <option value="1">Nam</option>
                    </select>
                </div>
            </div>
            <button class="btn btn-primary text-white" type="submit">Submit</button> 
            <button class="btn btn-warning text-white" type="reset">Reset</button>
        </form>
        <%--        Form End--%>
        <br>

        <%--        table start--%>
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
