function initValidate(){
	jQuery.validator.addMethod("isMobile", function(value, element) {
	    var length = value.length;
	    var mobile = /^[1][358]\d{9}$/;
	    return this.optional(element) || (length == 11 && mobile.test(value));
	}, "请正确填写您的手机号码");
}

function validate(params) {
	var formId = params.formId;
	var rules = params.rules;
	var messages = params.messages;
	var submitHandler = params.submitHandler;
    $(formId).validate({
    	errorElement: 'label', //default input error message container
        errorClass: 'help-inline', // default input error message class
        focusInvalid: false, // do not focus the last invalid input
        rules: rules,
        messages: messages,
        highlight: function (element) { // hightlight error inputs
            $(element).closest('.control-group').addClass('error'); // set error class to the control group
        },
        success: function (label) {
            label.closest('.control-group').removeClass('error');
            label.remove();
        },
        submitHandler: submitHandler
    }); 
}

function validateUser(submitHandler){
	var params = {
		formId:'#user_form',
		rules:{
	        name: {
	            required: true
	        },
	        password: {
	            required: true
	        },
	        nickName: {
	            required: true
	        }
	       
	    },
	    messages: {
	        name: {
	            required: "用户名不能为空!"
	        },
	        password: {
	            required: "密码不能为空!"
	        },
	        nickName: {
	            required: "昵称不能为空!"
	        },
	        
	    },
	    submitHandler:submitHandler
	};
	
	
	validate(params);
}
