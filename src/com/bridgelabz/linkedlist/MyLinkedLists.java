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
		// the condition will go until currentNode is null or key of currentNode equals
		// to key parameter
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

	public void pop() {
		// if head is null then list is empty
		if (head == null) {
			System.out.println("List is empty");
		} // else head value change to next value
		else {
			head = head.getNext();
		}
	}

	public void popLast() {
		// if list is empty
		if (head == null) {
			System.out.println("List is empty");
			return;
		}

		// if there is only one element in the list
		if (head == tail) {
			head = null;
			tail = null;
			return;
		}

		// traverse the list till the second last element
		MyNode<K> currentNode = head;
		while (currentNode.getNext() != tail) {
			currentNode = currentNode.getNext();
		}

		// update tail and its previous element's next pointer to null
		tail = currentNode;
		tail.setNext(null);
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

	public void search(K key) {
		// the value of head is stored in currentNode
		MyNode<K> currentNode = head;
		// the condition will go until currentNode is null or key of currentNode equals
		// to key parameter
		while (currentNode != null && !currentNode.getKey().equals(key)) {
			currentNode = currentNode.getNext();
		}
		// if currentNode is null then key is not found
		if (currentNode == null) {
			System.out.println("Node not found");
		} else {
			System.out.println("Node found: " + currentNode.getKey());
		}
	}

	public void delete(K key) {
		// if head is null then list is empty
		if (head == null) {
			System.out.println("List is empty");
			return;
		}

		// if the node to be deleted is the head node
		if (head.getKey().equals(key)) {
			head = head.getNext();
			// if the list has only one node
			if (head == null) {
				tail = null;
			}
			System.out.println(key + " is deleted from the list");
			return;
		}

		// search for the previous node of the node to be deleted
		MyNode<K> currentNode = head;
		while (currentNode.getNext() != null && !currentNode.getNext().getKey().equals(key)) {
			currentNode = currentNode.getNext();
		}

		// if the node to be deleted is not found
		if (currentNode.getNext() == null) {
			System.out.println(key + " not found in the list");
			return;
		}

		// update the next pointer of the previous node to the next node of the deleted
		// node
		currentNode.setNext(currentNode.getNext().getNext());
		// if the deleted node is the tail node, update the tail pointer
		if (currentNode.getNext() == null) {
			tail = currentNode;
		}
		System.out.println(key + " is deleted from the list");
	}

	public int size() {
		int size = 0;
		MyNode<K> currentNode = head;
		while (currentNode != null) {
			size++;
			currentNode = currentNode.getNext();
		}
		return size;
	}

	public static void main(String[] args) {

		MyLinkedLists<Integer> list = new MyLinkedLists<Integer>();
		list.append(56);
		list.append(70);
		list.insertAfter(56, 30);
		// list.popLast();
		list.search(30);
		list.insertAfter(30, 40);
		list.delete(40);
		System.out.println("size of a linkedlist" + list.size());
		list.print();
	}
}
