package dataStructure;

public class Stack {

	int count;
	Node start;

	Stack() {
		count = 0;
		start = null;
	}

	void push(int val) {
		Node tmp = new Node(val, start);
		start = tmp;
		count++;
	}

	int pop() {
		if (empty())
			return -1;
		int ret = start.number;
		start = start.next;
		count--;
		return ret;
	}

	int size() {
		return count;
	}

	boolean empty() {
		return count == 0;
	}

	int top() {
		if (empty())
			return -1;
		return start.number;
	}

}
