package dataStructure;

public class Heap {

	private int size;
	private int[] array;

	public Heap() {
		this(16);
	}

	public Heap(int capacity) {
		this.array = new int[capacity];
		this.size = 0;
	}

	private int getParent(int index) {
		return index / 2;
	}

	private int getLeftChild(int index) {
		return index * 2;
	}

	private int getRightChild(int index) {
		return index * 2 + 1;
	}

	private void resize(int newCapacity) {
		int[] newArray = new int[newCapacity];
		for (int i = 1; i <= size; i++) {
			newArray[i] = array[i];
		}
		this.array = newArray;
	}

	public void add(int value) {
		if (size + 1 == array.length) {
			resize(array.length * 2);
		}

		siftUp(size + 1, value); // 가장 마지막에 추가 되는 위치와 넣을 값(타겟)을 넘겨줌
		size++; // 정상적으로 재배치가 끝나면 사이즈를 증가
	}

	private void siftUp(int idx, int target) {
		while (idx > 1) {
			int parent = getParent(idx);
			int parentVal = array[parent];
			if (target >= parentVal) {
				break;
			}
			array[idx] = parentVal;
			idx = parent;
		}
		array[idx] = target;
	}
	
	public void remove(int target) {
		for (int i = 1; i <= size; i++) {
			if (array[i] == target) {
				siftDown(i, target);
				return;
			}
		}
	}
	
	public int remove() {	    
		int result = array[1];	// 삭제된 요소를 반환하기 위한 임시 변수 
		int target = array[size];	// 타겟이 될 요소
			
		// 삭제할 노드의 인덱스와 이후 재배치 할 타겟 노드를 넘겨준다.
		siftDown(1, target);	// 루트 노드가 삭제되므로 1을 넘겨준다.			
		return result;
	}
	
	private void siftDown(int idx, int target) {
		size--;
			
		int parent = idx;
		int child;
	 
		while ((child = getLeftChild(parent)) <= size) {
				
			int right = getRightChild(parent);
				
			int childVal = array[child];
			
			if(right <= size && childVal > array[right]) {
				child = right;
				childVal = array[child];
			}
				
			if (target <= childVal){
				break;
			}
			
			array[parent] = childVal;
			parent = child;
				
		}
		array[parent] = target;			
	}
}