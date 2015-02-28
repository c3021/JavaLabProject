
public class User {
	
	User(int id, String name, String email){
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString(){
		return "User [userId=" + id + ", userName=" + name + ", userEmail=" + email +"]" ;
	}
	
	public int hashCode(){
		return name.hashCode() * 17 + email.hashCode();
	}//XXX id.hashCode() * 11 + 
	
	public boolean equals(Object o){
		
		if (this.hashCode() == o.hashCode()) return true;
		
		if (o == null) return false;
		
		if (this.getClass().equals(o.getClass())){
			User temp = (User) o;
			if (this.name.equals(temp.getName()) && this.email.equals(temp.getEmail()))
				return true;
			else return false;
		}
	}
	
	private int id;
	private String name;
	private String email;
}
