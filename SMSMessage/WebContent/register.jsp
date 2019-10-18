<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>注册</title>
<style>
/* 让页面所有元素的padding和margin都设置为0 */ 
*{margin:0;padding:0;box-sizing:border-box;}
/* 设置背景图，字体设置为微软雅黑 */ 
body{background:url(bg.jpg);font-family: "微软雅黑", sans-serif;}
/* 引用图片高度设置为28px，就是页面最上方像屋檐一样的黑色图 */ 
.headtop{background:url(topbg.jpg);height:28px;}
/* 整个登录框的css，并使用绝对定位居中 */ 
.login { 
    position: absolute;
    top: 50%;
    left: 50%;
    margin: -150px 0 0 -150px;
    width:300px;
    height:400px;
    background-color:#FFECEC ;
}
/* 前面分析过的h1标签的css，text-shadow设置阴影使文字更好看，letter-spacing设置字符间距 */ 
.login h1 { color:#555555; text-shadow: 0px 10px 8px #CDC673; letter-spacing:2px;text-align:center;margin-bottom:30px; }
/* 两个输入框的css，border属性设置边框线粗细以及颜色，border-radius设置边框的圆角角度 */
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
    width:50%;
    padding:10px;
    background-color:#CDC673;
    border:1px solid black;
    border-radius:4px;
    cursor:pointer; 
   
}   
 #tj{
     width:50%;
    padding:10px;
    background-color:#CDC673;
    border:1px solid black;
    border-radius:4px;
    cursor:pointer; color: black;
 } 
#cz{
	width: 50%; background-color:#CDC673 ;  border:1px solid black; color: black;
}  
a{
	text-decoration: none;text-align: center;
}                                                                                                                                           
</style>
</head>
<body>
<div class="headtop"></div>
<div class="login">
  <h1>注册信息</h1>
  <form action="UserRegister" method="post">
    用户名:<input type="text" name="username" placeholder="用户名" required="required">
    用户账号:<input type="text" name="account" placeholder="用户账号" required="required">
    密码:<input type="password" name="password" placeholder="密  码" required="required">
    确认密码:<input type="password" name="password2" placeholder="确认密码" required="required">
    邮箱:<input type="email" name="email" placeholder="email" required="required">
  <input type="submit" value="提交" id="tj"><input type="reset" value="重置"  id="cz"/>
  </form>
 <% if(request.getAttribute("msg") != null){ %>
						<%= request.getAttribute("msg") %>
					<% } %>
  <a href="http://localhost:8080/SMSMessage/login.jsp">返回登陆</a>
</div>
</body>
</html>