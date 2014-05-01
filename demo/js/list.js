$(window).scroll(function(event) {
	var topHeight = 140 - $(window).scrollTop();
	if ( topHeight > 80){
		$('.contact-us').css( 'top', topHeight );
		$('.nav').css( 'top', topHeight );
	};
});

$('.nav li').eq(0).addClass('active');
$('.project-list').addClass('active');
$('.nav li').click(function(event) {
	var index = $('.nav li').index($(this));
	$(this).addClass('active').siblings().removeClass('active');
	$('.project-list').eq(index).addClass('active').siblings().removeClass('active');
});