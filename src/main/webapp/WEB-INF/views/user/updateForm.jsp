<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../layout/header.jsp" %>
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal" />
</sec:authorize>
<div class="container">
	<form>
	<input type="hidden" id="id" value="${principal.user.id }">
		<div class="form-group">
			<label for="username">username</label> 
			<input value="${principal.user.username}" type=text class="form-control" placeholder="Enter userName" id="username" readonly>
		</div>
		<div class="form-group">
			<label for="password">password</label> 
			<input type="password" class="form-control" placeholder="Enter passWord" id="password">
		</div>
		<div class="form-group">
			<label for="email">Email</label>
			 <input value="${principal.user.email}" type="email" class="form-control" placeholder="Enter email" id="email">
		</div>
	</form>
	<button id="btn-update" class="btn btn-primary">정보수정완료</button>
</div>
<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp" %>