
class Main {
	// I'll be using this main method for testing
	public static void main(String[] args) {

		Society peopleTown = new Society(10000);

        //gets the name of the person in the people arrayList at position 8000
        System.out.println(peopleTown.people.get(8000).getName());

        //Shows gender of person 0 and person 1
        System.out.println(peopleTown.people.get(0).getName() + ", is " + peopleTown.people.get(0).getGender());
        System.out.println(peopleTown.people.get(1).getName() + ", is " + peopleTown.people.get(1).getGender());

        //Test make person command with person 0 and person 1
        peopleTown.addPerson(peopleTown.people.get(0), peopleTown.people.get(1));
        System.out.println(peopleTown.people.get(peopleTown.people.size()-1).getName());
	}

}
