package web.app.eng.service;

import java.util.List;

import web.app.eng.dao.LogDAO;
import web.app.eng.dao.support.LogDAOImpl;
import web.app.eng.dto.Log;

public class LogService {

	private LogDAO logDAO = LogDAOImpl.getInstance();
	
	public void insertLog(Log log) {
		logDAO.insertLog(log);
	}
	
	public List<Log> getNotifications(String username) {
		return logDAO.getNotifications(username);
	}
	
	public List<Log> getActivity(String username) {
		return logDAO.getActivity(username);
	}
	
}
