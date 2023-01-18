package by.htp.ex.dao.impl;

import by.htp.ex.dao.IUserDAO;
import by.htp.ex.dao.DaoException;
import by.htp.ex.bean.User;
import java.util.List;
import java.util.ArrayList;

public class UserDAO implements IUserDAO {

	
	
	@Override
	public String logination(String login, String password) throws DaoException{
	
		List<User> usersList = new ArrayList<User>();
		usersList.add(new User("admin", "111", "admin", "Иванов", "Максим", "80291111111", "ivanov@globus.com"));
		usersList.add(new User("petrov", "222", "user", "Петров", "Василий", "80292222222", "petrov@globus.com"));
		usersList.add(new User("sidorov", "333", "user", "Сидоров", "Михаил", "80293333333", "sidorov@globus.com"));
		usersList.add(new User("pavlov", "444", "user", "Павлов", "Олег", "80294444444", "pavlov@globus.com"));
		usersList.add(new User("nikolaev", "111", "admin", "Николаев", "Денис", "80295555555", "nikolaev@globus.com"));		
		
		String userRole = "";
		for(User us:usersList) {
			if(us.getLogin().equals(login)&&us.getPassword().equals(password)) {
				userRole=us.getRole();
			} 
		}
		if(userRole.equals(""))
			return "guest";
		else 	
			return userRole;
	}


	
	public String getRole(String login, String password) {
		return "guest";
	}
	
	@Override
	public boolean registration(User user) throws DaoException{
		
		List<User> usersList = new ArrayList<User>();
		usersList.add(new User("admin", "111", "admin", "Иванов", "Максим", "80291111111", "ivanov@globus.com"));
		usersList.add(new User("petrov", "222", "user", "Петров", "Василий", "80292222222", "petrov@globus.com"));
		usersList.add(new User("sidorov", "333", "user", "Сидоров", "Михаил", "80293333333", "sidorov@globus.com"));
		usersList.add(new User("pavlov", "444", "user", "Павлов", "Олег", "80294444444", "pavlov@globus.com"));
		usersList.add(new User("nikolaev", "111", "admin", "Николаев", "Денис", "80295555555", "nikolaev@globus.com"));		
		
		String loginR = user.getLogin();
		String passwordR = user.getPassword();
		String roleR = user.getRole();
		String surnameR = user.getSurname();
		String nameR = user.getName();
		String phoneR = user.getPhone();
		String emailR = user.getEmail();
		int k=0;		
		for(User us:usersList) {
			if(us.getLogin().equals(loginR)||us.getPhone().equals(phoneR)||us.getEmail().equals(emailR)) {
				k++;
			}
		}
		if(k>0)
			return false;
		else {
			usersList.add(user);
			return true;
		}
		
	}
}
