<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
	<form>
		<div class="form-group">
			<label for="username">username</label> <input type=text class="form-control" placeholder="Enter userName" id="username">
		</div>
		<div class="form-group">
			<label for="password">password</label> <input type="password" class="form-control" placeholder="Enter passWord" id="password">
		</div>
		<div class="form-group">
			<label for="email">Email</label> <input type="email" class="form-control" placeholder="Enter email" id="email">
		</div>
	</form>
	<button id="btn-save" class="btn btn-primary">회원가입완료</button>
</div>
<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp" %>