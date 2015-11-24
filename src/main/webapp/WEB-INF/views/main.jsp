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
    <base href="${pageContext.request.contextPath}/"/>

    <!-- Le styles -->
    <link href="flatpoint/css/bootstrap.css" rel="stylesheet">
    <link href="flatpoint/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="flatpoint/css/stylesheet.css" rel="stylesheet">
    <link href="flatpoint/icon/font-awesome.css" rel="stylesheet">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="flatpoint/js/html5shiv.js"></script>
    <![endif]-->
  </head>

  <body>

    <header class="light_blue"> <!-- Header start -->
        <a href="#" class="logo_image"><span class="hidden-480">TOEFL21</span></a>
        <ul class="header_actions">
            <li class="dropdown"><a href="#"><img src="flatpoint/demo/avatar_06.png" alt="User image" class="avatar"> ${currentUser.name} <i class="icon-angle-down"></i></a>
                <ul>
                    <li><a href="#"><i class="icon-user"></i>个人中心</a></li>
                </ul>
            </li>
            <li><a id="logout" href="logout"><i class="icon-signout"></i> <span class="hidden-768 hidden-480">Logout</span></a></li>
        </ul>
    </header>

    <!-- menu -->
    <div id="main_navigation" class="light_blue"> <!-- Main navigation start -->
        <div class="inner_navigation">
            <ul class="main">
                <li><a href="javascript:void(0)"><i class="icon-home"></i> Dashboard</a>
                    <ul class="sub_main">
                        <li ><a id="m_user" href="javascript:void(0)"><i class="icon-user"></i> User</a></li>
                        <li ><a id="m_company" href="javascript:void(0)"><i class="icon-apple"></i> Company</a></li>
                        
                    </ul>
                </li>
                
                <li ><a href="javascript:void(0)"><i class="icon-calendar"></i> Calendar</a></li>
                <li ><a href="javascript:void(0)"><i class="icon-signal"></i> Charts</a></li>
                
                
            </ul>
        </div>
    </div> 
    <!-- end menu --> 

    <div id="content"> <!-- Content start -->
        <div id="show_area">
        </div>
    </div>

    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="flatpoint/js/jquery-1.10.2.js"></script>
    <script src="flatpoint/js/jquery-ui-1.10.3.js"></script>
    <script src="flatpoint/js/bootstrap.js"></script>

    <script src="flatpoint/js/library/jquery.collapsible.min.js"></script>
    <script src="flatpoint/js/library/jquery.mCustomScrollbar.min.js"></script>
    <script src="flatpoint/js/library/jquery.uniform.min.js"></script>
    <script src="flatpoint/js/library/chosen.jquery.min.js"></script>
    <!-- <script src="flatpoint/js/library/bootstrap-fileupload.js"></script> -->
    <script src="flatpoint/js/library/jquery.validate.min.js"></script>
    
    <script src="flatpoint/js/flatpoint_core.js"></script>
    <script src="js/validate.js"></script>
    <script src="js/fitz.js"></script>
  </body>
</html>
