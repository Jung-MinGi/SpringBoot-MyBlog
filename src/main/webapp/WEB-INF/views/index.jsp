<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="layout/header.jsp"%>
<div class="container" style="margin-top: 30px">
	<c:forEach var="board" items="${boards.content}">
		<div class="card m-3">
			<div class="card-body m-2">
				<div>
					<h2 class="card-title">${board.title}</h2>
					<h5>${board.createDate }</h5>
					<a href="/board/${board.id}" class="btn btn-primary">상세보기</a>
				</div>
			</div>
		</div>
	</c:forEach>
	<ul class="pagination justify-content-center">
		<c:choose>
			<c:when test="${boards.first}">
				<li class="page-item disabled"><a class="page-link" href="/${category}?page=${boards.number-1}">Previous</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link" href="/${category }?page=${boards.number-1}">Previous</a></li>
			</c:otherwise>
		</c:choose>
			<c:choose>
			<c:when test="${boards.last}">
				<li class="page-item disabled"><a class="page-link" href="/${category }?page=${boards.number+1}">Next</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item " ><a class="page-link" href="/${category }?page=${boards.number+1}">Next</a></li>
			</c:otherwise>
		</c:choose>
	</ul>
</div>
<%@ include file="layout/footer.jsp"%>