package test;

import java.util.ArrayList;
import java.util.LinkedList;


public class GeneralTreeNode<T> {
	
	private T data;
	private GeneralTreeNode<T> leftChild;
	private GeneralTreeNode<T> rightChild;
	
	public GeneralTreeNode(T data) {
		this.data = data;
		leftChild = null;
		rightChild = null;
	}
	
	public T getData() {
		return data;
	}
	
	public GeneralTreeNode<T> getLeftChild() {
		return leftChild;
	}
	
	public void setLeftChild(GeneralTreeNode<T> lc) {
		this.leftChild = lc;
	}
	
	public GeneralTreeNode<T> getRightChild() {
		return rightChild;
	}

	public void setRightChild(GeneralTreeNode<T> rc) {
		this.rightChild = rc;
	}
	
	public boolean search(T key) {
		boolean exist = false;
		
		if (data.equals(key)) {
			return true;
		}
		
		if (leftChild != null) {
			exist = leftChild.search(key);
		}
		
		if (exist == true) {
			return true;
		}
		else if (rightChild != null) {
			exist = rightChild.search(key);
		}
		return false;
	}
	
	public boolean isSymmetric() {
		boolean c1 = false, c2 = false;
		
		ArrayList<GeneralTreeNode<T>> al = new ArrayList<GeneralTreeNode<T>>();
		LinkedList<GeneralTreeNode<T>> ll= new LinkedList<GeneralTreeNode<T>>();
		ll.offer(this);
		al.add(this);
		while (!ll.isEmpty()) {
			LinkedList<GeneralTreeNode<T>> ll2 = new LinkedList<GeneralTreeNode<T>>();
			for (GeneralTreeNode<T> a: ll) {
				if (a.getLeftChild() != null) {
					ll2.offer(a.getLeftChild());
					if (al.size() > 0) {
						if (al.get(al.size() - 1).equals(a.getLeftChild().getData())) {
							al.remove(al.size() - 1);
						}
						else {
							al.add(a.getLeftChild());
						}
					}
					al.add(a.getLeftChild());
				}
				if (a.getRightChild() != null) {
					ll2.offer(a.getRightChild());
					if (al.size() > 0) {
						if (al.get(al.size() - 1).equals(a.getRightChild().getData())) {
							al.remove(al.size() - 1);
						}
						else {
							al.add(a.getRightChild());
						}
					}
					al.add(a.getRightChild());
				}
			}
			ll = ll2;
		}
		
		if (al.size() == 1 && data.equals(al.get(0))) {
			c1 = true;
		}
		
		
		
		return c1 && c2;
	}
	
}
