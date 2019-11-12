<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Request A Song!</title>
	</head>
	<body>

		<form action="songRequest" method="POST">
			<label for="artist">Artist: </label><input name="artist" type="text" />
			<label for="title">Title: </label><input name="title" type="text" />
			<label for="album">Album: </label><input name="album" type="text" />
			
			<input type="submit" value="Make Request" />
		</form>
		
	</body>
</html>