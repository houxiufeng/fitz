function _validate(params){
	params.form.validate({
		rules:params.rules,
		messages: params.messages
	});
	
	if (params.form.valid()) {
		params.cbk();
	}
}
var validates = {};
validates.user = function(cbk) {
	var params = {};
	params.rules = {
        name: {
            required: true
        }
    }
	params.messages={
        name: {
            required: "用户名不能为空!sfsfs"
        }
    }
	params.form = jQuery("#user");
	params.cbk = cbk;
	_validate(params);
}


	



