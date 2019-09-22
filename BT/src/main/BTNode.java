package main;

public class BTNode {
	BTNode left, right;
	int data;

	public BTNode() {
		left = null;
		right = null;
		data = -1;
	}

	public BTNode(int n) {
		left = new BTNode();
		right = new BTNode();
		data = n;
	}

	public void setLeft(BTNode n) {
		left = n;
	}

	public void setRight(BTNode n) {
		right = n;
	}

	public BTNode getLeft() {
		return left;
	}

	public BTNode getRight() {
		return right;
	}

	public void setData(int d) {
		data = d;
	}

	public int getData() {
		return data;
	}
}