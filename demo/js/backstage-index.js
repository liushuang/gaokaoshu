$('.img-add').live('click', function() {
	$(this).parent().find('.course-img').append('<li><label>图片和文字:</label><i>×</i><input class="form-control course-imgurl" type="text" placeholder="图片链接" /><input class="form-control course-title" type="text" placeholder="标题" /><input class="form-control course-text" type="text" placeholder="文案" /><input class="form-control course-link" type="text" placeholder="链接"/></li>')
});

$('#add-course').click(function() {
	$('.course-content').append('<div class="course-main clearfix"><label>重点学科：</label><input class="form-control" type="text" placeholder="标题" /><input class="form-control" type="text" placeholder="链接"/></div>')
});

$('#save-course').click(function() {
	var index = $('.course-main').length;
	for( var i = 0; i < index; i ++){		
		var courseId = $('.course-main').eq(i).find('.course-id').val,
			courseLink = $('.course-main').eq(i).find('.course-link').val;
		$.ajax({
		  	type: 'POST',
		  	url: '/admin/index/insertHotType?level=1&typeId='+courseId+'&desc='+courseLink
		});
	}
});

$('#save-course').click(function() {
	var index = $('.course-img li').length;
	for( var i = 0; i < index; i ++){		
		var textimgImgurl = $('.course-img li').eq(i).find('.textimg-imgurl').val,
			textimgTitle = $('.course-img li').eq(i).find('.textimg-titlerl').val,
			textimgText = $('.course-img li').eq(i).find('.textimg-text').val,
			textimgLink = $('.course-img li').eq(i).find('.textimg-link').val;
		$.ajax({
		  	type: 'POST',
		  	url: /admin/index/insertHotType?level=2&typeId=type_id&desc=desc&img=img(type_id:学科id,img:展示图片)
		});
	}
});

$('.course-img i').live('click',function(){
	var that = this;
	$('.will-delete').show();
	$('#is-delete').click(function(event) {
		$(that).parent().remove();
		$('.will-delete').hide();
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
