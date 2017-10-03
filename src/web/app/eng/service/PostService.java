package web.app.eng.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.app.eng.dao.PostDAO;
import web.app.eng.dao.support.PostDAOImpl;
import web.app.eng.dto.Log;
import web.app.eng.dto.Post;
import web.app.eng.dto.User;

public class PostService {
	
	private PostDAO postDAO = PostDAOImpl.getInstance();
	
	public Post createPost(HttpServletRequest request) {
		Post post = new Post();
		
		if (request.getParameter("poster") != null && !request.getParameter("poster").equals("")) {
			post.setPoster(request.getParameter("poster"));
		}
		if (request.getParameter("content") != null && !request.getParameter("content").equals("")) {
			post.setContent(request.getParameter("content"));
		}
		
	    return post;
	}
	
	public void insertPost(Post post) {
		postDAO.insertPost(post);
	}
	
	public List<Post> getPostList(String username) {
		return postDAO.getPostList(username);
	}

	public void likePost(User user, int id) {
		Log log = new Log();
		log.setSubject(user.getUsername());
		log.setPredicate(5);
		log.setObject2(id);
		
		LogService logService = new LogService();
    	if (logService.selectLog(log) != null) {
    		throw new ServiceException("You have already liked this post!");
    	}
    	else {
    		logService.insertLog(log);
    	}
	}

	public void unlikePost(User user, int id) {
		Log log = new Log();
		log.setSubject(user.getUsername());
		log.setPredicate(5);
		log.setObject2(id);
		
		LogService logService = new LogService();
    	if (logService.selectLog(log) == null) {
    		throw new ServiceException("You haven't liked this post!");
    	}
    	else {
    		logService.deleteLog(log);
    	}
	}
	
}
