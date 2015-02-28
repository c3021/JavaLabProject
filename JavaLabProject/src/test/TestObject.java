package test;

import base.User;
import base.FriendsPost;

import java.util.Date;

/**
 * 
 * Testing Classes : User.java, Post.java, FriendsPost.java
 *
 */
public class TestObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user = new User(1, "COMP3021", "COMP3021@cse.ust.hk");
		Date date = new Date();
		String content = "This is my first post";
		FriendsPost postFromFriend = new FriendsPost(date, content, user);
		System.out.println(postFromFriend);
		System.out.println(postFromFriend.contains("first"));
		System.out.println(postFromFriend.contains("HKUST"));
		
	}

}
