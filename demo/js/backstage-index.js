$('.img-add').live('click', function() {
	$(this).parent().find('.course-img').append('<li><label>图片和文字:</label><i>×</i><form enctype="multipart/form-data" method="post" action="/admin/index/insertHotType"><input type="hidden" value="1" name="level"><input type="text" placeholder="学科id" name="typeId"><input type="text" placeholder="描述" name="desc"><input type="file" name="img"><button class="btn btn-lg btn-success btn-block" type="submit">保存</button></form></li>')
});

$('#add-course').click(function() {
	$('.course-content').append('<div class="course-main clearfix"><label>重点学科：</label><input type="text" placeholder="学科ID" class="form-control course-id"><input type="text" placeholder="学科名" class="form-control course-title"></div>')
});

$('#save-course').click(function() {
	var index = $('.course-main').length;
	for( var i = 0; i < index; i ++){		
		var courseId = $('.course-main').eq(i).find('.course-id').val(),
			courseTitle = $('.course-main').eq(i).find('.course-title').val();
		$.ajax({
		  	type: 'POST',
		  	url: '/admin/index/insertHotType?level=1&typeId='+courseId+'&desc='+courseTitle
		});
	}
});

$('.course-img i').live('click',function(){
	var that = this;
	$('.will-delete').show();
	$('#is-delete').click(function(event) {
		$(that).parent().remove();
		$('.will-delete').hide();
		var typeId = $(that).parent().find('input').eq(2).val();
		$.ajax({
		  	type: 'POST',
		  	url: '/admin/index/deleteHotType?id='+typeId
		});
	});
	$('#no-delete').click(function(event) {
		$('.will-delete').hide();
	});
})

$('#webinfo-save').click(function() {
	var webInfo = $('#webinfo-text').val();
	$.ajax({
	  	type: 'POST',
	  	url: '/admin/index/update?id=1&text='+webInfo
	});
});

$('#examinfo-save').click(function() {
	var webInfo = $('#examinfo-text').val();
	$.ajax({
	  	type: 'POST',
	  	url: '/admin/index/update?id=2&text='+webInfo
	});
});
