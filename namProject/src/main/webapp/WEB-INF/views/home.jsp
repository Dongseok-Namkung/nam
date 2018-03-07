<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<style>
	body{
		font: 62.5% "Trebuchet MS", sans-serif;
		margin: 50px;
	}
	.demoHeaders {
		margin-top: 2em;
	}
	#dialog-link {
		padding: .4em 1em .4em 20px;
		text-decoration: none;
		position: relative;
	}
	#dialog-link span.ui-icon {
		margin: 0 5px 0 0;
		position: absolute;
		left: .2em;
		top: 50%;
		margin-top: -8px;
	}
	#icons {
		margin: 0;
		padding: 0;
	}
	#icons li {
		margin: 2px;
		position: relative;
		padding: 4px 0;
		cursor: pointer;
		float: left;
		list-style: none;
	}
	#icons span.ui-icon {
		float: left;
		margin: 0 4px;
	}
	.fakewindowcontain .ui-widget-overlay {
		position: absolute;
	}
	select {
		width: 200px;
	}
	</style>
<%@include file="/WEB-INF/header.jsp" %>

<title>Insert title here</title>

<script type="text/javascript">
	$(function() {
		
		//초기화
		fn_init();
	});
	
	/**********************************************************
	초기화
	**********************************************************/
	function fn_init(){
		fn_componentInit();
		fn_setEventHandler();
		
		//fn_transactionTest();
	}
	
	/**********************************************************
	1. 각종 컴포넌트 상태 포넌트 초기화
	**********************************************************/
	function fn_componentInit(){
		$( "#button" ).button();
		$( "#button" ).click(function(){
			alert("button");
		});
		
		$( "#selectmenu" ).selectmenu();
		$("#selectmenu").on( "selectmenuchange", function(){
			alert();
	        alert( $("#selectmenu option:selected").val() );
	    });
		
		
	}
	
	/**********************************************************
	1. 이벤트핸들러 등록
	**********************************************************/
	function fn_setEventHandler(){
		
		

	}
	
	/**********************************************************
	Transaction 함수
	**********************************************************/
	function fn_transactionTest(){
		var param = {
				svcId : "asdf",
				beanName : "com.nkds.myapp.service.ServiceTest",
				parameterTypeName : "com.nkds.myapp.service.ServiceTestVO",
				methodName : "processService",
				parameters : "id=nam6068&pw=1234"
			};

		gfn_transaction(param);
	}
	
	/**********************************************************
	Callback 함수
	**********************************************************/
	function fn_callback(svcId, result){
		switch(svcId){
		case "asdf":
			//var list = result.list;
			//alert(list);
			alert(result.list.length);
			alert(result.list[0].name);
		break;
		}
	}
</script>

</head>

<body>

<section>

<h1>Jaeran Lee.</h1>

<article>
<p>We are just married.</p>
<img src="http://192.168.1.2:8090/img.jpg">
</article>



</section>

</body>

</html>