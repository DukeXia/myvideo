
var video_func = {
    pageNo : 1,
    pageSize : 10,
    total : 0,
    id : 0,
    init : function(){
        this.getVideoList();
        this.loadEvent();
    },
    getVideoList : function(){
        var dataForm = {
            'pageNo' : this.pageNo,
            'pageSize' : this.pageSize
        };
        var data;
        $.ajax({
            url : "/getVideoList",
            method : "POST",
            dataType : "json",
            data : dataForm,
            async : false,
            success : function(result){
                data = result;
            },
            error : function(){
                alert("请求失败");
            }
        });
        if(data && data.result == "100") {
            this.loading(data);
        }else{
            alert(data.message);
        }
    },
    loading : function(data){
        var total = data.data.total;
        this.total = total;
        var list = data.data.videoBeanList;
        var contentHtml = "";
        for(var i =0;i<list.length;i++){
            contentHtml += '<tr id="' +
                list[i].id +'"><td>' +
                ((this.pageNo-1)*this.pageSize+i/1+1)+'</td><td>' +
                list[i].title+'</td><td>' +
                list[i].desc.substr(0,10)+'..</td><td>' +
                list[i].username+'</td><td>' +
                list[i].category +
                '</td><td>' +
                list[i].created+
                '</td><td><button type="button" class="mybtn mybtn-delete mybtn-hover">删除</button></td></tr>';
        }
        $("#content_table tbody").html(contentHtml);
        var maxPage = Math.ceil(this.total/this.pageSize);
        $("#pageInfo").html(this.pageNo+"/"+maxPage);
    },
    loadEvent : function(){
        //删除按钮
        $(".mybtn-delete").on("click",function(){
            video_func.id = $(this).parents("tr").attr("id");
            if(confirm("是否删除")){
                video_func.deleteVideo();
            }
        });
        //上一页，下一页等按钮
        $(".mybtn-default").on("click",function(){
            if($(this).attr("pageno")=="-1"){
                //上一页
                video_func.upPage();
            }else if($(this).attr("pageno")=="-2"){
                //下一页
                video_func.downPage();
            }else if($(this).attr("pageno")=="-3"){
                //第一页
                video_func.pageNo = 1;
                video_func.getVideoList();
            }else if($(this).attr("pageno")=="-4"){
                //最后一页
                video_func.pageNo  = Math.ceil(video_func.total/video_func.pageSize);;
                video_func.getVideoList();
            }else if($(this).html() == "GO!"){
                video_func.toTargetPage();
            }
        });
    },
    deleteVideo : function(){
        if(this.id == 0){
            return;
        }
        var dataForm = {
            'id' : this.id
        };
        var data;
        $.ajax({
            url : "/admin/delVideo",
            method : "POST",
            dataType : "json",
            data : dataForm,
            async : false,
            success : function(result){
                data = result;
            },
            error : function(){
                alert("请求失败");
            }
        });
        if(data&&data.result == "100"){
            alert("删除成功");
            this.getVideoList();
        }else{
            alert(data.message);
        }
    },
    upPage : function(){
        if(this.pageNo == 1){
            alert("已经最小页啦！");
            return;
        }
        this.pageNo -= 1;
        this.getVideoList();
    },
    downPage : function(){
        if(this.total == 0){
            return;
        }
        var maxPage = Math.ceil(this.total/this.pageSize);
        if(this.pageNo == maxPage){
            alert("已经到达最大页了!");
            return;
        }
        this.pageNo += 1;
        this.getVideoList();
    },
    toTargetPage : function(){
        var target = $("#target").val()/1;
        var maxPage = Math.ceil(this.total/this.pageSize);
        if(target < 1 || target > maxPage){
            return;
        }
        if(isNaN($("#target").val()/1)){
            alert("请输入正确的数字");
            return;
        }
        this.pageNo = $("#target").val()/1;


        this.getVideoList();
    }

}