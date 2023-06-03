<%-- 
    Document   : Login
    Created on : May 26, 2023, 10:35:07 AM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="assets/css/login.css">
<!DOCTYPE html>
<html lang="es" dir="ltr">

    <head>
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0">
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="main.css">
        <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700;800&display=swap" rel="stylesheet">
    </head>

    <body>
        <div class="main">

            <div class="container a-container" id="a-container">
                <form class="form" id="a-form" method="post" action="dang-ki">
                    <h2 class="form_title title">Tạo tài khoản</h2>

                    <p class="text-danger">${mess0}</p><br>
                    <p class="text-danger">${mess1}</p><br>
                    <p class="text-success">${mess2}</p><br>
                    <p class="text-danger">${mess3}</p><br>
                    <input class="form__input" type="text" placeholder="Họ và tên" name="name">
                    <input class="form__input" type="email" placeholder="Email" name="email">
                    <input class="form__input" type="password" placeholder="Mật khẩu" name="pass">
                    <input class="form__input" type="password" placeholder="Xác nhận mật khẩu" name="confirm">
                    <input class="form__input" type="number" placeholder="Số điện thoại" name="phone">
                    <button class="button-login">ĐĂNG KÍ</button>
                </form>
            </div>
            <div class="container b-container" id="b-container">
                <form class="form" id="b-form" method="post" action="dang-nhap">
                    <h2 class="form_title title">Đăng nhập vào Website</h2>
                    <p class="text-danger">${mess}</p><br>
                    <input class="form__input" type="text" placeholder="Email" name="email">
                    <input class="form__input" type="password" placeholder="Password" name="pass">
                    <i class="fas fa-key"></i>
                    <a class="form__link" href="Quenmatkhau.jsp" style="text-decoration: none">Quên mật khẩu?</a>
                    <button class="button-login" >ĐĂNG NHẬP</button>
                </form>
            </div>
            <div class="switch" id="switch-cnt">
                <div class="switch__circle"></div>
                <div class="switch__circle switch__circle--t"></div>

                <div class="switch__container" id="switch-c1">
                    <h2 class="switch__title title">Chào bạn !</h2>
                    <p class="switch__description description">Để giữ kết nối với chúng tôi, vui lòng đăng nhập bằng thông tin cá nhân của bạn</p>
                    <button class="switch__button button switch-btn">ĐĂNG NHẬP</button>
                </div>
                <div class="switch__container is-hidden" id="switch-c2">

                    <h2 class="switch__title title">Chào bạn !</h2>
                    <p class="switch__description description">Nhập thông tin cá nhân của bạn và bắt đầu hành trình với chúng tôi</p>
                    <button class="switch__button button switch-btn">ĐĂNG KÍ</button>
                </div>
            </div>
        </div>

    </body>
</html>
<script src="./assets/js/login.js"></script>