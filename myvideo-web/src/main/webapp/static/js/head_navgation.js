/**
 * Created by linjunjie(490456661@qq.com) on 2016/5/28.
 */
var head_navgation = {
    init : function(){
        this.uploadEvent();
    },
    uploadEvent : function(){
        //装载左侧按钮
        $("a").each(function(){
            if($(this).html() == "发表文章"){
                $(this).click(function(){
                    $("#page-wrapper").load("/jsp/back/addContent.jsp",function(){
                        article_func.init();
                        //alert($("#content").html());
                        CKEDITOR.replace("content");
                    });
                });
            }else if($(this).html() == "添加分类"){
                $(this).click(function(){
                    $("#page-wrapper").load("/jsp/back/addCategory.jsp",function(){
                        category_func.init();
                    });
                });

            }else if($(this).html() == "操作文章"){
                $(this).click(function(){
                    $("#page-wrapper").load("/jsp/back/videoManager.jsp",function(){
                        managerContent_func.init();
                    });
                });
            }
        });
    }

};