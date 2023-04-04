let index = {
	init: function() {
		$("#btn-write").on("click", () => {
			this.write();
		});
		$("#btn-delete").on("click", () => {
			this.del();
		});
		$("#btn-update").on("click", () => {
			this.update();
		});
	},
	write: function() {
		let data = {
			title: $("#title").val(),
			content: $("#content").val(),
			category:$("#mySelect").val()
		}
		console.log(data);
		$.ajax({
			type: "post",
			url: "/api/board",
			data: JSON.stringify(data),//현재 위 data는 자바스크립트오브젝트임 이걸 그대로 ㄷ보내면 이해를 못함 그래서 json문자열으로 변형시켜서 보냄
			contentType: "application/json; charset=utf-8",
			dataType: "json"//요청에대한 응답데이터의 타입은 기본적으로 모두 문자열임 근데 datatype을 json으로 설정해놓으면 자바스크립트 오브젝트로 변환해줌
		}).done(function(resp) {
			alert("글작성 완료" + JSON.stringify(resp));
			location.href = "/os";
		}).fail(function(err) {
			alert("글작성 실패" + JSON.stringify(err));
		});
	},
	del: function() {
		let id = $("#id").text();
		$.ajax({
			type: "delete",
			url: "/api/board" + id
		}).done(function(resp) {
			alert("삭제 완료" + JSON.stringify(resp));
			location.href = "/os";
		}).fail(function(err) {
			alert("삭제 실패" + JSON.stringify(err));
		});
	},
	update: function() {
		let data = {
			id: $("#id").val(),
			title: $("#title").val(),
			content: $("#content").val()
		}
		$.ajax({
			type: "put",
			url: "/api/board",
			data: JSON.stringify(data),//현재 위 data는 자바스크립트오브젝트임 이걸 그대로 ㄷ보내면 이해를 못함 그래서 json문자열으로 변형시켜서 보냄
			contentType: "application/json; charset=utf-8",
			dataType: "json"//요청에대한 응답데이터의 타입은 기본적으로 모두 문자열임 근데 datatype을 json으로 설정해놓으면 자바스크립트 오브젝트로 변환해줌
		}).done(function(resp) {
			alert("수정 완료" + JSON.stringify(resp));
			location.href = "/os";
		}).fail(function(err) {
			alert("수정 실패" + JSON.stringify(err));
		});
	}
}
index.init();