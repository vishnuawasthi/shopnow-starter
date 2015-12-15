<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://maps.googleapis.com/maps/api/js"></script>
<title>JSP -EXAMPLE</title>
<style>
#map {
	width: 500px;
	height: 400px;
}
</style>
</head>
<body>
	<h1>Local -Header</h1>

	<%-- <c:import url="http://www.javatpoint.com/jstl"></c:import> --%>

	<%-- <c:import url="https://www.google.co.in/?gws_rd=ssl"></c:import> --%>


	<div id="map"></div>


	<h1>Local - Footer</h1>
	<script>
		function initialize() {
			var mapCanvas = document.getElementById('map');
			var mapOptions = {
				center : new google.maps.LatLng(17.445824, 78.3773954),
				zoom : 8,
				mapTypeId : google.maps.MapTypeId.ROADMAP
			}
			var map = new google.maps.Map(mapCanvas, mapOptions);
		}
		google.maps.event.addDomListener(window, 'load', initialize);
	</script>
</body>
</html>