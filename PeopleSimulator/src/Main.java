
class Main {

	public static void main(String[] args) {

		Society peopleTown = new Society(10000);

        //gets the name of the person in the people arrayList at position 8000
        for(int i = 0; i < peopleTown.population; i++){
			//the ArrayList method .get(i) is how to get the element at i
            peopleTown.cycleDay();
			System.out.println(peopleTown.people.get(i).getName() + " age = "+ peopleTown.people.get(i).getAge() + " Depressed = " + peopleTown.people.get(i).getDepressed() + " Happiness = " + peopleTown.people.get(i).getHappiness() + "%");



        /* System.out.println(peopleTown.people.get(i).getName()); */
      }


    peopleTown.societalHappiness();
    }
}

