$('.add-course').live('click', function() {
	$(this).parent().parent().find('ul').append('<li><div class="department-input"><input class="div-control input-small input-coursename" type="text" /><button class="btn btn-lg btn-success btn-block btn-small save-coursename" type="submit">保存</button></div></li>')
});

$('#add-department').click(function() {
	$('.contanier').append('<div class="backstage"><div class="department"><a href="javascript:void(0)">请输入分类名</a><div class="department-input"><input class="div-control input-small" type="text" /><button class="btn btn-lg btn-success btn-block btn-small" type="submit">保存</button></div></div><ul class="course clearfix" id="course"><li><div class="department-input"><input class="div-control input-small" type="text"><button class="btn btn-lg btn-success btn-block btn-small" type="submit">保存</button></div></li></ul><div class="add-btn clearfix"><button class="btn btn-lg btn-primary btn-block add-course" type="submit">增加学科</button><button class="btn btn-lg btn-primary btn-block save-course" type="submit">保存</button></div>')
});

$('.department a').live('click', function() {
	$(this).parent().find('.department-input').show();
});

$('.course i').live('click',function(){
	var that = this;
	$('.will-delete').show();
	$('#is-delete').click(function(event) {
		$(that).parent().remove();
		var coursename = $(that).parent().find('a').text();
		$('.will-delete').hide();
		$.ajax({
		  	type: 'POST',
		  	url: '/admin/deleteType?id='+coursename
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
		var coursename = $(that).parent().find('a').text();
		$('.will-delete').hide();
		$.ajax({
		  	type: 'POST',
		  	url: '/admin/deleteType?id='+coursename
		});
	});
	$('#no-delete').click(function(event) {
		$('.will-delete').hide();
	});
})

$('.save-coursename').live('click',function(){
	var coursename = $(this).parent().find('.input-coursename').val();
	$.ajax({
	  	type: 'POST',
	  	url: '/admin/addSecondType?name='+coursename+'&fid=f_id'
	});	
})

$('.save-name').live('click',function(){
	var course = $(this).parent().find('.input-name').val();
	$.ajax({
	  	type: 'POST',
	  	url: '/admin/editType?id=id&name='+course
	});	
})