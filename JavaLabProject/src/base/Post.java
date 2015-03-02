package base;

import java.util.Date;

public class Post {
	
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
	 * 
	 * @param keyword
	 * @return
	 */
	public boolean contains(String keyword) {
		String[] wordArr = content.split(" ");
		for (String word: wordArr){
			if (word.equals(keyword)) return true;
		}
		return false;
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
		
		if (this.hashCode() == o.hashCode()) return true;
		
		//TODO if (o == null) return false;
		
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
	
	private Date date;
	private String content;
	
}

