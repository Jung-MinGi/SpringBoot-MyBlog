let index={
	init:function(){
		$("#btn-save").on("click",()=>{
			this.save();
		});
		$("#btn-update").on("click",()=>{
			this.update();
		});
	},
	save:function(){
		let data={
			username:$("#username").val(),
			password:$("#password").val(),
			email:$("#email").val()
		}
		console.log(data);
		$.ajax({
			type:"post",
			url:"/auth/joinProc",
			data: JSON.stringify(data),//현재 위 data는 자바스크립트오브젝트임 이걸 그대로 ㄷ보내면 이해를 못함 그래서 json문자열으로 변형시켜서 보냄
			contentType:"application/json; charset=utf-8",
			dataType:"json"//요청에대한 응답데이터의 타입은 기본적으로 모두 문자열임 근데 datatype을 json으로 설정해놓으면 자바스크립트 오브젝트로 변환해줌
		}).done(function(resp){
			alert("회원가입 완료"+JSON.stringify(resp));
			location.href="/os";
		}).fail(function(err){
			alert("회원가입 실패"+JSON.stringify(err));
		});
	},
	update:function(){
		if($("#password").val() == ''){
			alert("비밀번호를 입력하세요");
			return;
		}
		let data={
			id:$("#id").val(),
			password:$("#password").val(),
			email:$("#email").val()
		}
		console.log(data);
		$.ajax({
			type:"put",
			url:"/api/user",
			data: JSON.stringify(data),//현재 위 data는 자바스크립트오브젝트임 이걸 그대로 ㄷ보내면 이해를 못함 그래서 json문자열으로 변형시켜서 보냄
			contentType:"application/json; charset=utf-8",
			dataType:"json"//요청에대한 응답데이터의 타입은 기본적으로 모두 문자열임 근데 datatype을 json으로 설정해놓으면 자바스크립트 오브젝트로 변환해줌
		}).done(function(resp){
			console.log(JSON.stringify(resp));
			alert("수정 완료");
			location.href="/os";
		}).fail(function(err){
			alert("수정 실패"+JSON.stringify(err));
		});
	}
}
index.init();