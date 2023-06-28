<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:include page="master/head.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">

<div class="custom-container">
    <form action="" method="post">

        <div class="row">
            <div class="form-group mb-1 mt-1 col-md-6">
            
                <h1>Bạn đang đặt lịch với bác sĩ ${doctor.name}</h1>
                <h1>Chuyên ngành : ${doctor.speciality_name}</h1>
                <h1>Số năm kinh nghiệm : ${doctor.experience}</h1>
                <div class="col-md-3" style="position: relative;">
                    <img style="border-radius: 50%;width: 100%; height: 100%; object-fit: cover" src="${pageContext.request.contextPath}/${doctor.image}" alt="">
                </div>
                <label for="note">Lời nhắn</label><br>
                <textarea name="note" id="note" cols="90" rows="5"></textarea>
                <button class="btn btn-block">Submit</button>
            </div>
            <%--        <c:set var="myVariable" value="value1" />--%>

            <%--        <c:if test="${myVariable ne 'value2'}">--%>
            <%--            <!-- Code to execute when myVariable is not equal to 'value2' -->--%>
            <%--            <p>Variable is not equal to 'value2'</p>--%>
            <%--        </c:if>--%>

            <div class="col-md-6 d-flex">

                <div class="">
                    <c:if test="${fn:length(available) > 0}">
                        <c:set var="current_date" value="${fn:split(available.get(0).getStart(), ' ')[0]}" />
                        <strong><c:out value="${current_date}"/></strong>  
                        <c:forEach var="item" items="${available}">
                            <c:set var="item_date" value="${fn:split(item.getStart(), ' ')[0]}" />
                            <c:if test="${current_date ne item_date}">
                                <c:set var="current_date" value="${item_date}"/>
                                <h5>           <c:out value="${current_date}"/></h5>  
                            </c:if>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" id="${item.getId()}" name="doctor_schedule_id" value="${item.getId()}">
                                <label class="form-check-label" for="${item.getId()}">Từ ${fn:split(item.getStart(), ' ')[1]} đến ${fn:split(item.getEnd(), ' ')[1]}</label><br>
                            </div>
                        </c:forEach>
                    </c:if>
                    <c:if test="${fn:length(available) == 0}">
                        <h1>Bác sĩ này không có lịch rảnh.</h1>
                    </c:if>
                </div>
                <div class="col-md-6" style="padding-left: 25%">
                    <c:forEach items="${review}" var="item"  >
                        <c:forEach begin="1" end="${item.rating}">
                            <i class="bi bi-star-fill" style="color: #ffcc00"></i>
                        </c:forEach><br>
                       
                            <label > <strong>${item.namePatient}</strong></label>
                            <label>${item.dateUp}</label><br>
                            <label>${item.comment}</label><br>

                      

                    </c:forEach> 
                </div>
            </div>

        </div>
    </form>


    <%--<button class="btn btn-info" data-toggle="modal" data-target="#addModel">Thêm lịch</button>
    <div class="modal fade" id="addModel" tabindex="-1" role="dialog" aria-labelledby="addModel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <form action="" method="post">
                    <input type="hidden" name="_method" value="add_appointment">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="custom-container form-group mb-1">
                            <label for="date">Ngày</label>
                            <input class="form-control" required type="date" name="date" id="date">
                        </div>
                        <div class="custom-container form-group mt-1 mb-1">
                            <label for="from">Từ (8-17)</label>
                            <input class="form-control" min="8" max="16" required type="number" name="from" id="from">
                            <p class="text-warning">LƯU Ý : Thời gian đặt lịch khám mặc định là 1h</p>
                        </div>
                        <div class="custom-container form-group mb-1">
                            <label for="note">Ghi chú</label>
                            <textarea name="note" id="note" cols="45" rows="10"></textarea>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Save changes</button>
                    </div>
                </form>
            </div>
        </div>
    </div>--%>
</div>
<jsp:include page="master/foot.jsp"/>
