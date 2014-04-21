$('.img-add').live('click', function() {
	$(this).parent().find('.course-img').append('<li><label>重点学科图片和文字:</label><input class="form-control course-imgurl" type="text" placeholder="图片链接" /><input class="form-control course-title" type="text" placeholder="标题" /><input class="form-control course-text" type="text" placeholder="文案" /></li>')
});

$('#add-course').click(function() {
	$('.contanier').append('<div class="clearfix backstage course-info"><h3>学科信息</h3><div class="course-content"><div class="course-main clearfix"><div><label>重点学科：</label><input class="form-control" type="text" /></div><ul class="course-img"><li><label>重点学科图片和文字:</label><input class="form-control course-imgurl" type="text" placeholder="图片链接" /><input class="form-control course-title" type="text" placeholder="标题" /><input class="form-control course-text" type="text" placeholder="文案" /></li></ul><button class="btn btn-lg btn-primary btn-block img-add" type="submit">增加图片</button><button class="btn btn-lg btn-primary btn-block img-save" type="submit">保存</button></div></div></div>')
});