/**
 * Created by Tane on 2016/6/8.
 */
var Request = new GetRequest();
var type = Request['getVideoList'];

$(function () {

    $.ajax({
        url: '/getCategoryList',
        success: function (data) {
            var categoryList = data.data.categoryBeanList;
            var len = categoryList.length;
            var navStr = '';
            for (var i = 0; i < len; i++) {
                navStr += '<li data-type="' + categoryList[i].id + '">' + categoryList[i].name + '</li>';
                if (categoryList[i].id == type) {
                    $('title').html(categoryList[i].name + ' -- Video Platform');
                }
            }
            $('#navbar').append(navStr);

        }
    });
    $.ajax({
        url: '/getVideoList',
        dataType: 'json',
        data: {'categoryId': type, 'pageNo': 1, 'pageSize': 100},
        success: function (data) {
            console.log(data);
            if (data.result == '100') {
                var str = '';
                var cateData = data.data.videoBeanList;
                var len = cateData.length;
                $('.item-title').html(cateData[0].category);
                for (var i = 0; i < len; i++) {
                    str += '' +
                    '<div class="video-single">' +
                    '<img src="' + cateData[i].pic + '" width="225" height="110" alt="视频封面" title="视频封面">' +
                    '<div class="video-layout">' + '<p>' + cateData[i].title + '</p>' +
                    '<p>' + cateData[i].desc + '</p>' +
                    '<p>' + cateData[i].created + '</p>' +
                    '<span class="player-btn" data-id="' + cateData[i].id + '">播放</span>' +
                    '</div>' +
                    '</div>';
                }
                $('.video-list').append(str);
            }
        },
        error: function (data) {

        }
    });

})


