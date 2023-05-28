<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/profile.css">
    </head>
    <body>
        <div class="container rounded bg-white mt-5 mb-5">
            <div class="row">
                <div class="col-md-3 border-right">
                    <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img class="rounded-circle mt-5" width="150px" src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg"><span class="font-weight-bold"></span><span class="text-black-50"></span><span> </span></div>
                </div>
                <div class="col-md-5 border-right">
                    <form action="chinh-sua" method="post">
                    <div class="p-3 py-5">
                        <div class="d-flex justify-content-between align-items-center mb-3">
                            <h4 class="text-right">Chỉnh sửa trang cá nhân</h4>
                        </div>
                       
                        <div class="row mt-3">
                            <div class="col-md-12"><label class="labels">Họ và tên</label><input type="text" class="form-control" 
                                                                                                 placeholder="Nhập đầy đủ họ và tên" value="${sessionScope.acc.name}" name="name"></div>
                            <div class="col-md-12">
                                <label class="labels">Ngày sinh</label>
                                <input type="date" class="form-control" placeholder="Nhập ngày sinh" name="DOB" >
                            </div>
                            <div class="col-md-12">
                                <label class="labels">Giới tính</label>
                                <select class="form-control" name="gender">
                                    <option value="Nam">Nam</option>
                                    <option value="Nữ">Nữ</option>
                                </select>
                            </div>
                            <div class="col-md-12"><label class="labels">Địa chỉ</label><input type="text" class="form-control" placeholder="Nhập địa chỉ" name="address"></div>
                            <div class="col-md-12"><label class="labels">Email</label><input type="text" class="form-control" placeholder="Nhập email" value="${sessionScope.acc.email}"name="email"></div>
                            <div class="col-md-12"><label class="labels">Số điện thoại</label><input type="number" class="form-control" placeholder="Nhập số điện thoại" value="${sessionScope.acc.phone}" name="phone"></div>

                        </div>

                        <div class="mt-5 text-center"><button class="btn btn-primary profile-button" type="button">Lưu thay đổi</button></div>
                    </div>
                            </form>
                </div>
                <div class="col-md-4">
                    <div class="p-3 py-5">

                    </div>
                </div>
            </div>
        </div>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
