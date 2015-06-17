<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>xiaoma</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <c:set var="ctx" value="${pageContext.request.contextPath}"/>
    <c:set var="flatpointPath" value="${pageContext.request.contextPath}/flatpoint"/>
    <link href="${flatpointPath}/css/bootstrap.css" rel="stylesheet">
    <link href="${flatpointPath}/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="${flatpointPath}/css/stylesheet.css" rel="stylesheet">
    <link href="${flatpointPath}/icon/font-awesome.css" rel="stylesheet">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="${flatpointPath}/js/html5shiv.js"></script>
    <![endif]-->
  </head>

  <body class="light_blue">

    <div class="login-container">
        <div class="login-header blue">
            <h4>TOEFL21</h4>
        </div>
        <form action="login" method="post">
            <div class="login-field">
                <label for="username">Username</label>
                <input type="text" name="userName" id="userName" placeholder="Username">
                <i class="icon-user"></i>
            </div>
            <div class="login-field">
                <label for="password">Password</label>
                <input type="password" name="password" id="password" placeholder="Password">
                <i class="icon-lock"></i>
            </div>
            <div class="login-button">
                <button type="submit" class="btn btn-large btn-block blue">Login <i class="icon-arrow-right"></i></button>
            </div>
            <div class="forgot-password">
                <a href="javascript:void(0);">Forgot password?</a>
            </div>
        </form>
    </div>



    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <%-- <script src="${flatpointPath}/js/jquery-1.10.2.js"></script> --%>
    <%-- <script src="${flatpointPath}/js/jquery-ui-1.10.3.js"></script>
    <script src="${flatpointPath}/js/bootstrap.js"></script>

    <script src="${flatpointPath}/js/library/jquery.collapsible.min.js"></script>
    <script src="${flatpointPath}/js/library/jquery.mCustomScrollbar.min.js"></script>
    <script src="${flatpointPath}/js/library/jquery.uniform.min.js"></script>
    <script src="${flatpointPath}/js/library/chosen.jquery.min.js"></script>
    <script src="${flatpointPath}/js/library/bootstrap-fileupload.js"></script>
    <script src="${flatpointPath}/js/library/jquery.validate.min.js"></script>
    
    <script src="${flatpointPath}/js/flatpoint_core.js"></script>
    <script src="${ctx}/js/validate.js"></script>
    <script src="${ctx}/js/fitz.js"></script> --%>
  </body>
</html>
