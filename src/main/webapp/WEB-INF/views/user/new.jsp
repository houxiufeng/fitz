<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row-fluid">
    <div class="span12">
        <div class="well light_blue">
            <div class="well-header">
                <h5>User Form</h5>
            </div>

            <div class="well-content no-search">
            <form id="user">
                <div class="form_row">
                    <label class="field_name align_right">Name</label>
                    <div class="field">
                        <input name="name" class="span4" type="text">
                    </div>
                </div>
                
                <div class="form_row">
                    <label class="field_name align_right">Password</label>
                    <div class="field">
                        <input name="password" class="span4" type="password">
                    </div>
                </div>
                
                <div class="form_row">
                    <label class="field_name align_right">Age</label>
                    <div class="field">
                        <input name="age" class="span2" type="text">
                    </div>
                </div>
                
                <div class="form_row">
                    <label class="field_name align_right">Email</label>
                    <div class="field">
                        <input name="email" class="span4" type="text">
                    </div>
                </div>
                
                <!--  <div class="form_row">
                    <label class="field_name align_right">Avatar</label>
                    <div class="field">
                        <div class="fileupload fileupload-new" data-provides="fileupload">
                          <div class="fileupload-new thumbnail" style="width: 200px; height: 150px;"><img src="http://www.placehold.it/200x150/EFEFEF/AAAAAA&amp;text=no+image" /></div>
                          <div class="fileupload-preview fileupload-exists thumbnail" style="max-width: 200px; max-height: 150px; line-height: 20px;"></div>
                          <div>
                            <span class="btn btn-file"><span class="fileupload-new">Select image</span><span class="fileupload-exists">Change</span><input name="avatar" type="file" /></span>
                            <a href="#" class="btn fileupload-exists" data-dismiss="fileupload">Remove</a>
                          </div>
                        </div>
                    </div>
                </div> -->
                
                <div class="form_row">
                    <div class="field">
                        <a href="javascript:void(0);" class="btn light_blue submit create">Submit</a>
                        <!-- <input class="btn light_blue submit create" type="submit" value="Submit"> -->
                        <a href="javascript:void(0)" class="btn red cancel">Cancel</a>
                    </div>
                </div>
                </form>
            </div>
        </div>
    </div>
</div>
<c:set var="flatpointPath" value="${pageContext.request.contextPath}/flatpoint"/>
<script src="${flatpointPath}/js/library/jquery.validate.min.js"></script>
<script>
/* jQuery("#user").validate();
jQuery("a.create").click(function(){
	if(jQuery("#user").valid()){
		alert("xxx");
	}
}); */
</script>