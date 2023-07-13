<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:include page="master/head.jsp"/>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<style>
    @import url('https://fonts.googleapis.com/css?family=Poppins:400,500,600,700&display=swap');
    .rating input{
        display: none;
    }

    .rating label{
        font-size: 15px;
        padding-top: 4px;
        padding: 2px 0 2px 2px;
        color: #444;
        float: right;
        transition: all 0.2s ease;
    }
    input:not(:checked) ~ label:hover,
    input:not(:checked) ~ label:hover ~ label{
        color: #fd4;
    }
    input:checked ~ label{
        color: #fd4;
    }
    input#rate-5:checked ~ label{
        color: #fe7;
        text-shadow: 0 0 5px;
    }
    input:checked ~ form{
        display: block;
    }
</style>
<div class="custom-container">

    <h1>Đây là cuộc hẹn với bệnh nhân ${patient.getName()} với ${doctor.getName()}</h1>
    <h1>Vào ngày ${fn:split(time[0], ' ')[0]}</h1>
    <h1>Từ ${fn:split(time[0], ' ')[1]} Đến ${fn:split(time[1], ' ')[1]}</h1>
    <h1>Lời nhắn của bệnh nhân : ${app.getNote()}</h1>
    <div class="row ml-1">
        <h1>Tình trạng</h1>
        <select name="status" disabled id="">
            <option value="finished" ${app.getStatus() == "finished" ? "selected" : ""}>Đã khám</option>
            <option value="canceled" ${app.getStatus() == "canceled" ? "selected" : ""}>Đã huỷ</option>
            <option value="not_yet" ${app.getStatus() == "not_yet" ? "selected" : ""}>Chưa khám</option>
        </select>
    </div>
    <c:if test="${app.getStatus() == 'not_yet'}">
        <a href="${pageContext.request.contextPath}/patient/cancel-appointment?app_id=${app.getId()}">
            <button class="btn">Huỷ lịch</button>
        </a>
    </c:if>
        <br><br>
    <c:if test="${app.getStatus() == 'finished'}">
        <form action="review" method="">
            <div class="form-group">
                <label>Để lại đánh giá</label>
                <div class="rating">
                    <div class="form-check form-check-inline">
                        <input value="5" type="radio" name="rate" id="rate-5" class="form-check-input">
                        <label for="rate-5" class="bi bi-star-fill form-check-label"></label>
                        <input value="4" type="radio" name="rate" id="rate-4" class="form-check-input">
                        <label for="rate-4" class="bi bi-star-fill form-check-label"></label>
                        <input value="3" type="radio" name="rate" id="rate-3" class="form-check-input">
                        <label for="rate-3" class="bi bi-star-fill form-check-label"></label>
                        <input value="2" type="radio" name="rate" id="rate-2" class="form-check-input">
                        <label for="rate-2" class="bi bi-star-fill form-check-label"></label>
                        <input value="1" type="radio" name="rate" id="rate-1" class="form-check-input">
                        <label for="rate-1" class="bi bi-star-fill form-check-label"></label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label for="cmt">Bình luận:</label>
                <textarea class="form-control" id="cmt" name="cmt" rows="10" placeholder="Bình luận ..." style="font-size: 15px;resize: none;"></textarea>


            </div>
            <input type="hidden" name="iddoctor" value="${doctor.id}">
            <button class="btn btn-primary" type="submit">Bình luận</button>
        </form>
    </c:if>


</div>


</div>
<jsp:include page="master/foot.jsp"/>
