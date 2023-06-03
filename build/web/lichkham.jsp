<%-- 
    Document   : lichkham
    Created on : May 29, 2023, 2:53:59 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">


        <title>bs4 account tickets - Bootdey.com</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="assets/css/lichkham.css">


    </head>
    <body>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
        <div class="container mb-4 main-container">
            <div class="row" style="background-color:#fff; padding:20px 30px;border-radius:10px;">
                <div class="col-lg-4 pb-5">

                    <div class="author-card pb-3">
                        <div class="author-card-cover" style="background-image: url(https://file4.batdongsan.com.vn/2016/03/02/wxbwknn6/20160302092841-4302.jpg);"><a class="btn btn-style-1 btn-white btn-sm" href="#" data-toggle="tooltip" title data-original-title="You currently have 290 Reward points to spend"><i class="fa fa-award text-md"></i>&nbsp;290 points</a></div>
                        <div class="author-card-profile">
                            <div class="author-card-avatar"><img src="assets/img_doctor/NguyenHoangLong.png" alt="">
                            </div>
                            <div class="author-card-details">
                                <h5 class="author-card-name text-lg">Tên Bác Sĩ</h5><span class="author-card-position">Joined February 06, 2017</span>
                            </div>
                        </div>
                    </div>
                    <div class="wizard">
                        <nav class="list-group list-group-flush">
                            <a class="list-group-item active" href="#">
                                <div class="d-flex justify-content-between align-items-center">
                                    <div><i class="fa fa-shopping-bag mr-1 text-muted"></i>
                                        <div class="d-inline-block font-weight-medium text-uppercase">Lịch khám</div>
                                    </div><span class="badge badge-secondary">6</span>
                                </div>
                            </a>
                            <a class="list-group-item" href="" target="__blank"><i class="fa fa-user text-muted"></i>Profile Settings</a><a class="list-group-item" href="#"><i class="fa fa-map-marker text-muted"></i>Cập nhật lịch khám</a>
                            <a class="list-group-item" href="" tagert="__blank">
                                <div class="d-flex justify-content-between align-items-center">

                                    <div>
                                        <div class="d-inline-block font-weight-medium text-uppercase"><i class='fas fa-envelope-open'></i>
Xác nhận yêu cầu đặt khám</div>
                                    </div>
                                </div>
                            </a>
                            <a class="list-group-item" href="#">
                                <div class="d-flex justify-content-between align-items-center">
                                    <div>
                                        <div class="d-inline-block font-weight-medium text-uppercase"> </div>
                                    </div>
                                </div>
                            </a>
                        </nav>
                    </div>
                </div>

                <div class="col-lg-8 pb-5">
                    <div class="d-flex justify-content-end pb-3">
                        <div class="form-inline">
                            <label class="text-muted mr-3" for="order-sort">Sắp xếp</label>
                            <select class="form-control" id="order-sort">
                                <option>Tất cả</option>
                                <option>Đã khám</option>
                                <option>Đang khám</option>
                                <option>Chưa Khám</option>
                                <option>Hủy</option>
                            </select>
                        </div>
                    </div>
                    <div class="table-responsive">
                        <table class="table table-hover mb-0">
                            <thead>
                                <tr>
                                    <th>Bệnh nhân</th>
                                    <th>Ngày đặt lịch</th>
                                    <th>Giờ khám</th>
                                    <th>Trạng thái</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td><a class="navi-link" href="#order-details" data-toggle="modal">78A643CD409</a></td>
                                    <td>August 08, 2017</td>
                                    <td><span>8:30</span></td>
                                    <td><span class="badge badge-danger m-0">Hủy</span></td>
                                </tr>
                                <tr>
                                    <td><a class="navi-link" href="#order-details" data-toggle="modal">34VB5540K83</a></td>
                                    <td>July 21, 2017</td>
                                    <td>7:15</td>
                                    <td><span class="badge badge-info m-0">Đang Khám</span></td>

                                </tr>
                                <tr>
                                    <td><a class="navi-link" href="#order-details" data-toggle="modal">112P45A90V2</a></td>
                                    <td>June 15, 2017</td>
                                    <td>14:30</td>
                                    <td><span class="badge badge-warning m-0">Chưa Khám</span></td>

                                </tr>
                                <tr>
                                    <td><a class="navi-link" href="#order-details" data-toggle="modal">28BA67U0981</a></td>
                                    <td>May 19, 2017</td>
                                    <td>15:10</td>
                                    <td><span class="badge badge-success m-0">Đã Khám</span></td>

                                </tr>
                                <tr>
                                    <td><a class="navi-link" href="#order-details" data-toggle="modal">502TR872W2</a></td>
                                    <td>April 04, 2017</td>
                                    <td>10:15</td>
                                    <td><span class="badge badge-success m-0">Đã Khám</span></td>

                                </tr>
                                <tr>
                                    <td><a class="navi-link" href="#order-details" data-toggle="modal">47H76G09F33</a></td>
                                    <td>March 30, 2017</td>
                                    <td>15:45</td>
                                    <td><span class="badge badge-success m-0">Đã Khám</span></td>

                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.1/dist/js/bootstrap.bundle.min.js"></script>
        <script type="text/javascript">

        </script>
    </body>
</html>
