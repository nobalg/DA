package com.nobalg.BT;

import java.util.LinkedList;
import java.util.Queue;

public class BT {
	public int count;
	private Node rootNode;
	private Queue<Node> queue;
	Queue<Node> tempQueue;
	public BT(Node rootNode)
	{
		queue =  new LinkedList<>(); 
		this.rootNode = rootNode;
		queue.add(rootNode);
	}
	public void insert(int data)
	{
		Node presentNode = tempQueue.poll();
		System.out.println(presentNode.getData());
		Node nodeToBeAdded = new Node(data);
		if(presentNode.getLeftNode() == null){
			presentNode.setLeftNode(nodeToBeAdded);
			queue.add(nodeToBeAdded);
		}
		else if(presentNode.getRightNode() == null){
			presentNode.setRightNode(nodeToBeAdded);
			queue.add(nodeToBeAdded);
		}
		else
		{
			insert(data);
		}
	}
	
	public void traverse(Node node)
	{
		if(node == null)return;
		else{
			System.out.println("Node visited : "+node.getData());
			traverse(node.getLeftNode());
			traverse(node.getRightNode());
		}
	}
	public void performInsert(int data)
	{
		Node rootNode = this.rootNode;
		tempQueue = new LinkedList<>(queue);
		insert(data);
	}
}
