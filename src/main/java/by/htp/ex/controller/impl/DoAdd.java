package by.htp.ex.controller.impl;

import java.io.IOException;
import java.util.List;

import by.htp.ex.bean.News;
import by.htp.ex.controller.Command;
import by.htp.ex.service.INewsService;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DoAdd implements Command {

	private final INewsService newsService = ServiceProvider.getInstance().getNewsService();
	
	private static final String JSP_NEWS_ID_PARAM = "newsId";
	private static final String JSP_NEWS_TITLE_PARAM = "titleEdit";
	private static final String JSP_NEWS_DATE_PARAM = "newsDateEdit";
	private static final String JSP_BRIEF_PARAM = "briefEdit";
	private static final String JSP_CONTENT_PARAM = "titleEdit";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	String newsId = request.getParameter(JSP_NEWS_ID_PARAM);
	String titleA = request.getParameter(JSP_NEWS_TITLE_PARAM);
	String dateA = request.getParameter(JSP_NEWS_DATE_PARAM);
	String briefA = request.getParameter(JSP_BRIEF_PARAM);
	String contentA = request.getParameter(JSP_CONTENT_PARAM);
	
	List<News> newsList;
	
		try {
			
			String check = "";
		
			if(String.valueOf(newsId).equals(check)||titleA.equals(check)||dateA.equals(check)||briefA.equals(check)||contentA.equals(check)) {
			
				request.getSession(true).setAttribute("add", "warning");
				request.getRequestDispatcher("/WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);
			} else {
				
				News newsA = new News(Integer.valueOf(newsId), titleA, dateA, briefA, contentA);
				newsService.save(newsA);
				newsList = newsService.list();
				request.getSession(true).setAttribute("news", newsList);
				request.getSession(true).setAttribute("add", "");
				request.getSession(true).setAttribute("presentation", "newsList");
				request.getRequestDispatcher("/WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);
			}
		
		} catch (ServiceException e) {
			request.getRequestDispatcher("/WEB-INF/pages/layouts/error.jsp").forward(request, response);
		}
	}
}
