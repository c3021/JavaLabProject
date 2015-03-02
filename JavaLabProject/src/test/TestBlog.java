package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

import base.Post;
import base.User;
import blog.Blog;

public class TestBlog {

	/**
	 * Sample in put :
	 * post Hello! This is my first post.
	 * post Welcome to my blog!
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestBlog testBlog = new TestBlog();
		User user = new User(1, "COMP3021", "COMP3021@cse.ust.hk");
		Blog myblog = new Blog(user);
		String prompt = null;
		
		while (!(prompt = testBlog.getInput()).equals("exit")) {
			//String prompt already stores the input
			
			if (prompt.startsWith("list")) {
				myblog.list();
			}
			else if (prompt.startsWith("post")) {
				if (prompt.length() > 5 && prompt.charAt(4) == ' ') {
					Post post = new Post(new Date(), prompt.substring(5));
					myblog.post(post);
				}
				else {
					System.out.println("Nothing has changed in your blog.");
				}
			}
			else if (prompt.startsWith("delete")) {
				//Delete the post at the index parameter
				if (prompt.length() > 7) {
					//String prompt format: delete index
					try {
						myblog.delete(Integer.parseInt(prompt.split(" ")[1]));
					}
					catch (Exception e) {
						System.out.println("Nothing has deleted in your blog.");
						continue;
					}
				}
				else if (prompt.length() == 6 || prompt.length() == 7 && prompt.charAt(6) == ' ') {
					//String prompt format: delete
					try {
					myblog.delete(Integer.parseInt(testBlog.getInput()));
					}
					catch (Exception e) {
						System.out.println("Nothing has deleted in your blog.");
						continue;
					}
				}
				else {
					System.out.println("Nothing has deleted in your blog.");
				}
			}
		}
	}

	/**
	 * Get user's input
	 * @return
	 */
	public String getInput() {
		String line = "";
		System.out.println("Enter the prompt: ");
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			line = reader.readLine();
		}
		catch (IOException e){
			e.printStackTrace();
		}
		return line;
	}
}
