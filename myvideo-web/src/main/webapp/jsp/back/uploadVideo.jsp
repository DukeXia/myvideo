<%@page language="java" pageEncoding="UTF-8" %>
<script type="text/javascript" src="/js/uploadVideo.js"></script>
<script type="text/javascript" src="/js/jquery-form.js"></script>
<script>
    $(function(){
        upload_func.init();
    });
</script>
<style>

    .mybtn{
        padding: 4px 6px;
        border: 1px solid rgb(220,220,220);
        border-radius: 3px;
    }

    .mybtn-delete{
        background-color: rgb(255, 255, 255);
        color:red;
    }

    .mybtn-hover:hover{
        border:1px solid rgb(114, 208, 130);background-color: rgb(206, 53, 53);
        color: rgb(255, 255, 255);
    }

    .mybtn-default{
        background-color: rgb(248, 248, 248);
        color: rgb(133, 94, 167);

    }

</style>
<!-- /.row -->
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">上传视频</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>
<div class="row" style="padding-top:17px;">
        <div class="col-md-12 col-xs-12">
            <form enctype="multipart/form-data" id="myform">
                <div class="form-group">
                    <label for="title">标题</label>
                    <input type="email" class="form-control" id="title" placeholder="标题">
                </div>
                <div class="form-group">
                    <label for="desc">描述</label>
                    <input type="password" class="form-control" id="desc" placeholder="描述">
                </div>
                <div class="form-group">
                    <label for="video">视频上传</label>
                    <input type="file" id="video">
                    <p class="help-block">视频文件上传，格式为mp4或avi</p>
                </div>
                <div class="form-group">
                    <label for="pic">封面上传</label>
                    <input type="file" id="pic">
                    <p class="help-block">图片格式为png、jpg、gif等</p>
                </div>

                <button id="btnUpload" type="button" class="btn btn-default">上传</button>
            </form>

        </div>
</div>
<!-- /.row -->