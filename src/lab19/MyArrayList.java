package lab19;
import java.util.Arrays;

public class MyArrayList implements MyList {
	
	// The allocated array of memory. This might be bigger than the actual list.
	private String[] array = new String[4];
	// How many items are actually in the list. May be less than the length of the array.
	private int length = 0;

	
	@Override
	public boolean removeAt(int index) {
		if (index < 0 || index > memory() - 1) {
			return false;
		}
		array[index] = null;
		for (int i = index; i < memory() - 1; i++) {
			array[i] = array[i + 1];
		}
		length--;
		return true;
	}
	
	@Override
	public boolean insertAt(int index, String data) {
		if (index < 0 || index > memory() - 1) {
			return false;
		}
		if (isFull()) {
			doubleLength();
		}
		for (int i = memory() - 1; i > index; i--) {
			array[i] = array[i - 1];
		}
		array[index] = data;
		length++;
		return true;
	}
	
	@Override
	public void addAtEnd(String data) {
		int count = 0;
		if (isFull()) {
			doubleLength();
		} 
		for (String s : array) {
			if (s == null) {
				break;
			}
			count++;
		}
		for (int i = count; i < memory() - 1; i++) {
			array[i] = array[i + 1];
		}
		array[count] = data;		
		length++;
	}
	
	@Override
	public void removeFromEnd() {
		if (length > 0) {
			array[length - 1] = null;
		}
		length--;
	}

	@Override
	public void addAtBeginning(String data) {
		if (isFull()) {
			doubleLength();
		}
		for (int i = memory() - 1; i > 0; i--) {
			array[i] = array[i - 1];
		}
		array[0] = data;
		length++;
	}

	@Override
	public void removeFromBeginning() {
		for (int i = 0; i < memory() - 1; i++) {
			array[i] = array[i + 1];
		}
		array[memory() - 1] = null;
		length--;
	}

	@Override
	public String get(int index) {
		if (array[index] == null) {
			return null;
		}	
		return array[index];
	}

	@Override
	public int size() {
		return length;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[ ");
		
		for (int i = 0; i < length; i++) {
			if (array[i] != null) {
				sb.append(array[i]);
				if (i != length -1 && (array[i + 1] != null)) {
					sb.append(", ");
				}				
			}
		}
		
		sb.append(" ]");
		return sb.toString();
	}
	
	private boolean isFull() {
		for (String s : array) {
			if (s == null) {
				return false;
			}
		}
		return true;
	}
	
	private int memory() {
		int count = 0;
		for (String s : array) {
			count++;
		}
		return count;
	}
	
	private void doubleLength() {
		// make a new copy of the array that is twice as long
		String[] copy = new String[memory() * 2];
		for (int i = 0; i < memory(); i++) {
			copy[i] = array[i];
		}
		String[] array = new String[memory() * 2];
		for (int i = 0; i < memory(); i++) {
			array[i] = copy[i];
		}
	}

}