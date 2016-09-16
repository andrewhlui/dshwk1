package hw1;

public class Name implements Comparable<Name>{
	
	private String name;
	private char gender;
	private int count;
	
	public Name(String name, String gender, int count) {
		if (name == "") {
			throw new IllegalArgumentException();
		} else {
			this.name = name;
		}
		
		// convert gender
		char genderChar = gender.toLowerCase().toCharArray()[0];
		if (genderChar != 'm' & genderChar != 'f') {
			throw new IllegalArgumentException();
		} else {
			this.gender = genderChar;
		}
		
		if (count < 0) {
			throw new IllegalArgumentException();
		} else {
			this.count = count;
		}
		
				
	}
	
	public String getName() {
		return this.name;
	}	
	public void setName(String name) {
		this.name = name;
	}	
	public int getCount() {
		return this.count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
	public int compareTo(Name n){
		if (this.count > n.count) {
			return 1;
		} else if (this.count < n.count) {
			return -1;
		} else {
			return n.name.compareTo(this.name);
		}
	}
	
	@Override
	public boolean equals(Object n){
		if (n != null && n instanceof Name) {
			return (((Name)n).name.equals(this.name) && ((Name)n).gender == this.gender);
		} else {
			return false;
		}
		
	}
	
	public String toString(){
		return this.name + " (" + this.gender + "): " + this.count;
	}
}
