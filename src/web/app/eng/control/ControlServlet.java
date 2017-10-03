package web.app.eng.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.app.eng.dto.Post;
import web.app.eng.dto.User;
import web.app.eng.service.PostService;
import web.app.eng.service.ServiceException;
import web.app.eng.service.UserService;

/**
 * Servlet implementation class ControlServlet
 */
@WebServlet(urlPatterns="/control", displayName="ControlServlet")
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
        String action = new String("");
        if (request.getParameter("action") != null) {
            action = request.getParameter("action");
        }
        
        if (action.equals("registration")) {
            try {
                UserService userService = new UserService();
                User user = userService.create(request);
				userService.register(user);
				
				session.setAttribute("display", "confirmEmail");
			}
            catch (Exception e) {
            	request.setAttribute("error", e.getMessage());
			}
		}
        
        else if (action.equals("confirm")){
            try {
            	UserService userService = new UserService();
            	userService.confirmEmail(request.getParameter("username"));
            	
                session.setAttribute("display", "registrationComplete");
            }
            catch (ServiceException e) {
            	request.setAttribute("error", e.getMessage());
            }
        }
        
		else if (action.equals("login")) {
			try {
				UserService userService = new UserService();
				User user = userService.create(request);
				userService.login(user.getUsername(), user.getPassword());
				user = userService.selectUser(user.getUsername());
				
				session.setAttribute("user", user);
				session.setAttribute("display", "wall");
				session.setMaxInactiveInterval(60*60);
			}
			catch (ServiceException e) {
				request.setAttribute("error", e.getMessage());
			}
		}
        
        else if (action.equals("acceptFriend")){
        	try {
        		UserService userService = new UserService();
        		userService.acceptFriend(request);
        		
        		request.setAttribute("username", request.getParameter("subject"));
        		session.setAttribute("display", "userAcceptFriend");
        	}
			catch (ServiceException e) {
				request.setAttribute("error", e.getMessage());
			}
        }
        
        // All actions past this requires login
		else if (request.getSession().getAttribute("user") == null) {
			
		}
        
		else if (action.equals("search")) {
			String tagName = request.getParameter("tagName");
			String searchValue = request.getParameter("searchValue");
			
			UserService userService = new UserService();
			List<User> searchResults;
			if (tagName.equals("firstname")) {
				searchResults = userService.searchUsers(searchValue, "");
			}
			else if (tagName.equals("surname")) {
				searchResults = userService.searchUsers("", searchValue);
			}
			else if (tagName.equals("gender")) {
				searchResults = userService.searchUsers(searchValue);
			}
			else {
				try {
					int birthdate = Integer.parseInt(searchValue.substring(0, 2));
					int birthmonth = Integer.parseInt(searchValue.substring(3, 5));
					int birthyear = Integer.parseInt(searchValue.substring(6, 10));
					searchResults = userService.searchUsers(birthdate, birthmonth, birthyear);
				}
				catch (Exception e) {
					searchResults = null;
				}
			}
			
			session.setAttribute("searchResults", searchResults);
			session.setAttribute("display", "result");
		}
        
        else if (action.equals("otherProfile")) {
        	String username = request.getParameter("username");
        	
			UserService userService = new UserService();
			User otherUser = userService.selectUser(username);
			
			session.setAttribute("otherUser", otherUser);
			session.setAttribute("display", "otherProfile");
		}
        
        else if (action.equals("addFriend")) {
			try {
				User user = (User) session.getAttribute("user");
				UserService userService = new UserService();
				userService.addFriend(user, request);
				
				session.setAttribute("display", "otherProfile");
			}
			catch (ServiceException e) {
				request.setAttribute("error", e.getMessage());
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
        
        else if (action.equals("home")) {
			session.setAttribute("display", "wall");
		}
        
        else if (action.equals("profile")) {
			session.setAttribute("display", "profile");
		}
        
        else if (action.equals("editProfile")) {
			session.setAttribute("display", "editProfile");
		}
        
        else if (action.equals("update")) {
			User user = (User) session.getAttribute("user");
			
			UserService userService = new UserService();
			user = userService.create(user, request);
			userService.updateUser(user);
			
			session.setAttribute("user", user);
			session.setAttribute("display", "profile");
		}
        
        else if (action.equals("post")) {
			PostService postService = new PostService();
			Post post = postService.createPost(request);
			postService.insertPost(post);
			
			session.setAttribute("display", "wall");
		}
        
        else if (action.equals("like")) {
        	try {
	        	User user = (User) session.getAttribute("user");
	        	
				PostService postService = new PostService();
				postService.likePost(user, Integer.parseInt(request.getParameter("id")));
				
				session.setAttribute("display", "wall");
	    	}
	    	catch (ServiceException e) {
	    		request.setAttribute("error", e.getMessage());
	    	}
		}
        
        else if (action.equals("unlike")) {
        	try {
	        	User user = (User) session.getAttribute("user");
	        	
				PostService postService = new PostService();
				postService.unlikePost(user, Integer.parseInt(request.getParameter("id")));
				
				session.setAttribute("display", "wall");
        	}
        	catch (ServiceException e) {
        		request.setAttribute("error", e.getMessage());
        	}
		}
        
        else if (action.equals("logout")){
            session.invalidate();
        }
		
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/home.jsp");
        requestDispatcher.forward(request, response);
	}

}
