
//package base;

import java.util.Date;

public class Post {
	
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
	 * Constructor
	 * @param date
	 * @param content
	 */
	public Post(Date date, String content){
		this.date = date;
		this.content = content;
	}
	
	/**
	 * 
	 */
	public String toString(){
		return date.toString() + "\n" + content ;
	}
	/**
	 * 
	 * @param keyword
	 * @return
	 */
	public boolean contains(String keyword){
		String[] wordArr = content.split(" ");
		for (String word: wordArr){
			if (word.equals(keyword)) return true;
		}
		return false;
	}
	
	/**
	 * 
	 */
	public boolean equals(Object o){
		
		if (this.hashCode() == o.hashCode()) return true;
		
		if (o == null) return false;
		
		if (this.getClass().equals(o.getClass())){
			Post temp = (Post) o;
			if (this.date.equals(temp.getDate()) && this.content.equals(temp.getContent()))
				return true;
			else return false;
		}
	}
	
	/**
	 * 
	 */
	public int hashCode(){
		int a = date.hashCode();
		int b= content.hashCode();
		return a*17 + b;
	}
	
	private Date date;
	private String content;

	
}

