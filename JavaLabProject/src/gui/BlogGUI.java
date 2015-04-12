package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicBorders;

import base.Post;
import base.User;
import blog.Blog;

public class BlogGUI{
	
	private int size;
	private final int charLimit = 140;
	
	private JFrame mainFrame;
	private JTextArea postTextArea;
	private JTextArea postContent;
	private JButton refresh;
	private JButton post;
	private JLabel label;
	private JPanel Textpanel;
	private JPanel TextButtonPanel;
	private Blog myBlog;
	
	private class lengthListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {

		}

		@Override
		public void keyReleased(KeyEvent e) {
			updateTextLimit();
		}

		@Override
		public void keyTyped(KeyEvent e) {
			updateTextLimit();
		}
		
	}
	
	private class postListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String content = postTextArea.getText();
			
			//Check length of content of the post, post content if its length is legal
			if (content.length() == 0) { //post is empty
				System.err.println("Cannot post that is empty");
				return;
			}
			else if (content.length() > 140) { //post content exceed word limit
				System.err.println("Post content has exceeded word limit");
			}
			else {
				//add post to the Blog and its file
				myBlog.post(new Post(new Date(), content));
				myBlog.save(myBlog.getPath());
				
				//display the post in the display area and clear the edit area
				postTextArea.setText("");
				updateTextLimit();
				displayPost();
			}
		}
	}
	
	private class refreshListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			//postContent.setHorizontalAlignment(JTextField.LEFT);
			displayPost();
		}
	}
	
	/**
	 * Constructor
	 */
	public BlogGUI() {
		size = 500;
		
		myBlog = new Blog(new User(1, "A", "a@cse.ust.hk"));
		
		postTextArea = new JTextArea();
		postTextArea.setBackground(new Color(255, 255, 200));
		postTextArea.setLineWrap(true);
		postTextArea.setWrapStyleWord(true);
		postTextArea.addKeyListener(new lengthListener());
		postTextArea.setEditable(true);
		postTextArea.setEnabled(true);
		
		postContent = new JTextArea();
		postContent.setText("Here is put my posts!");
		postContent.setBackground(new Color(240, 240, 240));
		//postContent.setHorizontalAlignment(JTextField.CENTER);
		postContent.setLayout(new FlowLayout());
		postContent.setLineWrap(true);
		postContent.setWrapStyleWord(true);
		postContent.setEditable(false);
		postContent.setEnabled(true);
		
		refresh = new JButton(); //refresh button
		refresh.setText("refresh");
		refresh.setBackground(new Color(180, 200, 220));
		refresh.addActionListener(new refreshListener());
		//refresh.setBorder(new BasicBorders.ButtonBorder(null, null, null, null));
		
		post = new JButton(); //post button
		post.setText("post");
		post.setBackground(new Color(100, 230, 230));
		post.addActionListener(new postListener());
		
		Textpanel = new JPanel();
		TextButtonPanel = new JPanel();
		
		label = new JLabel();
		label.setBorder(new BasicBorders.SplitPaneBorder(Color.GREEN, Color.GREEN));
		updateTextLimit();
		
		Textpanel.setLayout(new BorderLayout());
		Textpanel.add(label, BorderLayout.NORTH);
		Textpanel.add(postTextArea, BorderLayout.CENTER);
		Textpanel.add(TextButtonPanel, BorderLayout.SOUTH);
		Textpanel.setBorder(new BasicBorders.SplitPaneBorder(Color.YELLOW, Color.CYAN));
		
		//TextButtonPanel.setLayout(new BorderLayout());
		//TextButtonPanel.add(refresh, BorderLayout.WEST);
		//TextButtonPanel.add(post, BorderLayout.EAST);
		TextButtonPanel.setLayout(new GridLayout(1, 2));
		TextButtonPanel.setBorder(new BasicBorders.SplitPaneBorder(Color.YELLOW, Color.CYAN));
		TextButtonPanel.add(refresh);
		TextButtonPanel.add(post);
		
	}
	
	/**
	 * 
	 */
	public void setWindow() {
		mainFrame = new JFrame("Micro Blog");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(size,size);
		mainFrame.setLayout(new GridLayout(2, 1));
		mainFrame.add(Textpanel);
		mainFrame.add(postContent);
		//mainFrame.setLayout(new BoxLayout(Component.CENTER_ALIGNMENT, BoxLayout.Y_AXIS));
		mainFrame.setVisible(true);
	}
	
	public void updateTextLimit() {
		if (postTextArea.getText().length() <= charLimit) {
		label.setText("You can still input " + (charLimit - postTextArea.getText().length()) + " characters"); //Label show charRemain
		}
		else {
			label.setText("Your post length has exceeded " + charLimit + "! (Now post length = " + postTextArea.getText().length() + "");//Label shows limit exceeded!
		}
	}
	
	public void displayPost() {
		String content = myBlog.getUser().getUserName() + "'s current posts: \n";
		
		for (int i = 0; i < myBlog.getAllPosts().size(); i++) {
			content += "Post[" + (i + 1) + "]: " + myBlog.getAllPosts().get(i) + "\n";
		}
		postContent.setText(content);
	}
	
	/*lab6
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == post) {
			postContent.setText("You click POST!");
			//postContent.setText(postTextArea.getText());
			}
		else if (e.getSource() == refresh) {
			postContent.setText("You click REFRESH!");
			}
		}*/
	/*
	if(e.getSource() == postContent) {
		if (postTextArea.getText().length() <= charLimit) {
			charRemain = charLimit - postTextArea.getText().length();
			}
		else {
			charRemain = 0;
			postTextArea.setText(postTextArea.getText().substring(0, charLimit));
			}
	}
		*/
	
	public static void main(String[] args) {
		BlogGUI blogGUI = new BlogGUI();
		blogGUI.setWindow();
	}
	
}
