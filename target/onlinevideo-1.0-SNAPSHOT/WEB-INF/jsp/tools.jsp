<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>工具</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <%--    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">--%>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="shortcut icon" href="#"/>
</head>
<body>

<%--头部--%>
<jsp:include page="/WEB-INF/jsp/common/header.jsp"></jsp:include>
<br><br>
<%--首页内容区域--%>
<div class="container">

    <%--    工具导航--%>
    <ul class="nav nav-pills">
        <li class="nav-item">
            <a class="nav-link ${toolsTypeId == 0 ? "active" : ""} " href="/tools">全部</a>
        </li>

        <c:forEach items="${toolsAllType}" var="toolsType">
            <li class="nav-item">
                <a class="nav-link ${ toolsType.id == toolsTypeId ? "active" :""} "
                   href="/toolsList/type/${toolsType.id}">${toolsType.name}</a>
            </li>
        </c:forEach>

    </ul>

        <c:forEach items="${toolsItemAll.list}" var="tools" varStatus="idx" begin="0">
            <c:if test="${idx.index % 4 == 0 }">
                <div class="row row-cols-1 row-cols-md-4 mt-2">
            </c:if>
            <div class="col mb-3">
                <a href="${tools.toolsUrl}" target="_blank">
                    <div class="card select-shadow">
                        <img src="${tools.iconUrl}" class="card-img-top" alt="...">
                        <div class="card-body">
                            <p class="card-text">${tools.name}</p>
                        </div>
                    </div>
                </a>
            </div>
            <c:if test="${idx.index % 4 == 3 || idx.last}">
                </div>
            </c:if>
        </c:forEach>

        <%-- 分页--%>
        <nav aria-label="Page navigation example">
            <ul class="pagination justify-content-center">
                <li class="page-item ${toolsItemAll.hasPreviousPage? "" :"disabled"} ">
                    <a class="page-link" href="/toolsList/type/${toolsTypeId}?pageNum=${toolsItemAll.prePage}">上一页</a>
                </li>
                <%--            //导航条上的第一页--%>
                <%--            private int navigateFirstPage;--%>
                <%--            //导航条上的最后一页--%>
                <%--            private int navigateLastPage;--%>
                <c:forEach var="i" begin="${toolsItemAll.navigateFirstPage}" end="${toolsItemAll.navigateLastPage}">
                    <li class=" page-item
                ${toolsItemAll.pageNum == i ? "active" : "" } ">
                        <a class="page-link" href="/toolsList/type/${toolsTypeId}?pageNum=${i}">${i}</a>
                    </li>
                </c:forEach>
                <li class="page-item ${toolsItemAll.hasNextPage? "" :"disabled"} ">
                    <a class="page-link" href="/toolsList/type/${toolsTypeId}?pageNum=${toolsItemAll.nextPage}">下一页</a>
                </li>
            </ul>
        </nav>
</div>
<br>
<br>
<%--网站的尾部--%>
<jsp:include page="/WEB-INF/jsp/common/footer.jsp"></jsp:include>
</body>
</html>