package test;

import java.util.ArrayList;
import java.util.LinkedList;

import test.TestAny.t1;


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
		boolean c1 = true, c2 = true;
		
		ArrayList<GeneralTreeNode<T>> al = new ArrayList<GeneralTreeNode<T>>();
		al.add(this);
		while (!al.isEmpty()) {
			ArrayList<GeneralTreeNode<T>> al2 = new ArrayList<GeneralTreeNode<T>>();
			for (GeneralTreeNode<T> tn: al) {
				if (tn.getLeftChild() != null) {
					al2.add(tn.getLeftChild());
				}
				if (tn.getRightChild() != null) {
					al2.add(tn.getRightChild());
				}
			}
			if(al2.size() % 2 == 1) {
				c1 = false;
				al.clear();
				break;
			}
			al = al2;
			ArrayList<T> dl = new ArrayList<T>();
			for (GeneralTreeNode<T> tn: al2) {
				if (dl.isEmpty()) {
					dl.add(tn.data);
				}
				else {
					if (tn.data.equals(dl.get(dl.size() - 1))) {
						dl.remove(dl.size() - 1);
					}
					else {
						dl.add(tn.data);
					}
				}
			}
			if (!dl.isEmpty()) {
				c1 = false;
				break;
			}
		}
		
		al.clear();
		al.add(this.leftChild);
		al.add(this.rightChild);
		while (!isAllEmpty(al)) {
			for (int i = 0; i < al.size() / 2; i++) {
				if ((al.get(i) == null && al.get(al.size() - 1 - i) != null) || al.get(i) != null && al.get(al.size() - 1 - i) == null ) {
					c2 = false;
					al.clear();
					break;
				}
			}
			ArrayList<GeneralTreeNode<T>> al2 = new ArrayList<GeneralTreeNode<T>>();
			for (GeneralTreeNode<T> tn: al) {
				if (tn != null) {
					al2.add(tn.leftChild);
					al2.add(tn.rightChild);
				}
			}
			al = al2;
		}
		
		return c1 && c2;
	}
	private boolean isAllEmpty(ArrayList<GeneralTreeNode<T>> l) {
		for (GeneralTreeNode<T> tn: l) {
			if (tn != null)
				return false;
		}
		return true;
	}
}
