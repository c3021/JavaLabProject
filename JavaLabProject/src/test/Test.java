package test;


/**
 * 
 * @author Xiaodong
 * 
 */
public class Test {
	public static void main(String[] args) {
		TreeNode tree = new TreeNode(66);
		TreeNode ch1 = new TreeNode(54);
		TreeNode ch2 = new TreeNode(107);
		ch1.setLeftChild(new TreeNode(1));
		ch1.setRightChild(new TreeNode(22));
		tree.setLeftChild(ch1);
		tree.setRightChild(ch2);
		System.out.println(tree.getLeftChild().getRightChild().getData() + "");
		System.out.println("data:" + tree.toString());

		GeneralTreeNode<Double> doubTree = new GeneralTreeNode<Double>(0.02);
		doubTree.setLeftChild(new GeneralTreeNode<Double>(0.03));
		doubTree.setRightChild(new GeneralTreeNode<Double>(0.04));
		GeneralTreeNode<String> strTree = new GeneralTreeNode<String>(
				"Comp3021");
		strTree.setLeftChild(new GeneralTreeNode<String>("src"));
		strTree.setRightChild(new GeneralTreeNode<String>("lib"));
		strTree.getLeftChild()
				.setLeftChild(new GeneralTreeNode<String>("blog"));
		strTree.getLeftChild()
				.setRightChild(new GeneralTreeNode<String>("gui"));
		System.out.println(strTree.getLeftChild().getRightChild().getData());

		boolean doubExist = doubTree.search(0.01);
		boolean strExist = strTree.search("blog");
		System.out.println(doubExist);
		System.out.println(strExist);
		System.out.println(doubTree.isSymmetric());
	}

}
