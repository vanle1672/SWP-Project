<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<jsp:include page="../master/head.jsp"/>
<form action="" method="post" class="bd-example">
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="inputEmail4">Email</label>
            <input type="email" class="form-control" name="email" value="${x.email}" id="inputEmail4" placeholder="Email">
        </div>
        <div class="form-group col-md-6">
            <label for="inputPassword4">Mật khẩu</label>
            <input type="password" class="form-control" name="password" value="${x.password}" id="inputPassword4" placeholder="Password">
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="inputName">Tên</label>
            <input type="text" class="form-control" name="name" value="${x.name}" id="inputName" placeholder="Name">
        </div>
        <div class="form-group col-md-6">
            <label for="inputPhone">Số điện thoại</label>
            <input type="text" class="form-control" name="phone" value="${x.phone}" id="inputPhone" placeholder="Phone">
        </div>
    </div>

    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="inputDoB">Ngày sinh</label>
            <input type="date" class="form-control" name="dob" value="${x.getDob()}" id="inputDoB">
        </div>
        <div class="form-group col-md-6">
            <label>Giới tính</label>
            <select id="gender" name="gender">
                <option ${x.gender == false ? "selected" : ""} value="0">Nữ</option>
                <option ${x.gender == true ? "selected" : ""} value="1">Nam</option>
            </select>
        </div>
        <div class="form-group col-md-6">
            <label for="inputaddress">Địa chỉ</label>
            <input type="text" class="form-control" name="address" value="${x.getAddress()}" id="inputaddress">
        </div>
    </div>
    <button class="btn btn-primary" >Xác nhận</button>
    <button type="reset" class="btn btn-primary" >Hủy</button>
</form>
<jsp:include page="../master/foot.jsp"/>