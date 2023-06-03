

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">


        <title>bs5 profile security page - Bootdey.com</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="assets/css/hosobacsi.css">

    </head>
    <body>
        <div class="container-xl px-4 mt-4">

            <nav class="nav nav-borders">
                <a class="nav-link" href="hosobacsi.jsp" target="__blank">Profile</a>
                <a class="nav-link" href="" target="__blank">Lịch Khám</a>
                <a class="nav-link" href="" target="__blank">Bảo Mật</a>
                <a class="nav-link" href="" target="__blank">Đánh Giá</a>
            </nav>
            <hr class="mt-0 mb-4">
            <div class="row">
                <div class="col-lg-8">

                    <div class="card mb-4">
                        <div class="card-header">Đổi mật khẩu</div>
                        <div class="card-body">
                            <form>

                                <div class="mb-3">
                                    <label class="small mb-1" for="currentPassword">Mật khẩu hiện tại</label>
                                    <input class="form-control" id="currentPassword" type="password" placeholder="Nhập mật khẩu hiện tại">
                                </div>

                                <div class="mb-3">
                                    <label class="small mb-1" for="newPassword">Mật khẩu mới</label>
                                    <input class="form-control" id="newPassword" type="password" placeholder="Nhập mật khẩu mới">
                                </div>

                                <div class="mb-3">
                                    <label class="small mb-1" for="confirmPassword">Xác nhận mật khẩu</label>
                                    <input class="form-control" id="confirmPassword" type="password" placeholder="Nhập lại mật khẩu mới">
                                </div>
                                <button class="btn btn-primary" type="button">Lưu</button>
                            </form>
                        </div>
                    </div>


                </div>
                <div class="col-lg-4">

                    <div class="card mb-4">
                        <div class="card-header">Xác thực hai yếu tố</div>
                        <div class="card-body1">
                            <p>Thêm một mức bảo mật khác vào tài khoản của bạn bằng cách bật xác thực hai yếu tố. Chúng tôi sẽ gửi cho bạn một tin nhắn văn bản để xác minh nỗ lực đăng nhập của bạn trên các thiết bị và trình duyệt không được nhận dạng.</p>
                            <form>
                                <div class="form-check">
                                    <input class="form-check-input" id="twoFactorOn" type="radio" name="twoFactor" checked>
                                    <label class="form-check-label" for="twoFactorOn">Bật</label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" id="twoFactorOff" type="radio" name="twoFactor">
                                    <label class="form-check-label" for="twoFactorOff">Tắt</label>
                                </div>
                                <div class="mt-3">
                                    <label class="small mb-1" for="twoFactorSMS">SMS Điện Thoại</label>
                                    <input class="form-control" id="twoFactorSMS" type="tel" value="555-123-4567">
                                </div>
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
