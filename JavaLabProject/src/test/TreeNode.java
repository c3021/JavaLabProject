package test;

import java.util.ArrayList;
import java.util.LinkedList;


public class TreeNode {
	
	private int data;
	private TreeNode leftChild;
	private TreeNode rightChild;
	
	public TreeNode(int data) {
		this.data = data;
		leftChild = null;
		rightChild = null;
	}
	
	public int getData() {
		return data;
	}
	
	public TreeNode getLeftChild() {
		return leftChild;
	}
	
	public void setLeftChild(TreeNode lc) {
		this.leftChild = lc;
	}
	
	public TreeNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(TreeNode rc) {
		this.rightChild = rc;
	}
	
	@Override
	public String toString() {
		ArrayList<TreeNode> al = new ArrayList<TreeNode>();
		LinkedList<TreeNode> ll= new LinkedList<TreeNode>();
		ll.offer(this);
		al.add(this);
		while (!al.isEmpty()) {
			ArrayList<TreeNode> al2 = new ArrayList<TreeNode>();
			for (TreeNode a: al) {
				if (a.getLeftChild() != null) {
					ll.offer(a.getLeftChild());
					al2.add(a.getLeftChild());
				}
				if (a.getRightChild() != null) {
					ll.offer(a.getRightChild());
					al2.add(a.getRightChild());
				}
			}
			al = al2;
		}
		
		String str = "";
		while (!ll.isEmpty()) {
			str = str + ll.poll().getData() + " ";
		}
		str = str.trim();
		return str;
	}
	
	private LinkedList<String> ref(LinkedList<String> ll, TreeNode n, int lev) {
		
		TreeNode lc =n.getLeftChild();
		TreeNode rc=n.getRightChild();
		if (lc != null) {
			ll.offer(""+lc.getData());
			
		}
		
		if (rc != null) {
			ll.offer(""+rc.getData());
			
		}
		if (lc != null) {
			ref(ll, n.getLeftChild(), lev+1);
			
		}
		if (rc != null) {
			ref(ll, n.getRightChild(), lev+1);
			
		}
	
		return ll;
	}
	
}
