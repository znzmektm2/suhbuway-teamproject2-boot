<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<script>
	$(document).ready(function () {
		$('img').each(function () {
			var baseUrl = $(this).attr('src');
			var url = $(this).attr('src','http://subway.co.kr'+baseUrl);
		    console.log(url);
		})
	});
</script>
<body>

</body>
</html>
