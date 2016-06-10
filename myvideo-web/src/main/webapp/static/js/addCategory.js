/**
 * Created by linjunjie(490456661@qq.com) on 2016/5/17.
 */

var category_func = {
    categoryId : 0,
    init : function(){
        this.getCategoryListForBack();

    },
    uploadEvent : function(){
        //装载删除按钮事件
        $(".mybtn-delete").on("click",function(){
            if(confirm("是否删除\""+$(this).parents("tr").find("td").eq(1).html()+"\"")) {
                var e = $(this).parents("tr");
                category_func.categoryId = e.attr("id");
                category_func.remove();
            }
        });
    },
    insert : function(){
        var dataForm = {
            'category' : $("#categoryName").val()
        };
        if(dataForm.category == ""){
            $("#cateWarning").attr("class","alert alert-warning");
            $("#cateWarning").html("不能为空!");
            document.getElementById("cateWarning").style.visibility="visible";
            return ;
        }
        var data;
        $.ajax({
            url : "/admin/addCategory",
            method : "POST",
            dataType : "json",
            async : false,
            data : dataForm,
            success : function(result){
                data = result;
            },
            error : function(){
                alert("请求失败");
            }
        });
        if(data&&data.result == "100"){
            $("#cateWarning").attr("class","alert alert-success");
            $("#cateWarning").html("\""+dataForm.category+"\"添加成功");
            this.getCategoryListForBack();
        }else{
            $("#cateWarning").attr("class","alert alert-warning");
            $("#cateWarning").html("\""+dataForm.category+"\"添加失败,"+data.message);
        }
        document.getElementById("cateWarning").style.visibility="visible";
    },
    getCategoryListForBack : function(){
        var data;
        $.ajax({
            url : "/getCategoryList",
            method : "POST",
            dataType : "json",
            async : false,
            success : function(result){
                data = result;
            },
            error : function(){
                alert("请求失败");
            }
        });
        this.uploading(data);
    },
    uploading : function(data){
        if(data&&data.data&&data.data.categoryBeanList){
            var list = data.data.categoryBeanList;
            var contentHtml = "";
            for(var i=0;i<list.length;i++){
                contentHtml += "<tr id='" +
                    list[i].id+"'><td>" +
                    (i+1) +
                    "</td><td>" +
                    list[i].name +
                    "</td><td><button type='button' class='mybtn mybtn-delete mybtn-hover'>删除</button></td></tr>";
            }
            $("#category_table tbody").html(contentHtml);
            this.uploadEvent();
        }
    },
    remove : function(){
        var dataForm = {
            'id' : this.categoryId
        };
        var data;
        $.ajax({
            url : "/admin/delCategory",
            method : "POST",
            dataType : "json",
            async : false,
            data : dataForm,
            success : function(result){
                data = result;
            },
            error : function(){
                alert("请求失败");
            }
        });

        if(data.result == "100"){
            this.getCategoryListForBack();
            alert("删除成功");
        }else if(data.result == "902"){
            alert(data.message);
        }
    }

}