<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
		<title></title>
		<style>
.main{
	width: 50%;height: 400px; margin:0 auto;background-color: #ECF5FF; overflow: hidden;
}			
.main textarea{
	margin-top: 40px; height: 200px;width: 600px; margin-left: 40px;
}	
.bt{
	margin-top: 30px;
}	
a{
text-decoration: none;	
}

		</style>
	</head>
	<body>
		<div class="main">
		<form action="SendContent" method="post">
			<div class="bt"><hr/>
		发件人:<input type="text" name="fj" value="<%=session.getAttribute("currentUser") %>" >		
		发送给:<select name="select" class="xl">
		</select>
		
		标题:<input type="text" name="subject" required="required"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="QuitSend?content=<%=session.getAttribute("content")%>">返回</a> <hr />
		</div>
		<textarea required="required" name="content"><%=session.getAttribute("content") %></textarea><br />
		<input type="submit" value="发送" />
		</form>
		 <% if(request.getAttribute("msg") != null){ %>
						<%= request.getAttribute("msg") %>
					<% } %>
		</div>
	</body>
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" >
	 $(function () {
		$.ajax({
			url:"SendInfo",			
			type: "post",
			cache: false,
			dataType: "json",
			success: function(data){
				 console.log(data);
				$.each(data,function(index,info){
					var xl = "<option value='"+info.account+"'>"+info.username+"</option>";
			        $(".xl").append(xl);
				});
			}
			
			
		});
	});
	
	
	
	</script>
</html>