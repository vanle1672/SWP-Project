<%-- 
    Document   : hosobacsi
    Created on : May 29, 2023, 12:55:20 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">


        <title>bs5 edit profile account details - Bootdey.com</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="assets/css/hosobacsi.css">


    </head>
    <body>
        <div class="container-xl px-4 mt-4">

            <nav class="nav nav-borders">
                <a class="nav-link" href="" target="__blank">Profile</a>
                <a class="nav-link" href="lichkham.jsp" target="__blank">Lịch Khám</a>
                <a class="nav-link" href="baomat.jsp" target="__blank">Bảo Mật</a>
                <a class="nav-link" href="" target="__blank">Đánh Giá</a>
            </nav>
            <hr class="mt-0 mb-4">
            <div class="row">
                <div class="col-xl-4">

                    <div class="card mb-4 mb-xl-0">
                        <div class="card-header">Ảnh cá nhân</div>
                        <div class="card-body text-center">
                           
                            <img class="img-account-profile rounded-circle mb-2" <src="${acc1.image}">

                            <div class="small font-italic text-muted mb-4"></div>

                            <button class="btn btn-primary" type="button">Cập nhật hình ảnh</button>
                        </div>
                    </div>
                </div>
                <div class="col-xl-8">

                    <div class="card mb-4">
                        <div class="card-header">Thông tin chi tiết</div>
                        <div class="card-body">
                            <form>

                                <div class="mb-3">
                                    <label class="small mb-1" for="inputUsername">Họ và tên</label>
                                    <input class="form-control" id="inputUsername" type="text"  value="${acc1.name}">
                                </div>

             

                                <div class="row gx-3 mb-3">

                                    <div class="col-md-6">
                                        <label class="small mb-1" for="inputOrgName">Chuyên Khoa</label>
                                        <input class="form-control" id="inputOrgName" type="text"  value="${acc1.specialization}">
                                    </div>

                                    <div class="col-md-6">
                                        <label class="small mb-1" for="inputLocation">Số Năm Kinh Nghiệm</label>
                                        <input class="form-control" id="inputLocation" type="text"  value="${acc1.experience}">
                                    </div>
                                </div>

                                <div class="mb-3">
                                    <label class="small mb-1" for="inputEmailAddress">Trình Độ</label>
                                    <input class="form-control" id="inputEmailAddress" type="email"  value="${acc1.degree}">
                                </div>

                                <div class="row gx-3 mb-3">

                                    <div class="col-md-6">
                                        <label class="small mb-1" for="inputPhone">Số điện thoại</label>
                                        <input class="form-control" id="inputPhone" type="tel" value="${acc1.phoneNumber}">
                                    </div>

                                    <div class="col-md-6">
                                        <label class="small mb-1" for="inputBirthday">Năm sinh</label>
                                        <input class="form-control" id="inputBirthday" type="text" name="birthday"  value="${acc1.dob}">
                                    </div>
                                </div>

                                <button class="btn btn-primary" type="button">Lưu thay đổi</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>
        <script type="text/javascript">

        </script>
    </body>
</html>
