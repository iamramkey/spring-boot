package com.iamramkey.springboot.starter;

public class BinarySearchTree {

	private TreeNode root;
	
	public void smallest() {
		System.out.println("Smallest : " + this.root.smallest());
	}
	
	public void largest() {
		System.out.println("Smallest : " + this.root.largest());
	}

	public void insert(Integer data) {
		if (this.root == null) {
			this.root = new TreeNode(data);
		} else {
			this.root.insertNode(data);
		}
	}

	public TreeNode find(Integer data) {
		if (this.root != null) {
			this.root.find(data);
		}
		return null;
	}

	public TreeNode find1(Integer data) {

		TreeNode node = this.root;
		while (node != null) {
			if (node.getData() == data) {
				return node;
			} else if (node.getData() < data) {
				node = node.getLeft();
			} else if (node.getData() > data) {
				node = node.getRight();
			}
		}

		return null;
	}

	public TreeNode delete(Integer data) {

		TreeNode current = this.root;
		TreeNode parent = this.root;
		Boolean isLeftChild = false;

		if (current == null) {
			return null;
		}

		while (current != null && current.getData() != data) {
			parent = current;

			if (data < current.getData()) {
				current = current.getLeft();
				isLeftChild = true;
			} else if (data > current.getData()) {
				current = current.getRight();
				isLeftChild = false;
			}
		}

		if (current == null) {
			return null;
		}

		if (current.getLeft() == null && current.getRight() == null) {
			if (current == this.root) {
				this.root = null;
			} else {
				if (isLeftChild) {
					parent.setLeft(null);
				} else {
					parent.setRight(null);
				}
			}
		} else if (current.getRight() == null && current.getLeft() != null) {
			if (current == root) {
				root = current.getLeft();
			} else if (isLeftChild) {
				parent.setLeft(current.getLeft());
			} else {
				parent.setRight(current.getLeft());
			}
		} else if (current.getRight() != null && current.getLeft() == null) {
			if (current == root) {
				root = current.getRight();
			} else if (isLeftChild) {
				parent.setLeft(current.getRight());
			} else {
				parent.setRight(current.getRight());
			}
		}

		return null;
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(50);
		bst.insert(70);
		bst.insert(40);
		bst.insert(30);
		bst.insert(39);
		bst.insert(20);
		bst.insert(29);
		bst.insert(10);
		bst.insert(19);
		bst.insert(65);
		bst.insert(75);
		bst.insert(60);
		bst.insert(66);
		bst.insert(80);

		System.out.println(bst);
	}
}

class TreeNode {
	private Integer data;
	private TreeNode left;
	private TreeNode right;

	public TreeNode(Integer data) {
		super();
		this.data = data;
	}

	public Integer smallest() {
		if (this.left == null) {
			return this.data;
		} else {
			return this.left.smallest();
		}
	}
	
	public Integer largest() {
		if (this.right == null) {
			return this.data;
		} else {
			return this.right.largest();
		}
	}

	public Integer getData() {
		return data;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public TreeNode find(Integer data) {
		if (this.data == data) {
			return this;
		} else if (this.data < data && this.left != null) {
			this.left.find(data);
		} else if (this.data > data && this.data != null) {
			this.right.find(data);
		}
		return null;
	}

	public void insertNode(Integer data) {
		if (this.data > data) {
			if (this.right == null) {
				this.right = new TreeNode(data);
			} else {
				this.right.insertNode(data);
			}
		} else {
			if (this.left == null) {
				this.left = new TreeNode(data);
			} else {
				this.left.insertNode(data);
			}
		}
	}

	@Override
	public String toString() {
		return "TreeNode [data=" + data + "]";
	}

}