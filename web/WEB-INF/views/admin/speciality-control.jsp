<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../master/head.jsp"/>
<div class="custom-container">
    ${message}
    <div class="row">
        <div class="col-md-4">
            <form action="" method="post">
                <input type="hidden" name="_method" value="">
                <label for="name">Nhập tên chuyên khoa</label>
                <input class="form-control" id="name" type="text" name="name">
                <button class="btn">submit</button>
            </form>
        </div>
        <div class="col-md-8">
            <table class="table" border="1">
                <tr>
                    <th>id</th>
                    <th>name</th>
                    <th>action</th>
                </tr>
                <c:forEach var="item" items="${speciality_list}">
                    <tr>
                        <td>${item.id}</td>
                        <td> ${item.getName()}</td>
                        <td>
                            <div  class="row ml-5">
                                <form action="" method="POST">
                                    <input type="hidden" name="_method" value="DELETE">
                                    <input type="hidden" value="${item.id}" name="id">
                                    <button class="btn" >delete</button>
                                </form>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<jsp:include page="../master/foot.jsp"/>
