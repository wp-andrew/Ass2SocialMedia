package web.app.eng.service;

import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import web.app.eng.dao.UserDAO;
import web.app.eng.dao.support.UserDAOImpl;
import web.app.eng.dto.Log;
import web.app.eng.dto.User;

public class UserService {
	
	private UserDAO userDAO = UserDAOImpl.getInstance();

	public User create(HttpServletRequest request) {
		User user = new User();
		
		if (request.getParameter("firstname") != null && !request.getParameter("firstname").equals("")) {
			user.setFirstname(request.getParameter("firstname"));
		}
		if (request.getParameter("surname") != null && !request.getParameter("surname").equals("")) {
			user.setSurname(request.getParameter("surname"));
		}
		if (request.getParameter("email") != null && !request.getParameter("email").equals("")) {
			user.setEmail(request.getParameter("email"));
		}
		if (request.getParameter("username") != null && !request.getParameter("username").equals("")) {
			user.setUsername(request.getParameter("username"));
		}
		if (request.getParameter("password") != null && !request.getParameter("password").equals("")) {
			user.setPassword(request.getParameter("password"));
		}
		if (request.getParameter("birthdate") != null && !request.getParameter("birthdate").equals("")) {
			user.setBirthdate(Integer.parseInt(request.getParameter("birthdate")));
		}
		if (request.getParameter("birthmonth") != null && !request.getParameter("birthmonth").equals("")) {
			user.setBirthmonth(Integer.parseInt(request.getParameter("birthmonth")));
		}
		if (request.getParameter("birthyear") != null && !request.getParameter("birthyear").equals("")) {
			user.setBirthyear(Integer.parseInt(request.getParameter("birthyear")));
		}
		if (request.getParameter("gender") != null && !request.getParameter("gender").equals("")) {
			user.setGender(request.getParameter("gender"));
		}
		
	    return user;
	}
	
	public User create(User user, HttpServletRequest request) {		
		if (request.getParameter("firstname") != null && !request.getParameter("firstname").equals("")) {
			user.setFirstname(request.getParameter("firstname"));
		}
		if (request.getParameter("surname") != null && !request.getParameter("surname").equals("")) {
			user.setSurname(request.getParameter("surname"));
		}
		if (request.getParameter("email") != null && !request.getParameter("email").equals("")) {
			user.setEmail(request.getParameter("email"));
		}
		if (request.getParameter("username") != null && !request.getParameter("username").equals("")) {
			user.setUsername(request.getParameter("username"));
		}
		if (request.getParameter("password") != null && !request.getParameter("password").equals("")) {
			user.setPassword(request.getParameter("password"));
		}
		if (request.getParameter("birthdate") != null && !request.getParameter("birthdate").equals("")) {
			user.setBirthdate(Integer.parseInt(request.getParameter("birthdate")));
		}
		if (request.getParameter("birthmonth") != null && !request.getParameter("birthmonth").equals("")) {
			user.setBirthmonth(Integer.parseInt(request.getParameter("birthmonth")));
		}
		if (request.getParameter("birthyear") != null && !request.getParameter("birthyear").equals("")) {
			user.setBirthyear(Integer.parseInt(request.getParameter("birthyear")));
		}
		if (request.getParameter("gender") != null && !request.getParameter("gender").equals("")) {
			user.setGender(request.getParameter("gender"));
		}
		
	    return user;
	}
	
	public boolean register(User user) throws MessagingException {
		// verify that username is unique
		User userExist = userDAO.selectUser(user.getUsername());
		if (userExist != null) {
			return false;
		}
		
		user.setBanned(false);
		user.setVerified(false);
		
		userDAO.insertUser(user);
		
		EmailService.sendVerificationEmail(user);
		
		return true;
	}
	
	public User confirmEmail(String username) {
		User user = userDAO.selectUser(username);
		if (user == null) {
			return null;
		}
		else if (!user.isVerified()) {
			user.setVerified(true);
			userDAO.updateUser(user);
		}
		
		Log log = new Log();
		log.setSubject(username);
		log.setPredicate(1);
		
		LogService logService = new LogService();
		logService.insertLog(log);
		
		return user;
	}
	
	public void login(String username, String password) throws ServiceException {
		User user = userDAO.selectUser(username);
		if (user == null) {
			throw new ServiceException("Specified username does not exist!");
		}
		else if (user.isBanned()) {
		    throw new ServiceException("Your account has been disabled!");
		}
		else if (!user.isVerified()) {
		    throw new ServiceException("Your UNSWBook email address must be verified before you can sign in.");
		}
		
		user =  userDAO.selectUser(username, password);
		if (user == null) {
			throw new ServiceException("Incorrect password for " + username + "!");
		}
	}
	
	public User selectUser(String username) {
		return userDAO.selectUser(username);
	}
	
	public void updateUser(User user) {
		userDAO.updateUser(user);
	}
	
	public List<User> searchUsers(String firstname, String surname) {
		return userDAO.searchUsers(firstname, surname);
	}
	
	public List<User> searchUsers(int birthdate, int birthmonth, int birthyear) {
		return userDAO.searchUsers(birthdate, birthmonth, birthyear);
	}
	
	public List<User> searchUsers(String gender) {
		return userDAO.searchUsers(gender);
	}
	
	public List<User> getFriendList(String username) {
		return userDAO.getFriendList(username);
	}
	
	public void banUser(String username) {
		userDAO.banUser(username);
	}
	
	public void unbanUser(String username) {
		userDAO.unbanUser(username);
	}
	
	public Boolean isFriend(String username1, String username2) {
		return userDAO.isFriend(username1, username2);
	}
	
}
