var blogId = $('#blog-blogid').val(),
	typeId = $('#blog-typeid').val();
	
$.ajax({
	type: 'get',
	url: '/admin/getBlogContent?blogId=' + blogId,
	success:function(data){
		var contentAll = eval('(' + data + ')'); 
		var index = contentAll.text.length;
		$('.single-panel-header h3').text(contentAll.blogtitle);
		for( var i = 0; i < index; i ++ ){
			$('.single-panel-body').append( '<h4 class="blog-title" id="blog-title' + i + '">' + contentAll.title[i] + '</h4>' +  contentAll.text[i]);
			$('.nav').append( '<li><a data-local="' + i + '">' + contentAll.title[i] + '</a></li>');
		};
	}
});

// var data = '{"blogtitle":"123","title":["123","456"],"text":["123","456"]}';
// var contentAll = eval('(' + data + ')'); 
// var index = contentAll.text.length;
// $('.single-panel-header h3').text(contentAll.blogtitle);
// for( var i = 0; i < index; i ++ ){
// 	$('.single-panel-body').append( '<h4 class="blog-title" id="blog-title' + i + '">' + contentAll.title[i] + '</h4>' +  contentAll.text[i]);
// 	$('.nav').append( '<li><a data-local="' + i + '">' + contentAll.title[i] + '</a></li>');
// };
$('.nav a').live('click',function(){	
	var domId = $(this).attr('data-local');
	$("html,body").animate({scrollTop:$("#blog-title" + domId).offset().top - 80},300);
})