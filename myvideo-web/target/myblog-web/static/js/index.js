/**
 * Created by Tane on 2016/6/3.
 */
$(document).ready(function(){
    //填充分类视频数据
    var pageNo=1; //页数
    var pageSize=6 //每页条数
    //填充分类信息
    $.ajax({
        url:'/getVideoList',
        dataType:'json',
        data:{'categoryId':1,'pageNo':pageNo,'pageSize':pageSize},
        success:function(data){
            console.log(data);
            if(data.result=='100'){

            }
        },
        error:function(data){

        }
    });

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
                if(data.result=='100'){
                    //window.open('http://127.0.0.1:8095/index.html');
                    $('#login-trigger').html('admin');
                    $('#login-content').slideUp();
                }

            }
        })
    });
    $(".type-list").find("li").hover(function(){
        $('.dot').css('width','60px');
        var  listWidth = $(".type-list").width();
        var  remain_left = ($(window).width()-listWidth)/2;
        var _left = $(this).offset().left-remain_left;
        $(".type-list").find(".dot").animate({left:_left},10);
    })

});