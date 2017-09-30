package web.app.eng.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.app.eng.dao.PostDAO;
import web.app.eng.dao.support.PostDAOImpl;
import web.app.eng.dto.Post;

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
	
}
