package blog;

import java.util.ArrayList;
import java.util.Calendar;

import base.Post;
import base.User;

public class Blog {
	
	private User user;
	private ArrayList<Post> allPosts;
	
	/**
	 * Constructor
	 * @param user
	 */
	public Blog(User user) {
		this.user = user;
		allPosts = new ArrayList<Post>();//initialize the ArrayList
	}
	
	/**
	 * 
	 * @return
	 */
	public User getUser() {
		return user;
	}

	/**
	 * 
	 * @param user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<Post> getAllPosts() {
		return allPosts;
	}

	/**
	 * 
	 * @param allPosts
	 */
	public void setAllPosts(ArrayList<Post> allPosts) {
		this.allPosts = allPosts;
	}

	/**
	 * create a new post in your blog
	 * @param post
	 */
	public void post(Post post)	{
		//add a post to your blog
		int num = allPosts.size();
		allPosts.add(post);
		//print a message if succeed
		if (++num == allPosts.size()) {
			System.out.println("A new Post:\n" + post);
		}
	}
	
	/**
	 * Delete a post from the blog (Index starts from 1)
	 */
	public void delete(int index) {
		if (--index > -1 && index < allPosts.size()){
			allPosts.remove(index);
		}
		else {
			System.out.println("Illegal deletion. (List index out of bound)");
		}
	}
	
	/**
	 * list all posts in the blog
	 */
	public void list() {
		System.out.println("Current posts: ");
		for (int i = 0; i < allPosts.size(); i++) {
		System.out.println("Post[" + (i + 1) + "]: " + allPosts.get(i));
		}
		
		/*
		for (Post p : allPosts){
			System.out.println(p);
		}
		*/
	}
	
	public void search (int month, String someone) {
		Calendar cal = Calendar.getInstance();
		//search from all posts
		for (Post p: allPosts) {
			//get the current post's month (note that Calendar.Month starts with 0 (Jan), not 1)
			cal.setTime(p.getDate());
			if ((month - 1) == cal.get(Calendar.MONTH)) {
				if (p.contains(someone))
					System.out.println(p);
			}
		}
	}
	/**
	 * 
	 */
	@Override
	public String toString() {
		return user.toString() + "\n" + allPosts.size() + "post(s) in this blog";//allPosts.toString() ;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Blog other = (Blog) obj;
		if (allPosts == null) {
			if (other.allPosts != null)
				return false;
		} else if (!allPosts.equals(other.allPosts))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((allPosts == null) ? 0 : allPosts.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

}
