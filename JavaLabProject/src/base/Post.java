package base;

import java.util.Date;

public class Post implements Comparable<Post>{
	
	private Date date;
	private String content;
	
	/**
	 * Constructor
	 * @param date
	 * @param content
	 */
	public Post(Date date, String content) {
		this.date = date;
		this.content = content;
	}
	
	/**
	 * 
	 * @return date of the post
	 */
	public Date getDate() {
		return date;
	}
	
	/**
	 * 
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
	/**
	 * 
	 * @return the content of the post in blog
	 */
	public String getContent() {
		return content;
	}
	
	/**
	 * 
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * Case-sensitive checking
	 * @param keyword
	 * @return
	 */
	public boolean contains(String keyword) {
		for (int i = 0; i < (content.length() - keyword.length() + 1); i++) {
			if (content.substring(i, i + keyword.length()).equals(keyword))
				return true;
		}
		return false;
	}
	
	/**
	 * Return 1 if this post・s date is greater than u・s date
	 * Return -1 if this post・s date is less than u・s date
	 * Return 0 if this post・s date equals to u・s date
	 * Option 1: Date can be compared using before() and after() methods of Date
	 * Option 2: Date already implements compareTo(),
	 */
	@Override
	public int compareTo(Post p) {
		if (p == null)
			return -2;
		else if (date.compareTo(p.getDate()) < 0)//else if (date.before(p.getDate()))
			return -1;
		else if (date.compareTo(p.getDate()) > 0)//else if (date.after(p.getDate()))
			return 1;
		else
			return 0;
	}
	
	/**
	 * Output this object in string format
	 */
	@Override
	public String toString() {
		return date.toString() + "\n" + content ;
	}
	
	/**
	 * Check whether this object equals to o
	 */
	@Override
	public boolean equals(Object o) {
		if (o == null) return false;
		
		if (this.hashCode() == o.hashCode()) return true;
		
		if (this.getClass().equals(o.getClass())){
			Post temp = (Post) o;
			if (this.date.equals(temp.getDate()) && this.content.equals(temp.getContent()))
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
		int a = date.hashCode();
		int b= content.hashCode();
		return a*17 + b;
	}
	
}

