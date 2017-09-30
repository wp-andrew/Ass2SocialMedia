package web.app.eng.dao.support;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.app.eng.common.DBConnectionFactory;
import web.app.eng.dao.PostDAO;
import web.app.eng.dto.Post;

public class PostDAOImpl extends DBConnectionFactory implements PostDAO {
	
	public static PostDAOImpl instance;

	public static PostDAOImpl getInstance() {
		if (instance == null) {
			instance = new PostDAOImpl();
		}
		
		return instance;
	}
	
	private Post convertPost(ResultSet resultSet) throws SQLException {
		Post post = new Post();

		post.setId(resultSet.getInt("id"));
		post.setDatetime(resultSet.getString("datetime"));
		post.setPoster(resultSet.getString("subject"));
		post.setContent(resultSet.getString("content"));
		
		return post;
	}
	
	@Override
	public Post selectPost(int id) {
		Connection connection = getConnection();
		
		String sql = "SELECT * FROM post WHERE id=?;";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
                Post post = convertPost(resultSet);
				connection.close();
				return post;
			}
			
			connection.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void insertPost(Post post) {
		Connection connection = getConnection();
		
		String sql = "INSERT INTO post (content) VALUES (?);";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, post.getContent());
			preparedStatement.executeUpdate();
			
			sql = "SELECT max(id) AS id FROM post;";
			preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				sql = "INSERT INTO log (subject, predicate, object2) VALUES ('" + post.getPoster() + "', "
						+ Integer.toString(4) + ", '" + Integer.toString(resultSet.getInt("id")) + "');";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.executeUpdate();
			}
			
			connection.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Post> getPostList(String username) {
		Connection connection = getConnection();
		
		List<Post> posts = new ArrayList<Post>();
		
		String sql = "SELECT t1.id, datetime, subject, content FROM (post AS t1) "
				+ "INNER JOIN (SELECT datetime, subject, object2 AS id FROM log "
				+ "WHERE predicate=4 AND datetime > (SELECT datetime FROM log "
				+ "WHERE predicate=1 AND subject=?) "
				+ "AND subject IN (SELECT object1 FROM log WHERE predicate=3 AND subject=? "
				+ "UNION SELECT subject FROM log WHERE predicate=3 AND object1=? "
				+ "UNION SELECT ?)) AS t2 ON t1.id = t2.id ORDER BY t1.id DESC;";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, username);
			preparedStatement.setString(3, username);
			preparedStatement.setString(4, username);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
                Post post = convertPost(resultSet);
                sql = "SELECT count(*) AS likes FROM log WHERE predicate=5 AND object2=?;";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, post.getId());
                ResultSet resultSet2 = preparedStatement.executeQuery();
                if (resultSet2.next()) {
	                post.setLikes(resultSet2.getInt("likes"));
	                posts.add(post);
                }
			}
			
			connection.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return posts;
	}
	
}
