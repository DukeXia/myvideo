/**
 * Created by Tane on 2016/6/10.
 */
var Request = new GetRequest();
var id = Request['id'];
$(function(){
    $.ajax({
        url: '/getCategoryList',
        success: function (data) {
            var categoryList = data.data.categoryBeanList;
            var len = categoryList.length;
            var navStr = '';
            for (var i = 0; i < len; i++) {
                navStr += '<li data-type="' + categoryList[i].id + '">' + categoryList[i].name + '</li>';

            }
            $('#navbar').append(navStr);

        }
    });
    $.ajax({
        url:'/getVideo',
        data:{'id':id},
        success: function (data) {
            if(data.result=='100'){
                $('.video-name').html(data.data.title);
                $('.video-desc').html(data.data.desc);
                $('.video-owner').html(data.data.username);
                $('.video-date').html(data.data.created);
                $('.videotitle').html(data.data.title);
            }
        }
    }) ;
});