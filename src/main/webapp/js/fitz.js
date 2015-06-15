jQuery(function($){
	
	var goTo = function(url, itemsPerPage, currentPage){
		$.ajax({
			url: url + "/",
			type: 'get',
			data: {"itemsPerPage":itemsPerPage, "currentPage":currentPage},
			success: function(json) {
				$("#show_area").html(json);
				$('.chosen').chosen();
			},
			error: function(xhr, textStatus, errorThrown){
				alert(errorThrown);
			}
		});
	}
	
	var loadForm = function(url){
		$.ajax({
			url: url,
			type: 'get',
			success: function(json) {
				$("#show_area").html(json);
				$('.chosen').chosen();//if have
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
	
	//operation
	$(document).on('click',"a.add",function(){
		loadForm($('#_url').val() + "/add");
	});
	
	$(document).on('click',"a.edit",function(){
		loadForm($('#_url').val() + "/edit/" + $(this).attr("id"));
	});
	
	$(document).on('click',"a.cancel",function(){
		goTo($("form").attr("id"));
	});
	
	$(document).on('click',"a.delete",function(){
		if(confirm("Delte?")){
			$.ajax({
				url: $('#_url').val() + "/delete/" + $(this).attr("id"),
				type: 'post',
				success: function(json) {
					$("#show_area").html(json);
					$('.chosen').chosen();//if have
				},
				error: function(xhr, textStatus, errorThrown){
					alert(errorThrown);
				}
			});
		}
	});
	
	$(document).on('click',"a.create",function(){
		console.log(jQuery("form").serialize());
		return;
		validates[$("form").attr("id")](function(){
			$.ajax({
				url: jQuery("form").attr("id") + "/create",
				type: 'post',
				data:jQuery("form").serialize(),
				success: function(json) {
					jQuery("#show_area").html(json);
					jQuery('.chosen').chosen();//if have
				},
				error: function(xhr, textStatus, errorThrown){
					alert(errorThrown);
				}
			});
		});
	});
	$(document).on('click',"a.update",function(){
		validates[$("form").attr("id")](function(){
			$.ajax({
				url: $("form").attr("id") + "/update",
				type: 'post',
				data:$("form").serialize(),
				success: function(json) {
					$("#show_area").html(json);
					$('.chosen').chosen();//if have
				},
				error: function(xhr, textStatus, errorThrown){
					alert(errorThrown);
				}
			});
		});
	});
	
})

