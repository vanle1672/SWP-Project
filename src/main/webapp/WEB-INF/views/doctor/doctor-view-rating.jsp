<%-- 
    Document   : doctor-view-rating
    Created on : Jul 18, 2023, 9:26:49 PM
    Author     : ASUS
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:include page="../master/head.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/MaterialDesign-Webfont/5.3.45/css/materialdesignicons.css" integrity="sha256-NAxhqDvtY0l4xn+YVa6WjAcmd94NNfttjNsDmNatFVc=" crossorigin="anonymous" />
<section class="section">
    <div class="container">
        <div class="justify-content-center row">
            <div class="col-lg-12">
                <div class="candidate-list-widgets mb-4">

                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="candidate-list">
                    <c:forEach var="review" items="${reviewList}">
                        <div class="candidate-list-box card mt-4">
                            <div class="p-4 card-body">
                                <div class="align-items-center row">
                                    <div class="col-auto">
                                        <div class="candidate-list-images">
                                            <a href="#"><img src="https://bootdey.com/img/Content/avatar/avatar1.png" alt="" class="avatar-md img-thumbnail rounded-circle" /></a>
                                        </div>
                                    </div>
                                    <div class="col-lg-5">
                                        <div class="candidate-list-content mt-3 mt-lg-0">
                                            <h5 class="fs-19 mb-0">
                                                <a class="primary-link">${review.namePatient}</a><span class="badge bg-success ms-1"> <i class="mdi mdi-star align-middle"></i> ${review.rating}</span>
                                            </h5>
                                            <p class="text-muted mb-2">${review.dateUp}</p>

                                        </div>

                                    </div>  

                                </div>  
                                <ul class="list-inline mb-0 ">
                                    <li style="margin-left: 80px" > ${review.comment}</li>

                                </ul>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>

    </div>
</section>
<jsp:include page="../master/foot.jsp" />



<style>

    .card {
        box-shadow: 0 20px 27px 0 rgb(0 0 0 / 5%);
    }

    .avatar-md {
        height: 5rem;
        width: 5rem;
    }

    .fs-19 {
        font-size: 19px;
    }

    .primary-link {
        color: #314047;
        -webkit-transition: all .5s ease;
        transition: all .5s ease;
    }

    a {
        color: #02af74;
        text-decoration: none;
    }

    .bookmark-post .favorite-icon a, .job-box.bookmark-post .favorite-icon a {
        background-color: #da3746;
        color: #fff;
        border-color: danger;
    }
    .favorite-icon a {
        display: inline-block;
        width: 30px;
        height: 30px;
        font-size: 18px;
        line-height: 30px;
        text-align: center;
        border: 1px solid #eff0f2;
        border-radius: 6px;
        color: rgba(173,181,189,.55);
        -webkit-transition: all .5s ease;
        transition: all .5s ease;
    }


    .candidate-list-box .favorite-icon {
        position: absolute;
        right: 22px;
        top: 22px;
    }
    .fs-14 {
        font-size: 14px;
    }
    .bg-soft-secondary {
        background-color: rgba(116,120,141,.15)!important;
        color: #74788d!important;
    }

    .mt-1 {
        margin-top: 0.25rem!important;
    }

</style>