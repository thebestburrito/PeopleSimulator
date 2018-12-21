import java.util.*;

class Society{
	//this declares a new instance variable... an ArrayList for people
	List<Person> people = new ArrayList<Person>();

	public int population;
	//these names came from https://nameberry.com/unisex-names
	private String[] firstNames = {"Avery","Riley","Jordan","Angel","Parker","Sawyer","Peyton","Quinn","Blake","Hayden","Taylor","Dakota","Reese","Zion","Remmington","Amari","Phoenix","Kendall","Harley","Rylan","Marley","Dallas"};
	private String[] lastNames = {"Hill","Carson","Ware","McMahon","Murray","Smith","Jones","Robinson","Morris","Brown","Meyers","Reed","Schmidt","Estrada","Huang","Patel","Gupta","Gomez","Ramirez","Thomas","Jordan","Samson","Samuels","Evans","Butts","Wright","Black","White"};

	Society(int numPeople){
		population = numPeople;
		String fullName;
        int pN;

        double a = (Math.random() * 100);
        if (a >= 0 && a <= 0.0625) {
            pN = 0;
        } else if (a > 0.0625 && a <= 0.4000) {
            pN = 1;
        } else if (a > 0.4000 && a <= 2.1000) {
            pN = 2;
        } else if (a > 2.1000 && a <= 2.4375) {
            pN = 3;
        } else if (a > 2.4375 && a <= 2.5000) {
            pN = 4;
        } else if (a > 2.5000 && a <= 2.8375) {
            pN = 5;
        } else if (a > 2.8375 && a <= 4.6600) {
            pN = 6;
        } else if (a > 4.6600 && a <= 13.8400) {
            pN = 7;
        } else if (a > 13.8400 && a <= 15.6625) {
            pN = 8;
        } else if (a > 15.6625 && a <= 16.0000) {
            pN = 9;
        } else if (a > 16.0000 && a <= 17.7000) {
            pN = 10;
        } else if (a > 17.7000 && a <= 26.8800) {
            pN = 11;
        } else if (a > 26.8800 && a <= 73.1200) {
            pN = 12;
        } else if (a > 73.1200 && a <= 82.3000) {
            pN = 13;
        } else if (a > 82.3000 && a <= 84.0000) {
            pN = 14;
        } else if (a > 84.0000 && a <= 84.3375) {
            pN = 15;
        } else if (a > 84.3375 && a <= 86.1600) {
            pN = 16;
        } else if (a > 86.1600 && a <= 95.3400) {
            pN = 17;
        } else if (a > 95.3400 && a <= 97.1625) {
            pN = 18;
        } else if (a > 97.1625 && a <= 97.5000) {
            pN = 19;
        } else if (a > 97.5000 && a <= 97.5625) {
            pN = 20;
        } else if (a > 97.5625 && a <= 97.9000) {
            pN = 21;
        } else if (a > 97.9000 && a <= 99.6000) {
            pN = 22;
        } else if (a > 99.6000 && a <= 99.9375) {
            pN = 23;
        } else {
            pN = 24;
        }

		for(int i = 0; i < numPeople; i++){
			fullName = firstNames[(int)(Math.random()*firstNames.length)] + " " + lastNames[(int)(Math.random()*lastNames.length)];
			people.add(new Person((int)(Math.random()*100), fullName, pN));
		}
	}
}