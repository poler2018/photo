<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>QQ空间图片浏览代码DEMO演示</title>
<script src="layer/jquery.js?v=1.83.min"></script>
<script src="layer/layer.min.js"></script>
<style>
html{background-color:#E3E3E3; font-size:14px; color:#000; font-family:'微软雅黑'}
a,a:hover{ text-decoration:none;}
pre{font-family:'微软雅黑'}
.box{padding:20px; background-color:#fff; margin:20px 100px; border-radius:5px;}
.box a{padding-right:15px;}
#about_hide{display:none}
.layer_text{background-color:#fff; padding:20px;}
.layer_text p{margin-bottom: 10px; text-indent: 2em; line-height: 23px;}
.button{display:inline-block; *display:inline; *zoom:1; line-height:30px; padding:0 20px; background-color:#56B4DC; color:#fff; font-size:14px; border-radius:3px; cursor:pointer; font-weight:normal;}
.imgs img{width:300px;padding:0 20px 20px;}
</style>
</head>
<body>
<div class="box">
    <h2 style="padding-bottom:20px;">layer1.8相册模块，点击下述图片试试</h2>
    <div id="imgs" class="imgs">
<!--         <img src="images/1.jpg" layer-pname="HTML5资源教程 - 1">
        <img src="images/2.jpg" layer-pname="HTML5资源教程 - 2">
        <img src="images/3.jpg" layer-pname="HTML5资源教程 - 3">
        <img src="images/4.jpg" layer-pname="HTML5资源教程 - 4"> -->
        <c:forEach var="showlist" items="${sessionScope.showlist}">
				<img src="upload/${showlist.photoName}" layer-pname="HTML5资源教程 - 4" style="width: 125px;height: 125px">	
		</c:forEach>
    </div>
	<div style="text-align:center;clear:both;">
<script src="/gg_bd_ad_720x90.js" type="text/javascript"></script>
<script src="/follow.js" type="text/javascript"></script>
</div>
</div>
<script>
;!function(){
layer.use('extend/layer.ext.js', function(){
    //初始加载即调用，所以需放在ext回调里
    layer.ext = function(){
        layer.photosPage({
            html:'<div style="padding:20px;"><input type="text">这里传入自定义的html<p>相册支持左右方向键，支持Esc关闭</p><p>另外还可以通过异步返回json实现相册。更多用法详见官网。</p><p>'+ unescape("%u7D20%u6750%u5BB6%u56ED%20-%20sc.chinaz.com") +'</p><p id="change"></p></div>',
            title: '快捷模式-获取页面元素包含的所有图片',
            id: 100, //相册id，可选
            parent:'#imgs'
        });
    };
});
}();
</script>

</body>
</html>