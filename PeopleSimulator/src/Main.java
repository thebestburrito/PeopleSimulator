
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

	}



    // This is the Places Code- Need help? Ask Brandon, Ian, or read the documentation provided.
}