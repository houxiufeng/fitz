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
	
	$(document).on('click', ".next", function() {
		if(!$(".next.disabled").html()){
			var itemsPerPage = $(".chosen").val();
			var currentPage = $(".pagination li.item.active").next().find("a").html();
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
		}
	});
	$(document).on('click', ".last", function() {
		if(!$(".last.disabled").html()){
			var itemsPerPage = $(".chosen").val();
			var currentPage = $(".pagination li.item").length;
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
		}
	});
	$(document).on('click', ".first", function() {
		if(!$(".first.disabled").html()){
			var itemsPerPage = $(".chosen").val();
			var currentPage = 1;
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
		}
	});
	$(document).on('click', ".prev", function() {
		if(!$(".prev.disabled").html()){
			var itemsPerPage = $(".chosen").val();
			var currentPage = $(".pagination li.item.active").prev().find("a").html();
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
		}
	});
	var loadData = function(url) {
		alert("aaa");
	}
	
	$(document).on('click',".pagination li.item",function(){
		var itemsPerPage = $(".chosen").val();
		var currentPage = $(this).find("a").html();
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

