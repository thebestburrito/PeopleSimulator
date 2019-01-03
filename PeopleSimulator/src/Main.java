class Main {
	// I'll be using this main method for testing
	public static void main(String[] args) {

		Society peopleTown = new Society(200);
        //this counts out the population for each place
        //if you change the
        for(int o = 0; o < 200; o++){

        }


    peopleTown.people.get(1).changePlaceTo("brandontown");
    System.out.println(peopleTown.people.get(1).getPlace());
        //gets the name of the person in the people arrayList at position 8000
    for(int o = 0; o < 10; o++){
        System.out.println(peopleTown.people.get(o).getName() +" "+ peopleTown.people.get(o).getPlace());
        System.out.println(peopleTown.people.get(o).getPopulationOf("brandontown"));
    }
    //testing that the change location feature works

	}

}
