<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <table id="list-table" width="500" cellpadding="0" cellspacing="0" border="1">
      <form:form action="reply" method="post">
         <input type="hidden" name="id" value="${reply_view.id}">
         <input type="hidden" name="bgroup" value="${reply_view.bgroup}">
         <input type="hidden" name="step" value="${reply_view.step}">
         <input type="hidden" name="indent" value="${reply_view.indent}">
         <tr>
            <td> 번호 </td>
            <td> ${reply_view.id} </td>
         </tr>
         <tr>
            <td> 히트 </td>
            <td> ${reply_view.hit} </td>
         </tr>
         <tr>
            <td> 이름 </td>
            <td> <input type="text" name="member_id" value="${reply_view.member_id}"></td>
         </tr>
         <tr>
            <td> 제목 </td>
            <td> <input type="text" name="title" value="${reply_view.title}"></td>
         </tr>
         <tr>
            <td> 내용 </td>
            <td> <textarea rows="10" name="content" >${reply_view.content}</textarea></td>
         </tr>
         <tr >
            <td colspan="2"> <input type="submit" value="답변"> &nbsp;&nbsp; <a href="list">목록</a></td>
         </tr>
      </form:form>
   </table>   
      

</body>
</html>
