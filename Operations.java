package com.nobalg.Linkedist;

public interface Operations {
	
	public void addNode(Node nodeData);
	public void addAtTail(Node nodeData);
	public void addAtHead(Node nodeData);
	public void addAtIndex(int index,Node nodeData);
	public void deleteAtTail();
	public void deleteAtHead();
	public void deleteAtIndex(int index) throws Exception;
	public int getValueAtIndex(int index) throws Exception;
	public int size();
	public void display();
}
