<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>在线视频</title>

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
        <br>
        <br>
        <%--首页内容区域--%>
    <div class="container">
        <%--轮播--%>
        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
            <%--    轮播下划线--%>
            <ol class="carousel-indicators">
                <c:forEach items="${listBanner}" var="banner" varStatus="idx" begin="0">
                    <li data-target="#carouselExampleIndicators" data-slide-to="${idx.index}"
                        <c:if test="${idx.index == 0}">class="active"</c:if> >
                    </li>
                </c:forEach>
            </ol>
            <%--轮播的内容--%>
            <div class="carousel-inner">

                <c:forEach items="${listBanner}" varStatus="idx" var="banner" begin="0">
                    <div class="carousel-item <c:if test="${idx.index == 0}"> active </c:if>">
                        <a href="${banner.targetUrl}">
                            <img src="${banner.imgUrl}" class="d-block w-100 rounded" alt="...">
                        </a>
                    </div>
                </c:forEach>

            </div>
            <%--  左箭头  --%>
            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <%--    右箭头--%>
            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
        <br>
            <%--最新课程类型--%>
        <div class="border border-top-0 border-left-0 border-right-0  border-secondary">
            <a href="/course_list" class="float-right">更多 ></a>
            <h4 class="text-center">最新课程</h4>
        </div>
        <div class="row row-cols-1 row-cols-md-4 mt-2">
            <c:forEach var="topic" items="${listNews.list}">
                <div class="col mb-3">
                    <a href="/topic/${topic.id}" target="_blank">
                        <div class="card select-shadow">
                            <img src="${topic.iconUrl}" class="card-img-top" alt="...">
                            <div class="card-body">
                                <p class="card-text">${topic.title}</p>
                                <p class="card-text">${topic.views}</p>
                                <c:choose>
                                    <c:when test="${topic.vipFlag != 1}">
                                        <span class="badge badge-pill badge-success ">免费</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="badge badge-pill badge-danger ">会员</span>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </a>
                </div>
            </c:forEach>
        </div>


        <br>
            <%--常用框架--%>
        <div class="border border-top-0 border-left-0  border-right-0  border-secondary">
            <a href="/course_list/type/3" class="float-right">更多</a>
            <h4 class="text-center">常用框架</h4>
        </div>
        <div class="row row-cols-1 row-cols-md-4 mt-2">
            <c:forEach var="topic" items="${listIndex.list}">
                <div class="col mb-3">
                    <a href="/topic/${topic.id}" target="_blank">
                        <div class="card select-shadow">
                            <img src="${topic.iconUrl}" class="card-img-top" alt="...">
                            <div class="card-body">
                                <p class="card-text">${topic.title}</p>
                                <p class="card-text">${topic.views}</p>
                                <c:choose>
                                    <c:when test="${topic.vipFlag != 1}">
                                        <span class="badge badge-pill badge-success ">免费</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="badge badge-pill badge-danger ">会员</span>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </a>
                </div>
            </c:forEach>
        </div>


    </div>
    <%-- 尾部--%>
    <jsp:include page="/WEB-INF/jsp/common/footer.jsp"></jsp:include>
</body>
</html>