import java.util.*;
class Main {
    public static int totalPopulation = 10000;
	public static void main(String[] args) {
	    Society peopleTown = new Society(totalPopulation);
        
        //gets the name and place of each person
        for(int o = 0; o < totalPopulation; o++){
            System.out.println(peopleTown.people.get(o).getName() +" "+ peopleTown.people.get(o).getPlace());
        }


        //places Demo code PLEASE REMOVE!!
        peopleTown.people.get(1).changePlaceTo("brandontown");
        System.out.println(peopleTown.people.get(1).getPlace());
        populationOf(totalPopulation,peopleTown,"brandontown");
    }

    // This is the Places Code- Need help? Ask Brandon, Ian, or read the documentation provided.
    public static int populationOf(int totalPopulation,Society society,String PlaceName){
        ArrayList<String> placedata = new ArrayList<String>();
        for(int count = 0;count < totalPopulation;count++){
            placedata.add(society.people.get(count).getPlace());
        }
        int occurances = Collections.frequency(placedata, PlaceName);
        System.out.println("Population for "+PlaceName+":"+occurances);
        //empty the placedata array every time.
        placedata.clear();
        return occurances;
    }
}
