$(window).scroll(function(event) {
	var topHeight = 140 - $(window).scrollTop();
	if ( topHeight > 80){
		$('.contact-us').css( 'top', topHeight );
		$('.nav').css( 'top', topHeight );
	};
});