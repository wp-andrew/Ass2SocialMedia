package web.app.eng.service;

import java.util.List;

import web.app.eng.dao.LogDAO;
import web.app.eng.dao.support.LogDAOImpl;
import web.app.eng.dto.Log;

public class LogService {

	private LogDAO logDAO = LogDAOImpl.getInstance();
	
	public List<Log> getNotifications(String username) {
		return logDAO.getNotifications(username);
	}
	
}
