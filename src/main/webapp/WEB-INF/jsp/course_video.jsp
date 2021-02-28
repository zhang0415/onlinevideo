<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>直播</title>

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="/static/css/duyi-video.css" crossorigin="anonymous">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/static/css/bootstrap.min.css" crossorigin="anonymous">
</head>
<body>

<%--头部--%>
<jsp:include page="/WEB-INF/jsp/common/header.jsp"></jsp:include>
<br><br>
<%--首页内容区域--%>
<div class="container">
    <%--    视频--%>
    <div class="card">
        <div class="embed-responsive embed-responsive-16by9">
            <iframe src="//player.bilibili.com/player.html?aid=31112147&bvid=BV1aW411Z7KY&cid=54343242&page=1"
                    scrolling="no" border="0" frameborder="no" framespacing="0" allowfullscreen="true">
            </iframe>
        </div>
    </div>
    <%--    视频相关--%>
    <div class="row mt-2">
        <div class="col-md-9">
            <span class="font-weight">浏览次数：<b class="text-primary">1069次</b></span>
            <span class="font-weight ml-3">课时数：<b class="text-primary">19</b></span>
            <span class="text-weight ml-3">类别：<b class="text-success">免费</b></span>
            &nbsp;<a href="#" class="alert-link text-secondary col-md-2">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-share"
                 viewBox="0 0 16 16">
                <path d="M13.5 1a1.5 1.5 0 1 0 0 3 1.5 1.5 0 0 0 0-3zM11 2.5a2.5 2.5 0 1 1 .603 1.628l-6.718 3.12a2.499 2.499 0 0 1 0 1.504l6.718 3.12a2.5 2.5 0 1 1-.488.876l-6.718-3.12a2.5 2.5 0 1 1 0-3.256l6.718-3.12A2.5 2.5 0 0 1 11 2.5zm-8.5 4a1.5 1.5 0 1 0 0 3 1.5 1.5 0 0 0 0-3zm11 5.5a1.5 1.5 0 1 0 0 3 1.5 1.5 0 0 0 0-3z"/>
            </svg>
            分享
        </a>
            <a href="#" class="alert-link text-secondary col-md-2">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-star"
                     viewBox="0 0 16 16">
                    <path d="M2.866 14.85c-.078.444.36.791.746.593l4.39-2.256 4.389 2.256c.386.198.824-.149.746-.592l-.83-4.73 3.523-3.356c.329-.314.158-.888-.283-.95l-4.898-.696L8.465.792a.513.513 0 0 0-.927 0L5.354 5.12l-4.898.696c-.441.062-.612.636-.283.95l3.523 3.356-.83 4.73zm4.905-2.767l-3.686 1.894.694-3.957a.565.565 0 0 0-.163-.505L1.71 6.745l4.052-.576a.525.525 0 0 0 .393-.288l1.847-3.658 1.846 3.658a.525.525 0 0 0 .393.288l4.052.575-2.906 2.77a.564.564 0 0 0-.163.506l.694 3.957-3.686-1.894a.503.503 0 0 0-.461 0z"/>
                </svg>
                收藏
            </a>
        </div>

        <div class="col-md-3">
            <a class="btn btn-info text-white" href="#">资料下载</a>
            <a class="btn btn-info text-white ml-2" target="_blank">在线咨询</a>
        </div>
    </div>

        <%--    视频内容列表--%>
    <div class="row mt-2">
        <div class="col-md-9">
            <div class="card">
                <nav>
                    <div class="nav nav-tabs" id="nav-tab" role="tablist">
                        <a class="nav-item nav-link active" id="nav-home-tab" data-toggle="tab" href="#nav-home"
                           role="tab"
                           aria-controls="nav-home" aria-selected="true">课程介绍</a>
                        <a class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab" href="#nav-profile"
                           role="tab"
                           aria-controls="nav-profile" aria-selected="false">课程目录</a>
                    </div>
                </nav>
                <div class="tab-content" id="nav-tabContent">
                    <div class="tab-pane fade show active" id="nav-home" role="tabpanel"
                         aria-labelledby="nav-home-tab">
                        Vue3.0（正式版） + TS 仿知乎专栏企业级项目
                        慕课网首发，Vue3.0企业级项目实战。热门技术双剑合璧，Vue3.0 配合 TypeScript ，使用新版Vuex 和 Vue-Router
                        全家桶完成前后端分离复杂实战项目。一系列由易到难通用组件开发，让你学会一个基本的组件库的开发思路和技巧。接入真实后端API，告别 mock 数据，并提供Swagger
                        在线调试查询。抓住前后端分离开发痛点 - 权限管理，路由控制，全局Store 结构设计，前端缓存实现等。
                    </div>
                    <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
                        <a href="#" class="list-group-item list-group-item-action list-group-item-light border-0">
                            <iclass="fa fa-play-circle-o">&nbsp;&nbsp;第1讲<span class="ml-3">1.尚硅谷-IDEA-IntelliJ IDEA的介绍和优势</span>
                            <span class="ml-1 badge badge-pill badge-success  pt-1">免费</span>
                            </i>
                        </a>
                        <a href="#" class="list-group-item list-group-item-action list-group-item-light border-0">
                            <iclass="fa fa-play-circle-o">&nbsp;&nbsp;第1讲<span class="ml-3">1.尚硅谷-IDEA-IntelliJ IDEA的介绍和优势</span>
                            <span class="ml-1 badge badge-pill badge-success  pt-1">免费</span>
                            </i>
                        </a>
                        <a href="#" class="list-group-item list-group-item-action list-group-item-light border-0">
                            <iclass="fa fa-play-circle-o">&nbsp;&nbsp;第1讲<span class="ml-3">1.尚硅谷-IDEA-IntelliJ IDEA的介绍和优势</span>
                            <span class="ml-1 badge badge-pill badge-success  pt-1">免费</span>
                            </i>
                        </a>
                        <a href="#" class="list-group-item list-group-item-action list-group-item-light border-0">
                            <iclass="fa fa-play-circle-o">&nbsp;&nbsp;第1讲<span class="ml-3">1.尚硅谷-IDEA-IntelliJ IDEA的介绍和优势</span>
                            <span class="ml-1 badge badge-pill badge-success  pt-1">免费</span>
                            </i>
                        </a>
                        <a href="#" class="list-group-item list-group-item-action list-group-item-light border-0">
                            <iclass="fa fa-play-circle-o">&nbsp;&nbsp;第1讲<span class="ml-3">1.尚硅谷-IDEA-IntelliJ IDEA的介绍和优势</span>
                            <span class="ml-1 badge badge-pill badge-success  pt-1">免费</span>
                            </i>
                        </a>
                    </div>
                </div>
            </div>
        </div>

        <div class="col-md-3">
            <div class="card">
                <div class="card-header">
                    在线视频
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-md-4">
                            <img src="/static/imgs/hicon.jpg" class="rounded-circle"alt="Responsive image" style="height: 60px;width: 60px;">
                        </div>
                        <div class="col-md-8">XX老师<br>
                            <span class="text-secondary"style="font-size: 16px;">管理员</span>
                        </div>
                        <span class="text-secondary mt-2" style="font-size: 14px;">分布式微服务QQ交流群：123456789</span>
                        </blockquote>
                    </div>
                </div>
            </div>
        </div>
    </div>
<br>
<%--网站的尾部--%>
<jsp:include page="/WEB-INF/jsp/common/footer.jsp"></jsp:include>
</body>
</html>