package web.app.eng.dao;

import web.app.eng.dto.Log;
import web.app.eng.dto.Post;
import web.app.eng.dto.User;

public interface TripleStoreDAO {
	
	public void insertUser(User user);
	
	public void updateUser(User user);
	
	public void insertPost(Post post);
	
	public void insertRelation(Log log);
	
	public void deleteRelation(Log log);
	
}
