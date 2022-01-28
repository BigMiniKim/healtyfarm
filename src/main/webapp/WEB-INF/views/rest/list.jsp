<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<table width="500" border="1">
			<tr>
				<td>번호:</td>
				<td>이름:</td>
				<td>제목:</td>
				<td>날짜:</td>
				<td>히트:</td>
			
			</tr>
			
			
			<!-- 여기 또 핵심 3 -->
			<c:forEach var="board" items="${boardList}">
			<tr>
			
				<td>${board.id}</td>
				<td>${board.name}</td>
				<td>
					<c:forEach begin="1" end="${board.indent}"> [Re] </c:forEach>
 						<a href="content_view?id=${board.id}">${board.title}</a>
				</td>
				
				
				<td>${board.date}</td>
				<td>${board.hit}</td>
				
			</tr>	
			</c:forEach>
			
			<tr>
				<td colspan="5"> 
					<a href="write_view">글작성</a>
				</td>
			</tr>
		
		</table>

</body>
</html>
