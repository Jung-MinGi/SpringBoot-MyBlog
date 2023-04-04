<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../layout/header.jsp"%>
<div class="container" style="margin-top: 30px">
	<form>
		<div class="form-group">
			<label for="title">title</label> <input type=text class="form-control" placeholder="Enter title" id="title">
		</div>
		<select id="mySelect">
			<option value="os">os</option>
			<option value="network">network</option>
			<option value="springJPA">springJPA</option>
			<option value="springSECURITY">springSECURITY</option>
			<option value="algorithm">algorithm</option>
		</select>
		<div class="form-group">
			<label for="content">content</label>
			<textarea class="form-control summernote" rows="5" id="content"></textarea>
		</div>
	</form>
	<button id="btn-write" class="btn btn-primary">글쓰기 완료</button>
</div>
<script>
	$('.summernote').summernote({
		tabsize : 2,
		height : 300
	});
</script>
<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>