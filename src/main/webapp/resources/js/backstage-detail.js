var blogId = $('#blog-blogid').val(),
	typeId = $('#blog-typeid').val();
$.ajax({
	type: 'get',
	url: '/admin/getBlogContent?blogId=' + blogId,
	success:function(data){
		var contentAll = eval('(' + data + ')'); 
		var index = contentAll.text.length;
		$('#blog-title').val(contentAll.blogtitle);
		$('#blog-author').val(contentAll.author);
		for( var i = 1; i <= index; i++ ){	
		    $('.container').append('<div class="text-area"><div class="clearfix text-title"><label>小标题：</label><input type="text" class="form-control" id="input-title' + i + '"><button class="btn btn-lg btn-primary btn-block delete-editor">删除小节</button></div><script type="text/plain" id="myEditor' + i + '" style="width:1000px;height:240px;">请输入内容</script></div>');
		    var idName = 'myEditor' + i;
			UM.getEditor(idName);
			$('#myEditor' + i).text('');
			$('#myEditor' + i).append(contentAll.text[i-1]);
			$('#input-title'+i).val( contentAll.title[i-1] );
		}
	}
});

$('#add-editor').click(function() {
	var num = $('.text-area').length;
    num ++;
    $('.container').append('<div class="text-area"><div class="clearfix text-title"><label>小标题：</label><input type="text" class="form-control" id="input-title' + num + '"><button class="btn btn-lg btn-primary btn-block delete-editor">删除小节</button></div><script type="text/plain" id="myEditor' + num + '" style="width:1000px;height:240px;">请输入内容</script></div>');
    var idName = 'myEditor' + num;
	UM.getEditor(idName);
});

$('#save-editor').click(function() {
	var num = $('.text-area').length,
		arrText = [],
		arrTitle = [];
		author = $('#blog-author').val(),
		blogTitle = $('#blog-title').val();
	for( var i = 1; i <= num; i++){	
    	var idName = 'myEditor' + i;    
	    arrText.push( UM.getEditor(idName).getContent() );
	};	
	for( var j = 1; j <= num; j++){	
    	var inputName = 'input-title' + j;    
	    arrTitle.push( $('#input-title'+j).val() );
	};
	var contentJson = {
		'blogtitle': blogTitle,
		'author': author,
		'title' : arrTitle,
		'text' : arrText
	};
	var contentStr = JSON.stringify( contentJson );
	$('#blog-content').val(contentStr);
	$('#saveblog').submit();
});

$('.delete-editor').live('click',function(){	
	var that = this;
	$('.will-delete').show();
	$('#is-delete').click(function(event) {
		$(that).parent().parent().remove();
		$('.will-delete').hide();
	});
	$('#no-delete').click(function(event) {
		$('.will-delete').hide();
	});
});
