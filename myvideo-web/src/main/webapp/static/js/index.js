/**
 * Created by Tane on 2016/6/3.
 */

$(function(){
    //填充分类视频数据
    var pageNo=1; //页数
    var pageSize=6 //每页条数
    //填充分类详细信息
    $.ajax({
        url:'/getCategoryList',
        success:function(data){
            var categoryList=data.data.categoryBeanList;
            var len=categoryList.length;
            var navStr='';
            for(var i=0;i<len;i++){
                navStr += '<li data-type="'+categoryList[i].id+'">'+categoryList[i].name+'</li>';
            }
            $('#navbar').append(navStr);
        }
    });
    $.ajax({
        url:'/getVideoList',
        dataType:'json',
        data:{'categoryNum':5,'videoNum':4},
        success:function(data){
            if(data.result=='100'){
                var str='';
                var cateData=data.data.preVideoList;
                var len= cateData.length;
                for(var i=0;i<len;i++){
                    if(cateData[i].length ==0){
                        continue;
                    }
                    str+='<div class="items"><div class="item-con"><div class="item-title">' +
                    cateData[i][0].category +'</div><div class="video-list">';
                    var innerLen=cateData[i].length;
                    for(var j=0;j<innerLen;j++){
                        str+=
                        '<div class="video-single">'+
                        '<img src="'+cateData[i][j].pic+'" width="225" height="110" alt="视频封面" title="视频封面">'+
                        '<div class="video-layout">' +
                        '<p>'+cateData[i][j].title+'</p>' +
                        '<p>'+cateData[i][j].desc+'</p>' +
                        '<p>'+cateData[i][j].created+'</p>' +
                        '<span class="player-btn" data-id="'+cateData[i][j].id+'">播放</span>' +

                        '</div>'+

                        '</div>';

                    }
                    str += "</div></div></div>";
                }
                $('.main-box').append(str);
            }
        },
        error:function(data){

        }
    });



});