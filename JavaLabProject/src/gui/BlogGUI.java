package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BlogGUI {
	private int size;
	private int charLimit;
	private JFrame mainFrame;
	private JTextArea postTextArea;
	private JTextField postContent;
	private JButton refresh;
	private JButton post;
	private JLabel label;
	private JPanel Textpanel;
	private JPanel TextButtonPanel;
	
	public BlogGUI() {
		size = 300;
		charLimit =140;
		
		postTextArea = new JTextArea();
		//postTextArea.setSize(size, size/2);
		postContent = new JTextField();
		//postContent.setSize(size, size/2);
		
		refresh = new JButton();
		refresh.setText("refresh");
		post = new JButton();
		post.setText("post");
		
		Textpanel = new JPanel();
		
		TextButtonPanel = new JPanel();
		//TextButtonPanel.setSize(size, size/2);
		
		label = new JLabel();
		label.setText("You can still input " + charLimit + " characters");
		Textpanel.setLayout(new BorderLayout());
		Textpanel.add(label, BorderLayout.NORTH);
		Textpanel.add(postTextArea, BorderLayout.CENTER);
		Textpanel.add(TextButtonPanel, BorderLayout.SOUTH);
		
		//TextButtonPanel.setLayout(new BorderLayout());
		//TextButtonPanel.add(refresh, BorderLayout.WEST);
		//TextButtonPanel.add(post, BorderLayout.EAST);
		TextButtonPanel.setLayout(new GridLayout(1, 2));
		//TextButtonPanel.setLayout(new GridLayout());
		TextButtonPanel.add(refresh);
		TextButtonPanel.add(post);
		
	}
	
	public void setWindow() {
		//private JFrame?
		mainFrame = new JFrame("Your Name");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(size,size);
		mainFrame.setLayout(new BorderLayout());
		mainFrame.add(Textpanel, BorderLayout.NORTH);
		mainFrame.add(postContent, BorderLayout.SOUTH);
		mainFrame.setVisible(true);
	}
	
	public static void main(String[] args) {
		BlogGUI blogGUI = new BlogGUI();
		blogGUI.setWindow();
	}
}
