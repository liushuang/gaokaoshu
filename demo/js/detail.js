var blogId = $('#blog-blogid').val(),
	typeId = $('#blog-typeid').val();
	
$.ajax({
	type: 'get',
	url: '/admin/getBlogContent?blogId=' + blogId,
	success:function(data){
		var contentAll = eval('(' + data + ')'); 
		var index = contentAll.text.length;
		$('.single-panel-header h3').text(contentAll.blogtitle);
		$('.single-panel-header span').eq(0).text(contentAll.author);
		$('.single-panel-header span').eq(1).text(contentAll.time);
		for( var i = 0; i < index; i ++ ){
			$('.single-panel-body').append( '<h4 class="blog-title" id="blog-title' + i + '">' + contentAll.title[i] + '</h4>' +  contentAll.text[i]);
			$('.nav-tabs').append( '<li><a href="javascript:void(0)" data-local="' + i + '">' + contentAll.title[i] + '</a></li>');
		};
	}
});

$('.nav a').live('click',function(){	
	var domId = $(this).attr('data-local');
	$("html,body").animate({scrollTop:$("#blog-title" + domId).offset().top - 80},300);
})

function setCount(em,type){	
	if( $.cookie('hasSetcount') ){
		return false;
	}
	else{
		$.ajax({
			type: 'get',
			url: '/blog/vote?typeId=' + typeId + '&voteType=' + type,
			success:function(data){
				var index = $(this).find('span').text();
				$(this).find('span').text(++index);
			}
		});
				var index = em.find('span').text();
				em.find('span').text(++index);
	    $.cookie('hasSetcount', 1, { path: '/', expires: 30000000 });
	};
}

$('#count-up').click(function(event) {
	setCount( $(this) , 1 );
});

$('#count-normal').click(function(event) {
	setCount( $(this) , 2 );
});

$('#count-down').click(function(event) {
	setCount( $(this) , 3 );
});