package dataStructure;

public class Deque {

	int count;
	Node start;
	Node end;

	Deque() {
		count = 0;
		start = null;
		end = null;
	}
	
	void push_front(int val) {
		if (empty()) {
			start = new Node(val);;
			end = start;
		} else {
			start.SetPrev(new Node(val));
			start = start.prev;
		}
		count++;
	}

	void push_back(int val) {
		if (empty()) {
			start = new Node(val);
			end = start;
		} else {
			end.SetNext(new Node(val));
			end = end.next;
		}
		count++;
	}

	int pop_front() {
		if (empty())
			return -1;
		int ret = start.number;
		start = start.next;
		if (start != null) {
			start.prev = null;
		}		
		count--;
		return ret;
	}
	
	int pop_back() {
		if (empty())			
			return -1;
		int ret = end.number;
		end = end.prev;
		if (end != null) {
			end.next = null;
		}
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