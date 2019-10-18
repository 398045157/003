<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>html登录模板</title>
<style>
/* 让页面所有元素的padding和margin都设置为0 */ 
*{margin:0;padding:0;box-sizing:border-box;}

body{background:url(bg.jpg);font-family: "微软雅黑", sans-serif;}

.headtop{background:url(topbg.jpg);height:28px;}

.login { 
    position: absolute;
    top: 50%;
    left: 50%;
    margin: -150px 0 0 -150px;
    width:300px;
    height:350px;
    background-color:#FFECEC ;
}
.login h1 { color:#555555; text-shadow: 0px 10px 8px #CDC673; letter-spacing:2px;text-align:center;margin-bottom:70px; }
input{
    padding:10px;
    width:100%;
    color:white;
    margin-bottom:10px;
    background-color:#555555;
    border: 1px solid black;
    border-radius:4px;
    letter-spacing:2px;
}
/* 登录按钮的css，cursor:pointer当鼠标移到按钮上面时变成小手形状 */
form button{
    width:100%;
    padding:10px;
    background-color:#CDC673;
    border:1px solid black;
    border-radius:4px;
    cursor:pointer; 
   
}  
#zc{
    width:300px;
    padding:10px;
    background-color:#CDC673;
    border:1px solid black;
    border-radius:4px;
    cursor:pointer; 
    text-align: center;
}    
a{
 text-decoration: none; 
}                                                                                                                                            

</style>
  <%
        Cookie[] cookies = request.getCookies();
        Cookie ck = null;
        if (cookies != null && cookies.length > 0) {
            for (Cookie c : cookies) {
                if (c.getName().equals("ck")) {
                    ck = c;
                }
            }
        }
    %>

</head>
<body>
<div class="headtop"></div>
<div class="login">
  <h1>短信管理系统</h1>
  <form action="UserLogin" method="post">
    <input type="text" name="account" placeholder="输入账号" required="required">
    <input type="password" name="password" placeholder="输入密码" required="required">
  <!--  <lable> 记住密码：</lable><input type="checkbox" value="yes" name="ck" > -->
  <button type="submit">登录</button>
  </form>
  <div id="zc">
 <a href="register.jsp">立即注册</a>
 </div> <br>

 <% if(request.getAttribute("msg") != null){ %>
						<%= request.getAttribute("msg") %>
					<% } %>
</div>
</body>
</html>