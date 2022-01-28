<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
   $(document).ready(function(){
       
      $("#updateForm").submit(function(event){
         
         event.preventDefault();
         
           var bname = $("#member_id").val();
           var btitle = $("#title").val();
           var bcontent = $("#content").val();
           
           var bid = $("#id").val();
           
           console.log(bcontent);           
           console.log($(this).attr("action"));
           
           var form = {
                 bid: bid,
                 member_id: member_id,
                   content: content,
                   title: title
           };       
//json 과 객체차이
          //{json
			//	 "bid": bid,
            //    "bname": bname,
           //     "bcontent": bcontent,
           //    "btitle": btitle
         // };     
           console.log(JSON.stringify(form));

           $.ajax({
             type : "PUT",
             url : $(this).attr("action"),
             cache : false,
             contentType:'application/json; charset=utf-8',
              data: JSON.stringify(form), 
             success: function (result) {       
               if(result == "SUCCESS"){
                  //list로               
                  $(location).attr('href', '${pageContext.request.contextPath}/rest/board/');                            
               }                       
             },
             error: function (e) {
                 console.log(e);
             }
         })          
   
       }); // end submit()
       
   }); // end ready()
</script>



</head>
<body>

   <table width="500" cellpadding="0" cellspacing="0" border="1">
      <form id="updateForm" action="${pageContext.request.contextPath}/rest/board/${content_view.id}" >
         <input type="hidden" id="id" name="id" value="${content_view.id}">
         <tr>
            <td> 번호 </td>
            <td> ${content_view.id} </td>
         </tr>
         <tr>
            <td> 히트 </td>
            <td> ${content_view.hit} </td>
         </tr>
         <tr>
            <td> 이름 </td>
            <td> <input type="text" id="member_id" name="member_id" value="${content_view.member_id}"></td>
         </tr>
         <tr>
            <td> 제목 </td>
            <td> <input type="text" id="title" name="title" value="${content_view.title}"></td>
         </tr>
         <tr>
            <td> 내용 </td>
            <td> <textarea rows="10" id="content" name="content" >${content_view.content}</textarea></td>
         </tr>
         <tr >
            <td colspan="2"> <input type="submit" value="수정"> &nbsp;&nbsp; <a href="/ex/rest/board/">목록보기</a> &nbsp;&nbsp; <a href="delete?id=${content_view.id}">삭제</a> &nbsp;&nbsp; <a href="reply_view?id=${content_view.id}">답변</a></td>
         </tr>
      </form>
   </table>
   
</body>
</html>