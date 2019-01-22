
class Main {
	public static void main(String[] args) {
        Society peopleTown = new Society(100);

      for(int i = 0; i < 4000; i++) {
        peopleTown.cycleDay();
        //Write your print/tests in here if your feature should happen on a dialy basis
            //System.out.println(peopleTown.people.get(i).getName() + " age = " + peopleTown.people.get(i).getAge() + " Depressed = " + peopleTown.people.get(i).getDepressed() + " Optimistic = " + peopleTown.people.get(i).getOptimistic() +" Happiness = " + peopleTown.people.get(i).setHappiness() + "%");


             //System.out.println(" Societal Happiness = " + peopleTown.societalHappiness() +"% ");


      }
        System.out.println(peopleTown.couples);
      for(Person individual : peopleTown.people){
          //This is a test of the people who got married
          if(individual.getSpouse() != null){
              System.out.println(individual.getName() + " married to " + individual.getSpouse().getName() + " for " + individual.getDaysMarried() + " " + individual.getSpouse().getDaysMarried() + " and " + individual.getYearsMarried() + " " + individual.getSpouse().getYearsMarried() + " years!");
              System.out.println(individual.getSpouse().getName() + " is married to " + individual.getName());
          }
          //Write your print/tests below if they involve a property of the people in peopleTown
          //use individual as it does in the example above



      }

	}

}
