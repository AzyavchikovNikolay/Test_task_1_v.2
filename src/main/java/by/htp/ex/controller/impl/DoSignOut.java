package by.htp.ex.controller.impl;

import by.htp.ex.controller.Command;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import jakarta.servlet.ServletException;


public class DoSignOut implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		try {
		
			request.getSession(true).setAttribute("user", "not active");
			request.getSession(true).setAttribute("welcome", "guest");
			response.sendRedirect("index.jsp");	
		
		} catch (Exception e) {
			request.getRequestDispatcher("/WEB-INF/pages/layouts/error.jsp").forward(request, response);
		}
	}
}
