package web.app.eng.service;

import java.util.List;

import web.app.eng.dao.PostDAO;
import web.app.eng.dao.support.PostDAOImpl;
import web.app.eng.dto.Post;

public class PostService {
	
	private PostDAO postDAO = PostDAOImpl.getInstance();
	
	public int getLastPostId() {
		return postDAO.getLastPostId();
	}
	
	public String getPoster(int id) {
		return postDAO.getPoster(id);
	}
	
	public List<Post> getPostList(String username) {
		return postDAO.getPostList(username);
	}
	
}
