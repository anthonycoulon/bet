<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<script type="text/javascript">
		$(function() {
			$('.menu-item').removeClass('active');
			$('#menu-admin').addClass('active');
		})
	</script>
</head>
<body>
	<label class="control-label" for="run-button">Run calculate score task</label>
	<input type="button" value="Run" id="run-button" class="btn btn-large btn-primary"/>
	<script type="text/javascript">
		$(function() {
			$('#run-button').click(function(){
				window.location='/bet/admin/calculateTask'
			})
		})
	</script>
</body>
</html>
