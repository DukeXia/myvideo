/**
 * Created by Tane on 2016/6/3.
 */
$(function(){
    //    play
    $(document).on('click','.player-btn',function(){
        //alert(1)
        var id = $(this).attr('data-id');
        window.open('/playpage.html?id='+id);
    });
    //navbar
    $(document).on("click","#navbar li",function(e){
        e.stopPropagation();
        var type = $(this).attr('data-type');
        $.ajax({
            url:'/getVideoList',
            data:{'categoryId':type,'pageNo':1,'pageSize':6},
            success:function(data){
                window.open('/category-detail.html?getVideoList='+type);
            }
        })
    });
    //login
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
                    window.open('/jsp/back/index.jsp');
                    $('#login-content').slideUp();
                }else{
                    alert('登录失败：'+data.message);
                }

            }
        })
    });

    //backTop
    $(".foot .back").click(function () {
        $("body,html").animate({scrollTop: 0}, 500)
        return false;
    });


});
/*  获取url中的参数
 *  用法：
 *	var Request = new GetRequest();
 *	var 参数1 = Request['参数1'];
 * */
function GetRequest() {
    var url = location.search;
    var theRequest = new Object();
    if (url.indexOf("?") != -1) {
        var _split = url.split("?"),str='';
        for(var i=1,len=_split.length;i<len;i++){
            str += _split[i];
        }
        strs = str.split("&");
        for(var i = 0; i < strs.length; i ++) {
            theRequest[strs[i].split("=")[0]]=decodeURIComponent(strs[i].split("=")[1]);
        }
    }
    return theRequest;
}