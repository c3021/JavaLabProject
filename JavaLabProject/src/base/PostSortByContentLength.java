package base;

import java.util.Comparator;

public class PostSortByContentLength implements Comparator<Post> {

	/**
	 * Return 1 if p1 is greater than p2 (in terms of the length of post content)
	 * Return -1 if p1 is less than p2
	 * Return 0 if p1 equals to p2
	 */
	@Override
	public int compare(Post p1, Post p2) {
		if (p1 == null || p2 == null)
			throw new NullPointerException();
		else if (p1.getContent().length() < p2.getContent().length())
			return -1;
		else if (p1.getContent().length() > p2.getContent().length())
			return 1;
		else
			return 0;
	}
}
