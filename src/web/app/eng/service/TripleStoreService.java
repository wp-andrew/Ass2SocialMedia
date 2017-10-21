package web.app.eng.service;

import java.util.List;

import org.json.JSONObject;

import web.app.eng.dao.TripleStoreDAO;
import web.app.eng.dao.support.TripleStoreDAOImpl;

public class TripleStoreService {

	private TripleStoreDAO tripleStoreDAO = TripleStoreDAOImpl.getInstance();
	
	public List<JSONObject> getAllRelations(String username) {
		return tripleStoreDAO.getAllRelations(username);
	}
	
	public List<JSONObject> getFriendsOf(String username) {
		return tripleStoreDAO.getFriendsOf(username);
	}
	
	public List<JSONObject> getPosted(String username) {
		return tripleStoreDAO.getPosted(username);
	}
	
	public List<JSONObject> getLiked(String username) {
		return tripleStoreDAO.getLiked(username);
	}
	
	public List<JSONObject> getPostedBy(int number) {
		return tripleStoreDAO.getPostedBy(number);
	}
	
	public List<JSONObject> getLikedBy(int number) {
		return tripleStoreDAO.getLikedBy(number);
	}
	
	public List<JSONObject> searchUsers(String searchValue) {
		return tripleStoreDAO.searchUsers(searchValue);
	}
	
	public List<JSONObject> searchPosts(int number) {
		return tripleStoreDAO.searchPosts(number);
	}
	
	public List<JSONObject> getEntities(List<JSONObject> relations) {
		return tripleStoreDAO.getEntities(relations);
	}
	
}
