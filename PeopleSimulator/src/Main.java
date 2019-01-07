import java.util.*;
class Main {
	// I'll be using this main method for testing

	public static void main(String[] args) {
    ArrayList<String> placedata = new ArrayList<String>();
		Society peopleTown = new Society(200);



    peopleTown.people.get(1).changePlaceTo("brandontown");
    System.out.println(peopleTown.people.get(1).getPlace());
        //gets the name of the person in the people arrayList at position 8000
    for(int o = 0; o < 10; o++){
        System.out.println(peopleTown.people.get(o).getName() +" "+ peopleTown.people.get(o).getPlace());
        System.out.println(peopleTown.people.get(o).getPopulationOf("brandontown"));
    }
    //testing that the change location feature works


    //this is part of the places counter (Do not touch)
    for(int count = 0;count < 200;count++){
        placedata.add(peopleTown.people.get(count).getPlace());
        System.out.println(placedata.get(count));
    }

    PopulationOf(placedata, "brandontown");
    }

    //this took way to F***ing to long. I legit want to die.
    // This is the Places Code- Need help? Ask Brandon, or Ian.
    public static int PopulationOf(ArrayList<String> A, String PlaceName){
        //this Method allows for a loction to be counted for population totals.
        //How it works: Do not mess with the array list part. Only add the place name (second parameter)
        // Example:  System.out.println(PopulationOf(placedata, "brandontown"));
        int occurances = Collections.frequency(A, PlaceName);
        System.out.println("Population for "+PlaceName+":"+occurances);
        return occurances;
    }
}
