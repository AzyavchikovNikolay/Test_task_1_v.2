package by.htp.ex.controller.impl;

import java.io.IOException;

import by.htp.ex.controller.Command;
import by.htp.ex.service.INewsService;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import by.htp.ex.bean.News;

public class DoEdit implements Command {

	private final INewsService newsService = ServiceProvider.getInstance().getNewsService();
	
	private static final String JSP_NEWS_TITLE_PARAM = "titleEdit";
	private static final String JSP_NEWS_DATE_PARAM = "newsDateEdit";
	private static final String JSP_BRIEF_PARAM = "briefEdit";
	private static final String JSP_CONTENT_PARAM = "titleEdit";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String titleE = request.getParameter(JSP_NEWS_TITLE_PARAM);
		String dateE = request.getParameter(JSP_NEWS_DATE_PARAM);
		String briefE = request.getParameter(JSP_BRIEF_PARAM);
		String contentE = request.getParameter(JSP_CONTENT_PARAM);
		
		int idE = Integer.valueOf((String)request.getSession(true).getAttribute("idPre"));
		
		try {
			
			News newsE = new News(idE, titleE, dateE, briefE, contentE);
				
			String check = "";
			
			if(titleE.equals(check)||dateE.equals(check)||briefE.equals(check)||contentE.equals(check)) {
			
				request.getSession(true).setAttribute("edit", "warning");
				request.getRequestDispatcher("/WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);
			} else {
		
				newsService.update(newsE);
				request.getSession(true).setAttribute("edit", "");
				request.getSession(true).setAttribute("presentation", "viewNews");
				request.getRequestDispatcher("/WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);
			}
		} catch (ServiceException e) {
			request.getRequestDispatcher("/WEB-INF/pages/layouts/error.jsp").forward(request, response);
		}
	}
}