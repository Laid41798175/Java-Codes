package dataStructure;

public class Queue {

	int count;
	Node start;
	Node end;

	Queue() {
		count = 0;
		start = null;
		end = null;
	}

	void push(int val) {
		if (empty()) {
			start = new Node(val);
			end = start;
		} else {
			end.next = new Node(val);
			end = end.next;
		}
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

	int front() {
		if (empty())
			return -1;
		return start.number;
	}

	int back() {
		if (empty())
			return -1;
		return end.number;
	}

}
