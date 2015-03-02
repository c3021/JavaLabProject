package base;

import java.util.Date;

public class FriendsPost extends Post {
	
	/**
	 * Constructor
	 * @param date
	 * @param content
	 * @param friend
	 */
	public FriendsPost(Date date, String content, User friend) {
		super(date, content);
		this.friend = friend;
	}
	
	/**
	 * 
	 * @param friend
	 */
	public void setFriend(User friend) {
	this.friend = friend;
	}
	
	/**
	 * 
	 * @return
	 */
	public User getFriend() {
	return friend;
	}

	/**
	 * Output this object in string format
	 */
	@Override
	public String toString() {
		return friend.toString() + "\n" + super.toString() ;
	}
	
	/**
	 * Check whether this object equals to o
	 */
	@Override
	public boolean equals(Object o) {
		if (this.hashCode() == o.hashCode()) return true;
		
		//TODO if (o == null) return false;
		if (this.getClass().equals(o.getClass())){
			FriendsPost temp = (FriendsPost) o;
			if (this.friend.equals(temp.getFriend()))
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
		return friend.hashCode() * 11;
	}
	
	private User friend;
	
}
