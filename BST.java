package com.nobalg.BST;

public class BST implements BSTOperations {
	private Node rootNode;
	private int count;
	
	public BST(Node node)
	{
		this.rootNode = node;
		this.count = 1;
	}
	
	/*************O(log n)****************************/
	@Override
	public void insertNode(Node node, int data) {
		Node temp = node;
		if(temp.getData() == data){
			System.out.println("Data Already exists in the BST");
			return;
		}
		else if(temp.getData() > data){
			if(temp.getLeftChildNode() == null){
				temp.setLeftChildNode(new Node(data));
				count++;
			}
			else{
				temp = node.getLeftChildNode();
				insertNode(temp, data);
				
			}
		}
		else if(temp.getData() < data){
			if(temp.getRightChildNode() == null){
				temp.setRightChildNode(new Node(data));
				count++;
			}
			else{

				temp = node.getRightChildNode();
				insertNode(temp, data);
			}
		}
	}
	
	
	public Node findMinInTree(Node node)
	{
		while(node.getLeftChildNode()!=null)
		{
			node = node.getLeftChildNode();
		}
		return node;
	}
	
	public Node findMaxInTree(Node node)
	{
		while(node.getRightChildNode()!=null)
		{
			node = node.getRightChildNode();
		}
		return node;
	}
	
	
	public void deleteNode(Node node,Node parentNode,int data) {
		Node tempNode = node;
		//Node has been found, so delete here
		if(tempNode.getData() == data)
		{
			if(node.isLeafNode())
			{
				if(parentNode.getData()>data)//we need to remove left node of parent
				{
					tempNode = null;
					parentNode.setLeftChildNode(tempNode);
				}
				else//remove right node of parent
				{
					tempNode = null;
					parentNode.setRightChildNode(tempNode);
				}
			}
			else if(node.numberOfChildren() == 1)
			{
				if(node.getLeftChildNode()!=null && parentNode.getData() > node.getLeftChildNode().getData())
				{
					parentNode.setLeftChildNode(node.getLeftChildNode());
				}
				else if(node.getRightChildNode()!=null && parentNode.getData() < node.getRightChildNode().getData())//surely only right child node exists
				{
					parentNode.setRightChildNode(node.getRightChildNode());
				}
				else if(node.getLeftChildNode()!=null && parentNode.getData() < node.getLeftChildNode().getData())
				{
					parentNode.setRightChildNode(node.getLeftChildNode());
				}
				else if(node.getRightChildNode()!=null && parentNode.getData() > node.getRightChildNode().getData())//surely only right child node exists
				{
					parentNode.setLeftChildNode(node.getRightChildNode());
				}
				node=null;
			}
			else if(node.numberOfChildren() == 2)
			{
				//find minimum in right sub tree or find max in the left subtree
				//swap with current node
				//delete the duplicate
				Node mimumNode = findMinInTree(node);
				node.setData(mimumNode.getData());
				Node rightNodeOfNodeToBeDeleted = node.getRightChildNode();
				deleteNode(rightNodeOfNodeToBeDeleted, node, data);
			}
			return;
		}
		else if(tempNode.getData() < data)
		{
			if(tempNode.getRightChildNode() == null){
				return;
			}
			else{
				parentNode = tempNode;
				tempNode = tempNode.getRightChildNode();
				deleteNode(tempNode,parentNode, data);
			}
		}
		else if(tempNode.getData() > data)
		{
			if(tempNode.getLeftChildNode() == null){
				return;
			}
			else{
				parentNode = tempNode;
				tempNode = tempNode.getLeftChildNode();
				deleteNode(tempNode,parentNode, data);
			}
		}
	}
	
	
	public int sizeOfBST(Node node)
	{
		if(node == null)return 0;
		System.out.println(" Visited "+node.getData());
		return 1 +
				sizeOfBST(node.getLeftChildNode()) +
				sizeOfBST(node.getRightChildNode());
		
	}
	
	@Override
	public Node searchNode(Node node,int data) {
		Node temp = node;
		if(temp.getData() == data){
			System.out.println("Data  exists in the BST");
			return temp;
		}
		else if(temp.getData() > data){
			if(temp.getLeftChildNode() == null){
				return null;
			}
			else{
				temp = node.getLeftChildNode();
				return searchNode(temp, data);
				
			}
		}
		else if(temp.getData() < data){
			if(temp.getRightChildNode() == null){
				return null;
			}
			else{

				temp = node.getRightChildNode();
				return searchNode(temp, data);
			}
		}
		return null;
	}
	
	public int nodeCount()
	{
		return count;
	}
	
	
}
