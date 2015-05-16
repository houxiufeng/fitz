<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src='<c:url value="/js/1.11.1.js"/>'></script>

<script>
    $(function(){
    	//alert("hello xxxxx");
    	//do something init
    	//test git commit 5
    })
    var test = function(){
    	/* var obj = {};
    	var date = new Date();
    	obj.productionName = "TOFEL";
    	obj.moduleName = "TOFEL_ORAL";
    	obj.type = "1";
    	obj.questionId = 1;
    	obj.question ="abc";
    	obj.answerId = 1;
    	obj.answer = "xxx";
    	obj.studentId = 1;
    	obj.studentNickName = "yyy";
    	obj.studentAvatar = "urllllll";
    	obj.ticket = "9a8acf19-b659-4bd5-bea0-38ba53b34ddb";
    	obj.submitTime = date; */
    	var obj = {};
    	obj.name = "allen";
    	$.ajax({
            // url: "/test3",http://localhost:8080/xmpg/exercise/postResult?token=13600000000
            url: "<c:url value="/test3" />",
            type:'post',
            data:JSON.stringify(obj),
            contentType: "application/json",
            //data:JSON.stringify({exerciseId:1, score:20, type:2, audioUrl:'xxx', marktips:[{startIndex:1, endIndex:3, audioUrl:'aaa', textContent:'bbb'},{startIndex:5, endIndex:8, audioUrl:'ccc', textContent:'ddd'}]}),
            /* data:{"exerciseId":7, "score":20, "type":2,"marktips":[{"startIndex":1,"endIndex":10,"textContent":"fuckfuck"}]}, */
            //contentType: "application/json",
            dataType: "json",
             headers: {
               // "Authorization": tokenTmp,
                "token":"xxxxxx"
            }, 
            success: function(json){
               console.log(json);
               /* $.each(json.tickets,function(key, value){
                   console.log(value.identifier);
               }); */
            },
            error: function(msg){
            	alert("error");
            	console.log(msg);
            }
        });
    }
    $(document).on('click', '#test', test);
    
    
</script>
</head>
<body>
    <form action="<c:url value="/create.html" />" method="post">
	    用户名：<input type="text" name="name"/><br/>
	    密码：<input type="password" name="password"/><br/>
	    <input type="submit" value="提交"/>
    </form>
    <a href="#" id="test">test</a>
</body>
</html>