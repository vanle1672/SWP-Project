<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:include page="../master/head.jsp"/>
<div class="custom-container">
    <c:if test="${not empty error}">
        <p class="text-danger">${error}</p>
    </c:if>
    <form action="" method="post" enctype="multipart/form-data">
        <input type="hidden" name="blogid" value="${blog.blogid}">
        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <label for="name">Ngày đăng</label>
                    <input class="form-control" type="text" id="day" name="update_day" placeholder="Ngày đăng" value="${blog.day}">
                </div>
                <div class="form-group">
                    <label for="mail">Tháng đăng</label>
                    <input class="form-control" type="text" id="month" name="update_month" placeholder="Tháng đăng" value="${blog.month}">
                </div>
                <div class="form-group">
                    <label for="password">Tiêu đề</label>
                    <input class="form-control" type="text" id="title" name="update_title" placeholder="Tiêu đề" value="${blog.title}">
                </div>
                <div class="form-group">
                    <label for="degree">Mô tả ngắn</label>
                    <input class="form-control" type="text" id="scriptshort" name="update_scriptshort" placeholder="Mô tả ngắn" value="${blog.scriptShort}">
                </div>
                <div class="form-group">
                    <label for="experience">Mô tả đầy đủ</label>
                    <input class="form-control" type="text" id="scriptfull" name="update_scriptfull" placeholder="Mô tả đầy đủ" value="${blog.scriptFull}">
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <label for="file">Ảnh</label>
                    <input class="form-control" type="file" id="file" name="update_image">
                    <img style="max-width: 100%; object-fit: cover" src="${pageContext.request.contextPath}/${doctor.image}" alt="">
                </div>
            </div>
        </div>
        <button type="submit" class="btn">submit</button>
    </form>
    <%--    <form action="" method="post">--%>
    <%--        <input type="text">--%>
    <%--        <button>submit</button>--%>
    <%--    </form>--%>
</div>
<jsp:include page="../master/foot.jsp"/>
