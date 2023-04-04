<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal" />
</sec:authorize>
<!DOCTYPE html>
<html lang="en">
<head>
<title>WRITE ONCE, REMEMBER FOREVER</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
<style>
.fakeimg {
	height: 200px;
	background: #aaa;
}
</style>
</head>
<body>
	<%-- <c:if test="empty principal"></c:if> --%>
	<div class="jumbotron text-center" style="margin-bottom: 0">
		<a href="/os"><h1>mk'notepad</h1></a>
		<li class="nav-item"><a class="" href="https://github.com/MingGi-Jung" target="_blank" role="button" aria-label="st-github 링크"> <img class="favicon" style=""
				src="https://cdn.jsdelivr.net/gh/kaniwari/fcresources@1.0/favicon/github.png" alt="링크의 아이콘" width="16" height="16" aria-hidden="true">mingi-jung github
		</a></li>
	</div>

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="/os">운영체제</a></li>
				<li class="nav-item"><a class="nav-link" href="/network">네트워크</a></li>
				<li class="nav-item"><a class="nav-link" href="/springJPA">스프링jpa</a></li>
				<li class="nav-item"><a class="nav-link" href="/springSECURITY">스프링security</a></li>
				<li class="nav-item"><a class="nav-link" href="/algorithm">알고리즘 문제</a></li>
			</ul>
		</div>
		<c:choose>
			<c:when test="${empty principal}">
				<a href="/auth/loginForm">로그인</a>
				<a href="/auth/joinForm">회원가입</a>
			</c:when>
			<c:otherwise>
				<a class="nav-link" href="/board/writeForm">글쓰기</a>
				<a class="nav-link" href="/user/updateForm">회원정보</a>
				<a href="/logout">로그아웃</a>
			</c:otherwise>
		</c:choose>
	</nav>