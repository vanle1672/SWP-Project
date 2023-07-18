<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
</main>
<footer>
    <div class="footer-wrappr section-bg3" data-background="${pageContext.request.contextPath}/assets/img/gallery/footer-bg.png">
        <div class="footer-area footer-padding ">
            <div class="container">
                <div class="row justify-content-between">
                    <div class="col-xl-8 col-lg-8 col-md-6 col-sm-12">
                        <div class="single-footer-caption mb-50">
                            <!-- logo -->
                            <div class="footer-logo mb-25">
                                <a href="${pageContext.request.contextPath}"><img src="${pageContext.request.contextPath}/assets/img/logo/logo_5.png" alt=""></a>
                            </div>
                            <d iv class="header-area">
                                <div class="main-header main-header2">
                                    <div class="menu-main d-flex align-items-center justify-content-start">
                                        <!-- Main-menu -->
                                        <div class="main-menu main-menu2">
                                            <nav>

                                            </nav>
                                        </div>
                                    </div>
                                </div>
                            </d>
                            <!-- social -->
                            <div class="footer-social mt-50">
                              
                                <a href="https://www.facebook.com/profile.php?id=100092981378234" target="_blank" ><i class="fab fa-facebook-f"></i></a>
                              
                            </div>

                        </div>
                        <div class="contact-info">
                            <ul>
                                <li><h3 class="fas fa-map-marker-alt"> 123 Ngũ Hành Sơn, TP Đà Nẵng</h3></li> <br>
                                <li><h3 class="fas fa-phone"> +84 1900 8369</h3></li> <br>
                                <li><h3 class="far fa-envelope"> antam@gmail.com</h3></li>
                            </ul>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <!-- footer-bottom area -->
        <div class="footer-bottom-area">
            <div class="container">
                <div class="footer-border">
                    <div class="row">
                        <div class="col-xl-10 ">

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</footer>
<!-- Scroll Up -->
<div id="back-top">
    <a title="Go to Top" href="#">
        <i class="fas fa-level-up-alt"></i>
    </a>
</div>

<div id="messenger-container">
    <a title="Messenger" href="https://www.facebook.com/messages/t/110012632102742" target="_blank" id="messenger-icon">
        <i class="fab fa-facebook-messenger"></i>
    </a>
</div>


<!-- JS here -->

<script src="${pageContext.request.contextPath}/assets/js/vendor/modernizr-3.5.0.min.js"></script>
<!-- Jquery, Popper, Bootstrap -->
<script src="${pageContext.request.contextPath}/assets/js/vendor/jquery-1.12.4.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
<!-- Jquery Mobile Menu -->
<script src="${pageContext.request.contextPath}/assets/js/jquery.slicknav.min.js"></script>

<!-- Jquery Slick , Owl-Carousel Plugins -->
<script src="${pageContext.request.contextPath}/assets/js/owl.carousel.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/slick.min.js"></script>
<!-- One Page, Animated-HeadLin -->
<script src="${pageContext.request.contextPath}/assets/js/wow.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/animated.headline.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery.magnific-popup.js"></script>

<!-- Date Picker -->
<script src="${pageContext.request.contextPath}/assets/js/gijgo.min.js"></script>
<!-- Nice-select, sticky -->
<script src="${pageContext.request.contextPath}/assets/js/jquery.nice-select.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery.sticky.js"></script>

<!-- counter , waypoint,Hover Direction -->
<script src="${pageContext.request.contextPath}/assets/js/jquery.counterup.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/waypoints.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery.countdown.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/hover-direction-snake.min.js"></script>

<!-- contact js -->
<script src="${pageContext.request.contextPath}/assets/js/contact.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery.form.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/mail-script.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery.ajaxchimp.min.js"></script>

<!-- Jquery Plugins, main Jquery -->
<script src="${pageContext.request.contextPath}/assets/js/plugins.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/main.js"></script>
<%--Jquery Table--%>
<%--<script src="https://code.jquery.com/jquery-3.5.1.js"></script>--%>
<%--<script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>--%>
</body>
</html>


<script>
    // Thêm lớp 'show' vào biểu tượng Messenger khi cuộn lên hoặc cuộn xuống
    window.addEventListener('scroll', function () {
        var messengerContainer = document.getElementById('messenger-container');
        var scrollPosition = window.scrollY || document.documentElement.scrollTop;

        if (scrollPosition > 300) {
            messengerContainer.classList.add('show');
        } else {
            messengerContainer.classList.remove('show');
        }
    });

</script>
<style>
    #messenger-container {
        position: fixed;
        bottom: 80px;
        right: 28px;
        z-index: 9999;
        opacity: 0;
        transition: opacity 0.3s;
        width: 50px;
        height: 50px;
        border-radius: 50%;
        background-color: #0084FF;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
        display: flex;
        justify-content: center;
        align-items: center;
    }

    #messenger-icon {
        display: block;
        color: #ffffff;
        font-size: 26px;
    }

    #messenger-container.show {
        opacity: 1;
    }

</style>