package com.bridgelabz.linkedlist;

public class MyLinkedLists<K> {
	private MyNode<K> head;
	private MyNode<K> tail;

	/*
	 * public void add(K key) { // key value is stored in newNode MyNode<K> newNode
	 * = new MyNode<K>(key);
	 * 
	 * // if head is null then newNode value is stored head and tail if (head ==
	 * null) { head = newNode; tail = newNode; } // if head is not null then newNode
	 * of next value is stored in head else { newNode.setNext(head); head = newNode;
	 * } }
	 */
	public void append(K key) {
		// key value is stored in newNode
		MyNode<K> newNode = new MyNode<K>(key);

		// if tail is null then newNode value is stored head and tail
		if (tail == null) {
			head = newNode;
			tail = newNode;
		} // if tail is not null then newNode of next value is stored in tail
		else {
			tail.setNext(newNode);
			tail = newNode;
		}
	}

	public void insertAfter(K key, K newData) {
		// head value is stored in currentNode
		MyNode<K> currentNode = head;
		// the condition check if currentNode is not null and it also check key of
		// currentNode is not equal to key parameter passed
		while (currentNode != null && !currentNode.getKey().equals(key)) {
			currentNode = currentNode.getNext();
		}
		// if currentNode is null then key is not found
		if (currentNode == null) {
			System.out.println(key + " not found in the list");
			return;
		}
		// a new node is created with the newData value, and its next pointer is set to
		// the next pointer of the current node.
		MyNode<K> newNode = new MyNode<K>(newData);
		newNode.setNext(currentNode.getNext());
		currentNode.setNext(newNode);
	}

	public void print() {
		// the value of head is stored in currentNode
		MyNode<K> currentNode = head;
		// the condition will go until currentNode is null
		while (currentNode != null) {
			System.out.print(currentNode.getKey() + "->");
			currentNode = currentNode.getNext();
		}
		System.out.println("null");
	}

	public static void main(String[] args) {

		MyLinkedLists<Integer> list = new MyLinkedLists<Integer>();
		list.append(56);
		list.append(70);
		list.insertAfter(56, 30);
		list.print();
	}
}
