package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicBorders;

public class BlogGUI implements ActionListener{
	
	private int size;
	private final int charLimit = 160;
	private int charRemain;
	
	private JFrame mainFrame;
	private JTextArea postTextArea;
	private JTextField postContent;
	private JButton refresh;
	private JButton post;
	private JLabel label;
	private JPanel Textpanel;
	private JPanel TextButtonPanel;
	
	/**
	 * Constructor
	 */
	public BlogGUI() {
		size = 300;
		charRemain =charLimit;
		
		postTextArea = new JTextArea();
		//postTextArea.setBorder();
		postTextArea.setBackground(new Color(255, 255, 200));
		//postTextArea.setSize(size, size/2);
		
		postContent = new JTextField();
		//postContent.setSize(size, size/2);
		postContent.setText("Here is put my posts!");
		postContent.setBackground(new Color(240, 240, 240));
		postContent.addActionListener(this);
		
		//refresh button
		refresh = new JButton();
		refresh.setText("refresh");
		refresh.setBackground(new Color(180, 200, 220));
		refresh.addActionListener(this);
		
		//post button
		post = new JButton();
		post.setText("post");
		post.setBackground(new Color(100, 230, 230));
		post.addActionListener(this);
		
		Textpanel = new JPanel();
		Textpanel.setBorder(new  BasicBorders.FieldBorder(Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW));
		
		TextButtonPanel = new JPanel();
		//TextButtonPanel.setSize(size, size/2);
		
		label = new JLabel();
		label.setText("You can still input " + charRemain + " characters");
		label.setBorder(new BasicBorders.SplitPaneBorder(Color.GREEN, Color.GREEN));
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
		//TextButtonPanel.setLayout(new GridLayout());
		TextButtonPanel.add(refresh);
		TextButtonPanel.add(post);
		
	}
	
	/**
	 * 
	 */
	public void setWindow() {
		//private JFrame?
		mainFrame = new JFrame("Micro Blog");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(size,size);
		mainFrame.setLayout(new GridLayout(2, 1));
		mainFrame.add(Textpanel);
		mainFrame.add(postContent);
		//mainFrame.setLayout(new BoxLayout(Component.CENTER_ALIGNMENT, BoxLayout.Y_AXIS));
		mainFrame.setVisible(true);
	}
	
	/**
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == post) {
			postContent.setText("You click POST!");
			//postContent.setText(postTextArea.getText());
			}
		else if (e.getSource() == refresh) {
			postContent.setText("You click REFRESH!");
			}
		}
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
