package base;

import java.io.Serializable;
import java.util.Date;

public class Post implements Comparable<Post>, Serializable{
	
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
			throw new NullPointerException();
		else
			return date.compareTo(p.getDate());
	}
	
	/**
	 * Output this object in string format
	 */
	@Override
	public String toString() {
		return date.toString() + "\n" + content ;
	}
	
	/**
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		return true;
	}
	
	/**
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		return result;
	}
	
}

