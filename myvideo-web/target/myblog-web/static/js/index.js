/**
 * Created by Tane on 2016/6/3.
 */
//µÇÂ¼
$(document).ready(function(){
    $('#login-trigger').click(function(){
        $(this).next('#login-content').slideToggle();
        $(this).toggleClass('active');

        if ($(this).hasClass('active')) $(this).find('span').html('&#x25B2;')
        else $(this).find('span').html('&#x25BC;')
    });
    $('#submit').click(function(){
        var username=$('#username').val();
        var password=$('#password').val();
        $.ajax({
            url:'/user/login',
            data:{'username':username,'password':password},
            dataType:'json',
            success: function (data) {
                console.log(data)

            }
        })
    });
    $(".type-list").find("li").hover(function(){
        var  listWidth = $(".type-list").width();
        var  remain_left = ($(window).width()-listWidth)/2;
        var _left = $(this).offset().left-remain_left;
        $(".type-list").find(".dot").animate({left:_left},10);
    })

});