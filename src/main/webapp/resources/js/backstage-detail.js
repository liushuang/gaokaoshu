var blogId = $('#blog-blogid').val(),
	typeId = $('#blog-typeid').val();
	
$.ajax({
	type: 'get',
	url: '/admin/getBlogContent?blogId=' + blogId,
	success:function(data){
		var contentAll = eval('(' + data + ')'); 
		console.log(contentAll); 
		var index = contentAll.text.length;
		for( var i = 1; i <= index; i++ ){	
		    $('.container').append('<div class="text-area"><div class="clearfix text-title"><label>重点学科：</label><input type="text" class="form-control" id="input-title' + i + '"><button class="btn btn-lg btn-primary btn-block delete-editor">删除小节</button></div><script type="text/plain" id="myEditor' + i + '" style="width:1000px;height:240px;">请输入内容</script></div>');
		    var idName = 'myEditor' + i;
			UM.getEditor(idName);
			$('#myEditor' + i).text('');
			$('#myEditor' + i).append(contentAll.text[i-1]);
			$('#input-title'+i).val( contentAll.title[i-1] );
		}
	}
});

var num = $('.text-area').length;

$('#add-editor').click(function() {
    num ++;
    $('.container').append('<div class="text-area"><div class="clearfix text-title"><label>重点学科：</label><input type="text" class="form-control" id="input-title' + num + '"><button class="btn btn-lg btn-primary btn-block delete-editor">删除小节</button></div><script type="text/plain" id="myEditor' + num + '" style="width:1000px;height:240px;">请输入内容</script></div>');
    var idName = 'myEditor' + num;
	UM.getEditor(idName);
});

$('#save-editor').click(function() {
	var arrText = [];
	for( var i = 1; i <= num; i++){	
    	var idName = 'myEditor' + i;    
	    arrText.push( UM.getEditor(idName).getContent() );
	};
	var arrTitle = [];	
	for( var j = 1; j <= num; j++){	
    	var inputName = 'input-title' + j;    
	    arrTitle.push( $('#input-title'+j).val() );
	};
	var contentJson = {
		'title' : arrTitle,
		'text' : arrText
	};
	var contentStr = JSON.stringify( contentJson );
	console.log(contentJson);
	console.log(contentStr);
	if( blogId == 0 ){
		$.ajax({
			type: 'post',
			url: '/admin/addBlog?typeId=' + typeId + '&content=' + contentStr,
			success:function(data){
				if( data == 'success'){
					alert('保存成功');
				}
				else{
					alert('请登录');
				}
			},
			error:function() {
				alert('保存失败');
			}
		})
	}
	else{
		$.ajax({
			type: 'post',
			url: '/admin/editBlog?blogId=' + blogId + '&content=' + contentStr,
			success:function(data){
				if( data == 'success'){
					alert('保存成功');
				}
				else{
					alert('请登录');
				}
			},
			error:function() {
				alert('保存失败');
			}
		})
	};
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
