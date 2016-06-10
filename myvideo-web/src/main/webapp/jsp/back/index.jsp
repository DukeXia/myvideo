<%@page language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>博客管理系统 v0.0.1</title>

    <!-- Bootstrap Core CSS -->
    <link href="/bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="/css/metisMenu.min.css" rel="stylesheet">

    <!-- Timeline CSS -->
    <!--<link href="../dist/css/timeline.css" rel="stylesheet">-->

    <!-- Custom CSS -->
    <link href="/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
   <!-- <link href="../bower_components/morrisjs/morris.css" rel="stylesheet">-->

    <!-- Custom Fonts -->
    <link href="/bootstrap-3.3.5-dist/css/font-awesome.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- jQuery -->
    <script src="/bootstrap-3.3.5-dist/js/jquery-2.1.1.min.js"></script>


    <script>
        $(function(){
            //加载（分类）页面
            //$("#page-wrapper").load("videoManager.jsp");
        })
    </script>
</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->

        <span id="navigation">
            <!-- js加载左侧+顶部导航 -->
            <jsp:include page="head_navgation.jsp"/>
        </span>
         <script>
             //<!-- 加载左侧+上侧的导航 -->
             //$("#navigation").load("head_navgation.jsp");
         </script>


        <div id="page-wrapper" style="">


        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->



    <!-- Bootstrap Core JavaScript -->
    <script src="/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="/js/metisMenu.min.js"></script>

    <!-- Morris Charts JavaScript -->
 <!--   <script src="../bower_components/raphael/raphael-min.js"></script>
    <script src="../bower_components/morrisjs/morris.min.js"></script>
    <script src="../js/morris-data.js"></script>-->
    <!-- Custom Theme JavaScript 初始导航的js-->
    <script src="/js/sb-admin-2.js"></script>


</body>

</html>
