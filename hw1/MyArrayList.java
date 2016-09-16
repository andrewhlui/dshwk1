package hw1;
import java.util.ArrayList;
import java.util.Collections;



public class MyArrayList<E extends Comparable<E>> extends ArrayList<E> {
	
	private static final long serialVersionUID = 1L;

	public MyArrayList() {
		super();
	}
	
	public MyArrayList(int n){
		super(n);
	}
	
	
	public void sort() {
		Collections.sort(this);
	}
	
	public boolean isSorted() {
		if (this.size() < 2) {
			return true;
		}
		boolean sorted = true;
		for (int i = 1; i < this.size(); i++) {
			if (this.get(i-1).compareTo(this.get(i))> 0) {
				sorted = false;
			}
		}
		return sorted;
	}
	
	@Override
	public boolean contains(Object o) {
		if (this.isSorted()) {
			if (o == null) {
				throw new IllegalArgumentException();
			}
			// search for the object
			// TODO: actually implement a binary search 
			for (int i = 0; i < this.size(); i++) {
				E test = this.get(i);
				if (o.equals(test)) return true;
				
			}
			return false;
			
		} else {
			// apply linear search with ArrayList
			return super.contains(o);
		}
	}
}
