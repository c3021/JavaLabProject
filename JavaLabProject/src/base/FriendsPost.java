package base;

import java.util.Date;

public class FriendsPost extends Post {
	
	private User friend;
	
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
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		FriendsPost other = (FriendsPost) obj;
		if (friend == null) {
			if (other.friend != null)
				return false;
		} else if (!friend.equals(other.friend))
			return false;
		return true;
	}
	
	/**
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((friend == null) ? 0 : friend.hashCode());
		return result;
	}
	
}
