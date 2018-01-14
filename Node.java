package com.nobalg.BST;

public class Node {
	private Node leftChildNode;
	private Node rightChildNode;
	private int data;
	public Node(int data)
	{
		this.data = data;
	}
	public Node getLeftChildNode() {
		return leftChildNode;
	}
	public void setLeftChildNode(Node leftChildNode) {
		this.leftChildNode = leftChildNode;
	}
	public Node getRightChildNode() {
		return rightChildNode;
	}
	public void setRightChildNode(Node rightChildNode) {
		this.rightChildNode = rightChildNode;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public boolean isLeafNode()
	{
		if(this.getLeftChildNode() == null && this.getRightChildNode() == null)
		{
			return true;
		}
		return false;
	}
	public int numberOfChildren()
	{
		int count = 0;
		if(this.getLeftChildNode() != null)count++;
		if(this.getRightChildNode() != null)count++;
		return count;
	}
	
	
}
