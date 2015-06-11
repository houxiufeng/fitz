jQuery(function($){
	var goTo = function(url, itemsPerPage, currentPage){
		$.ajax({
			url: url + "/",
			type: 'get',
			data: {"itemsPerPage":itemsPerPage, "currentPage":currentPage},
			success: function(json) {
				$("#show_area").html(json);
				$('.chosen').chosen({background:"green"});
				$('#_url').val(url);
			},
			error: function(xhr, textStatus, errorThrown){
				alert(errorThrown);
			}
		});
	}
	//----------event-------------------------
	//#menu
	$(document).on('click', "#m_user", function(){
		goTo("user");
	});
	
	//#paginate
	$(document).on('change','.chosen',function(){
		goTo($('#_url').val(),$(this).val());
	});
	
	$(document).on('click', ".next", function() {
		if(!$(".next.disabled").html()){
			var itemsPerPage = $(".chosen").val();
			var currentPage = $(".pagination li.item.active").next().find("a").html();
		    goTo($('#_url').val(),itemsPerPage,currentPage);
		}
	});
	$(document).on('click', ".last", function() {
		if(!$(".last.disabled").html()){
			var itemsPerPage = $(".chosen").val();
			var currentPage = $("#_lastPage").val();
			goTo($('#_url').val(),itemsPerPage,currentPage);
		}
	});
	$(document).on('click', ".first", function() {
		if(!$(".first.disabled").html()){
			var itemsPerPage = $(".chosen").val();
			var currentPage = 1;
			goTo($('#_url').val(),itemsPerPage,currentPage);
		}
	});
	$(document).on('click', ".prev", function() {
		if(!$(".prev.disabled").html()){
			var itemsPerPage = $(".chosen").val();
			var currentPage = $(".pagination li.item.active").prev().find("a").html();
			goTo($('#_url').val(),itemsPerPage,currentPage);
		}
	});
	
	$(document).on('click',".pagination li.item",function(){
		var itemsPerPage = $(".chosen").val();
		var currentPage = $(this).find("a").html();
		goTo($('#_url').val(),itemsPerPage,currentPage);
	});
	
})

