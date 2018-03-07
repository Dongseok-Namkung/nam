function gfn_transaction(params){
//	var parameter = {};
//	
//	$.each(params, function(idx, param){
//		alert(param);
//	});
	
	$.ajax({
		type: "POST",
		url: "service.ax",
		dataType: "json",
		data:"beanName="+params.beanName
			+"&methodName="+params.methodName
			+"&parameterTypeName="+params.parameterTypeName
			+"&"+params.parameters,
		//contentType: 'Content-type: text/plain; charset=iso-8859-1',
		//data: JSON.stringify( params ),
		success: function(result){
			var data = gfn_isEmpty(result) ? result : JSON.parse(JSON.stringify(result));
			
			fn_callback(params.svcId, data );
		},
		error:  function(e){
			alert(e);
		}
	});
}

function gfn_isEmpty(str){
	return str == null || str == undefined || str == "null" || str == "undefined" || str.length == 0 ? true : false;
}