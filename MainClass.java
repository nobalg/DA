package com.nobalg.BT;

public class MainClass {
	public static void  main(String args[])
	{
		Node rootNode = new Node(5);
		BT bt = new BT(rootNode);
		bt.performInsert(10);
		bt.performInsert(20);
		bt.performInsert(30);
		bt.performInsert(40);
		bt.performInsert(50);
		bt.performInsert(60);
		bt.performInsert(70);
		bt.traverse(rootNode);
	}
}
