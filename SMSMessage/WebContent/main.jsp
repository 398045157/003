<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
		<title></title>
		 <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="layui/css/layui.css"  media="all">
		<style>
.main{
	width: 50%;height: 400px; margin:0 auto;background-color: #ECF5FF; overflow: hidden;
}
h1 { color:#555555; text-shadow: 0px 10px 8px #CDC673; letter-spacing:2px; margin-left: 70px;margin-top: 20px;margin-bottom: 30px;}
a{
text-decoration: none;	
}	
#bg{
 margin-top:40px;
}	
td {text-align:center;width: 150px;}
tfoot{
width:300px;
}
		</style>
	</head>
	<body>
		<div class="main">
		<h1>我的短消息</h1>
		 
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>当前用户：</span><%=session.getAttribute("username") %>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		   <a href="http://localhost:8080/SMSMessage/send.jsp">发送消息</a> 
		   <a href="QuitMain?username=<%=session.getAttribute("username")%>">退出</a> 
		
  <div id="bg">
	<table>
		<thead>
			<tr><th>标题</th><th>发送时间</th><th>状态</th><th>删除消息</th><th>回复消息</th></tr>
		</thead>
		<tbody>
		
		</tbody>	
		<tfoot>
			<tr><td colspan="5">
			<!-- 首页     
			上一页   
			当前页  
			<span id="nextPage" onclick="goPage(2)">下一页</span>  
			最后一页  
			<input type="text" value="">跳转
			总共数据行数 -->
			</td></tr>
		</tfoot>
	</table>
  </div>
    <% if(request.getAttribute("msg") != null){ %>
						<%= request.getAttribute("msg") %>
					<% } %>
  </div>

	</body>
	<script src="js/jquery.min.js" charset="utf-8"></script>
	<script type="text/javascript">

	$(function(){

		goPage(1);
	});
	
	function toPage(){
		//获取input值
		var currentPage = $("#toPage").val();
		if(currentPage <= 0){
			currentPage = 1;
		}
		//调用goPage（指定页）
		goPage(currentPage);
	}
	
	function goPage(currentPage){
		console.log(currentPage);
		$.post("MainInfo",
				{"currentPage":currentPage,"pageSize":5},
				function(data){
					console.log(data);
                    
					var page = "<span id='firstPage' onclick='goPage(1)'>首页</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
						"<span id='prevPage' onclick='goPage("+data.prevPage+")'>上一页</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
						"当前页"+data.currentPage+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
						"<span id='nextPage' onclick='goPage("+data.nextPage+")'>下一页</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+  
						"<span id='lastPage' onclick='goPage("+data.lastPage+")'>最后一页</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ 
						"<input type='text' id='toPage'><span onclick='toPage()'>跳转</span>";
					$("table tfoot td").html('');	
					$("table tfoot td").append(page);
					$("table tbody").html('');
					$.each(data.dataList,function(index,obj){
						var t = "";
						if(obj.status==1){
							t="未读";
						}else{
							t="已读";
						}
						var tr = "<tr><td><a href='LookTitle?content="+obj.content+"'>"+obj.subject+"</a></td>"
						+"<td>"+obj.createtime+"</td>"
						+"<td>"+t+"</td>"
						+"<td><a href='MessageDelete?id="+obj.id+"'>删除</a></td>"
						+"<td><a href='send.jsp'>回复</a></td></tr>"
						$("table tbody").append(tr);
					});
				},"json");
	}
	
	
	
	</script>
</html>
</html>