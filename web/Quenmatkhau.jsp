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
                <form class="form" id="a-form"  action="quen-mat-khau">
                    <h2 class="form_title title">Quên mật khẩu</h2>
                    
                    <p class="text-danger">${mess0}</p><br>
                    <p class="text-danger">${mess1}</p><br>
                    <p class="text-success">${mess2}</p><br>
                    <p class="text-danger">${mess3}</p><br>
               
                    <input class="form__input" type="email" placeholder="Email" name="email">                
                    <button class="button-login">Xác nhận</button>
                </form>
            </div>
           
            <div class="switch" id="switch-cnt">
                <div class="switch__circle"></div>
                <div class="switch__circle switch__circle--t"></div>
                <div class="switch__container" id="switch-c1">
                    <h2 class="switch__title title">Chào bạn !</h2>
                    <p class="switch__description description">Để giữ kết nối với chúng tôi, vui lòng đăng nhập bằng thông tin cá nhân của bạn</p>
                    <button class="button-login "><a href="Login.jsp"  style="text-decoration: none; color: #f9f9f9;">ĐĂNG NHẬP</a></button>
                </div>
                
            </div>
        </div>

    </body>
</html>
<script src="./assets/js/login.js"></script>