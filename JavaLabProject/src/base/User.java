package base;

public class User implements Comparable<User>{
	
	private int userId;
	private String userName;
	private String userEmail;
	
	/**
	 * Constructor
	 * @param id
	 * @param name
	 * @param email
	 */
	public User(int id, String name, String email) {
		this.userId = id;
		this.userName = name;
		this.userEmail = email;
	}
	
	/**
	 * 
	 * @return Id of the user
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * 
	 * @param userId
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 
	 * @return
	 */
	public String getUserEmail() {
		return userEmail;
	}

	/**
	 * 
	 * @param userEmail
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	/**
	 * Return 1 if this user・s ID is greater than u・s ID
	 * Return -1 if this user・s ID is less than u・s ID
	 * Return 0 if this user・s ID equals to u・s ID
	 */
	@Override
	public int compareTo(User u) {
		if (u == null)
			return -2;
		else if (userId > u.getUserId())
			return 1;
		else if (userId < u.getUserId())
			return -1;
		else 
			return 0;
	}
	
	/**
	 * Output this object in string format
	 */
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail +"]" ;
	}
	
	/**
	 * Check whether this object equals to o
	 */
	@Override
	public boolean equals(Object o) {
		if (o == null) return false;
		
		if (this.hashCode() == o.hashCode()) return true;
		
		if (this.getClass().equals(o.getClass())){
			User temp = (User) o;
			if (this.userId == temp.getUserId() && this.userName.equals(temp.getUserName()) && this.userEmail.equals(temp.getUserEmail()))
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
		return userName.hashCode() * 17 + userEmail.hashCode();
	}//XXX id.hashCode() * 11 + 
	
}
