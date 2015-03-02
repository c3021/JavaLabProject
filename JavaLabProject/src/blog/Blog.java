package blog;

import java.util.ArrayList;

import base.Post;
import base.User;

public class Blog {

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
	 * 
	 */
	@Override
	public String toString() {
		return user.toString() + "\n" + allPosts.size() + "post(s) in this blog";//allPosts.toString() ;
	}
	
	/**
	 * Check whether this object equals to o
	 */
	@Override
	public boolean equals(Object o) {
		
		if (this.hashCode() == o.hashCode()) return true;
		
		//TODO if (o == null) return false;
		
		if (this.getClass().equals(o.getClass())){
			Blog temp = (Blog) o;
			if (this.user.equals(temp.getUser()) && this.allPosts.equals(temp.getAllPosts()))
				return true;
			else return false;
		}
		return false;
	}
	
	/**
	 * 
	 */
	@Override
	public int hashCode() {
		return user.hashCode() * 11 + allPosts.hashCode();
	}
	
	private User user;
	private ArrayList<Post> allPosts;
}
