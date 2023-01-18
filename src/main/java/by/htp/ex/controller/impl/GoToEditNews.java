package by.htp.ex.controller.impl;

import java.io.IOException;

import by.htp.ex.bean.News;
import by.htp.ex.controller.Command;
import by.htp.ex.service.INewsService;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GoToEditNews implements Command {

	
	private final INewsService newsService = ServiceProvider.getInstance().getNewsService();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		News newsView;
		
		String id;
		
		id = request.getParameter("id");
		request.getSession(true).setAttribute("idPre", id);

		
		try {	
			newsView  = newsService.findById(Integer.parseInt(id));
			request.getSession(true).setAttribute("addNews", "");
			request.getSession(true).setAttribute("edit", "");
			request.getSession(true).setAttribute("newsView", newsView);
			request.getSession(true).setAttribute("presentation", "edit");
			request.getRequestDispatcher("WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);
		} catch (ServiceException e) {
			request.getRequestDispatcher("/WEB-INF/pages/layouts/error.jsp").forward(request, response);
		}	
	}
}
