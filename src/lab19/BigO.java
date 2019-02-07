package lab19;

import java.util.HashMap;
import java.util.Map;

public class BigO {

	public static void main(String[] args) {
		int[] data = new int[] { 1,2,3,2,2,4,5,5,7,8,4,4,1,0,10 };		
		HashMap<Integer, Integer> frequency = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < 11; i++) {
			frequency.put(i, 0);
		}
		
		for (int number : data) {
			for (Map.Entry<Integer, Integer> map : frequency.entrySet()) {
				if (map.getKey() == number) {
					map.setValue(map.getValue() + 1);
				}
			}
		}
		for (Map.Entry<Integer, Integer> map : frequency.entrySet()) {
			System.out.println(map.getKey() + " = " + map.getValue());
		}
	}
	
}
