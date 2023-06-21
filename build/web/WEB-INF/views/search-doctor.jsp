<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:include page="master/head.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="custom-container">
    <div class="row">
        <div class="col-md-5">
            <h1>Tìm kiếm bác sĩ</h1>
            <form action="" method="post">
                <div class="form-group">
                    <label for="name">Nhập tên bác sĩ</label>
                    <input class="form-control" name="name" type="text" id="name">
                </div>
                <div class="">
                    <div class="row">
                        <div class="col-md-6 mt-2">
                            <label>Nhập chuyên môn bác sĩ</label>
                        </div>
                        <div class="col-md-6">
                            <select class="" name="speciality" id="speciality">
                                <option value="0">Tất cả</option>
                                <c:forEach var="item" items="${speciality_list}">
                                    <option value="${item.id}">${item.getName()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
                <button class="btn btn-block">submit</button>
            </form>
        </div>
        <div class="col-md-7">
            <h1>kết quả tìm kiếm</h1>
            <div class="container-fluid">
                <c:forEach var="item" items="${doctors}">
                <div class="row m-5">
                    <div class="col-md-3" style="position: relative;">
                        <img style="border-radius: 50%;width: 100%; height: 100%; object-fit: cover" src="${pageContext.request.contextPath}/${item.image}" alt="">
                    </div>
                    <div class="col-md-9">
                        <div class="row">
                            <div class="col-md-9 mt-3">
                                <h2 class="font-weight-bold">${item.name}</h2>
                                <h3>Chuyên ngành : ${item.speciality_name}</h3>
                                <h3>Liên hệ : ${item.phone}</h3>
                                <h3>trình độ : ${item.degree}</h3>
                            </div>
                            <div class="col-md-3">
                                    <a href="${pageContext.request.contextPath}/patient/make-appointment?doc_id=${item.id}">
                                        <button class="btn btn-block">đặt lịch</button>
                                    </a>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                </c:forEach>
            </div>

        </div>
    </div>
</div>
<jsp:include page="master/foot.jsp"/>
<script>
    $(document).ready(function() {
        var squareContainers = $('.col-md-3');
        squareContainers.each(function() {
            var containerWidth = $(this).width();
            $(this).css('height', containerWidth);
        });
    });
</script>