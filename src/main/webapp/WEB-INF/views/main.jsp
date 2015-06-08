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

  <body>

    <header class="blue"> <!-- Header start -->
        <a href="#" class="logo_image"><span class="hidden-480">托福21天</span></a>
        <ul class="header_actions">
            <li class="dropdown"><a href="#"><img src="${flatpointPath}/demo/avatar_06.png" alt="User image" class="avatar"> fitz <i class="icon-angle-down"></i></a>
                <ul>
                    <li><a href="#"><i class="icon-user"></i>个人中心</a></li>
                </ul>
            </li>
            <li><a href="#"><i class="icon-signout"></i> <span class="hidden-768 hidden-480">Logout</span></a></li>
            <li class="responsive_menu"><a class="iconic" href="#"><i class="icon-reorder"></i></a></li>
        </ul>
    </header>

    <div id="main_navigation" class="blue"> <!-- Main navigation start -->
        <div class="inner_navigation">
            <ul class="main">
                <li class="active"><a href="dashboard.html"><i class="icon-home"></i> Dashboard</a>
                    <ul class="sub_main">
                        <li><a id="m_user" href="javascript:void(0)">User</a></li>
                        <li><a href="dashboard_2.html">Dashboard multimedia</a></li>
                        <li><a href="dashboard_3.html">Dashboard no sidebar</a></li>
                    </ul>
                </li>
                <li class="active"><a href="dashboard.html"><i class="icon-home"></i> Dashboard</a></li>
            </ul>
        </div>
    </div>  

    <div id="content" class="no-sidebar"> <!-- Content start -->
        <div class="top_bar">
            <ul class="breadcrumb">
              <li><a href="dashboard.html"><i class="icon-home"></i></a> <span class="divider">/</span></li>
              <li class="active"><a href="#">Dashboard</a></li>
            </ul>
        </div>

        <div id="show_area" class="widgets_area">
            welcome to tpo management system
        </div>
    </div>

    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${flatpointPath}/js/jquery-1.10.2.js"></script>
    <script src="${flatpointPath}/js/jquery-ui-1.10.3.js"></script>
    <script src="${flatpointPath}/js/bootstrap.js"></script>

    <script src="${flatpointPath}/js/library/jquery.collapsible.min.js"></script>
    <script src="${flatpointPath}/js/library/jquery.mCustomScrollbar.min.js"></script>
    <script src="${flatpointPath}/js/library/jquery.uniform.min.js"></script>

    <script src="${flatpointPath}/js/library/jquery.sparkline.min.js"></script>
    <script src="${flatpointPath}/js/library/chosen.jquery.min.js"></script>
    
    <script src="${flatpointPath}/js/library/jquery.easytabs.js"></script>
    <script src="${flatpointPath}/js/library/jquery.autosize-min.js"></script>
    <script src="${flatpointPath}/js/library/jquery.minicolors.js"></script>
    <script src="${flatpointPath}/js/library/jquery.tagsinput.js"></script>
    <script src="${flatpointPath}/js/library/footable/footable.js"></script>
    <script src="${flatpointPath}/js/library/footable/data-generator.js"></script>
    <script src="${flatpointPath}/js/library/bootstrap-fileupload.js"></script>
    <script src="${flatpointPath}/js/library/jquery.inputmask.bundle.js"></script>

    <script src="${flatpointPath}/js/library/jquery.dataTables.js"></script>
    <script src="${flatpointPath}/js/flatpoint_core.js"></script>
    <script src="${ctx}/js/fitz.js"></script>
    <script src="${flatpointPath}/js/datatables.js"></script>
    
    <!-- <script type="text/javascript">
        jQuery(function($){
        	   //some code here
            }
        )
    </script> -->
    
  </body>
</html>
