package dataStructure;

public class Node {

	int number;
	Node next;
	Node prev;
	
	Node(int number, Node next) {
		this.number = number;
		SetNext(next);
		prev = null;
	}
	
	Node(int number) {
		this(number, null);
	}
	
	void SetNext(Node next) {
		this.next = next;
		if (next != null) {
			next.prev = this;
		}
	}
	
	void SetPrev(Node prev) {
		this.prev = prev;
		if (prev != null) {
			prev.next = this;
		}
	}
}