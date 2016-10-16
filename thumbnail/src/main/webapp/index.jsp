<html>
<body>
<h2>Hello World!</h2>

<form action=${pageContext.request.contextPath}/uploadImage" enctype="multipart/form-data">
	<input type="file" name="image"/>
	<input type="submit" value="上传"/>
</form>
</body>


</html>
