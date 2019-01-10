import java.util.*;
class Main {
	public static void main(String[] args) {
	    Society peopleTown = new Society(10000);


        //places Demo code PLEASE REMOVE!!
        //remember that there are only 5 towns to start with
                //gets the name and place of each person
        for(int o = 0; o < peopleTown.places.size(); o++){
            //this prints every place name
            System.out.println(peopleTown.places.get(o).getPlace());
        }
        peopleTown.people.get(1).changePlaceTo("brandontown");
        System.out.println(peopleTown.people.get(1).getPlace());
        peopleTown.populationOf(peopleTown,"brandontown");
        peopleTown.populationOf(peopleTown,peopleTown.places.get(0).getPlace());
        peopleTown.populationOf(peopleTown,peopleTown.places.get(1).getPlace());
        peopleTown.populationOf(peopleTown,peopleTown.places.get(2).getPlace());
        peopleTown.populationOf(peopleTown,peopleTown.places.get(3).getPlace());
        peopleTown.populationOf(peopleTown,peopleTown.places.get(4).getPlace());

    }

    // This is the Places Code- Need help? Ask Brandon, Ian, or read the documentation provided.
}