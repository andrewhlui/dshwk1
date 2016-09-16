package hw1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class YearNames {

	private MyArrayList<Name> names;
	
	@Override
	public String toString() {
		return this.names.toString();
	}
	
	public YearNames(int year){
		// array that stores all the particular names for an year
		String fileName = "data/yob" + String.valueOf(year) + ".txt";
		File f = new File(fileName);
		testFileRead(f);
		Scanner inputFile = null;
		try {
			inputFile = new Scanner(f);
		} catch (FileNotFoundException e) {
			System.err.printf("Error, cannot read file &s", fileName);
		}
		names = new MyArrayList<Name>((int)f.length());
		
		while (inputFile.hasNextLine()) {
			String[] dataFromFile = new String[3];
			dataFromFile = inputFile.nextLine().split(",");
			String name = dataFromFile[0];
			String gender = dataFromFile[1];
			int number = Integer.parseInt(dataFromFile[2]);
			Name newName = new Name(name, gender, number);
			try {
				add(newName);
			} catch (IllegalArgumentException e) {
				System.err.println(e + " Combining records.");
				int index = this.names.lastIndexOf(newName);
				this.names.get(index).setCount(this.names.get(index).getCount()+number);
			}
		}
		
		
	}
	
	public void add(Name n){		
		if (this.names.contains(n)){
			throw new IllegalArgumentException("Name " + n + " exists.");
		} else {
			this.names.add(n);
		}
	}
	
	public int getCountByName(String name){
		int count = 0;
		Name maleName = new Name(name, "m", 0);
		Name femaleName = new Name(name, "f", 0);
		if (this.names.contains(maleName)){
			int index = this.names.indexOf(maleName);			
			count += this.names.get(index).getCount();
		} 
		if (this.names.contains(femaleName)){
			int index = this.names.indexOf(femaleName);			
			count += this.names.get(index).getCount();
		} 
		return count;
	}
	
	public double getFractionByName(String name){
		// probably getCountByName/total names
				
		return getCountByName(name) * 100.0 / totalBabiesPerYear();
	}
	
	private int totalBabiesPerYear(){
		int total = 0;
		for (int i = 0; i < names.size(); i++) {
			total += names.get(i).getCount();
		}
		return total;
	}
	
	
	private static void testFileRead(File f) {
		if (!f.canRead()) {
			System.err.printf("Error: cannot read data from file %s", f.getName());
			System.exit(1);
		}
	}
}





