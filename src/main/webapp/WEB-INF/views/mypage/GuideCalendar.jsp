<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset='utf-8' />
		<script src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.15/index.global.min.js'></script>
		<script>
			$().ready(function () {


				var usrLgnId = $(".header-content").data("login-id");
				var calendarEl = document.getElementById('calendar');


				var calendar = new FullCalendar.Calendar(calendarEl, {
					headerToolbar: {
						left: 'prev,next today',
						center: 'title',
						right: 'dayGridMonth,timeGridWeek,timeGridDay,listMonth'
					},
					initialDate: new Date(),
					navLinks: true, // can click day/week names to navigate views
					businessHours: true, // display business hours
					editable: true,
					dayMaxEvents: true, // allow "more" link when too many event
					selectable: true,
					selectMirror: true,
					// 이벤트명 : function(){} : 각 날짜에 대한 이벤트를 통해 처리할 내용..
					select: function (arg) {
						console.log(arg);

						var title = prompt('입력할 일정:');
						// title 값이 있을때, 화면에 calendar.addEvent() json형식으로 일정을 추가
						if (title) {
							calendar.addEvent({
								title: calTitle,
								start: arg.calStart,
								end: arg.calEnd,
								allday: arg.calAllday,
								backgroundColor: "yellow",
								textColor: "blue"
							})
						}
						calendar.unselect()
					},
					eventClick: function (arg) {
						// 있는 일정 클릭시,
						console.log("#등록된 일정 클릭#");
						console.log(arg.event);

						if (confirm('Are you sure you want to delete this event?')) {
							arg.event.remove()
						}
					},
					events: function (info, successCallback, failureCallback) {
						// ajax 처리로 데이터를 로딩 시킨다.
						$.ajax({
							type: "get",
							url: `/mypage/calendar/gd-calendar/${usrLgnId}/cal`,
							dataType: "json",
							success: function (data) {
								if (!data || data.length === 0) {
									console.warn("No events data returned from server.");
								} else {
									console.log("Events data:", data);
								}
								// 서버에서 받은 데이터를 FullCalendar 이벤트 형식으로 변환
								const events = data.map(item => ({
									title: item.calTitle,
									start: item.calStart,
									end: item.calEnd,
									allDay: item.calAllday,
									backgroundColor: item.calBackColor,
									textColor: item.calTextColor
								}));
								// 변환된 데이터를 successCallback에 전달
								successCallback(events);
							},
							error: function (xhr, status, error) {
								console.error('Failed to fetch events:', error);
								failureCallback(error);
							}
						});
					}
				}); // 캘린더 끝

				calendar.render();
			});



			function dateFormat(date) {
				var yyyy = date.getFullYear();
				var MM = date.getMonth() + 1; // 0월 부터 시작해 +1을 시켜줌
				var dd = date.getDate();
				var rtnDate = yyyy + '-' + MM + '-' + dd;
				return rtnDate;
			}



			function getEvent(proSeq) {
				var events;
				$.ajax({
					type: 'POST',
					data: {
						proSeq: proSeq
					},
					datatype: 'json',
					async: false,
					url: 'projectTaskList',
					success: function (result) {
						events = result;
					},
					error: function (xhr, status, error) {
						alert('ajax error' + error);
					}
				});
				return events;
			}




			function updateFunc(info) {
				var proSeq = info.event.extendedProps.proSeq;
				var seq = info.event.extendedProps.seq;
				var start = info.event.start;
				start = dateFormat(start);
				var end = info.event.end;
				end = dateFormat(end);
				var title = info.event.title;
				var contents = info.event.extendedProps.contents;
				var msg;
				$.ajax({
					type: 'POST',
					data: {
						proSeq: proSeq,
						seq: seq,
						start: start,
						end: end,
						title: title,
						contents: contents
					},
					datatype: 'json',
					async: false,
					url: 'projectTaskUpdate',
					success: function (result) {
						if (result == 'y') {
							msg = '수정되었습니다.';
						} else {
							msg = '수정에 실패했습니다.';
						}
					},
					error: function (xhr, status, error) {
						msg = '수정에 실패했습니다.';
					}
				});
				return msg;
			}





		</script>
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