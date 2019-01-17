class Main {
	public static void main(String[] args) {

        Society peopleTown = new Society(100);

      for(int i = 0; i < 100; i++) {
        peopleTown.cycleDay();
        //Write your print/tests in here if your feature should happen on a dialy basis
      }
            System.out.println( peopleTown.people.get(5).getName() +" Balance = " + peopleTown.people.get(5).acct.getBalance());
           // System.out.println("IQ :" + peopleTown.people.get(100).calcIQ());
           // System.out.println("Income :" + peopleTown.people.get(i).calcIncome());




     for(Person individual : peopleTown.people){
          //This is a test of the people who got married
         if(individual.getSpouse() != null){
             // System.out.println(individual.getName() + " married to " + individual.getSpouse().getName() );
             // System.out.println(individual.getSpouse().getName() + " is married to " + individual.getName());
          }
          //Write your print/tests below if they involve a property of the people in peopleTown
          //use individual as it does in the example above
      }

	}

}