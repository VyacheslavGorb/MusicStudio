<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<fmt:setBundle basename="pagecontent" var="rb"/>

<!DOCTYPE html>
<html lang="${sessionScope.locale}">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="style/form_page.css" rel="stylesheet">
    <link href="style/footer.css" rel="stylesheet">
    <title><fmt:message key="company.name" bundle="${rb}"/> - <fmt:message key="teacher.tabs.lesson_schedule"
                                                                           bundle="${rb}"/></title>
</head>
<body>
<jsp:include page="../parts/header.jsp" flush="true"/>

<ul class="nav nav-tabs mb-5">
    <li class="nav-item">
        <a class="nav-link active" aria-current="page"
           href="${pageContext.request.contextPath}/controller?command=teacher_lesson_schedule"><fmt:message
                key="teacher.tabs.lesson_schedule"
                bundle="${rb}"/></a>
    </li>
    <li class="nav-item">
        <a class="nav-link"
           href="${pageContext.request.contextPath}/controller?command=teacher_schedule"><fmt:message
                key="teacher.tabs.teacher_schedule"
                bundle="${rb}"/></a>
    </li>
    <li class="nav-item">
        <a class="nav-link"
           href="${pageContext.request.contextPath}/controller?command=teacher_personal_info"><fmt:message
                key="teacher.tabs.personal_info"
                bundle="${rb}"/></a>
    </li>
</ul>


<div class="w-100 d-flex align-items-center flex-column min-vh-100">

    <c:if test="${requestScope.lesson_schedule_dates.size() == 0}">
        <div class="d-flex mt-5 align-items-center flex-column">
            <h1 class="display-1"><fmt:message key="teacher.lesson_schedule.not_found" bundle="${rb}"/></h1>
        </div>
    </c:if>

    <c:forEach items="${requestScope.lesson_schedule_dates}" var="date">
        <div class="d-flex w-75">
            <p class="fs-2 display-1">${date}</p>
        </div>
        <table class="table mb-5 w-75">
            <thead>
            <tr>
                <th scope="col"><fmt:message key="teacher.lesson_schedule.student_name" bundle="${rb}"/></th>
                <th scope="col"><fmt:message key="teacher.lesson_schedule.student_surname" bundle="${rb}"/></th>
                <th scope="col"><fmt:message key="teacher.lesson_schedule.course_name" bundle="${rb}"/></th>
                <th scope="col"><fmt:message key="teacher.lesson_schedule.start_time" bundle="${rb}"/></th>
                <th scope="col"><fmt:message key="teacher.lesson_schedule.duration" bundle="${rb}"/></th>
                <th scope="col"><fmt:message key="teacher.lesson_schedule.status" bundle="${rb}"/></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.lesson_schedule_map.get(date)}" var="lessonSchedule">
                <tr>
                    <td>${lessonSchedule.studentName}</td>
                    <td>${lessonSchedule.studentSurname}</td>
                    <td>${lessonSchedule.courseName}</td>
                    <td>${lessonSchedule.startDateTime.toLocalTime()}</td>
                    <td>${lessonSchedule.duration.hour}</td>
                    <td><fmt:message key="teacher.lesson_schedule.status.${lessonSchedule.status}"
                                     bundle="${rb}"/></td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </c:forEach>
</div>

<jsp:include page="../parts/footer.jsp"/>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>
