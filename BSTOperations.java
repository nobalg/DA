package com.nobalg.BST;

public interface BSTOperations {
	public void insertNode(Node node, int data);
	public int sizeOfBST(Node node);
	public Node searchNode(Node node,int data);
	public void deleteNode(Node node,Node parentNode,int data);
}
