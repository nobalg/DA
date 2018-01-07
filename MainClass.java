package com.nobalg.Linkedist;

public class MainClass {

	public static void main(String[] args) throws Exception {
		LinkedList list =  new LinkedList(new Node(10));
		list.addAtTail(new Node(20));
		list.addAtTail(new Node(30));
		list.addAtHead(new Node(5));
		System.out.println("Size of linkedlist : "+list.size());
		list.display();
		System.out.println("---------------");
		list.addAtIndex(2, new Node(2));
		list.display();
		System.out.println("----------------");
		list.addAtIndex(0, new Node(1));
		list.display();
		System.out.println("----------------");
		list.deleteAtTail();
		list.display();
		System.out.println("----------------");
	//	System.out.println("Value at index : "+list.getValueAtIndex(8));
		list.deleteAtIndex(4);
		list.display();
		
		
	}

}
