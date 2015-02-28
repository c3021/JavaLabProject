import java.util.Date;


public class FriendsPost extends Post {
	
	public FriendsPost(Date date, String content, User friend){
		super(date, content);
		this.friend = friend;
	}
	
	public void setFriend(User friend) {
	this.friend = friend;
	}
	
	public User getFriend() {
	return friend;
	}
	
	public String toString(){
		return friend.toString() + "\n" + super.toString() ;
	}
	
	public boolean equals(Object o){
	
	if (this.hashCode() == o.hashCode()) return true;
	
	if (o == null) return false;
	
	if (this.getClass().equals(o.getClass())){
		FriendsPost temp = (FriendsPost) o;
		if (this.friend.equals(temp.getFriend()))
			return true;
		else return false;
	}
	}
	
	public int hashCode(){
		return friend.hashCode() * 11;
	}
	private User friend;
}
