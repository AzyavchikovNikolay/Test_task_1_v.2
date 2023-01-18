<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="localization.local" var="loc" />
<fmt:message bundle="${loc}" key="local.news_list.news" var="news" />
<fmt:message bundle="${loc}" key="local.news_list.news_list" var="news_list" />
<fmt:message bundle="${loc}" key="local.news_list.delete_selected_news" var="delete_selected_news" />
<fmt:message bundle="${loc}" key="local.news_list.editlink" var="editlink" />
<fmt:message bundle="${loc}" key="local.news_list.viewlink" var="viewlink" />
<fmt:message bundle="${loc}" key="local.news_list.no_news" var="no_news" />

<div class="body-title">
	<a href="controller?command=go_to_news_list"><c:out value="${news}" /></a> <c:out value="${news_list}" />
</div>

<form action="controller?command=do_delete_selected_news" method="post">
	<c:if test="${sessionScope.role eq 'admin'}">
		<div class="delete2">
			<input type="submit" value="${delete_selected_news}"/>
		</div>
	</c:if>
	<c:forEach var="news" items="${sessionScope.news}">	
		<div class="single-news-wrapper">
			<div class="single-news-header-wrapper">
				<div class="news-title">
					<c:out value="${news.title}" />
				</div>
				<div class="news-date">
					<c:out value="${news.newsDate}"/>
				</div>	
				
				<div class="news-content">
					<c:out value="${news.briefNews}" />
				</div>
				<div class="news-link-to-wrapper">
					<div class="link-position">
						<c:if test="${sessionScope.role eq 'admin'}">
							<a href="controller?command=go_to_edit_news&id=${news.idNews}"><c:out value="${editlink}" /> </a>
						</c:if>
							
						<a href="controller?command=go_to_view_news&id=${news.idNews}"><c:out value="${viewlink}" /> </a>
						
						<c:if test="${sessionScope.role eq 'admin'}">
							<input type="checkbox" name="idNews" value="${news.idNews }" />
						</c:if>
					</div>
				</div>
				
			</div>
		</div>

	</c:forEach>
	
	<div class="no-news">
		<c:if test="${sessionScope.news eq null}">
		<c:out value="${no_news}" />
	</c:if>
	</div>
</form>