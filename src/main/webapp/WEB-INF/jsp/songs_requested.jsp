<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Songs Requested</title>
		<link href="css/style.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
		<h1>Songs Requested</h1>

		<h3> ${thanks} </h3>

		<table border=3>
			<tr>
				<th>Artist</th>
				<th>Title</th>
				<th>Album</th>
			</tr>
		
			<c:forEach items="${songs}" var="song">
			<tr>
				<td>${song.artist}</td>
				<td>${song.title}</td>
				<td>${song.album}</td>
			</tr>
			</c:forEach>
		
		</table>

	<h3><a href="song_request_form">REQUEST A SONG!</a></h3>

	</body>
</html>