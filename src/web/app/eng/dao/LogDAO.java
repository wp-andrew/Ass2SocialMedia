package web.app.eng.dao;

import java.util.List;

import web.app.eng.dto.Log;

public interface LogDAO {

	/**
	 * Tries to locate a post with the given id
	 * 
	 * @param	id of the Post
	 * @return	The Post if there is a Post with the id, null otherwise.
	 */
	public Log selectLog(int id);
	
	/**
	 * Insert a new log into the log database.
	 * 
	 * @param	The Log to insert
	 * @return
	 */
	public void insertLog(Log log);

	public List<Log> getNotifications(String username);
}
