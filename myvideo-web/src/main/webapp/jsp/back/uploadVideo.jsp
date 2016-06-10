<%@page language="java" pageEncoding="UTF-8" %>
<script type="text/javascript" src="/js/addCategory.js"></script>
<script>
    $(function(){

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
            <div class="panel panel-default" style="">

                <!-- /.panel-heading -->
                <div class="panel-body" style="    border-bottom: 2px solid rgb(204,183,239);">
                    <div id="category_table" class="table-responsive">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th>序号</th>
                                <th>名字</th>

                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                           <%-- <tr>
                                <td>1</td>
                                <td>文章名</td>
                                <td>作者</td>
                                <td>分类</td>
                                <td>访问量</td>
                                <td>留言数</td>
                                <td>创建时间</td>
                                <td><button type="button" class="mybtn mybtn-delete mybtn-hover">删除</button></td>
                            </tr>--%>

                            </tbody>
                        </table>
                    </div>
                    <!-- /.table-responsive -->

                </div>
                <!-- /.panel-body -->
            </div>
            <!-- /.panel -->
        </div>
</div>
<!-- /.row -->