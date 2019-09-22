package main;
import java.util.ArrayList;
import java.util.List;

/* Class BT */
public class BT {
	private BTNode root;

	public BT() {
		root = null;
	}

	public BTNode insert(int data) {
		root = insert(root, data);
		return root;
	}
	private BTNode insert(BTNode node, int data) {
		if (node == null){
			node = new BTNode(data);
			System.out.println("Inserted as root node : " + data);
		} else if (data < node.data){
			if (node.left.data != -1){
				insert(node.left, data);
			} else{
				System.out.println("Inserted " + data + " to left of Node " + node.data);
				node.left = new BTNode(data);
			}
		} else if (data > node.data){
			if (node.right.data != -1){
				insert(node.right, data);
			} else{
				System.out.println("Inserted " + data + " to right of Node " + node.data);
				node.right = new BTNode(data);
			}
		}
		return node;
	}

	
	private void simplifyNodes(BTNode root, int height) {
		
		if(root.left == null && height > 0) {
			root.left = new BTNode();
			simplifyNodes(root.left, height-1);
		}if(root.right == null && height > 0) {
			root.right = new BTNode();
			simplifyNodes(root.right, height-1);
		}if(height > 0) {
			simplifyNodes(root.right, height-1);
			simplifyNodes(root.left, height-1);
		}
	}
	
	
	public int findDistance(int first, int second, int level) {
		int height = maxDepth(root)-1;
		simplifyNodes(root, height);
		return findDistance(first, second, level, root);
	}
	private int findDistance(int first, int second, int level, BTNode root) {
		List<Integer> order = new ArrayList<>();
		List<Integer> list = printGivenLevel(root, level, order);
		if (list.contains(first) && list.contains(second)){
			int counter = 0;
			boolean flag = false;
			for (Integer i : list){
				if (i == first || i == second){
					flag = flag ? false : true;
					counter++;
				} else if (flag){
					counter++;
				}
			}
			System.out.println("Distance is :" + (counter - 2));
			return (counter - 2);
		} else{
			System.out.println("Given nodes for calculating distance are not from same level");
			System.out.println("Node 1:" + first + " , Node 2:" + second);
			System.out.println("Available nodes are:");
			list.stream().filter(e -> e != -1).forEach(System.out::println);
			return 0;
		}
	}

	public void printGivenLevel(int level) {
		printGivenLevel(root, level, new ArrayList<>());
	}
	static List<Integer> printGivenLevel(BTNode root, int level, List<Integer> order) {
		if (root == null) 
			return order;
		if (level == 1){
			order.add(root.data);
			if(root.data != -1)
				System.out.print(root.data + "  ");
		} else if (level > 1){
			printGivenLevel(root.left, level - 1, order);
			printGivenLevel(root.right, level - 1, order);
		}
		return order;
	}

	public int maxDepth() {
		return maxDepth(root);
	}

	private static int maxDepth(BTNode node) {
		if (node == null)
			return 0;
		else{
			int lDepth = maxDepth(node.left);
			int rDepth = maxDepth(node.right);

			if (lDepth > rDepth)
				return (lDepth + 1);
			else return (rDepth + 1);
		}
	}
}