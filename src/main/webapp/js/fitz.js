jQuery(function($){
	//-------menu-----------
	$(document).on('click', "#m_user", function() {
		$.ajax({
			url: "user/",
			type: 'get',
			success: function(json) {
				$("#show_area").html(json);

			},
			error: function(xhr, textStatus, errorThrown){
				alert(errorThrown);
			}
		});
	});
	
	//-------event---------
	$('.chosen').chosen({width:"75px"});
	$(document).on('click', "#p_user li[class='prev']", function() {
		alert("1111");
	});
	$(document).on('click', "#p_user li[class='next']", function() {
		alert("2222");
	});
	$('#p_user li.item').click(function(event) {
	    var page = $(this).find("a").html();
	    $.ajax({
			url: "user/",
			type: 'get',
			data: {"currentPage":page},
			success: function(json) {
				$("#show_area").html(json);

			},
			error: function(xhr, textStatus, errorThrown){
				alert(errorThrown);
			}
		});
	});
})

