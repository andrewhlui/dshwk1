package hw1;

public class BabyNames {
	public static void main(String[] args){
		
		int startingYear = 1880;
		int endingYear = 1900;
		YearNames[] histogramYears = new YearNames[endingYear-startingYear];
		String name = "Andrew";
				
		for (int i = startingYear; i < endingYear; i++) {
			int count;
			double percentage;
			histogramYears[i - startingYear] = new YearNames(i);
			// count = histogramYears[i - startingYear].getCountByName(name);
			percentage = histogramYears[i - startingYear].getFractionByName(name);
			System.out.printf(i + " (%6.4f): ", percentage);
			for (int j = 0; j <= Math.round(percentage * 100); j++) {
				System.out.print("|");
			}
			System.out.println();
		}





	}
}
