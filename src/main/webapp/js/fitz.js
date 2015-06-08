jQuery(function($){
	$(document).on('click', "#m_user", function() {
		$.ajax({
			url: "user/",
			type: 'get',
			success: function(json) {
//				$('#content').html(json);
//				TableTeacher.init();
				$("#show_area").html(json);

			}
		});
	});
})

