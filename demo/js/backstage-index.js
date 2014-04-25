$('.img-add').live('click', function() {
	$(this).parent().find('.course-img').append('<li><label>图片和文字:</label><i>×</i><input class="form-control course-imgurl" type="text" placeholder="图片链接" /><input class="form-control course-title" type="text" placeholder="标题" /><input class="form-control course-text" type="text" placeholder="文案" /><input class="form-control course-link" type="text" placeholder="链接"/></li>')
});

$('#add-course').click(function() {
	$('.course-main').append('<div><label>重点学科：</label><input class="form-control" type="text" placeholder="标题" /><input class="form-control" type="text" placeholder="链接"/></div>')
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