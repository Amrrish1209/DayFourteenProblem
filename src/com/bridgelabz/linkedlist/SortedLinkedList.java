package com.bridgelabz.linkedlist;

public class SortedLinkedList<T extends Comparable<T>> {
	private Node<T> head;

	public void add(T data) {
		// creating new node with given data
		Node<T> newNode = new Node<>(data);
		// if head is null or head data is greater than given data then newnode become
		// the newhead
		if (head == null || head.getData().compareTo(data) > 0) {
			// newNode next pointer is set to the current head
			newNode.setNext(head);
			// head pointer updated to newNode
			head = newNode;
		} else {
			Node<T> current = head;
			// check if currentnode is not null and check if the data in the next node is
			// less than the data
			while (current.getNext() != null && current.getNext().getData().compareTo(data) < 0) {
				current = current.getNext();
			}
			newNode.setNext(current.getNext());
			current.setNext(newNode);
		}
	}

	public void printList() {
		Node<T> current = head;
		while (current != null) {
			System.out.print(current.getData() + "->");
			current = current.getNext();
		}
		System.out.println("null");
	}

	private static class Node<T extends Comparable<T>> {
		private final T data;
		private Node<T> next;

		public Node(T data) {
			this.data = data;
			this.next = null;
		}

		public T getData() {
			return data;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}
	}

	public static void main(String[] args) {
		SortedLinkedList<Integer> list = new SortedLinkedList<>();
		list.add(56);
		list.add(30);
		list.add(40);
		list.add(70);
		list.printList(); // output: 30->40->56->70->null
	}
}
