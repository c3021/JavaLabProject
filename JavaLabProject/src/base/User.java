package base;

public class User {
	
	/**
	 * Constructor
	 * @param id
	 * @param name
	 * @param email
	 */
	public User(int id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	/**
	 * 
	 * @return Id of the user
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Output this object in string format
	 */
	@Override
	public String toString() {
		return "User [userId=" + id + ", userName=" + name + ", userEmail=" + email +"]" ;
	}
	
	/**
	 * Check whether this object equals to o
	 */
	@Override
	public boolean equals(Object o) {
		if (this.hashCode() == o.hashCode()) return true;
		
		//TODO if (o == null) return false;
		
		if (this.getClass().equals(o.getClass())){
			User temp = (User) o;
			if (this.name.equals(temp.getName()) && this.email.equals(temp.getEmail()))
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
		return name.hashCode() * 17 + email.hashCode();
	}//XXX id.hashCode() * 11 + 
	
	private int id;
	private String name;
	private String email;
}
