$('.add-course').live('click', function() {
	var	courseId = $(this).parent().parent().find('.department a').attr('data-id');
	$(this).parent().parent().find('ul').append('<li><form class="department-input" name="course-name" action="/admin/addSecondType" method="post"><input type="hidden" name="fid" value="' + courseId + '" /><input type="text" class="div-control input-small input-coursename" name="name" /><button class="btn btn-lg btn-success btn-block btn-small" type="submit">保存</button></form></li>')
});

$('#add-department').click(function() {
	$('.contanier').append('<div class="backstage"><div class="department"><a href="javascript:void(0)">请输入分类名</a><div class="department-input" style="display:block"><form name="department-name" action="/admin/addFirstType" method="post"><input class="div-control input-small input-name" type="text" name="name" /><button class="btn btn-lg btn-success btn-block btn-small save-name" type="submit">保存</button></form></div></div><ul class="course clearfix" id="course"></ul></div>')
});

$('.department a').live('click', function() {
	$(this).parent().find('.department-input').show();
});

$('.course i').live('click',function(){
	var that = this;
	$('.will-delete').show();
	$('#is-delete').click(function(event) {
		$(that).parent().remove();
		var courseId = $(that).parent().find('a').attr('data-id');
		$('.will-delete').hide();
		$.ajax({
		  	type: 'POST',
		  	url: '/admin/deleteType?id=' + courseId
		});
	});
	$('#no-delete').click(function(event) {
		$('.will-delete').hide();
	});
})

$('.department i').live('click',function(){
	var that = this;
	$('.will-delete').show();
	$('#is-delete').click(function(event) {
		$(that).parent().parent().remove();
		var courseId = $(that).parent().find('a').attr('data-id');
		$('.will-delete').hide();
		$.ajax({
		  	type: 'POST',
		  	url: '/admin/deleteType?id=' + courseId
		});
	});
	$('#no-delete').click(function(event) {
		$('.will-delete').hide();
	});
})

$('.save-coursename').live('click',function(){
	var courseName = $(this).parent().find('.input-coursename').val()
		cousrseId = $(this).parent().parent().parent().parent().find('.department a').attr('data-id');
	$.ajax({
	  	type: 'POST',
	  	url: '/admin/addSecondType?name=' + courseName + '&fid=' + cousrseId
	});	
})

$('.save-name').live('click',function(){
	var course = $(this).parent().find('.input-name').val();
	if ( $(this).parent().parent().attr('data-id')!= '' ){
		$.ajax({
		  	type: 'POST',
		  	url: '/admin/editType?id=' + id + '&name=' + course
		});	
	}
	else{
		$.ajax({
		  	type: 'POST',
		  	url: '/admin/addFirstType?name=' + course
		});	
	}
})