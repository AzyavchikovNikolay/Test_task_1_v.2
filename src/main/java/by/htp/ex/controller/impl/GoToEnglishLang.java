package by.htp.ex.controller.impl;

import by.htp.ex.controller.Command;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import jakarta.servlet.ServletException;
import by.htp.ex.service.ServiceException;

public class GoToEnglishLang implements Command {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		try {

			request.getSession(true).setAttribute("local", "en");
			request.getRequestDispatcher("WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);
		
		} catch(Exception e) {
			request.getRequestDispatcher("/WEB-INF/pages/layouts/error.jsp").forward(request, response);
		}
	}
}
