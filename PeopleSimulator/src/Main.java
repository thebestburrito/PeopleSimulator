class Main {
	public static void main(String[] args) {
        Society peopleTown = new Society(20);
        for(int i = 0; i < 100; i++) {
            peopleTown.cycleDay();
            //Uncomment any of these to shot them
            if(!peopleTown.getDisaster().equals("none")){
                //Shows Disaster news report
                //p(peopleTown.getDisaster() + " on " + peopleTown.time.dateToString());
            }

            //if(false){
                //Jared and Sophia's Societal Happiness
                //p(" Societal Happiness = " + peopleTown.societalHappiness() +"% on "+ peopleTown.time.dateToString());
            //}

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
            if(individual.spouse != null){
                System.out.println(individual.getName() + " married to " + individual.getSpouse().getName() );
                System.out.println(individual.getSpouse().getName() + " is married to " + individual.getName());
            }
            if(individual.getNumOfTimesDivorced() > 0 && individual.getAge() > 20){
              System.out.println(individual.getName() + " got divorced " + individual.getNumOfTimesDivorced() + " time(s) because their happiness (or sometimes their spouse's) dropped to " + individual.getHappiness());
            }

            if(individual.getAge() >= 20){
                System.out.println(individual.getName() + "'s Income: " + individual.income);
                System.out.println(individual.getName() + " has personality number " + individual.getPersonalityNumber() + ", called "+ individual.getPersonalityString() + ". " + "isLawful = " + individual.getPersonalityBoolean("isLawful"));
            }
        }
	}
    
    public static void p(String toPrint){
        System.out.println(toPrint);
    }
}