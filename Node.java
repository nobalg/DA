package com.nobalg.BT;

public class Node {
	private Node leftNode;
	private Node rightNode;
	private int data;
	public Node(int data)
	{
		this.data=data;
	}
	public void setLeftNode(Node node)
	{
		this.leftNode = node;
	}
	public void setRightNode(Node node)
	{
		this.rightNode = node;
	}
	public Node getRightNode()
	{
		return this.rightNode;
	}
	public Node getLeftNode()
	{
		return this.leftNode;
	}
	public int getData() {
		return data;
	}
	
}
