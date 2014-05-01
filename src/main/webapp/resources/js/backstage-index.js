$('.course-img i').live('click',function(){
	var that = this;
	$('.will-delete').show();
	$('#is-delete').click(function(event) {
		$(that).parent().remove();
		$('.will-delete').hide();
		var typeId = $(that).parent().find('input').eq(1).val();
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
