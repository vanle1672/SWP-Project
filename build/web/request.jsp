<%-- 
    Document   : request
    Created on : May 30, 2023, 9:11:06 AM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">


        <title>Booking Requests list - Bootdey.com</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <style type="text/css">
            body{
                background: #E9F9E7;
                margin-top:20px;
            }
            /* booking */

            .bg-light-blue {
                background-color: #e9f7fe !important;
                color: #3184ae;
                padding: 7px 18px;
                border-radius: 4px;
            }

            .bg-light-green {
                background-color: rgba(40, 167, 69, 0.2) !important;
                padding: 7px 18px;
                border-radius: 4px;
                color: #28a745 !important;
            }

            .buttons-to-right {
                position: absolute;
                right: 0;
                top: 40%;
            }

            .btn-gray {
                color: #666;
                background-color: #eee;
                padding: 7px 18px;
                border-radius: 4px;
            }

            .booking:hover .buttons-to-right .btn-gray {
                opacity: 1;
                transition: .3s;
            }

            .buttons-to-right .btn-gray {
                opacity: 0;
                transition: .3s;
            }

            .btn-gray:hover {
                background-color: #36a3f5;
                color: #fff;
            }

            .booking {
                margin-bottom: 30px;
                border-bottom: 1px solid #eee;
                padding-bottom: 30px;
            }

            .booking:last-child {
                margin-bottom: 0px;
                border-bottom: none;
                padding-bottom: 0px;
            }

            @media screen and (max-width: 575px) {
                .buttons-to-right {
                    top: 10%;
                }
                .buttons-to-right a {
                    display: block;
                    margin-bottom: 20px;
                }
                .buttons-to-right a:last-child {
                    margin-bottom: 0px;
                }
                .bg-light-blue,
                .bg-light-green,
                .btn-gray {
                    padding: 7px;
                }
            }

            .card {
                margin-bottom: 20px;
                background-color: #fff;
                border-radius: 4px;
                -webkit-box-shadow: 0 1px 1px rgba(0, 0, 0, 0.05);
                box-shadow: 0 1px 1px rgba(0, 0, 0, 0.05);
                border-radius: 4px;
                box-shadow: none;
                border: none;
                padding: 25px;
            }
            .mb-5, .my-5 {
                margin-bottom: 3rem!important;
            }
            .msg-img {
                margin-right: 20px;
            }
            .msg-img img {
                width: 60px;
                border-radius: 50%;
            }
            img {
                max-width: 100%;
                height: auto;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="card card-white mb-5">
                        <div class="card-heading clearfix border-bottom mb-4">
                            <h4 class="card-title">Booking Requests</h4>
                        </div>
                        <div class="card-body">
                            <ul class="list-unstyled">
                                <li class="position-relative booking">
                                    <div class="media">
                                        <div class="msg-img">
                                            <img src="https://bootdey.com/img/Content/avatar/avatar6.png" alt>
                                        </div>
                                        <div class="media-body">
                                            <h5 class="mb-4">Sunny Apartment <span class="badge badge-primary mx-3">Chưa xử lý</h5>
                                            <div class="mb-3">
                                                <span class="mr-2 d-block d-sm-inline-block mb-2 mb-sm-0">Ngày đặt khám:</span>
                                                <span class="bg-light-blue">02.03.2020</span>
                                            </div>
                                            <div class="mb-3">
                                                <span class="mr-2 d-block d-sm-inline-block mb-2 mb-sm-0">Giờ khám</span>
                                                <span class="bg-light-blue">8:00</span>
                                            </div>
                                            <div class="mb-3">
                                                <span class="mr-2 d-block d-sm-inline-block mb-2 mb-sm-0">Price:</span>
                                                <span class="bg-light-blue">$147</span>
                                            </div>
                                            <div class="mb-5">
                                                <span class="mr-2 d-block d-sm-inline-block mb-1 mb-sm-0">Bệnh nhân:</span>
                                                <span class="border-right pr-2 mr-2">John Inoue</span>
                                                <span class="border-right pr-2 mr-2"> <a href="/cdn-cgi/l/email-protection" class="__cf_email__" data-cfemail="dfb5b0b7b19fbaa7beb2afb3baf1bcb0b2">[email&#160;protected]</a></span>
                                                <span>123-563-789</span>
                                            </div>
      

                                        </div>
                                    </div>
                                    <div class="buttons-to-right">
                                        <a href="#" class="btn-gray mr-2"><i class="far fa-times-circle mr-2"></i>Từ chối</a>
                                        <a href="#" class="btn-gray"><i class="far fa-check-circle mr-2"></i> Chấp nhận</a>
                                    </div>
                                </li>
                                <li class="position-relative booking">
                                    <div class="media">
                                        <div class="msg-img">
                                            <img src="https://bootdey.com/img/Content/avatar/avatar1.png" alt>
                                        </div>
                                        <div class="media-body">
                                            <h5 class="mb-4">Burger House <span class="badge badge-success ml-3">Chấp Nhận</span></h5>
                                            <div class="mb-3">
                                                <span class="mr-2 d-block d-sm-inline-block mb-2 mb-sm-0">Ngày đặt Khám:</span>
                                                <span class="bg-light-green">06.03.2020</span>
                                            </div>
                                            <div class="mb-3">
                                                <span class="mr-2 d-block d-sm-inline-block mb-2 mb-sm-0">Giờ khám:</span>
                                                <span class="bg-light-green">8:30 - 8:45</span>
                                            </div>
                                            <div class="mb-5">
                                                <span class="mr-2 d-block d-sm-inline-block mb-1 mb-sm-0">Bệnh nhân:</span>
                                                <span class="border-right pr-2 mr-2">Jaime Cressey</span>
                                                <span class="border-right pr-2 mr-2"> <a href="/cdn-cgi/l/email-protection" class="__cf_email__" data-cfemail="e78d868e8a82a7829f868a978b82c984888a">[email&#160;protected]</a></span>
                                                <span>355-456-789</span>
                                            </div>
                                            <a href="#" class="btn-gray">Chưa Khám</a>
                                            <a href="#" class="btn-gray">Đã Khám</a>                                        </div>
                                    </div>
                                    <div class="buttons-to-right">
                                        <a href="#" class="btn-gray mr-2"><i class="far fa-times-circle mr-2"></i>Hủy</a>
                                    </div>
                                </li>
                                <li class="position-relative booking">
                                    <div class="media">
                                        <div class="msg-img">
                                            <img src="https://bootdey.com/img/Content/avatar/avatar2.png" alt>
                                        </div>
                                        <div class="media-body">
                                            <h5 class="mb-4">Modern Hotel <span class="badge badge-danger ml-3">Hủy</span></h5>
                                            <div class="mb-3">
                                                <span class="mr-2 d-block d-sm-inline-block mb-2 mb-sm-0">Ngày đặt khám:</span>
                                                <span class="btn-gray">20.03.2020</span>
                                            </div>
                                            <div class="mb-3">
                                                <span class="mr-2 d-block d-sm-inline-block mb-2 mb-sm-0">Giờ khám:</span>
                                                <span class="btn-gray">14:30 - 14:45</span>
                                            </div>
                                            <div>
                                                <span class="mr-2 d-block d-sm-inline-block mb-1 mb-sm-0">Bệnh nhân:</span>
                                                <span class="border-right pr-2 mr-2">Tesha Stovall</span>
                                                <span class="border-right pr-2 mr-2"> <a href="/cdn-cgi/l/email-protection" class="__cf_email__" data-cfemail="d8acbdabb0b998bda0b9b5a8b4bdf6bbb7b5">[email&#160;protected]</a></span>
                                                <span>123-456-684</span>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script data-cfasync="false" src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script><script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.bundle.min.js"></script>
        <script type="text/javascript">

        </script>
    </body>
</html>