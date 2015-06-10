jQuery(function($){
	//----------event-------------------------
	var cbk;
	//#menu
	$(document).on('click', "#m_user", function() {
		$.ajax({
			url: "user/",
			type: 'get',
			success: function(json) {
				$("#show_area").html(json);
				cbk = 1;

			},
			error: function(xhr, textStatus, errorThrown){
				alert(errorThrown);
			}
		});
	});
	
	//#page
	
	
	//-------event---------
	$('.chosen').chosen().change(function(){
		var itemsPerPage = $(this).val();
		$.ajax({
			url: "user/",
			type: 'get',
			data: {"itemsPerPage":itemsPerPage},
			success: function(json) {
				$("#show_area").html(json);
				
			},
			error: function(xhr, textStatus, errorThrown){
				alert(errorThrown);
			}
		});
		
	});
	$(document).on('unload', ".chosen", function() {
		alert("cccccccccccccccccccccccccc");
	});
	
	$(document).on('click', "#next_user", function() {
		alert("2222");
	});
	$(document).on('click', "#last_user", function() {
		alert("3333");
	});
	$(document).on('click', "#first_user", function() {
		alert("4444");
	});
	$(document).on('click', "#pre_user", function() {
		alert("5555");
	});
	var loadData = function(url) {
		alert("aaa");
	}
	
	$(document).on('click',"#p_user li.item",function(){
		var itemsPerPage = $(".chosen").val();
		var currentPage = $(this).find("a").html();
		alert(cbk);
	    $.ajax({
			url: "user/",
			type: 'get',
			data: {"itemsPerPage":itemsPerPage, "currentPage":currentPage},
			success: function(json) {
				$("#show_area").html(json);

			},
			error: function(xhr, textStatus, errorThrown){
				alert(errorThrown);
			}
		});
	});
	
})

