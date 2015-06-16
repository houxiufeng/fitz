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
        },
        age: {
        	required: true,
        	digits: true
        },
        email: {
        	email: true
        }
    }
	params.messages={
        name: {
            required: "用户名不能为空！"
        },
        age: {
        	required: "年龄不能为空！",
        	digits: "必须为正整数！"
        },
        email: {
        	email: "格式不正确！"
        }
	}
	params.form = jQuery("#user");
	params.cbk = cbk;
	_validate(params);
}

validates.company = function(cbk) {
	var params = {};
	params.rules = {
			name: {
				required: true
			},
			address: {
				required: true
			},
			email: {
				email: true
			}
	}
	params.messages={
			name: {
				required: "城市名称不能为空！"
			},
			address: {
				required: "地址不能为空！"
			},
			email: {
				email: "格式不正确！"
			}
	}
	params.form = jQuery("#company");
	params.cbk = cbk;
	_validate(params);
}


	



