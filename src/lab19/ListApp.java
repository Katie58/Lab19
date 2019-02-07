package lab19;

public class ListApp {

	public static void main(String[] args) {
		testArrayList();
		testLinkedList();
	}
	
	private static void testArrayList() {
		MyArrayList list = new MyArrayList();
		
		list.addAtBeginning("B");
		System.out.println(list);
		list.addAtBeginning("A");
		System.out.println(list);
		list.addAtEnd("C");
		System.out.println(list);
		list.addAtEnd("D");
		System.out.println(list);
		list.removeFromBeginning();
		System.out.println(list);
		list.removeFromEnd();
		System.out.println(list);
		
		list.insertAt(1, "X");
		System.out.println(list);
		list.removeAt(1);
		
		System.out.println(list);
		System.out.println(list.size());
		System.out.println(list.get(0));
		System.out.println(list.get(1));
	}
	
	private static void testLinkedList() {
		MyLinkedList list = new MyLinkedList();
		
		list.addAtBeginning("B");
		list.addAtBeginning("A");
		list.addAtEnd("C");
		list.addAtEnd("D");
		list.removeFromBeginning();
		list.removeFromEnd();
		
		list.insertAt(1, "X");
		System.out.println(list);
		list.removeAt(1);
		
		System.out.println(list);
		System.out.println(list.size());
		System.out.println(list.get(0));
		System.out.println(list.get(1));
	}

}