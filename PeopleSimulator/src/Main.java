class Main {
	public static void main(String[] args) {
		Society peopleTown = new Society(10000);

        //gets the name of the person in the people arrayList at position 8000
        System.out.println(peopleTown.people.get(8000).getName() + " " + peopleTown.people.get(8000).getPersonalityNumber());
	}
}