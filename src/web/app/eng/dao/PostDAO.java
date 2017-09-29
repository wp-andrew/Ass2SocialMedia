package web.app.eng.dao;

import java.util.List;

import web.app.eng.dto.Post;

public interface PostDAO {
	
	/**
	 * Tries to locate a post with the given id
	 * 
	 * @param	id of the Post
	 * @return	The Post if there is a Post with the id, null otherwise.
	 */
	public Post selectPost(int id);
	
	/**
	 * Insert a new post into the post database.
	 * 
	 * @param	The Post to insert
	 * @return
	 */
	public void insertPost(Post post);
	
	/**
	 * Get the last post id in the post database
	 * 
	 * @param
	 * @return
	 */
	public int getLastPostId();
	
	/**
	 * Get the username of a poster
	 * 
	 * @param	id of the Post
	 * @return	the username of the poster if there is a Post with the given id, null otherwise
	 */
	public String getPoster(int id);
	
	/**
	 * Get all of user's own and friend's posts after user join datetime
	 * 
	 * @param	The username of the User
	 * @return	The list of Post (that the User is allowed to see)
	 */
	public List<Post> getPostList(String username);
	
}
