class Main {
	public static void main(String[] args) {



		Society peopleTown = new Society(1000);

      for(int i = 0; i < 1000; i++) {
        peopleTown.cycleDay();
        //Write your print/tests in here if your feature should happen on a dialy basis



      }

      for(Person individual : peopleTown.people){
          //This is a test of the people who got married
          if(individual.getSpouse() != null){
              System.out.println(individual.getName() + " married to " + individual.getSpouse().getName() );
              System.out.println(individual.getSpouse().getName() + " is married to " + individual.getName());
          }
          //Write your print/tests below if they involve a property of the people in peopleTown
          //use individual as it does in the example above



      }

      
        System.out.println(peopleTown.places.get(0).getClassification());
        System.out.println(peopleTown.getClassification(peopleTown.places.get(0).getPlace()));
        //places Demo code PLEASE REMOVE!!
        //remember that there are only 5 towns to start with
        //gets place of each person
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