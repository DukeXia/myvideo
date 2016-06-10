/**
 * Created by linjunjie(490456661@qq.com) on 2016/6/10.
 */

upload_func = {

    init : function(){
        this.loadEvent();
    },
    upload : function(){
        $("#myform").ajaxSubmit({
            type:'POST',
            url:'/uploadVideo',
            async:false,
            dataType:"json",
            success:function(result){
                var data = result ;
                if(data) {
                    if (data.result == "100") {
                        alert("上传成功");
                    } else {
                        alert(data.message);
                    }
                }
            },
            error:function(){
                alert("请求失败");
            }
        });

    },
    loadEvent : function(){
        $("#btnUpload").click(function(){
            upload_func.upload();
        });
    }

};
