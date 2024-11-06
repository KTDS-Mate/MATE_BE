<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset='utf-8' />
		<script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
      
		<script src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.15/index.global.min.js'></script>
		<script type="text/javascript" src="/js/mypage/GuideCalendar.js"></script>
		<style>
			body {
				padding: 0;
				font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
				font-size: 14px;
			}

			#calendar {
				max-width: 1100px;
				margin: 0 auto;
			}

			.fc-h-event .fc-event-title-container {
				flex-grow: 1;
				flex-shrink: 1;
				font-size: 1rem;
				min-width: 0px;
			}
		</style>
	</head>

	<body>

		<div id='calendar'></div>

	</body>

	</html>