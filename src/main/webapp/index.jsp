<%--
  Created by IntelliJ IDEA.
  User: meiyukai
  Date: 2019-11-05
  Time: 23:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<html>
<head>
    <title>index</title>
</head>
<body>

<h3>springmvc方式文件上传</h3>

<form action="/upload/commonUpload" method="post" enctype="multipart/form-data">
    选择文件： <input type="file" name="upload" /><br/>
    <input type="submit" value="上传">
</form>


<h3>跨服务器的方式实现文件上传 !</h3>
<form action="/upload/betweenServers" method="post" enctype="multipart/form-data">
    选择文件： <input type="file" name="upload" /><br/>
    <input type="submit" value="上传">
</form>

</body>
</html>


