class Main {
	public static void main(String[] args) {
        Society peopleTown = new Society(1000);
         for(int i = 0; i < 1000; i++) {
            peopleTown.cycleDay();
            //Write your print/tests in here if your feature should happen on a dialy basis

            if(!peopleTown.getDisaster().equals("none")){
                int preDisasterPop = peopleTown.population;
                //Shows Disater news report
                System.out.println(peopleTown.getDisaster() + " on " + peopleTown.time.dateToString());
            }
            if(true){
                //Jared and Sophia's Societal Happiness
                System.out.println(" Societal Happiness = " + peopleTown.societalHappiness() +"% on "+ peopleTown.time.dateToString());
            }


        }

        for(Person individual : peopleTown.people){

            //Logan's mating and wedlock methods
            if(individual.getSpouse() != null){
                System.out.println(individual.getName() + " married to " + individual.getSpouse().getName() );
                System.out.println(individual.getSpouse().getName() + " is married to " + individual.getName());
            }

            //Justin & Drew's income calculated on the bell curve
            System.out.println(individual.getName() + "'s Income: " + individual.calcIncome());

            //Fiona's assigning personality numbers based on Dungeouns and Dragons alignments
            System.out.println(individual.getName() + " has personality number " + individual.getPersonalityNumber() + ", called "+ individual.getPersonalityString() + ". " + "isLawful = " + individual.getPersonalityBoolean("isLawful"));
            System.out.println(individual.getName() + " has personality number " + individual.getPersonalityNumber() + ", called "+ individual.getPersonalityString() + ". " + "isLawful = " + individual.getPersonalityBoolean("isLawful"));

        }
    }

}


