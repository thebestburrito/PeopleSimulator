class Main {
	public static void main(String[] args) {
        Society peopleTown = new Society(1000);
        for(int i = 0; i < 1000; i++) {
            peopleTown.cycleDay();
            //Write your print/tests in here if your feature should happen on a dialy basis
        }

        /* for(Person individual : peopleTown.people){
            //This is a test of the people who got married
            if(individual.getSpouse() != null){
                System.out.println(individual.getName() + " married to " + individual.getSpouse().getName() );
                System.out.println(individual.getSpouse().getName() + " is married to " + individual.getName());
            }
            //Write your print/tests below if they involve a property of the people in peopleTown
            //use individual as it does in the example above
        } */

        System.out.println(peopleTown.people.get(800).getName() + " has Personality Number: " + peopleTown.people.get(800).getPersonalityNumber() + " With String: "+ peopleTown.people.get(800).getPersonalityString());
        System.out.println(peopleTown.people.get(80).getName() + " has Personality Number: " + peopleTown.people.get(80).getPersonalityNumber() + " With String: "+ peopleTown.people.get(80).getPersonalityString());
    }
    // This is the Places Code- Need help? Ask Brandon, Ian, or read the documentation provided.
}
