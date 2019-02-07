package lab19;
public class MyLinkedList implements MyList {

	// head is the first node in the list. if null, the list is empty.
	private Node head = null;
	// for convenience, keep track of how many items are in the list
	private int length = 0;
	
	@Override
	public boolean removeAt(int index) {
		Node pre = head;
		Node remove = getNodeAt(index);
		if (index < 0 || index > length) {
			return false;
		} 
		for (int i = 0; i < index - 2; i++) {
			pre = pre.getNext();			
		}
		pre.setNext(remove.getNext());
		remove.setNext(null);
		length--;
		return true;
	}
	
	@Override
	public boolean insertAt(int index, String data) {
		Node pre = head;
		Node node = new Node(data);
		if (index < 0 || index > length - 1) {
			return false;
		} 
		for (int i = 0; i < index - 2; i++) {
			pre = pre.getNext();
		}
		node.setNext(pre.getNext());
		pre.setNext(node);
		length++;
		return true;
	}
	
	@Override
	public void addAtBeginning(String data) {
		Node node = new Node(data);
		if (head != null) {
			node.setNext(head);
			head = node;
		}	
		head = node;
		length++;
	}
	
	@Override
	public void removeFromBeginning() {
		head = head.getNext();
		length--;
	}
	
	@Override
	public void addAtEnd(String data) {
		Node node = head;
		Node end = new Node(data);
		while(node.getNext() != null) {
			node = node.getNext();
		}
		node.setNext(end);
		length++;
	}
	
	@Override
	public void removeFromEnd() {
		if (length < 2) {
			// The beginning is the end.
			removeFromBeginning();
		} else {
			Node node = head;
			for (int i = 0; i < length - 2; i++) {
				node = node.getNext();
			}
			node.setNext(null);
		}
		length--;
	}
	
	@Override
	public String get(int index) {
		Node node = head;
		for (int i = 0; i <= index; i++) {		
			if (i == index) {
				return node.getData();
			} else {
				node = node.getNext();
			}
		}
		return null;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		// start at the head
		Node node = head;
		// follow the links between nodes until it reaches the end 
		while (node != null) {
			sb.append(node);
			node = node.getNext();
		}
		return sb.toString();
	}
	
	@Override
	public int size() {
		return length;
	}
	
	private Node getNodeAt(int index) {
		// start at the head
		Node node = head;
		// follow the links between nodes until it counts off the right number
		for (int i = 0; i < index; i++) {
			if (node.getNext() == null) {
				// In case we run out of nodes before we get up to the desired index, return null
				return null;
			}
			node = node.getNext();
		}
		return node;
	}


}