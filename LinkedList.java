package com.nobalg.Linkedist;


class Node{
	int data;
	Node next;
	public Node(int data)
	{
		this.data = data;
	}
}
/**
 * Vital checks:
 *1. If the list is empty
 *2. If the head and the tail are the same
 * */
public class LinkedList implements Operations
{
	Node headNode;
	Node tailNode;
	int count = 0;
	
	public LinkedList(Node node)
	{
		if(node==null)throw  new IllegalStateException();
		this.headNode = node;
		this.tailNode = node;
	}
	
	/**********This method takes O(n) time************/
	public void addNode(Node node)
	{
		Node temp = this.headNode;
		while(temp.next!=null){
			 temp = temp.next;
		}
		temp.next = node;
		count++;
	}

	/******This operation takes O(1) time********/
	public void addAtTail(Node node)
	{
		this.tailNode.next = node;
		tailNode = tailNode.next;
		count++;
	}
	

	/********This operation takes O(1) time**************/
	public void addAtHead(Node node)
	{
		node.next = this.headNode;
		this.headNode = node;
		count++;
	}

	/************This operation takes  O(i) time****************/
	public void addAtIndex(int index,Node node)
	{
		if(index < 0 || index >count)
		{
			throw new IllegalStateException();
		}
		Node tempLast = this.headNode;
		Node tempCurrent = this.headNode;
		int locCount = 0;
		while(locCount!=index)
		{
			tempLast = tempCurrent;
			tempCurrent = tempCurrent.next;
			locCount++;
		}
		node.next = tempCurrent;
		if(index == 0)this.headNode = node;
		else tempLast.next = node;
		count++;
	}
	
	/**********This operation takes O(n) time in case of singly linked list*************/
	public void deleteAtTail()
	{
		if(count == 1){
			this.headNode = null;
			this.tailNode = null;
			return;
		}
		Node temp = this.headNode;
		Node locLastNode = null;
		while(temp.next!=null)
		{
			locLastNode = temp;
			temp = temp.next;
		}
		this.tailNode = locLastNode;
		tailNode.next = null;
		count--;
	}
	
	/****************O(1) time*******************/
	public void deleteAtHead()
	{
		if(count==1)
		{
			this.headNode = null;
			this.tailNode = null;
			return;
		}
		Node secondNode = this.headNode.next;
		this.headNode = secondNode;
		count--;
	}

	/************This method takes O(i) time***************/
	@Override
	public void deleteAtIndex(int index)throws Exception 
	{
		if(count < 0 || index>count)throw new Exception("Index is not valid");
		else if(count==1)
		{
			this.headNode = null;
			this.tailNode = null;
			return;
		}
		Node temp = this.headNode;
		Node lastNode = this.headNode;
		int locCount = 0;
		while(locCount!=index)
		{
			locCount++;
			lastNode = temp;
			temp = temp.next;
		}
		lastNode.next = temp.next;
		temp=null;
		count--;
	}

	@Override
	public int size() {
		return count;
	}

	public void display()
	{
		Node temp = this.headNode;
		while(temp.next!=null)
		{
			System.out.println(temp.data);
			temp = temp.next;
		}
		System.out.println(temp.data);
	}

	/**************This method takes O(i) time*****************/
	@Override
	public int getValueAtIndex(int index) throws Exception {
		if(index < 0 || index >count)
		{
			throw new Exception("Index is not valid");
		}
		int locCount = 0;
		Node temp = this.headNode;
		do{
			if(locCount == index)
				return temp.data;
			temp = temp.next;
			locCount++;
		}while(temp!=null);
		return 0;
	}	
}