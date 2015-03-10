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
	public int compareTo(User u) throws NullPointerException {
		if (u == null)
			throw new NullPointerException();
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
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userEmail == null) {
			if (other.userEmail != null)
				return false;
		} else if (!userEmail.equals(other.userEmail))
			return false;
		if (userId != other.userId)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((userEmail == null) ? 0 : userEmail.hashCode());
		result = prime * result + userId;
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
		return result;
	}
	
}
