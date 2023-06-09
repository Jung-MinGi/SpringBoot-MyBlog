<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">
	<button class="btn btn-secondary" onclick="history.back()">돌아가기</button>
	<c:if test="${board.user.id == principal.user.id}">
		<a href="/board/updateForm/${board.id}" class="btn btn-warning">수정</a>
		<button id="btn-delete" class="btn btn-danger">삭제</button>
	</c:if>
	<div>
		글 번호: <span id="id"><i>${board.id} </i><br></span> 글 작성자: <span><i>${board.user.username} </i></span>
	</div>
	<div class="form-group">
		<h3>${board.title }</h3>
	</div>
	<hr>
	<div class="form-group">
		<div>${board.content }</div>
	</div>
</div>
<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>