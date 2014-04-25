//实例化编辑器
UM.getEditor('myEditor1');
// //按钮的操作
// $('.getcontent').click{
//     var arr = [];
//     arr.push(UM.getEditor('myEditor1').getContent());
//     alert(arr);
// }

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
	}
	var arrTitle = [];	
	for( var j = 1; j <= num; j++){	
    	var inputName = 'input-title' + j;    
	    arrTitle.push( $('#input-title'+j).val() );
	}
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
})