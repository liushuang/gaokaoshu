$(window).scroll(function(event) {
	var topHeight = 140 - $(window).scrollTop();
	if ( topHeight > 80){
		$('.contact-us').css( 'top', topHeight );
		$('.nav').css( 'top', topHeight );
	};
});

$('.nav li').eq(0).addClass('active');
$('.project-list').eq(0).addClass('active');
$('.nav li').click(function(event) {
	var index = $('.nav li').index($(this));
	$(this).addClass('active').siblings().removeClass('active');
	$('.project-list').eq(index).addClass('active').siblings().removeClass('active');
});

function GetQueryString(name)
{
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r!=null)return  unescape(r[2]); return null;
};

var index = GetQueryString('item');

$('.nav-tabs li').eq(index).addClass('active').siblings().removeClass('active');
$('.project-list').eq(index).addClass('active').siblings().removeClass('active');