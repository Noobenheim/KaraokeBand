<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Request A Song!</title>
		<link href="css/style.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
		<h1>Request A Song!</h1>
		<form:form action="songRequest" method="POST" modelAttribute="song">
			<div>
				<form:label path="artist">Artist: </form:label>
				<form:input path="artist" type="text" />
				<form:errors path="artist" />
			</div>
			<div>
				<form:label path="title">Title: </form:label>
				<form:input path="title" type="text" />
				<form:errors path="title" />
			</div>
			<div>
				<form:label path="album">Album: </form:label>
				<form:input path="album" type="text" />
				<form:errors path="album" />
			</div>
			
			<input type="submit" value="Make Request" />
		</form:form>
		
	</body>
</html>