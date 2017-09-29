package web.app.eng.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		
        String action = new String("");
        if (request.getParameter("action") != null){
            action = request.getParameter("action");
        }
		
        String nextPage = "home.jsp";
        if (action.equals("registration")) {
            UserService userService = new UserService();
            User user = userService.create(request);
            try {
                if (!userService.register(user)) {
                	nextPage = "registrationError.jsp";
                };
            }
            catch (MessagingException e) {
                e.printStackTrace();
            }
            if (!nextPage.equals("registrationError.jsp"))
            	nextPage = "confirmEmail.jsp";
		}
        else if (action.equals("confirm")){
            UserService userService = new UserService();
            userService.confirmEmail(request.getParameter("username"));
            nextPage = "registrationComplete.jsp";
        }
		else if (action.equals("login")) {
			UserService userService = new UserService();
			User user = userService.create(request);
			try {
				userService.login(user.getUsername(), user.getPassword());
				user = userService.selectUser(user.getUsername());
				
				HttpSession session = request.getSession();
				session.setAttribute("login", "true");
				session.setAttribute("user", user);
				session.setAttribute("display", "wall");
				session.setMaxInactiveInterval(60*60);
			}
			catch (ServiceException e) {
				request.setAttribute("error", e.getMessage());
			}
		}

        else if (action.equals("search")) {			
			UserService userService = new UserService();
			String tagName = request.getParameter("tagName");
			String searchValue = request.getParameter("searchValue");
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
				searchResults = null;
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("display", "result");
			session.setAttribute("searchResults", searchResults);
		}
        else if (action.equals("home")) {
			HttpSession session = request.getSession();
			session.setAttribute("display", "wall");
		}
        else if (action.equals("profile")) {
			HttpSession session = request.getSession();
			session.setAttribute("display", "profile");
		}
        else if (action.equals("edit")) {
			HttpSession session = request.getSession();
			session.setAttribute("display", "edit");
		}
        else if (action.equals("update")) {
			HttpSession session = request.getSession();
			session.setAttribute("display", "profile");
		}
        else if (action.equals("logout")){
        	HttpSession session = request.getSession();
            session.invalidate();
        }
		
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/" + nextPage);
        requestDispatcher.forward(request, response);
	}

}
