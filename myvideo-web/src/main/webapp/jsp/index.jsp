<%@page language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
	
	<script type="text/javascript" src="/resources/bootstrap-3.3.5-dist/js/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="/resources/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/resources/js/index.js"></script>
    <link type="text/css" rel="stylesheet" href="/resources/bootstrap-3.3.5-dist/css/bootstrap.min.css"/>


    <link type="text/css" rel="stylesheet" href="/resources/css/head.css"/>
	<link type="text/css" rel="stylesheet" href="/resources/css/index.css"/>
	<link type="text/css" rel="stylesheet" href="/resources/css/iconfont.css"/>

	<style type="text/css">
		/**
		* 右侧垂直栏
		**/
		.right_icon {
            position:fixed;
            right:30px;
            bottom:15px;
            filter:alpha(opacity=70);  /* ie 有效*/
            -moz-opacity:0.7; /* Firefox  有效*/
            opacity: 0.7;
            cursor: pointer;
        }
		
	</style>
	
	<script type="text/javascript">
        var index_func = {
            contentListPageNo : 1,
            contentListPageSize : 6,
            contentListCategoryId : -1,
            categoryInit : 0 //0表示分类栏从未加载过

        }

        $(function(){
            //右侧垂直滚动条按钮初始化
            scroll_control.init();
        });

		//搜索文章名
		function searchByTitle(){
			var title = $("#byTitle").val().trim();
			if(title==""){
				alert("搜索内容不能为空!");
				return ;
			}
			$("#framedd")[0].src="content/content!selectContentByDivPage?content.title="+title;
		}
		function addInitEvent(newfunc){
			var oldfunc = window.onload;
			if(typeof(oldfunc)== "function"){
				window.onload = function(){
					oldfunc();
					newfunc();
				}
			}else{
				window.onload = newfunc;
			}
		}
		function init(){
			$("#byTitle").bind("keypress",function(event){
				if(event.keyCode==13){
					searchByTitle();
				}
			});

		}
		addInitEvent(init);
			
	</script>
</head>

<body>
	<div class="right_icon">
        <div id="top_scroll" class="iconfont icon-yuanjiantoushang" style="position: relative;"></div>
        <div id="bottom_scroll" class="iconfont icon-yuanjiantouxia" style="position: relative;"></div>
	</div>
	<div class="container">
	
	<%--头部 --%>
	<jsp:include page="common/head.jsp"></jsp:include>
	<%--// --%>
	
	<div class="row clearfix" >
		<div class="col-md-3 column">
			<!--左侧 博客栏-->
            <iframe src="" id="leftFrame" frameborder="0" border="0px" width="100%" scrolling="no">
            </iframe>
				<%--<%@include file="common/left.jsp" %>--%>
				
			<!-- // -->
			
			
		</div>
		
		<div class="col-md-9 column" >

            <iframe src="/jsp/content/content_list.jsp" id="framedd" frameborder="0" border="0px" width="100%" scrolling="no">
            </iframe>

			
		</div>
		
		
	</div>
	<div class="row clearfix">
		<div class="col-md-12 column" >
			<!--面板-->
			
			
		</div>
	</div>
	
</div>
</body>


</html>