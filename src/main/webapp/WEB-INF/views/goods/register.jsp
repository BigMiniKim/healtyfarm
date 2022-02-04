<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
    <script src="https://cdn.ckeditor.com/ckeditor5/32.0.0/classic/ckeditor.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

	<title>상품등록</title>
</head>

<body>

<div class="admin_content_main">
                    	<form:form action="${pageContext.request.contextPath}/productRegister" method="get" id="registerForm">
                    		<div class="form_section">
                    			<div class="form_section_title">
                    				<label>상품 번호</label>
                    			</div>
                    			<div class="form_section_content">
                    				<input name="product_id" value="0">
                    			</div>
                    		</div>
                    		<div class="form_section">
                    			<div class="form_section_title">
                    				<label>상품명</label>
                    			</div>
                    			<div class="form_section_content">
                    				<input name="product_name" >
                    			</div>
                    		</div>            
                    		<div class="form_section">
                    			<div class="form_section_title">
                    				<label>재고량</label>
                    			</div>
                    			<div class="form_section_content">
                    				<input name="stock" value="0">
                    			</div>
                    		</div>            
                    		<div class="form_section">
                    			<div class="form_section_title">
                    				<label>단가</label>
                    			</div>
                    			<div class="form_section_content">
                    				<input name="price" value="0">
                    			</div>
                    		</div>             
                    		<div class="form_section">
                    			<div class="form_section_title">
                    				<label>카테고리</label>
                    			</div>
                    			<div class="form_section_content">
                    				<input name="categoryCode">
                    			</div>
                    		</div>  
                    		
                    		<div class="form_section">
                    			<div class="form_section_title">
                    				<label>상품소개</label>
                    			</div>
                    			<div class="form_section_content">
                    				
                    				<textarea id="detail" name = "detail"></textarea>
                    			<script>
                    			ClassicEditor
                    			.create(document.querySelector('#detail'))
                    			.catch(error=>{
                    				console.error(error);
                    			});
</script>
                    			
                    			</div>
                    		</div>  
                    		
                   		</form:form>
                   			<div class="btn_section">
                   				<button id="cancelBtn" class="btn">취 소</button>
	                    		<button id="registerBtn" class="btn register_btn">등 록</button>
	                    	</div> 
                    </div>  
                    <script>

	let registerForm = $("#registerForm")
	
/* 취소 버튼 */
$("#cancelBtn").click(function(){
	
	location.href="/admin/goodsManage"
	
});

/* 상품 등록 버튼 */
$("#registerBtn").on("click",function(e){
	
	e.preventDefault();
	
	registerForm.submit();
	
});

</script> 	
</body>
</html>