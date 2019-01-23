class Main {
	public static void main(String[] args) {
        Society peopleTown = new Society(100);
         for(int i = 0; i < 10000; i++) {
            peopleTown.cycleDay();
            //Write your print/tests in here if your feature should happen on a dialy basis
            p(peopleTown.time.dateToString());
            if(!peopleTown.getDisaster().equals("none")){
                //Shows Disater news report
                //p(peopleTown.getDisaster() + " on " + peopleTown.time.dateToString());
            }
            if(false){
                //Jared and Sophia's Societal Happiness
                p(" Societal Happiness = " + peopleTown.societalHappiness() +"% on "+ peopleTown.time.dateToString());
            }
            for(Person individual : peopleTown.people){
                //Logan's mating and wedlock methods

                if(individual.spouse != null){
                    p(individual.getName() + " married to " + individual.getSpouse().getName() );
                    p(individual.getSpouse().getName() + " is married to " + individual.getName());
                }
                if(individual.getNumOfTimesDivorced() > 0 && individual.getAge() > 20){
                    p(individual.getName() + " got divorced " + individual.getNumOfTimesDivorced() + " time(s) because their happiness (or sometimes their spouse's) dropped to " + individual.getHappiness());
                }
            }
        }

        for(Person individual : peopleTown.people){
            //Logan's mating and wedlock methods
            if(individual.getSpouse() != null){
                System.out.println(individual.getName() + " married to " + individual.getSpouse().getName() );
                System.out.println(individual.getSpouse().getName() + " is married to " + individual.getName());
            }
            if(individual.getNumOfTimesDivorced() > 0 && individual.getAge() > 20){
              System.out.println(individual.getName() + " got divorced " + individual.getNumOfTimesDivorced() + " time(s) because their happiness (or sometimes their spouse's) dropped to " + individual.getHappiness());
            }

            //Justin & Drew's income calculated on the bell curve... maybe too many poor people
            if(individual.getAge() >= 20){
                //System.out.println(individual.getName() + "'s Income: " + individual.income);
            }

            //Fiona's assigning personality numbers based on Dungeouns and Dragons alignments
            //System.out.println(individual.getName() + " has personality number " + individual.getPersonalityNumber() + ", called "+ individual.getPersonalityString() + ". " + "isLawful = " + individual.getPersonalityBoolean("isLawful"));
            //System.out.println(individual.getName() + " has personality number " + individual.getPersonalityNumber() + ", called "+ individual.getPersonalityString() + ". " + "isLawful = " + individual.getPersonalityBoolean("isLawful"));


        }

	}
public static void p(String toPrint){
    System.out.println(toPrint);
}


}


