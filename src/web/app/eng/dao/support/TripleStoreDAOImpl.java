package web.app.eng.dao.support;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import web.app.eng.common.DBConnectionFactory;
import web.app.eng.dao.TripleStoreDAO;
import web.app.eng.dto.Log;
import web.app.eng.dto.Post;
import web.app.eng.dto.User;

public class TripleStoreDAOImpl extends DBConnectionFactory implements TripleStoreDAO {
	
	public static TripleStoreDAOImpl instance;
	
	public static TripleStoreDAOImpl getInstance() {
		if (instance == null) {
			instance = new TripleStoreDAOImpl();
		}
		
		return instance;
	}
	
	public int getNextID() {
		int id = 0;
		
		Connection connection = getConnection();
		
		String sql = "SELECT max(subject) + 1 AS id FROM entity_store;";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				id = resultSet.getInt("id");
			}
			
			connection.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return id;
	}
	
	@Override
	public void insertUser(User user) {
		int id = getNextID();
		
		Connection connection = getConnection();
		
		String sql = "INSERT INTO entity_store VALUES (?, ?, ?);";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, "type");
			preparedStatement.setString(3, "user");
			preparedStatement.executeUpdate();
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, "class");
			preparedStatement.setString(3, "node");
			preparedStatement.executeUpdate();
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, "firstname");
			preparedStatement.setString(3, user.getFirstname());
			preparedStatement.executeUpdate();
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, "surname");
			preparedStatement.setString(3, user.getSurname());
			preparedStatement.executeUpdate();
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, "email");
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.executeUpdate();
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, "username");
			preparedStatement.setString(3, user.getUsername());
			preparedStatement.executeUpdate();
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, "birthdate");
			preparedStatement.setString(3, Integer.toString(user.getBirthdate()));
			preparedStatement.executeUpdate();
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, "birthmonth");
			preparedStatement.setString(3, Integer.toString(user.getBirthmonth()));
			preparedStatement.executeUpdate();
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, "birthyear");
			preparedStatement.setString(3, Integer.toString(user.getBirthyear()));
			preparedStatement.executeUpdate();
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, "gender");
			preparedStatement.setString(3, user.getGender());
			preparedStatement.executeUpdate();
			
			connection.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void updateUser(User user) {
		int id;
		
		Connection connection = getConnection();
		
		String sql = "SELECT subject AS id FROM entity_store WHERE predicate=? AND object=?;";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "username");
			preparedStatement.setString(2, user.getUsername());
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				id = resultSet.getInt("id");
				
				sql = "UPDATE entity_store SET object=? WHERE subject=? AND predicate=?;";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, user.getFirstname());
				preparedStatement.setInt(2, id);
				preparedStatement.setString(3, "firstname");
				preparedStatement.executeUpdate();
				
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, user.getSurname());
				preparedStatement.setInt(2, id);
				preparedStatement.setString(3, "surname");
				preparedStatement.executeUpdate();
				
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, user.getEmail());
				preparedStatement.setInt(2, id);
				preparedStatement.setString(3, "email");
				preparedStatement.executeUpdate();
				
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, Integer.toString(user.getBirthdate()));
				preparedStatement.setInt(2, id);
				preparedStatement.setString(3, "birthdate");
				preparedStatement.executeUpdate();
				
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, Integer.toString(user.getBirthmonth()));
				preparedStatement.setInt(2, id);
				preparedStatement.setString(3, "birthmonth");
				preparedStatement.executeUpdate();
				
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, Integer.toString(user.getBirthyear()));
				preparedStatement.setInt(2, id);
				preparedStatement.setString(3, "birthyear");
				preparedStatement.executeUpdate();
				
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, user.getGender());
				preparedStatement.setInt(2, id);
				preparedStatement.setString(3, "gender");
				preparedStatement.executeUpdate();
			}
			
			connection.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void insertPost(Post post) {
		int id = getNextID();
		
		Connection connection = getConnection();
		
		String sql = "INSERT INTO entity_store VALUES (?, ?, ?);";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, "type");
			preparedStatement.setString(3, "post");
			preparedStatement.executeUpdate();
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, "class");
			preparedStatement.setString(3, "node");
			preparedStatement.executeUpdate();
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, "number");
			preparedStatement.setString(3, Integer.toString(post.getId()));	// CHECK!!!
			preparedStatement.executeUpdate();
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, "content");
			preparedStatement.setString(3, post.getContent());
			preparedStatement.executeUpdate();
			
			connection.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertFriendOfRelation(Log log) {
		int subject, object;
		
		Connection connection = getConnection();
		
		String sql = "SELECT subject AS id FROM entity_store WHERE predicate=? AND object=?;";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "username");
			preparedStatement.setString(2, log.getSubject());
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				subject = resultSet.getInt("id");
				
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, "username");
				preparedStatement.setString(2, log.getObject1());
				resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					object = resultSet.getInt("id");
					
					sql = "INSERT INTO triple_store VALUES (?, ?, ?);";
					preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setInt(1, subject);
					preparedStatement.setInt(2, 1);
					preparedStatement.setInt(3, object);
					preparedStatement.executeUpdate();
				}
			}
			
			connection.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertPostedRelation(Log log) {
		int subject, object;
		
		Connection connection = getConnection();
		
		String sql = "SELECT subject AS id FROM entity_store WHERE predicate=? AND object=?;";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "username");
			preparedStatement.setString(2, log.getSubject());
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				subject = resultSet.getInt("id");
				
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, "number");
				preparedStatement.setString(2, Integer.toString(log.getObject2()));
				resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					object = resultSet.getInt("id");
					
					sql = "INSERT INTO triple_store VALUES (?, ?, ?);";
					preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setInt(1, subject);
					preparedStatement.setInt(2, 2);
					preparedStatement.setInt(3, object);
					preparedStatement.executeUpdate();
				}
			}
			
			connection.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertLikedRelation(Log log) {
		int subject, object;
		
		Connection connection = getConnection();
		
		String sql = "SELECT subject AS id FROM entity_store WHERE predicate=? AND object=?;";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "username");
			preparedStatement.setString(2, log.getSubject());
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				subject = resultSet.getInt("id");
				
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, "number");
				preparedStatement.setString(2, Integer.toString(log.getObject2()));
				resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					object = resultSet.getInt("id");
					
					sql = "INSERT INTO triple_store VALUES (?, ?, ?);";
					preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setInt(1, subject);
					preparedStatement.setInt(2, 3);
					preparedStatement.setInt(3, object);
					preparedStatement.executeUpdate();
				}
			}
			
			connection.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void insertRelation(Log log) {
		switch (log.getPredicate()) {
		case 3:
			insertFriendOfRelation(log);
			break;
		case 4:
			insertPostedRelation(log);
			break;
		case 5:
			insertLikedRelation(log);;
			break;
		}
	}
	
	public void deleteFriendOfRelation(Log log) {
		
	}
	
	public void deletePostedRelation(Log log) {
		
	}
	
	public void deleteLikedRelation(Log log) {
		int subject, object;
		
		Connection connection = getConnection();
		
		String sql = "SELECT subject AS id FROM entity_store WHERE predicate=? AND object=?;";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "username");
			preparedStatement.setString(2, log.getSubject());
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				subject = resultSet.getInt("id");
				
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, "number");
				preparedStatement.setString(2, Integer.toString(log.getObject2()));
				resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					object = resultSet.getInt("id");
					
					sql = "DELETE FROM triple_store WHERE subject=? AND predicate=? AND object=?;";
					preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setInt(1, subject);
					preparedStatement.setInt(2, 3);
					preparedStatement.setInt(3, object);
					preparedStatement.executeUpdate();
				}
			}
			
			connection.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteRelation(Log log) {
		switch (log.getPredicate()) {
		case 3:
			deleteFriendOfRelation(log);
			break;
		case 4:
			deletePostedRelation(log);
			break;
		case 5:
			deleteLikedRelation(log);;
			break;
		}
	}
	
}
