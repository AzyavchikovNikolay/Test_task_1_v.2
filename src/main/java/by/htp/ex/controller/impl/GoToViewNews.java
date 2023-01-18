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

public class GoToViewNews implements Command {
	
	private final INewsService newsService = ServiceProvider.getInstance().getNewsService();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getSession(true).setAttribute("edit", "");
		
		News newsView;
		
		String id;
		
		id = request.getParameter("id");
		
		if(id==null) {
			id=request.getSession(true).getAttribute("idPre").toString();
		} else
			request.getSession(true).setAttribute("idPre", id);
		
		try {
					
			newsView  = newsService.findById(Integer.parseInt(id));
			request.getSession(true).setAttribute("newsView", newsView);
			request.getSession(true).setAttribute("presentation", "viewNews");
			request.getRequestDispatcher("WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);
		} catch (ServiceException e) {
			request.getRequestDispatcher("/WEB-INF/pages/layouts/error.jsp").forward(request, response);
		}	
	}
}
